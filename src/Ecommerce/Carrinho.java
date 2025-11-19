package Ecommerce;
import java.util.ArrayList;

import Produtos.Produto;
import Usuários.Cliente;

public class Carrinho {

    private Cliente cliente;
    private ArrayList<Produto> carrinho;

    public Carrinho(Cliente cliente) {
        this.cliente = cliente;
        this.carrinho = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        carrinho.add(produto);
        System.out.println("Produto adicionado ao carrinho, para conferir acesse o carrinho.");
    }

    public void removerProduto(Produto produto) {
        carrinho.remove(produto);
        System.out.println("Produto removido do carrinho: " + produto.getDescricao());
    }

    public void exibirCarrinho() {
        System.out.println("Carrinho de compras do cliente: " + cliente.getUsername());
        for (Produto produto : carrinho) {
            produto.ExibirCatalogo();
        }
    }
    public Pedidos finalizarCompra(){
        Pedidos pedido = new Pedidos(cliente, carrinho);
        carrinho.clear();
        return pedido;
    } 

}