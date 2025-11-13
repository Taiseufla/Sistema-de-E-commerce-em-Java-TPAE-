package Produtos;

public class Smartphone extends Produto {

    private String SO;
    private double TelaTamanho;
    private String cor;

    public Smartphone(String idProduto, double preco, String descricao, String marca, String SO) {
        super(idProduto, preco, descricao, marca);
        this.SO = SO;
        this.TelaTamanho = TelaTamanho;
        this.cor = cor;
    }

}