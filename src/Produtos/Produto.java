package Produtos;

public class Produto {

    private String idProduto;
    private double preco;
    private String descricao;
    private String marca;

    public Produto(String idProduto, double preco, String descricao, String marca) {
        this.idProduto = idProduto;
        this.preco = preco;
        this.descricao = descricao;
        this.marca = marca;
    }

    public String getIdproduto() {
        return this.idProduto;
    }

    public double getPreco() {
        return this.preco;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getMarca() {
        return this.marca;
    }

   public void ExibirResumo(){
        System.out.println("Código do Produto: " + idProduto);
        System.out.println("Descrição: " + descricao);
        System.out.println("-----------------------\n");
    }

    public void ExibirProduto() {
        System.out.println("Código do Produto: " +idProduto);
        System.out.println("Preço: R$" +preco);
        System.out.println("Marca: " +marca);
        System.out.println("Descrição: " +descricao);
    }

}