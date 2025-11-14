package Produtos;

public class TV extends Produto {

    private double polegadas;
    private String resolucao;

    public TV(String idProduto, double preco, String descricao, String marca, int quantidade, double polegadas, String resolucao) {
        super(idProduto, preco, descricao, marca, quantidade);
        this.polegadas = polegadas;
        this.resolucao = resolucao;
    }

    @Override
    public void ExibirProduto() {
        super.ExibirProduto();
        System.out.println("Tamanho: " + polegadas + " polegadas");
        System.out.println("Resolução: " + resolucao);
    }

}