package Produtos.Perifericos;

import Model.CSV_produto;

public class Mouse extends Perifericos {

    private String Sensor;
    private int DPI;

    public Mouse(String idProduto, double preco, String descricao, String marca, int quantidade, String Conexao, String Sensor, int DPI) {
        super(idProduto, preco, descricao, marca, quantidade, Conexao);
        this.Sensor = Sensor;
        this.DPI = DPI;
    }

    @Override
    public void ExibirProduto() {
        super.ExibirProduto();
        System.out.println("Tipo de Sensor: " + Sensor);
        System.out.println("DPI: " + DPI);
    }

    @Override
    public CSV_produto toCSV(){
        CSV_produto csv = super.toCSV();
        csv.tipo = "MOUSE";
        csv.sensor = this.Sensor;
        csv.dpi = String.valueOf(this.DPI);
        return csv;
    }
}

