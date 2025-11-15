package Ecommerce;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import Usuários.Usuario;
import Usuários.Lojista;
import Usuários.Cliente;
import Produtos.Notebooks;
import Produtos.Consoles;
import Produtos.Produto;
import Produtos.Smartphone;
import Produtos.TV;
import Produtos.Perifericos.Headset;
import Produtos.Perifericos.Mouse;
import Produtos.Perifericos.Teclado;
import Model.CSV_usuarios;
import Model.CSV_produto;

public class Loja {
/**
 * Classe Loja - Ponto de entrada e utilitários da aplicação de e-commerce
 *
 * RESPONSABILIDADE:
 * - Contém o método `main` que inicializa a aplicação (login, menus e fluxo principal).
 * - Fornece utilitários estáticos para carregar e salvar dados em CSV
 *   (usuários e catálogo de produtos) e métodos auxiliares de busca/exibição.
 *
 * OBSERVAÇÕES IMPORTANTES:
 * - A serialização/desserialização de CSV utiliza a biblioteca OpenCSV.
 * - Os métodos `Catalogo` e `Ler_usuariosCSV` convertem linhas CSV em objetos do domínio
 *   (`Produto` e `Usuario`) usando as classes `CSV_produto` e `CSV_usuarios`.
 */

    public static void main(String[] args) {

        ArrayList<Usuario> Lista_usuario = Ler_usuariosCSV("usuarios.csv");
        ArrayList<Produto> catalogo = Catalogo("produtos.csv");
        Usuario usuariologado = null;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Bem-vindo(a) à nossa loja, para prosseguir digite o seu e-mail");
        String Email_in = entrada.next();
        System.out.println("\nDigite sua senha");
        String Senha_in = entrada.next();

        for (Usuario verifUsuario : Lista_usuario) {

            if (verifUsuario.getEmail().equals(Email_in) && verifUsuario.getSenha().equals(Senha_in)) {
                usuariologado = verifUsuario;
                break;
            } else {
                System.out.println("E-mail e/ou senha inválidos");
            }
        }

        if (usuariologado instanceof Lojista) {
            Lojista vendedor = (Lojista) usuariologado;
            vendedor.ExibirDados();
            while (usuariologado != null) {
                vendedor.ExibirMenu();

                int opcao = entrada.nextInt();
                entrada.nextLine(); // Consumir a quebra de linha pendente
                switch (opcao) {
                    case 1:
                        System.out.println("Ótimo! Vamos cadastrar um novo produto no sistema...");
                        ExibirCategorias();
                        vendedor.CadastrarProduto(catalogo, entrada);

                        break;
                    case 2:
                        System.out.println("Ótimo, a quantidade de produtos em estoque será carregada abaixo...");
                        for (Produto produto : catalogo) {
                            produto.ExibirResumo();
                        }
                        vendedor.GerenciarEstoque(catalogo, entrada);
                        break;
                    case 3:
                        for (Produto produto : catalogo) {
                            produto.ExibirCatalogo();
                        }
                        break;
                    case 4:
                        SalvarAlteracoesCSV(catalogo, entrada);
                        break;

                    case 5:
                        System.out.println("Logout realizado com sucesso!");
                        usuariologado = null; // Encerra a sessão do usuário
                        break;

                    default:
                        System.out.println("Opção inválida");
                        break;
                }
                
                if (opcao != 4) {
                    System.out.println("\nPara voltar ao menu, tecle ENTER");
                    entrada.nextLine();

                System.out.println("\nPara voltar ao menu, tecle ENTER");
                entrada.nextLine();
                }
            }

        } else {
            Cliente cliente = (Cliente) usuariologado;
            cliente.ExibirDados();

            while (usuariologado != null) {
                cliente.ExibirMenu();

                int opcao = entrada.nextInt();
                entrada.nextLine(); // Consumir a quebra de linha pendente

                switch (opcao) {
                    case 1:
                        System.out.println("Que legal! Vamos buscar um produto específico...");
                        System.out.println("Você quer ver o catálogo de produtos antes? (Sim/Não)");
                        String resposta = entrada.nextLine().toUpperCase();

                        if (resposta.equalsIgnoreCase("SIM")) {
                            for (Produto produto : catalogo) {
                                produto.ExibirCatalogo();
                            }
                        }
                        cliente.ProdutoDesejado(catalogo, entrada);
                        break;
                    case 2:
                        for (Produto produto : catalogo) {
                            produto.ExibirCatalogo();
                        }
                        break;
                    case 3:
                        SalvarAlteracoesCSV(catalogo, entrada);
                        break;
                    case 4:
                        System.out.println("Logout realizado com sucesso!");
                        usuariologado = null; // Encerra a sessão do usuário
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }

                if (opcao != 4) {
                    System.out.println("\nPara voltar ao menu, tecle ENTER");
                    entrada.nextLine();
                }
            }
        }

        entrada.close();
    }


    /**
     * Salva todo o catálogo atual no arquivo CSV `produtos.csv`.
     * Implementação:
     * - Limpa o arquivo existente (abre em modo escrita sem append)
     * - Percorre o `catalogo` e escreve cada produto chamando `SalvarProdutoNoCSV`
     *
     * @param catalogo lista de produtos a serem persistidos
     * @param entrada  scanner para interação (não utilizado diretamente aqui, mas
     *                 mantido para compatibilidade com chamadas existentes)
     * Limpar arquivo antes de salvar as alterações 
     */
    public static void SalvarAlteracoesCSV(ArrayList<Produto> catalogo, Scanner entrada) {
        try (Writer limpar = new FileWriter("produtos.csv")) {
        } catch (IOException e) {
            System.out.println("Erro ao limpar o arquivo de produtos: " + e.getMessage());
        }
        for (Produto produto : catalogo) {
            SalvarProdutoNoCSV(produto.toCSV(), "produtos.csv");
        }
    }

    /**
     * Lê o arquivo CSV de usuários e converte cada linha em instâncias de `Usuario`.
     * - Usa `CSV_usuarios` como bean de mapeamento (OpenCSV @CsvBindByName)
     * - O campo `tipo` determina se a entrada será instanciada como `Cliente` ou `Lojista`
     *
     * @param arquivo caminho para o arquivo CSV (ex: "usuarios.csv")
     * @return lista de usuários instanciados a partir do CSV
     */
    public static ArrayList<Usuario> Ler_usuariosCSV(String arquivo) {
        try {
            CsvToBean<CSV_usuarios> reader = new CsvToBeanBuilder<CSV_usuarios>(new FileReader(arquivo))
                    .withType(CSV_usuarios.class)
                    .withSeparator(';')
                    .build();

            List<CSV_usuarios> Lista_CSV = reader.parse();

            ArrayList<Usuario> Lista_usuario = new ArrayList<Usuario>();

            for (CSV_usuarios csvUser : Lista_CSV) {

                if (csvUser.tipo == 1) {
                    Usuario lojista = new Lojista(csvUser.id, csvUser.nome, csvUser.senha, csvUser.email, csvUser.cnpj);
                    Lista_usuario.add(lojista);
                } else {
                    Usuario cliente = new Cliente(csvUser.id, csvUser.nome, csvUser.senha, csvUser.email, csvUser.cpf,
                            csvUser.endereco);
                    Lista_usuario.add(cliente);
                }
            }
            return Lista_usuario;

        } catch (IOException ex) {
            System.out.println(ex.toString());
            return new ArrayList<Usuario>();
        }
    }

    /**
     * Exibe as categorias de produtos disponíveis.
     * Método utilitário usado durante o fluxo de cadastro para orientar o lojista.
     */
    public static void ExibirCategorias() {
        System.out.println("\n----- Categorias -----");
        System.out.println("Smartphone");
        System.out.println("Notebook");
        System.out.println("TV");
        System.out.println("Consoles");
        System.out.println("Headset");
        System.out.println("Mouse");
        System.out.println("Teclado");
    }

    /**
     * Carrega o catálogo de produtos a partir do arquivo CSV e converte cada linha
     * em objetos `Produto` apropriados (Smartphone, Notebooks, TV, Console, Mouse, Teclado, Headset).
     *
     * @param arquivo caminho para o CSV de produtos
     * @return lista de produtos instanciados a partir do CSV
     */
    public static ArrayList<Produto> Catalogo(String arquivo) {
        try {
            CsvToBean<CSV_produto> reader = new CsvToBeanBuilder<CSV_produto>(new FileReader(arquivo))
                    .withType(CSV_produto.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .withSeparator(';')
                    .build();

            List<CSV_produto> Lista_CSV = reader.parse();
            ArrayList<Produto> Lista_produtos = new ArrayList<Produto>();

            for (CSV_produto csvProd : Lista_CSV) {

                switch (csvProd.tipo.trim()) {
                    case "SMARTPHONE":
                        Produto smartphone = new Smartphone(csvProd.idProduto, Double.parseDouble(csvProd.preco),
                                csvProd.descricao, csvProd.marca, Integer.parseInt(csvProd.quantidade),
                                csvProd.sistemaOperacional, Double.parseDouble(csvProd.telaTamanho), csvProd.cor);
                        Lista_produtos.add(smartphone);
                        break;
                    case "NOTEBOOK":
                        Produto computador = new Notebooks(csvProd.idProduto, Double.parseDouble(csvProd.preco),
                                csvProd.descricao, csvProd.marca, Integer.parseInt(csvProd.quantidade),
                                csvProd.processador, csvProd.memoriaRam, csvProd.armazenamento);
                        Lista_produtos.add(computador);
                        break;
                    case "CONSOLE":
                        Produto console = new Consoles(csvProd.idProduto, Double.parseDouble(csvProd.preco),
                                csvProd.descricao, csvProd.marca, Integer.parseInt(csvProd.quantidade), csvProd.geracao,
                                csvProd.modelo);
                        Lista_produtos.add(console);
                        break;
                    case "TV":
                        Produto tv = new TV(csvProd.idProduto, Double.parseDouble(csvProd.preco), csvProd.descricao,
                                csvProd.marca, Integer.parseInt(csvProd.quantidade),
                                Double.parseDouble(csvProd.polegadas), csvProd.resolucao);
                        Lista_produtos.add(tv);
                        break;
                    case "MOUSE":
                        Produto mouse = new Mouse(csvProd.idProduto, Double.parseDouble(csvProd.preco),
                                csvProd.descricao, csvProd.marca, Integer.parseInt(csvProd.quantidade),
                                csvProd.tipoConexao, csvProd.sensor, Integer.parseInt(csvProd.dpi));
                        Lista_produtos.add(mouse);
                        break;
                    case "TECLADO":
                        Produto teclado = new Teclado(csvProd.idProduto, Double.parseDouble(csvProd.preco),
                                csvProd.descricao, csvProd.marca, Integer.parseInt(csvProd.quantidade),
                                csvProd.tipoConexao, csvProd.layout, csvProd.tipoSwitch);
                        Lista_produtos.add(teclado);
                        break;
                    case "HEADSET":
                        Produto headset = new Headset(csvProd.idProduto, Double.parseDouble(csvProd.preco),
                                csvProd.descricao, csvProd.marca, Integer.parseInt(csvProd.quantidade),
                                csvProd.tipoConexao, Boolean.parseBoolean(csvProd.somSurround),
                                Boolean.parseBoolean(csvProd.cancelamentoRuido));
                        Lista_produtos.add(headset);
                        break;

                }

            }
            return Lista_produtos;

        } catch (IOException ex) {
            System.out.println(ex.toString());
            return new ArrayList<Produto>();
        }
    }

    /**
     * Adiciona um único `CSV_produto` como nova linha no arquivo CSV especificado.
     * Utiliza `StatefulBeanToCsv` do OpenCSV para serializar o bean para CSV.
     *
     * @param csvParaSalvar bean contendo os campos que correspondem às colunas do CSV
     * @param arquivo       caminho do arquivo CSV (ex: "produtos.csv")
     */
    public static void SalvarProdutoNoCSV(CSV_produto csvParaSalvar, String arquivo) {
        try (

            Writer escrever = new FileWriter(arquivo, true)) {
            StatefulBeanToCsv<CSV_produto> NovoProduto = new StatefulBeanToCsvBuilder<CSV_produto>(escrever)
                    .withSeparator(';')
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withApplyQuotesToAll(false)
                    .build();

            NovoProduto.write(csvParaSalvar);

        } catch (Exception e) {
            System.out.println("Erro ao salvar produto no CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Busca um produto no catálogo pelo seu identificador (ID/código).
     * Retorna o objeto `Produto` correspondente ou `null` se não encontrado.
     *
     * @param codigoProduto código/ID do produto a buscar
     * @param catalogo      lista de produtos onde será realizada a busca
     * @return Produto correspondente ao ID ou null se não encontrado
     */
    public static Produto BuscarProdutoPorID(String codigoProduto, ArrayList<Produto> catalogo) {
        for (Produto produto : catalogo) {
            if (produto.idProduto.equals(codigoProduto)) {
                return produto;
            }
        }
        System.out.println("Produto com ID " + codigoProduto + " não encontrado.");
        return null;
    }
}
