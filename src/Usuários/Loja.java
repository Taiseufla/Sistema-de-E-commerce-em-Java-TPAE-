package Usuários;

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

import Produtos.Computadores;
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
            }  
        }
        
        if (usuariologado != null) {
            if (usuariologado instanceof Lojista) {
                Lojista vendedor = (Lojista) usuariologado;
                vendedor.ExibirDados();
                vendedor.ExibirMenu();
                
                int opcao = entrada.nextInt();
                entrada.nextLine(); // Consumir a quebra de linha pendente
                switch (opcao) {
                    case 1:
                    System.out.println("Ótimo! Vamos cadastrar um novo produto no sistema...");
                    ExibirCategorias();    
                    vendedor.CadastrarProduto(catalogo, entrada);  

                        break;
                    /*case 2:
                        vendedor.GerenciarEstoque();
                        break;*/
                    case 3:
                        for (Produto produto : catalogo) {
                            produto.ExibirResumo();
                        }
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                } 
                
            } else {
                Cliente cliente = (Cliente) usuariologado;
                cliente.ExibirDados();
                cliente.ExibirMenu();
            }
            
        } else {
            System.out.println("E-mail e/ou senha inválidos");
        }
        
        entrada.close();
    }
    
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

    public static void ExibirCategorias(){
        System.out.println("\n----- Categorias -----");
        System.out.println("Smartphone");
        System.out.println("Notebook");
        System.out.println("TV");
        System.out.println("Consoles");
        System.out.println("Headset");
        System.out.println("Mouse");
        System.out.println("Teclado");
    }

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

                switch(csvProd.tipo.trim()){
                    case "Smartphone":
                        Produto smartphone = new Smartphone(csvProd.idProduto,Double.parseDouble(csvProd.preco), csvProd.descricao, csvProd.marca, Integer.parseInt(csvProd.quantidade),csvProd.sistemaOperacional, csvProd.telaTamanho, csvProd.cor);
                        Lista_produtos.add(smartphone);
                        break;
                    case "Notebook":
                        Produto computador = new Computadores(csvProd.idProduto, Double.parseDouble(csvProd.preco), csvProd.descricao, csvProd.marca, Integer.parseInt(csvProd.quantidade), csvProd.processador, csvProd.memoriaRam, csvProd.armazenamento);
                        Lista_produtos.add(computador);
                        break;
                    case "Consoles":
                        Produto console = new Consoles(csvProd.idProduto, Double.parseDouble(csvProd.preco), csvProd.descricao, csvProd.marca, Integer.parseInt(csvProd.quantidade), csvProd.geracao, csvProd.modelo);
                        Lista_produtos.add(console);
                        break;
                    case "TV":
                        Produto tv = new TV(csvProd.idProduto, Double.parseDouble(csvProd.preco), csvProd.descricao, csvProd.marca, Integer.parseInt(csvProd.quantidade), Integer.parseInt(csvProd.polegadas), csvProd.resolucao);
                        Lista_produtos.add(tv);    
                        break;
                    case "Mouse":
                        Produto mouse = new Mouse(csvProd.idProduto, Double.parseDouble(csvProd.preco), csvProd.descricao, csvProd.marca, Integer.parseInt(csvProd.quantidade), csvProd.tipoConexao, csvProd.sensor, Integer.parseInt(csvProd.dpi));
                        Lista_produtos.add(mouse);
                        break;
                    case "Teclado":
                        Produto teclado = new Teclado(csvProd.idProduto, Double.parseDouble(csvProd.preco), csvProd.descricao, csvProd.marca, Integer.parseInt(csvProd.quantidade), csvProd.tipoConexao, csvProd.layout, csvProd.tipoSwitch);
                        Lista_produtos.add(teclado);
                        break;
                    case "Headset": 
                        Produto headset = new Headset(csvProd.idProduto, Double.parseDouble(csvProd.preco), csvProd.descricao, csvProd.marca, Integer.parseInt(csvProd.quantidade), csvProd.tipoConexao, Boolean.parseBoolean(csvProd.somSurround), Boolean.parseBoolean(csvProd.cancelamentoRuido));
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

    public static void SalvarProdutoNoCSV(CSV_produto csvParaSalvar, String arquivo) {

        try (
            // Abre o arquivo no modo "append" (anexar)
            // O 'true' é o segredo: ele adiciona ao final em vez de apagar
            Writer escrever = new FileWriter(arquivo, true)
        ) {
            // Configura o escritor de CSV
            StatefulBeanToCsv<CSV_produto> NovoProduto = new StatefulBeanToCsvBuilder<CSV_produto>(escrever)
            .withSeparator(';') // Usa ; como separador (igual à leitura)
            .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER) // Não usa aspas desnecessárias
            .withApplyQuotesToAll(false) // Só usa aspas se precisar (ex: se tiver ;)
            //.withWriteHeader(false) // Não escreve o cabeçalho (já existe)
            .build();

            // Escreve o novo objeto como uma nova linha no arquivo
            NovoProduto.write(csvParaSalvar);

        } catch (Exception e) {
            System.out.println("Erro ao salvar produto no CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
