package Produtos.Perifericos;
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

}