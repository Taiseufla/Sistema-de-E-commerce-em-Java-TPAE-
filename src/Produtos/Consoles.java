package Produtos;
public class Consoles extends Produto {

    private String Geracao;
    private String Modelo;

    public Consoles(String idProduto, double preco, String descricao, String marca, String Geracao, String Modelo) {
        super(idProduto, preco, descricao, marca);
        this.Geracao = Geracao;
        this.Modelo = Modelo;
    }
}