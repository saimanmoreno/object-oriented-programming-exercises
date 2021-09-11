package ficheirosobjectos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FicheirosObjectos {

    public static void main(String[] args) throws IOException {
       
        ArrayList <Funcionario> funcionarios = new ArrayList<>();
        Funcionario f2 = new Funcionario();
        Scanner scan = new Scanner (System.in);
        String msg;
        
        ler(funcionarios);
        System.out.println(funcionarios);
        
        System.out.println("==================Adicionar Funcionario2====================");
        System.out.print("Nome: "); msg = scan.nextLine(); f2.setNome(msg);
        System.out.print("Password: "); msg = scan.nextLine(); f2.setPassword(msg);
        System.out.print("Data Nascimento (dd-mm-aa): "); msg = scan.nextLine(); f2.setDataNasc(msg);
        System.out.print("Sexo: "); msg = scan.nextLine(); f2.setSexo(msg);
        System.out.print("Morada: "); msg = scan.nextLine(); f2.setMorada(msg);
        System.out.print("Telefone: "); msg = scan.nextLine(); f2.setTelefone(Integer.parseInt(msg));
        System.out.println("Funcionario '"+f2.getNome()+ "' adicionado com sucesso!");
        funcionarios.add(f2);
        
        for(int i=0; i<funcionarios.size(); i++){
            
            System.out.println("Posicao: "+i);
            System.out.println(funcionarios.get(i));
        }
        
        gravar(funcionarios);
    }
    
    public static class Funcionario implements Serializable {
    
        private String nome;
        private String password;
        private String morada;
        private int telefone;
        private String dataNasc;
        private String sexo;

        /*public Funcionario(String nome, String password, int id, String morada, int telefone, String dataNasc, String sexo) {
            this.nome = nome;
            this.password = password;
            this.id = id;
            this.morada = morada;
            this.telefone = telefone;
            this.dataNasc = dataNasc;
            this.sexo = sexo;
        }
        */

        public String getSexo() {
            return sexo;
        }

        public void setSexo(String sexo) {
            this.sexo = sexo;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getMorada() {
            return morada;
        }

        public void setMorada(String morada) {
            this.morada = morada;
        }

        public int getTelefone() {
            return telefone;
        }

        public void setTelefone(int telefone) {
            this.telefone = telefone;
        }

        public String getDataNasc() {
            return dataNasc;
        }

        public void setDataNasc(String dataNasc) {
            this.dataNasc = dataNasc;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        /**
         *
         * @return
         */
        @Override
        public String toString() {
            return "Funcionario:" + nome +  
                    "\n\tData Nascimento: " + dataNasc + 
                    "\n\tSexo: " +sexo +
                    "\n\tMorada: " + morada + 
                    "\n\tTelefone: " + telefone;
                    
                    
        }
    }
    
    //gravar
    public static void gravar(ArrayList<Funcionario> funcionarios) throws FileNotFoundException, IOException{
        FileOutputStream arq = new FileOutputStream("Funcionario.txt");
        ObjectOutputStream obj = new ObjectOutputStream(arq);
        try{
            obj.writeObject(funcionarios);
            obj.flush();
            System.out.println("Funcionario guardado com sucesso!");
        }catch(IOException erro){
            System.err.println("Ocorreu erro na gravacao do arquivo: "+erro.getMessage());
        }
    }
      
    //ler
    public static void ler(ArrayList<Funcionario> funcionarios) throws FileNotFoundException, IOException{    
        
        FileInputStream arq = new FileInputStream("Funcionario.txt");
        ObjectInputStream obj = new ObjectInputStream(arq);
        try{
            funcionarios = (ArrayList<Funcionario>)obj.readObject();
            System.out.println("Funcionario lido com sucesso!");
        }catch(IOException | ClassNotFoundException erro){
            System.err.println("Ocorreu erro na leitura do arquivo: "+erro.getMessage());
        }
    }
}
