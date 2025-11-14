package Produtos;

import Model.CSV_produto;

public class Consoles extends Produto {

    private String Geracao;
    private String Modelo;

    public Consoles(String idProduto, double preco, String descricao, String marca, int quantidade, String Geracao, String Modelo) {
        super(idProduto, preco, descricao, marca, quantidade);
        this.Geracao = Geracao;
        this.Modelo = Modelo;
    }

    @Override
    public void ExibirProduto() {
        super.ExibirProduto();
        System.out.println("Geração: " + Geracao);
        System.out.println("Modelo: " + Modelo);
    }

    @Override
    public CSV_produto toCSV(){
        CSV_produto csv = super.toCSV();
        csv.tipo = "CONSOLE";
        csv.geracao = this.Geracao;
        csv.modelo = this.Modelo;
        return csv;
    }
}