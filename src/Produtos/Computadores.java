package Produtos;
public class Computadores extends Produto{

    private String Processador;
    private String MemoriaRAM;
    private String armazenamento;

    public Computadores(String idProduto, double preco, String descricao, String marca, String Processador, String MemoriaRAM, String armazenamento) {
        super(idProduto, preco, descricao, marca);
        this.Processador = Processador;
        this.MemoriaRAM = MemoriaRAM;
        this.armazenamento = armazenamento;
}
}