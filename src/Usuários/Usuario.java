package Usuários;

/**
 * Classe abstrata Usuario - Classe base para todos os tipos de usuários do sistema
 * 
 * FUNCIONALIDADE PRINCIPAL:
 * Esta classe abstrata define a estrutura comum de todos os usuários no sistema de e-commerce.
 * Funciona como uma classe pai que herança as propriedades básicas de um usuário. 
 */
public abstract class Usuario {

        private int Id;
        private String Username;
        private String Email;
        private String Senha;

        /**
         * Construtor protegido da classe abstrata Usuario
         * 
         * PROTECTED: Apenas subclasses podem chamar este construtor
         * Não pode ser chamado diretamente pela aplicação (classe abstrata)
         * Inicializa os dados básicos de qualquer usuário
         * 
         * @param Id Identificador único do usuário
         * @param Username Nome de usuário para exibição
         * @param Senha Senha de acesso do usuário
         * @param Email Email de contato do usuário
         */
        protected Usuario (int Id, String Username, String Senha, String Email) {
            this.Id = Id;
            this.Username = Username;
            this.Senha = Senha;
            this.Email = Email;
        }
        
        public int getId(){
            return this.Id;
        }

        public String getUsername(){
           return this.Username;
       }

        public String getEmail(){
            return this.Email; 
        }
        
        public String getSenha(){
            return this.Senha;
        }

        public void ExibirDados(){
            System.out.println("\nLogin realizado com sucesso! \nOlá, " +this.Username);
    
        }
    }

