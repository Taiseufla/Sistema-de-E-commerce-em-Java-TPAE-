package Usuários;
public abstract class Usuario {

        private int Id;
        private String Username;
        private String Email;
        private String Senha;

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

