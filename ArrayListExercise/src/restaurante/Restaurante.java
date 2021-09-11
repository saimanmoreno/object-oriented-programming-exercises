package restaurante;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Restaurante {
    
    public static void main(String[] args) throws IOException {
        
        File filerest = new File("Restaurantes.txt");
        File filecod = new File("CodigosRest.txt");
        File fileloc = new File("LocalizacaoRest.txt");
        
        Scanner ler = new Scanner (System.in);
        ArrayList <String> rest = new ArrayList <>();
        ArrayList <String> cod = new ArrayList <>();
        ArrayList <String> loc = new ArrayList <>();
        int op;
        
        do{
            System.out.println("==============Menu=================");
            System.out.println("(1) Adicionar restaurantes;\n"
                            + "(2) Listar restaurantes;\n"
                            + "(3) Pesquisar restaurantes;\n"
                            + "(4) Alterar Restaurantes;\n"
                            + "(5) Remover restaurantes;\n"
                            + "(6) Apagar todos os restaurantes;\n"
                            + "(7) Sair");
            System.out.print(">>  "); op=ler.nextInt();

            switch(op){
                case 1: adicionarRest(rest, cod, loc, filerest, filecod, fileloc); break;
                case 2: listarRest(rest, cod, loc, filerest, filecod, fileloc); break;
                case 3: pesquisar(rest, cod, loc, filerest, filecod, fileloc); break;
                case 4: alterarRest(rest, cod, loc, filerest, filecod, fileloc); break;
                case 5: removerRest(rest, cod, loc, filerest, filecod, fileloc); break;
                case 6: 
                    apagar(rest, filerest); 
                    apagar(cod, filecod);
                    apagar(loc, fileloc);
                    break;
                case 7: break;
                default: System.out.println("Opção Invalido");
            }
            System.out.println("");
        }while(op!=7);
        
        
    }
    
    //adicionar
    @SuppressWarnings("empty-statement")
    public static void adicionarRest(ArrayList rest, ArrayList cod, ArrayList loc, File filerest, File filecod, File fileloc) throws IOException{
        
        Scanner ler = new Scanner (System.in);
        String nome, local, codigo;
        System.out.print("NOME DO RESTAURANTE: "); nome = ler.nextLine();
        rest.add(nome);
        do{
            System.out.print("CODIGO DO RESTAURANTE: ");
            codigo = ler.nextLine();
            if(cod.contains(codigo)){
                System.out.println("Codigo ja cadastrado. Introduza outro codigo!");
            }else{
                cod.add(codigo);
                break;
            }
        }while(cod.contains(codigo));
        
        System.out.print("LOCALIZAÇÃO DO RESTAURANTE: "); local = ler.nextLine();
        loc.add(local);
        gravarDados(rest, filerest);
        gravarDados(cod, filecod);
        gravarDados(loc, fileloc);
        System.out.println("Restaurante '"+nome+"' adicionado com sucesso!");
    }
    
    //listar
    public static void listarRest(ArrayList rest, ArrayList cod, ArrayList loc, File filerest, File filecod, File fileloc) throws FileNotFoundException, IOException{
        
        if(0==rest.size()){
            LerDados(rest, filerest);
            LerDados(cod, filecod);
            LerDados(loc, fileloc);
        }
        if(rest.isEmpty()){
            System.out.println("Nenhum restaurante cadastrado!");
        }
        else{
            System.out.println("Lista de restaurantes cadastrados:");
            for (int i = 0; i < rest.size(); i++) {
                System.out.printf("RESTAURANTE: %s\tLOCALIZAÇÃO: %s\n", rest.get(i), loc.get(i));
            }
        }
    }
    
    //pesquisa restaurantes
    public static void pesquisar(ArrayList rest, ArrayList cod, ArrayList loc, File filerest, File filecod, File fileloc) throws IOException{
        Scanner ler = new Scanner (System.in);
        if(0==rest.size()){
            LerDados(rest, filerest);
            LerDados(cod, filecod);
            LerDados(loc, fileloc);
        }
        if(rest.isEmpty()){
            System.out.println("Nenhum restaurante cadastrado!");
        }
        else{
            System.out.println("Digite o nome do restaurante ou da localização: ");String nome = ler.nextLine();
            for(int i=0; i<rest.size();i++){
                String j = (String) rest.get(i);
                String k = (String) loc.get(i);
                if(nome.equals(j) ||  nome.equals(k)){
                    System.out.println("Lista de restaurante(s) encontrado(s):");
                    System.out.printf("RESTAURANTE: %s\tLOCALIZAÇÃO: %s\n", rest.get(i), loc.get(i));
                }else{
                    if((i+1)==rest.size()) System.out.println("Nenhum restaurante encontrado com o nome especificado!");
                }
            }
        }
    }
    
    //alterar
    public static void alterarRest(ArrayList rest, ArrayList cod, ArrayList loc, File filerest, File filecod, File fileloc) throws IOException{
        
        Scanner ler = new Scanner (System.in);
        if(rest.isEmpty()){
            System.out.println("Nenhum restaurante cadastrado!");
        }
        else{
            String nome, codigo;
            System.out.print("Introduza o codigo do restaurante a alterar: "); codigo = ler.nextLine();
            if(cod.contains(codigo)){
                int i = cod.indexOf(codigo);
                System.out.print("Introduza o novo nome:");nome = ler.nextLine();
                rest.set(i, nome);
                System.out.print("Introduza a nova localização:");nome = ler.nextLine();
                loc.set(i, nome);
                System.out.println("Restaurante alterado com sucesso!");
            }else{
                System.out.println("Nenhum restaurante correspondente ao nome introduzido! Entre com um nome já registado!");
            }
            
        }
        gravarDados(rest, filerest);
        gravarDados(cod, filecod);
        gravarDados(loc, fileloc);
        
    }
    
    //remover
    public static void removerRest(ArrayList rest, ArrayList cod, ArrayList loc, File filerest, File filecod, File fileloc) throws IOException{
        
        Scanner ler = new Scanner (System.in);
        if(rest.isEmpty()){
            System.out.println("Nenhum restaurante cadastrado!");
        }
        else{
            String codigo;
            System.out.print("Introduza o codigo do restaurante a eliminar: "); codigo = ler.nextLine();
            for(int i=0; i<rest.size();i++){
                String j = (String) cod.get(i);
                if(codigo.equals(j)){
                    int k = cod.indexOf(codigo);
                    System.out.println("Restaurante "+rest.get(k)+" eliminado com sucesso!");
                    rest.remove(k);
                    cod.remove(k);
                    loc.remove(k);
                    gravarDados(rest, filerest);
                    gravarDados(cod, filecod);
                    gravarDados(loc, fileloc);
                }
                else{
                    if((i+1)==rest.size()) System.out.println("Restaurante com o codigo introduzido não foi encontrado!");
                }
            }    
            
        }
    }
    
    //Gravar Dados
    public static void gravarDados(ArrayList Colecao, File file) throws IOException{
        
        FileWriter arq = new FileWriter(file);
        BufferedWriter escreverFile = new BufferedWriter(arq);
        try{
            for (int i = 0; i < Colecao.size(); i++) {
                String msg = (String) Colecao.get(i);
                escreverFile.write(msg+"\n");
            }
            escreverFile.close();
        }catch(IOException ioexception){
            JOptionPane.showMessageDialog(null, "Erro na escrita do ficheiro!", "OK", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    //ler dados
    public static void LerDados(ArrayList Colecao, File file) throws FileNotFoundException, IOException{
        
        FileReader lerFile = new FileReader(file);
        BufferedReader buf = new BufferedReader(lerFile);
        try{
            String frase;
            while((frase = buf.readLine()) != null) Colecao.add(frase);
            buf.close();
            
        }catch(IOException ioexception){
            System.out.println("Erro na leitura do ficheiro");
        }
    }

    //Apagar todos os registos
    public static void apagar(ArrayList Colecao, File file) throws IOException {
        Colecao.clear();
        gravarDados(Colecao, file);
    }
}