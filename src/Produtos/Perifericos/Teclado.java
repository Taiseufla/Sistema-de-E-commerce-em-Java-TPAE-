package Produtos.Perifericos;
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
}