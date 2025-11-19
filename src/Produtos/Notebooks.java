package Produtos;

import Model.CSV_produto;

/**
 * Classe Notebooks - Representa um notebook portátil no sistema de e-commerce
 * 
 * HERANÇA: Estende a classe abstrata `Produto`, herdando atributos e métodos comuns como:
 * - idProduto, preco, descricao, marca, quantidade
 * - Métodos: ExibirProduto(), toCSV()
 * FUNCIONALIDADE:
 * Esta classe especializa o conceito de produto para notebooks, capturando características
 * técnicas essenciais que diferenciam um notebook de outro.
 */
public class Notebooks extends Produto{

    private String Processador;
    private String MemoriaRAM;
    private String armazenamento;

    /**
     * Construtor da classe Notebooks
     * 
     * @param idProduto       Identificador único do notebook
     * @param preco          Preço de venda do notebook
     * @param descricao      Descrição detalhada do notebook
     * @param marca          Marca/fabricante (ex: Dell, HP, Lenovo)
     * @param quantidade     Quantidade em estoque
     * @param Processador    Especificação do processador
     * @param MemoriaRAM     Especificação da memória RAM
     * @param armazenamento  Especificação do armazenamento
     */
    public Notebooks(String idProduto, double preco, String descricao, String marca,  int quantidade, String Processador, String MemoriaRAM, String armazenamento) {
        super(idProduto, preco, descricao, marca, quantidade);
        this.Processador = Processador;
        this.MemoriaRAM = MemoriaRAM;
        this.armazenamento = armazenamento;
    }

    /**
     * Exibe todas as informações de um objeto da classe notebook
     * Primeiro exibe os atributos comuns (via super.ExibirProduto())
     * e depois adiciona as especificações técnicas específicas do notebook
     */
    @Override
    public void ExibirProduto() {
        super.ExibirProduto();
        System.out.println("Processador: " + Processador);
        System.out.println("Memória RAM: " + MemoriaRAM);
        System.out.println("Armazenamento: " + armazenamento);
    }

    /**
     * @return instância de CSV_produto pronta para serialização em arquivo CSV
     */
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