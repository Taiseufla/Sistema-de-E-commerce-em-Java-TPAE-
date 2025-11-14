package Produtos.Perifericos;
public class Mouse extends Perifericos {

    private String Sensor;
    private int DPI;

    public Mouse(String idProduto, double preco, String descricao, String marca, int quantidade, String Conexao, String Sensor, int DPI) {
        super(idProduto, preco, descricao, marca, quantidade, Conexao);
        this.Sensor = Sensor;
        this.DPI = DPI;
    }
}

