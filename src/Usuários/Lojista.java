package Usuários;

public class Lojista extends Usuario {
    
    private String cnpj;
    String palavra;
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

    public void CadastrarProduto(String palavra) {
        switch (palavra) {
            case "Smartphones":
                System.out.println("\nPor favor, insira as seguintes informações do produto: idProduto, preco, descricao, marca, modelo, capacidadeBateria, tamanhoTela, sistemaOperacional ");

                break;

            case "Computadores":
                System.out.println("\nPor favor, insira as seguintes informações do produto: idProduto, preco, descricao, marca, processador, memoriaRAM, armazenamento ");

                break;

            case "Consoles":
                System.out.println("\nPor favor, insira as seguintes informações do produto: idProduto, preco, descricao, marca, modelo, capacidadeArmazenamento, tipoConsole");
               
                break;

             case "Tvs":
                System.out.println("\nPor favor, insira as seguintes informações do produto: idProduto, preco, descricao, marca, tamanhoTela, resolucao");

                break;

             case "Headset":
                System.out.println("\nPor favor, insira as seguintes informações do produto: idProduto, preco, descricao, marca, conexão, somSourroud, CancelRuido");

                break;
            
            case "Mouse":
                System.out.println("\nPor favor, insira as seguintes informações do produto:idProduto, preco, descricao, marca, conexão, sensor, DPI ");

                break;

            case "Teclado":
                System.out.println("\nPor favor, insira as seguintes informações do produto: idProduto, preco, descricao, marca, conexão, Layout, tipoSwitch");

                break;

            default:
                System.out.println("Categoria inválida. Por favor, escreva novamente sua escolha.");            
                break;
        }
    }
    
    public void inserirDados()}{
        
    }

    /*private void GerenciarEstoque() {

    }*/
}