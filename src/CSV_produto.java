import com.opencsv.bean.CsvBindByName;

public class CSV_produto {
    
    @CsvBindByName(column = "Tipo") public String tipo;
    @CsvBindByName(column = "idProduto") public String idProduto;
    @CsvBindByName(column = "descricao") public String descricao;
    @CsvBindByName(column = "marca") public String marca;
    @CsvBindByName(column = "preco") public double preco;

    @CsvBindByName(column = "SistemaOperacional") public String sistemaOperacional;
    @CsvBindByName(column = "TelaTamanho") public String telaTamanho;
    @CsvBindByName(column = "Cor") public String cor;

    @CsvBindByName(column = "Processador") public String processador;
    @CsvBindByName(column = "MemoriaRam") public String memoriaRam;
    @CsvBindByName(column = "Armazenamento") public String armazenamento;

    @CsvBindByName(column = "Polegadas") public String polegadas;
    @CsvBindByName(column = "Resolucao") public String resolucao;

    @CsvBindByName(column = "Geracao") public String geracao;
    @CsvBindByName(column = "Modelo") public String modelo;

    @CsvBindByName(column = "TipoConexao") public String tipoConexao;
    @CsvBindByName(column = "Sensor") public String sensor;
    @CsvBindByName(column = "DPI") public String dpi;
    @CsvBindByName(column = "Layout") public String layout;
    @CsvBindByName(column = "TipoSwitch") public String tipoSwitch;
    @CsvBindByName(column = "SomSurround") public String somSurround;
    @CsvBindByName(column = "CancelamentoRuido") public String cancelamentoRuido;
}
