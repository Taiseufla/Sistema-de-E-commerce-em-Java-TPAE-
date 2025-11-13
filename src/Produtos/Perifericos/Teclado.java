package Produtos.Perifericos;
public class Teclado extends Perifericos {

    private String Layout;
    private String tipoSwitch;

    public Teclado(String idProduto, double preco, String descricao, String marca, String Conexao, String Layout, String tipoSwitch) {
        super(idProduto, preco, descricao, marca, Conexao);
        this.Layout = Layout;
        this.tipoSwitch = tipoSwitch;
    }
}