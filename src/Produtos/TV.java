package Produtos;

import Model.CSV_produto;

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

    @Override
    public CSV_produto toCSV(){
        CSV_produto csv = super.toCSV();
        csv.tipo = "TV";
        csv.polegadas = String.valueOf(this.polegadas);
        csv.resolucao = this.resolucao;
        return csv;

    }

}