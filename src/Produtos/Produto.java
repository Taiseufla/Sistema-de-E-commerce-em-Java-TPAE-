package Produtos;

public abstract class Produto {

    private int idProduto;
    private double preco;
    private String descricao;
    private String marca;

    protected Produto(int idProduto, double preco, String descricao, String marca) {
        this.idProduto = idProduto;
        this.preco = preco;
        this.descricao = descricao;
        this.marca = marca;
    }

    public int getIdproduto() {
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

    public void Exibir(){
        System.out.println("Código do Produto: " +idProduto);
        System.out.println("Preço: R$" +preco);
        System.out.println("Marca: " +marca);
        System.out.println("Descrição: " +descricao);
    }
}