import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import com.opencsv.exceptions.CsvValidationException;
import com.opencsv.CSVReader;

import Produtos.Produto;
import Usuários.Cliente;
import Usuários.Lojista;
import Usuários.Usuario;

public class Loja {

    public static void main(String[] args) {

        ArrayList<Usuario> Lista_usuario = Ler_arquivos("usuarios.csv");
        Usuario usuariologado = null;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Bem-vindo(a) à nossa loja, para prosseguir digite o seu e-mail");
        String Email_in = entrada.next();
        System.out.println("\nDigite sua senha");
        String Senha_in = entrada.next();

        entrada.close();

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
            } else {
                Cliente cliente = (Cliente) usuariologado;
                cliente.ExibirDados();
            }

        } else {
            System.out.println("E-mail e/ou senha inválidos");
        }

    }

    public static ArrayList<Usuario> Ler_arquivos(String arquivo) {
        try {
            Scanner scanner = new Scanner(Paths.get(arquivo));
            scanner.useDelimiter(";|\\r\\n|\\n");

            ArrayList<Usuario> Lista_usuario = new ArrayList<Usuario>();

            scanner.nextLine();

            while (scanner.hasNext()) {
                int id = scanner.nextInt();
                int tipo = scanner.nextInt();
                String Email = scanner.next();
                String Senha = scanner.next();
                String Nome = scanner.next();
                String CNPJ = scanner.next();
                String CPF = scanner.next();
                String endereco = scanner.next();

                if (tipo == 1) {
                    Usuario lojista = new Lojista(id, Nome, Senha, Email, CNPJ);
                    Lista_usuario.add(lojista);
                } else {
                    Usuario cliente = new Cliente(id, Nome, Senha, Email, CPF, endereco);
                    Lista_usuario.add(cliente);
                }
            }
            scanner.close();
            return Lista_usuario;

        } catch (IOException ex) {
            System.out.println(ex.toString());
            return new ArrayList<Usuario>();
        }
    }

    public static ArrayList<Produto> Catalogo(String arquivo){
    try {
            Scanner scanner = new Scanner(Paths.get(arquivo));
            scanner.useDelimiter(";|\\r\\n|\\n");

            ArrayList<Produto> Catalogo = new ArrayList<Produto>();

            scanner.nextLine();

            while (scanner.hasNext()) {
                int id = scanner.nextInt();
                int tipo = scanner.nextInt();
                String Email = scanner.next();
                String Senha = scanner.next();
                String Nome = scanner.next();
                String CNPJ = scanner.next();
                String CPF = scanner.next();
                String endereco = scanner.next();

                if (tipo == 1) {
                    Usuario lojista = new Lojista(id, Nome, Senha, Email, CNPJ);
                    Lista_usuario.add(lojista);
                } else {
                    Usuario cliente = new Cliente(id, Nome, Senha, Email, CPF, endereco);
                    Lista_usuario.add(cliente);
                }
            }
            scanner.close();
            return Lista_usuario;

        } catch (IOException ex) {
            System.out.println(ex.toString());
            return new ArrayList<Usuario>();
        }
    }

}