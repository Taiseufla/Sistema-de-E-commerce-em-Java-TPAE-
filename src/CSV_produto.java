import com.opencsv.bean.CsvBindByName;

public class CSV_produto {
    //idProduto;preco;descricao;marca
    @CsvBindByName(column = "idProduto")
    public int idProduto;
    @CsvBindByName(column = "preco")
    public double preco;
    @CsvBindByName(column = "descricao")
    public String descricao;
    @CsvBindByName(column = "marca")
    public String marca;
}
