import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import Produtos.Produto;
import Usuários.Cliente;
import Usuários.Lojista;
import Usuários.Usuario;

public class Loja {

    public static void main(String[] args) {

        ArrayList<Usuario> Lista_usuario = Ler_usuariosCSV("usuarios.csv");
        Usuario usuariologado = null;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Bem-vindo(a) à nossa loja, para prosseguir digite o seu e-mail");
        String Email_in = entrada.next();
        System.out.println("\nDigite sua senha");
        String Senha_in = entrada.next();

        
        for (Usuario verifUsuario : Lista_usuario) {
            
            if (verifUsuario.getEmail().equals(Email_in) && verifUsuario.getSenha().equals(Senha_in)) {
                usuariologado = verifUsuario;
                break;
            }
            
        }
        
        if (usuariologado != null) {
            if (usuariologado instanceof Lojista) {
                Lojista vendedor = (Lojista) usuariologado;
                vendedor.ExibirDados();
                vendedor.ExibirMenu();
                
                int opcao = entrada.nextInt();
                switch (opcao) {
                    /*case 1:
                        vendedor.CadastrarProduto();  

                        break;
                    case 2:
                        vendedor.GerenciarEstoque();
                        break;*/
                    case 3:
                        ArrayList<Produto> catalogo = Catalogo("produtos.csv");
                        for (Produto produto : catalogo) {
                            produto.Exibir();
                        }
                    default:
                        System.out.println("Opção inválida");
                        break;
                } 
                
            } else {
                Cliente cliente = (Cliente) usuariologado;
                cliente.ExibirDados();
                cliente.ExibirMenu();
            }
            
        } else {
            System.out.println("E-mail e/ou senha inválidos");
        }
        
        entrada.close();
    }
    
    public static ArrayList<Usuario> Ler_usuariosCSV(String arquivo) {

        try {
            CsvToBean<CSV_usuarios> reader = new CsvToBeanBuilder<CSV_usuarios>(new FileReader(arquivo))
                    .withType(CSV_usuarios.class)
                    .withSeparator(';')
                    .build();

            List<CSV_usuarios> Lista_CSV = reader.parse();

            ArrayList<Usuario> Lista_usuario = new ArrayList<Usuario>();

            for (CSV_usuarios csvUser : Lista_CSV) {

                if (csvUser.tipo == 1) {
                    Usuario lojista = new Lojista(csvUser.id, csvUser.nome, csvUser.senha, csvUser.email, csvUser.cnpj);
                    Lista_usuario.add(lojista);
                } else {
                    Usuario cliente = new Cliente(csvUser.id, csvUser.nome, csvUser.senha, csvUser.email, csvUser.cpf,
                            csvUser.endereco);
                    Lista_usuario.add(cliente);
                }
            }
            return Lista_usuario;

        } catch (IOException ex) {
            System.out.println(ex.toString());
            return new ArrayList<Usuario>();
        }
    }

    public static ArrayList<Produto> Catalogo(String arquivo) {
        try {
            CsvToBean<CSV_produto> reader = new CsvToBeanBuilder<CSV_produto>(new FileReader(arquivo))
                    .withType(CSV_produto.class)
                    .withSeparator(';')
                    .build();

            List<CSV_produto> Lista_CSV = reader.parse();
            ArrayList<Produto> Lista_produtos = new ArrayList<Produto>();

            for (CSV_produto csvProd : Lista_CSV) {
                Produto produto = new Produto(csvProd.idProduto, csvProd.preco, csvProd.descricao, csvProd.marca);
                Lista_produtos.add(produto);
            }
            return Lista_produtos;

        } catch (IOException ex) {
            System.out.println(ex.toString());
            return new ArrayList<Produto>();
        }
    }
}