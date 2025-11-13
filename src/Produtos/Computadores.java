package Produtos;
public class Computadores extends Produto{

    private String Processador;
    private int MemoriaRAM;
    private int armazenamento;

    public Computadores(String idProduto, double preco, String descricao, String marca, String Processador, int MemoriaRAM, int armazenamento) {
        super(idProduto, preco, descricao, marca);
        this.Processador = Processador;
        this.MemoriaRAM = MemoriaRAM;
        this.armazenamento = armazenamento;
}