package Model;

import com.opencsv.bean.CsvBindByName;

public class CSV_usuarios {
    @CsvBindByName(column = "Id")
    public int id;
    @CsvBindByName(column = "Tipo")
    public int tipo;
    @CsvBindByName(column = "Email")
    public String email;
    @CsvBindByName(column = "Senha")
    public String senha;
    @CsvBindByName(column = "Nome")
    public String nome;
    @CsvBindByName(column = "CNPJ")
    public String cnpj;
    @CsvBindByName(column = "CPF")
    public String cpf;
    @CsvBindByName(column = "Endereço")
    public String endereco;
}