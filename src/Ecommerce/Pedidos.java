package Ecommerce;

import java.util.ArrayList;

import Produtos.Produto;
import Usuários.Cliente;

public class Pedidos {
    private Cliente cliente;
    private ArrayList<Produto> Lista_pedidos;
    private double precoTotal = 0;

    public Pedidos(Cliente cliente, ArrayList<Produto> Lista_pedidos) {
        this.cliente = cliente;
        this.Lista_pedidos = (ArrayList<Produto>) Lista_pedidos.clone();

        for(Produto produto:Lista_pedidos){
            precoTotal = produto.getPreco() + precoTotal;
            int quantidade = produto.getQuantidade();
            produto.setQuantidade(quantidade - 1);
        }
    }

    public void ExibirPedido() {
        System.out.println("--------- PEDIDO CONCLUÍDO ---------");
        System.out.println(cliente.getUsername() + ", " + cliente.getEmail());
        System.out.println(cliente.getEndereco() + "\n");
        for (Produto produto : Lista_pedidos) {
            produto.ExibirCatalogo();
        }
    }
}