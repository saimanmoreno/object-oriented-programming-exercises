package ficheiros;

import java.io.*;
import java.util.Scanner;

public class Ficheiros {
    public static void main(String[] args) throws IOException {
        Scanner ler = new Scanner(System.in);
        File file = new File("C:\\Users\\pc\\Documents\\NetBeansProjects\\Base de Dados.txt");
        String path = "C:\\Users\\pc\\Documents\\NetBeansProjects\\Base de Dados.txt";
        /*System.out.println("Nome do ficheiro: "+file.getName());
        System.out.println("Caminho: "+file.getAbsolutePath());
        System.out.println("Pode ser escrito? : "+file.canWrite());
        System.out.println("Pode ser lido? : "+file.canRead());
        System.out.println("É ficheiro? : "+file.isFile());
        System.out.println("É diretorio? : "+file.isDirectory());
        System.out.println("É oculto? : "+file.isHidden());
        System.out.println("Ultima modificação: "+file.lastModified());
        System.out.println("Tamanho: "+file.length());
        //file.setWritable(true, true);
        System.out.println("\nConteudos:");
        String conteudos[] = file.list();
        for(int i=0;i<conteudos.length;i++) System.out.println(">> "+conteudos[i]);
        */
        //Escrever
        FileWriter arq = new FileWriter(file, true);
        BufferedWriter escreverFile = new BufferedWriter(arq);
        try{
            System.out.println("Escreve: "); String msg = ler.nextLine();
            escreverFile.write(msg+"\n");
            System.out.println("Escrita com sucesso!");
            escreverFile.close();
        }catch(IOException ioexception){
            System.out.println("Erro na escrita do ficheiro");
        }
        
        //ler
        FileReader lerFile = new FileReader(file);
        BufferedReader buf = new BufferedReader(lerFile);
        try{
            System.out.println("Conteudo do documento:");
            String frase;
            while((frase = buf.readLine()) != null){
                System.out.println(frase);
            }buf.close();
        }catch(IOException ioexception){
            System.out.println("Erro na leitura do ficheiro");
        }
        /*ManipuladorArquivo.escritor(path);
        ManipuladorArquivo.leitor(path);*/
    }
}