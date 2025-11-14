package Produtos;

public class TV extends Produto {

    private int polegadas;
    private String resolucao;

    public TV(String idProduto, double preco, String descricao, String marca, int quantidade, int polegadas, String resolucao) {
        super(idProduto, preco, descricao, marca, quantidade);
        this.polegadas = polegadas;
        this.resolucao = resolucao;
    }   
}