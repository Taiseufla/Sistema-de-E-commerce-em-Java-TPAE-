package Usuários;

import Ecommerce.Loja;
import Produtos.Notebooks;
import Produtos.Consoles;
import Produtos.Produto;
import Produtos.Smartphone;
import Produtos.TV;
import Produtos.Perifericos.Mouse;
import Produtos.Perifericos.Teclado;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe Lojista que estende Usuario
 * Representa um lojista no sistema de e-commerce
 */
public class Lojista extends Usuario {

    private String cnpj;  // CNPJ do lojista (identificador único da empresa)

    /**
     * Construtor da classe Lojista
     * @param Id Identificador único do lojista
     * @param Username Nome de usuário do lojista
     * @param Senha Senha de acesso do lojista
     * @param Email Email de contato do lojista
     * @param cnpj CNPJ da empresa do lojista
     */
    public Lojista(int Id, String Username, String Senha, String Email, String cnpj) {
        // Chama construtor da classe pai (Usuario)
        super(Id, Username, Senha, Email);
        this.cnpj = cnpj;
    }

    /**
     * Exibe os dados do lojista na tela
     * Chama o método da classe pai e adiciona informações específicas do lojista
     */
    public void ExibirDados() {
        super.ExibirDados();
        System.out.println("------ Lojista ------");
        System.out.println("\nNome: " + getUsername());
        System.out.println("CNPJ: " + this.cnpj);

    }

    /**
     * Exibe o menu de opções disponíveis para o lojista
     * Apresenta as funcionalidades principais que o lojista pode realizar
     */
    public void ExibirMenu() {
        System.out.println("\nPara prosseguir, escolha uma das opções disponíveis do menu...");
        System.out.println("\n------ Menu ------");
        System.out.println("\n1.Cadastrar Produto");
        System.out.println("2.Gerenciar Produto");
        System.out.println("3.Exibir Produtos");
        System.out.println("4.Salvar Alterações");
        System.out.println("5.Logout");
        System.out.println("-----------------------\n");

    }

    /**
     * Cadastra um novo produto no sistema
     * Coleta informações do lojista sobre o produto e o salva no arquivo CSV
     * @param catalogo ArrayList contendo os produtos disponíveis
     * @param entrada Scanner para capturar entrada do usuário
     */
    public void CadastrarProduto(ArrayList<Produto> catalogo, Scanner entrada) {
        // Solicita o tipo de produto (SMARTPHONE, NOTEBOOK, CONSOLE, TV, HEADSET, MOUSE, TECLADO)
        System.out.println("Escreva qual tipo de produto deseja cadastrar:");
        String tipo = entrada.nextLine();

        // Coleta informações básicas do produto
        System.out.println("Insira o ID:");
        String idProduto = entrada.nextLine();

        System.out.println("Insira o Preço:");
        double preco = entrada.nextDouble();
        entrada.nextLine(); // Consumir a nova linha pendente

        System.out.println("Insira a Descrição:");
        String descricao = entrada.nextLine();

        System.out.println("Insira a Marca:");
        String marca = entrada.nextLine();

        System.out.println("Insira a Quantidade:");
        int quantidade = entrada.nextInt();
        entrada.nextLine(); // Consumir a nova linha pendente


        // Utiliza switch case para capturar informações específicas de cada tipo de produto
        switch (tipo.toUpperCase()) {

            case "SMARTPHONE":
                System.out.println("Insira o Sistema Operacional:");
                String so = entrada.nextLine();
                System.out.println("Insira o Tamanho da Tela:");
                Double tela = entrada.nextDouble();
                System.out.println("Insira a Cor:");
                String cor = entrada.nextLine();

                Produto smartphone = new Smartphone(idProduto, preco, descricao, marca, quantidade, so, tela, cor);
                catalogo.add(smartphone);

                break;

            case "NOTEBOOK":
                System.out.println("Insira o Processador:");
                String processador = entrada.nextLine();
                System.out.println("Insira a Memória RAM:");
                String memoriaRam = entrada.nextLine();
                System.out.println("Insira o Armazenamento:");
                String armazenamento = entrada.nextLine();

                Produto notebook = new Notebooks(idProduto, preco, descricao, marca, quantidade, processador, memoriaRam, armazenamento);
                catalogo.add(notebook);

                break;

            case "CONSOLE":
                System.out.println("Insira a Geração:");
                String geracao = entrada.nextLine();
                System.out.println("Insira o Modelo:");
                String modelo = entrada.nextLine();

                Produto console = new Consoles(idProduto, preco, descricao, marca, quantidade, geracao, modelo);
                catalogo.add(console);
                

                break;

            case "TV":
                System.out.println("Insira o Tamanho em Polegadas:");
                double polegadas = entrada.nextDouble();
                entrada.nextLine(); // Consumir a nova linha pendente
                System.out.println("Insira a Resolução:");
                String resolucao = entrada.nextLine();

                Produto tv = new TV(idProduto, preco, descricao, marca, quantidade, polegadas, resolucao);
                catalogo.add(tv);

                break;

            case "HEADSET":
                System.out.println("Insira o Tipo de Conexão:");
                String tipoConexao = entrada.nextLine();
                System.out.println("Possui Som Surround? (true/false):");
                String somSurround = entrada.nextLine();
                System.out.println("Possui Cancelamento de Ruído? (true/false):");
                String cancelamentoRuido = entrada.nextLine();

                Produto headset = new Teclado(idProduto, preco, descricao, marca, quantidade, tipoConexao, somSurround, cancelamentoRuido);
                catalogo.add(headset);

                break;

            case "MOUSE":
                System.out.println("Insira o Tipo de Conexão:");
                String tipoConexaoMouse = entrada.nextLine();
                System.out.println("Insira o Sensor:");
                String sensor = entrada.nextLine();
                System.out.println("Insira o DPI:");
                int dpi = entrada.nextInt();
                entrada.nextLine(); // Consumir a nova linha pendente

                Produto mouse = new Mouse(idProduto, preco, descricao, marca, quantidade, tipoConexaoMouse, sensor, dpi);
                catalogo.add(mouse);

                break;

            case "TECLADO":
                System.out.println("Insira o Tipo de Conexão:");
                String tipoConexaoTeclado = entrada.nextLine();
                System.out.println("Insira o Layout:");
                String layout = entrada.nextLine();
                System.out.println("Insira o Tipo de Switch:");
                String tipoSwitch = entrada.nextLine();

                Produto teclado = new Teclado(idProduto, preco, descricao, marca, quantidade, tipoConexaoTeclado, layout, tipoSwitch);
                catalogo.add(teclado);
                break;

            default:
                System.out.println("Categoria inválida. Por favor, escreva novamente sua escolha.");
                break;

        }


    }
    
    /**
     * Gerencia o estoque de um produto existente
     * Permite ao lojista alterar a quantidade em estoque de um produto específico
     * @param catalogo ArrayList contendo todos os produtos disponíveis no sistema
     * @param entrada Scanner para capturar entrada do usuário via teclado
     */

  public void GerenciarEstoque(ArrayList<Produto> catalogo, Scanner entrada) {

        System.out.println("\nEscreva o código do produto que deseja alterar:");
        String codigoProduto = entrada.nextLine();
        Produto produto = Loja.BuscarProdutoPorID(codigoProduto, catalogo);

        if (produto != null) {
            System.out.println("Produto encontrado:");
            produto.ExibirProduto();

            System.out.println("\nEscreva a nova quantidade em estoque:");
            int novaQuantidade = Integer.parseInt(entrada.nextLine());
            produto.setQuantidade(novaQuantidade);

            System.out.println("Quantidade atualizada com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
        


    }
}