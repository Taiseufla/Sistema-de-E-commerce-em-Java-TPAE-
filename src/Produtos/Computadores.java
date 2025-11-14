package Produtos;
public class Computadores extends Produto{

    private String Processador;
    private String MemoriaRAM;
    private String armazenamento;

    public Computadores(String idProduto, double preco, String descricao, String marca,  int quantidade, String Processador, String MemoriaRAM, String armazenamento) {
        super(idProduto, preco, descricao, marca, quantidade);
        this.Processador = Processador;
        this.MemoriaRAM = MemoriaRAM;
        this.armazenamento = armazenamento;
}
}