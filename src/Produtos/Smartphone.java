package Produtos;

import Model.CSV_produto;

public class Smartphone extends Produto {

    private String SO;
    private double TelaTamanho;
    private String cor;

    public Smartphone(String idProduto, double preco, String descricao, String marca, int quantidade, String SO, double TelaTamanho, String cor) {
        super(idProduto, preco, descricao, marca, quantidade);
        this.SO = SO;
        this.TelaTamanho = TelaTamanho;
        this.cor = cor;
    }

    @Override
    public void ExibirProduto() {
        super.ExibirProduto();
        System.out.println("Sistema Operacional: " + SO);
        System.out.println("Tamanho da Tela: " + TelaTamanho + " polegadas");
        System.out.println("Cor: " + cor);
    }

    @Override
    public CSV_produto toCSV(){
        CSV_produto csv = super.toCSV();
        csv.tipo = "SMARTPHONE";
        csv.sistemaOperacional = this.SO;
        csv.telaTamanho = String.valueOf(this.TelaTamanho);
        csv.cor = this.cor;
        return csv;
    }
}