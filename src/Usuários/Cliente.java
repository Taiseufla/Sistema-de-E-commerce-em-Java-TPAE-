package Usuários;

public class Cliente extends Usuario {

    private String CPF;
    private String endereco;

    public Cliente (int Id, String Username, String Senha, String Email, String CPF, String endereco){
        super(Id, Username, Senha, Email);
        this.CPF = CPF;
        this.endereco = endereco;
    }

    public void ExibirDados(){
        super.ExibirDados();
        System.out.println("------ Cliente ------");
        System.out.println("\nNome: " +getUsername());
        System.out.println("CPF: "+this.CPF);
        System.out.println("Endereço: "+this.endereco);
    }
     public void ExibirMenu(){
         System.out.println("\nPara prosseguir, escolha uma das opções disponíveis do menu...");
        System.out.println("\n------ Menu ------");
        System.out.println("\n1.Exibir Produtos");
        System.out.println("2.Buscar Produto\n");
    }
}