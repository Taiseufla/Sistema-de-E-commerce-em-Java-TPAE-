package Usuários;

import Model.CSV_produto;
import Produtos.Produto;
import java.util.ArrayList;
import java.util.Scanner;

public class Lojista extends Usuario {

    private String cnpj;
    String palavra;

    public Lojista(int Id, String Username, String Senha, String Email, String cnpj) {
        super(Id, Username, Senha, Email);
        this.cnpj = cnpj;
    }

    public void ExibirDados() {
        super.ExibirDados();
        System.out.println("------ Lojista ------");
        System.out.println("\nNome: " + getUsername());
        System.out.println("CNPJ: " + this.cnpj);

    }

    public void ExibirMenu() {
        System.out.println("\nPara prosseguir, escolha uma das opções disponíveis do menu...");
        System.out.println("\n------ Menu ------");
        System.out.println("\n1.Cadastrar Produto");
        System.out.println("2.Gerenciar Produto");
        System.out.println("3.Exibir Produtos\n");

    }

    public void CadastrarProduto(ArrayList<Produto> catalogo, Scanner entrada) {

        System.out.println("Escreva qual tipo de produto deseja cadastrar:");
        String tipo = entrada.nextLine();

        System.out.println("Insira o ID:");
        String idProduto = entrada.nextLine();

        System.out.println("Insira o Preço:");
        String preco = entrada.nextLine();

        System.out.println("Insira a Descrição:");
        String descricao = entrada.nextLine();

        System.out.println("Insira a Marca:");
        String marca = entrada.nextLine();

        System.out.println("Insira a Quantidade:");
        String quantidade = entrada.nextLine();

        CSV_produto csvParaSalvar = new CSV_produto();

        csvParaSalvar.tipo = tipo;
        csvParaSalvar.idProduto = idProduto;
        csvParaSalvar.descricao = descricao;
        csvParaSalvar.marca = marca;
        csvParaSalvar.preco = preco;
        csvParaSalvar.quantidade = quantidade;

        switch (tipo.toUpperCase()) {
            case "SMARTPHONE":
                System.out.println("Insira o Sistema Operacional:");
                String so = entrada.nextLine();
                System.out.println("Insira o Tamanho da Tela:");
                String tela = entrada.nextLine();
                System.out.println("Insira a Cor:");
                String cor = entrada.nextLine();

                csvParaSalvar.sistemaOperacional = so;
                csvParaSalvar.telaTamanho = tela;
                csvParaSalvar.cor = cor;

                break;

            case "NOTEBOOK":
                System.out.println("Insira o Processador:");
                String processador = entrada.nextLine();
                System.out.println("Insira a Memória RAM:");
                String memoriaRam = entrada.nextLine();
                System.out.println("Insira o Armazenamento:");
                String armazenamento = entrada.nextLine();

                csvParaSalvar.processador = processador;
                csvParaSalvar.memoriaRam = memoriaRam;
                csvParaSalvar.armazenamento = armazenamento;

                break;

            case "CONSOLE":
                System.out.println("Insira a Geração:");
                String geracao = entrada.nextLine();
                System.out.println("Insira o Modelo:");
                String modelo = entrada.nextLine();

                csvParaSalvar.geracao = geracao;
                csvParaSalvar.modelo = modelo;

                break;

            case "TV":
                System.out.println("Insira o Tamanho em Polegadas:");
                String polegadas = entrada.nextLine();
                System.out.println("Insira a Resolução:");
                String resolucao = entrada.nextLine();

                csvParaSalvar.polegadas = polegadas;
                csvParaSalvar.resolucao = resolucao;

                break;

            case "HEADSET":
                System.out.println("Insira o Tipo de Conexão:");
                String tipoConexao = entrada.nextLine();
                System.out.println("Possui Som Surround? (true/false):");
                String somSurround = entrada.nextLine();
                System.out.println("Possui Cancelamento de Ruído? (true/false):");
                String cancelamentoRuido = entrada.nextLine();

                csvParaSalvar.tipoConexao = tipoConexao;
                csvParaSalvar.somSurround = somSurround;
                csvParaSalvar.cancelamentoRuido = cancelamentoRuido;

                break;

            case "MOUSE":
                System.out.println("Insira o Tipo de Conexão:");
                String tipoConexaoMouse = entrada.nextLine();
                System.out.println("Insira o Sensor:");
                String sensor = entrada.nextLine();
                System.out.println("Insira o DPI:");
                String dpi = entrada.nextLine();

                csvParaSalvar.tipoConexao = tipoConexaoMouse;
                csvParaSalvar.sensor = sensor;
                csvParaSalvar.dpi = dpi;

                break;

            case "TECLADO":
                System.out.println("Insira o Tipo de Conexão:");
                String tipoConexaoTeclado = entrada.nextLine();
                System.out.println("Insira o Layout:");
                String layout = entrada.nextLine();
                System.out.println("Insira o Tipo de Switch:");
                String tipoSwitch = entrada.nextLine();

                csvParaSalvar.tipoConexao = tipoConexaoTeclado;
                csvParaSalvar.layout = layout;
                csvParaSalvar.tipoSwitch = tipoSwitch;

                break;

            default:
                System.out.println("Categoria inválida. Por favor, escreva novamente sua escolha.");
                break;

        }

        Loja.SalvarProdutoNoCSV(csvParaSalvar, "produtos.csv");
    }

}

/*
 * private void GerenciarEstoque() {
 * 
 * }
 */
