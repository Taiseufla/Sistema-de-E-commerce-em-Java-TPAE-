package Produtos.Perifericos;

import Model.CSV_produto;

public class Teclado extends Perifericos {

    private String Layout;
    private String tipoSwitch;

    public Teclado(String idProduto, double preco, String descricao, String marca, int quantidade,String Conexao, String Layout, String tipoSwitch) {
        super(idProduto, preco, descricao, marca, quantidade, Conexao);
        this.Layout = Layout;
        this.tipoSwitch = tipoSwitch;
    }

    @Override
    public void ExibirProduto() {
        super.ExibirProduto();
        System.out.println("Layout: " + Layout);
        System.out.println("Tipo de Switch: " + tipoSwitch);
    }

    @Override
    public CSV_produto toCSV() {
        CSV_produto csv = super.toCSV();
        csv.tipo = "Teclado";
        csv.layout = this.Layout;
        csv.tipoSwitch = this.tipoSwitch;
        return csv;
    }
}