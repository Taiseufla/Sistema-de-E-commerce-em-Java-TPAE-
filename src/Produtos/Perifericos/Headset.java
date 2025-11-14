package Produtos.Perifericos;

import Model.CSV_produto;

public class Headset extends Perifericos {

    private boolean somSourroud;
    private boolean CancelRuido;

    public Headset(String idProduto, double preco, String descricao, String marca, int quantidade, String Conexao, boolean somSourroud, boolean CancelRuido) {
        super(idProduto, preco, descricao, marca, quantidade, Conexao);
        this.somSourroud = somSourroud;
        this.CancelRuido = CancelRuido;
    }

    @Override
    public void ExibirProduto() {
        super.ExibirProduto();
        System.out.println("Som Surround: " + (somSourroud ? "Sim" : "Não"));
        System.out.println("Cancelamento de Ruído: " + (CancelRuido ? "Sim" : "Não"));
    }

    @Override
    public CSV_produto toCSV(){
        CSV_produto csv = super.toCSV();
        csv.tipo = "HEADSET";
        csv.somSurround = String.valueOf(this.somSourroud);
        csv.cancelamentoRuido = String.valueOf(this.CancelRuido);
        return csv;
    }

}