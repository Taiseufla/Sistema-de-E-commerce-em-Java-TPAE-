package Produtos;

import Model.CSV_produto;

public abstract class Produto {

    public String idProduto;
    private double preco;
    private String descricao;
    private String marca;
    private int quantidade;

    public Produto(String idProduto, double preco, String descricao, String marca, int quantidade) {
        this.idProduto = idProduto;
        this.preco = preco;
        this.descricao = descricao;
        this.marca = marca;
        this.quantidade = quantidade;
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

    public int getQuantidade() {
        return this.quantidade;
    }

    public void ExibirCatalogo() {
        System.out.println("Código do Produto: " + idProduto);
        System.out.println("Descrição: " + descricao);
        System.out.println("Preço: R$" + preco);
        System.out.println("-----------------------\n");
    }

    public void ExibirResumo() {
        System.out.println("Código do Produto: " + idProduto);
        System.out.println("Descrição: " + descricao);
        System.out.println("Quantidade em Estoque: " + quantidade);
        System.out.println("Preço: R$" + preco);
        System.out.println("-----------------------\n");

    }

    public void ExibirProduto() {
        System.out.println("Código do Produto: " + idProduto);
        System.out.println("Descrição: " + descricao);
        System.out.println("Preço: R$" + preco);
        System.out.println("Marca: " + marca);
    }

    public void setQuantidade(int novaQuantidade) {
        this.quantidade = novaQuantidade;
    }

    public CSV_produto toCSV() {
        CSV_produto csv = new CSV_produto();
        csv.idProduto = this.idProduto;
        csv.preco = String.valueOf(this.preco);
        csv.descricao = this.descricao;
        csv.marca = this.marca;
        csv.quantidade = String.valueOf(this.quantidade);
        return csv;
    }

}