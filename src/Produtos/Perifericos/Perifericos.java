package Produtos.Perifericos;
import Produtos.Produto;

public class Perifericos extends Produto {

    private String Conexao;

    public Perifericos(String idProduto, double preco, String descricao, String marca, String Conexao) {
        super(idProduto, preco, descricao, marca);
        this.Conexao = Conexao;
    }
}