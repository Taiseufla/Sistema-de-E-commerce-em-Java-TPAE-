package Model;

import com.opencsv.bean.CsvBindByName;

/**
 * Classe CSV_usuarios - Modelo de dados para serialização e desserialização de usuários no arquivo CSV
 * 
 * FUNCIONALIDADE PRINCIPAL:
 * Esta classe atua como um mapeador entre os dados em formato CSV e objetos Java.
 * Utiliza a biblioteca OpenCSV com anotações @CsvBindByName para vincular cada atributo
 * a uma coluna específica no arquivo CSV de usuários, identificando colunas pelo nome do cabeçalho.
 * 
 * IMPORTANTE:
 * - O campo "Endereço" só é utilizado por Clientes
 * - O campo "CNPJ" só é utilizado por Lojistas
 * - Campos não utilizados por um tipo de usuário podem ficar vazios no CSV
 */
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