package Usuários;

import java.util.ArrayList;
import java.util.Scanner;

import Ecommerce.Loja;
import Produtos.Produto;

public class Cliente extends Usuario {

    private String CPF;
    private String endereco;

    public Cliente (int Id, String Username, String Senha, String Email, String CPF, String endereco){
        super(Id, Username, Senha, Email);
        this.CPF = CPF;
        this.endereco = endereco;
    }

    public void ExibirDados(){
        super.ExibirDados();
        System.out.println("------ Cliente ------");
        System.out.println("\nNome: " +getUsername());
        System.out.println("CPF: "+this.CPF);
        System.out.println("Endereço: "+this.endereco);
    }
     public void ExibirMenu(){
         System.out.println("\nPara prosseguir, escolha uma das opções disponíveis do menu...");
        System.out.println("\n------ Menu ------");
        System.out.println("1.Buscar Produto");
        System.out.println("2.Exibir Produtos");
        System.out.println("3.Salvar ações");
        System.out.println("4.Logout");
        System.out.println("-----------------------\n");
    }

    public void ProdutoDesejado(ArrayList<Produto> catalogo, Scanner entrada) {

        System.out.println("\nEscreva o código do produto que buscar:");
        String codigoProduto = entrada.nextLine();
        Produto produto = Loja.BuscarProdutoPorID(codigoProduto, catalogo);

        if (produto != null) {
            System.out.println("Produto encontrado:");
            produto.ExibirProduto();

            System.out.println("\n1. Deseja adicionar este produto ao carrinho?");
            System.out.println("2. Deseja comprar este produto?");
            System.out.println("3. Voltar ao catálogo");

            int opcao = entrada.nextInt();
            entrada.nextLine(); // Consumir a nova linha após nextInt()

            try {
                
                switch(opcao){
                    case 1:
                    System.out.println("Produto adicionado ao carrinho de compras!");
                    Loja.SalvarProdutoNoCSV(produto.toCSV(), "carrinho.csv");
                    
                    break;
                    
                    case 2:
                    System.out.println("Pedido efetuado com sucesso!");
                    int quantidade = produto.getQuantidade();
                    produto.setQuantidade(quantidade - 1); 
                    break;
                    case 3:
                    break;
                }
            } catch (Exception ex) {
                System.out.println("Erro ao processar a solicitação: " + ex.getMessage());
            }
        } else {
            System.out.println("Produto não encontrado.");
        }
        


    }

}