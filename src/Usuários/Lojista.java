package Usuários;

public class Lojista extends Usuario {
    
    private String cnpj;
    
    public Lojista (int Id, String Username, String Senha, String Email, String cnpj){
        super(Id, Username, Senha, Email);
        this.cnpj = cnpj;
    }

    public void ExibirDados(){
        super.ExibirDados();
        System.out.println("------ Lojista ------");
        System.out.println("\nNome: " +getUsername());
        System.out.println("CNPJ: "+this.cnpj);
        
    }
    
    public void ExibirMenu(){
        System.out.println("\nPara prosseguir, escolha uma das opções disponíveis do menu...");
        System.out.println("\n------ Menu ------");
        System.out.println("\n1.Cadastrar Produto");
        System.out.println("2.Gerenciar Produto");
        System.out.println("3.Exibir Produtos\n");


    }

    /*private void CadastrarProduto() {
    }
    private void GerenciarEstoque() {

    }*/
}