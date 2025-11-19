package Usuários;

import java.util.ArrayList;
import java.util.Scanner;

import Ecommerce.Carrinho;
import Ecommerce.Loja;
import Ecommerce.Pedidos;
import Produtos.Produto;

/**
 * Classe Cliente - Representa um cliente/consumidor do sistema de e-commerce
 *
 * RESPONSABILIDADE:
 * - Estende a classe abstrata `Usuario` e adiciona informações específicas de clientes,
 *   como CPF, endereço e um carrinho de compras (`Carrinho`).
 * - Fornece métodos para exibir dados, mostrar o menu de cliente e procurar/adquirir produtos.
 */
public class Cliente extends Usuario {

    private String CPF;
    private String endereco;
    private Carrinho carrinho;
    private Pedidos pedido;

    /**
     * Construtor do cliente.
     * Inicializa atributos herdados e cria um `Carrinho` vazio associado a este cliente.
     *
     * @param Id        identificador único do usuário
     * @param Username  nome de usuário / nome exibido
     * @param Senha     senha de autenticação
     * @param Email     email de contato
     * @param CPF       CPF do cliente (pessoa física)
     * @param endereco  endereço do cliente
     */
    public Cliente (int Id, String Username, String Senha, String Email, String CPF, String endereco){
        super(Id, Username, Senha, Email);
        this.carrinho = new Carrinho(this);
        this.CPF = CPF;
        this.endereco = endereco;
    }

    /**
     * Retorna o endereço do cliente
     * @return endereço cadastrado
     */
    public String getEndereco(){
        return this.endereco;
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
        System.out.println("3.Exibir carrinho");
        System.out.println("4.Logout");
        System.out.println("-----------------------\n");
    }

    /**
     * Fluxo de busca/ação sobre um produto desejado pelo cliente.
     *
     * FUNCIONALIDADE:
     * - Solicita ao usuário o código do produto
     * - Busca no catálogo usando `Loja.BuscarProdutoPorID`
     * - Se encontrado, exibe detalhes e pergunta se o cliente deseja adicionar ao carrinho,
     *   comprar imediatamente (realiza decremento de estoque) ou voltar
     *
     * OBSERVAÇÕES SOBRE ENTRADA:
     * - Usa `Scanner` passado como parâmetro para ler entradas do usuário.
     * - Após chamar `nextInt()` é necessário consumir a nova linha com `nextLine()` para evitar problemas
     *   nas leituras subsequentes (padrão do Scanner ao misturar nextInt() e nextLine()).
     *
     * @param catalogo lista de produtos onde a busca será realizada
     * @param entrada  Scanner já instanciado usado para ler entradas do usuário
     */
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
                    carrinho.adicionarProduto(produto);                  
                    break;
                    
                    case 2:
                    //Criar uma forma de finalizar a compra diretamente.
                    ArrayList <Produto> realizarpedido = new ArrayList<Produto>();
                    realizarpedido.add(produto);
                    Pedidos pedido = new Pedidos(this, realizarpedido);
                    pedido.ExibirPedido();
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
    /**
     * Retorna o carrinho associado a este cliente
     * @return instância de `Carrinho` do cliente
     */
    public Carrinho getCarrinho(){
        return carrinho;
    }
}