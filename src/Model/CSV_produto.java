package Model;

import com.opencsv.bean.CsvBindByPosition;

public class CSV_produto {
    
    @CsvBindByPosition(position = 0) public String tipo;
    @CsvBindByPosition(position = 1) public String idProduto;
    @CsvBindByPosition(position = 2) public String descricao;
    @CsvBindByPosition(position = 3) public String marca;
    @CsvBindByPosition(position = 4) public String preco;
    @CsvBindByPosition(position = 5) public String quantidade;

    @CsvBindByPosition(position = 6) public String sistemaOperacional;
    @CsvBindByPosition(position = 7) public String telaTamanho;
    @CsvBindByPosition(position = 8) public String cor;

    @CsvBindByPosition(position = 9) public String processador;
    @CsvBindByPosition(position = 10) public String memoriaRam;
    @CsvBindByPosition(position = 11) public String armazenamento;

    @CsvBindByPosition(position = 12) public String polegadas;
    @CsvBindByPosition(position = 13) public String resolucao;

    @CsvBindByPosition(position = 14) public String geracao;
    @CsvBindByPosition(position = 15) public String modelo;

    @CsvBindByPosition(position = 16) public String tipoConexao;
    @CsvBindByPosition(position = 17) public String sensor;
    @CsvBindByPosition(position = 18)public String dpi;
    @CsvBindByPosition(position = 19) public String layout;
    @CsvBindByPosition(position = 20) public String tipoSwitch;
    @CsvBindByPosition(position = 21)public String somSurround;
    @CsvBindByPosition(position = 22) public String cancelamentoRuido;
}
