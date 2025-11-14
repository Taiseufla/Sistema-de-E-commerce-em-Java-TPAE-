package Produtos.Perifericos;
import Produtos.Produto;

public class Perifericos extends Produto {

    private String Conexao;

    public Perifericos(String idProduto, double preco, String descricao, String marca, int quantidade, String Conexao) {
        super(idProduto, preco, descricao, marca, quantidade);
        this.Conexao = Conexao;
    }

    @Override
    public void ExibirProduto() {
        super.ExibirProduto();
        System.out.println("Conexão: " + Conexao);
    }
}