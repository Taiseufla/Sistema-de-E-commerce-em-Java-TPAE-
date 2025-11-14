package Produtos;

import Model.CSV_produto;

public class Notebooks extends Produto{

    private String Processador;
    private String MemoriaRAM;
    private String armazenamento;

    public Notebooks(String idProduto, double preco, String descricao, String marca,  int quantidade, String Processador, String MemoriaRAM, String armazenamento) {
        super(idProduto, preco, descricao, marca, quantidade);
        this.Processador = Processador;
        this.MemoriaRAM = MemoriaRAM;
        this.armazenamento = armazenamento;
    }

    @Override
    public void ExibirProduto() {
        super.ExibirProduto();
        System.out.println("Processador: " + Processador);
        System.out.println("Memória RAM: " + MemoriaRAM);
        System.out.println("Armazenamento: " + armazenamento);
    }

    @Override
    public CSV_produto toCSV(){
        CSV_produto csv = super.toCSV();
        csv.tipo = "NOTEBOOK";
        csv.processador = this.Processador;
        csv.memoriaRam = this.MemoriaRAM;
        csv.armazenamento = this.armazenamento;
        return csv;
    }
}