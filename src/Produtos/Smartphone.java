package Produtos;

public class Smartphone extends Produto {

    private String SO;
    private String TelaTamanho;
    private String cor;

    public Smartphone(String idProduto, double preco, String descricao, String marca, int quantidade, String SO, String TelaTamanho, String cor) {
        super(idProduto, preco, descricao, marca, quantidade);
        this.SO = SO;
        this.TelaTamanho = TelaTamanho;
        this.cor = cor;
    }

}