package ficheiros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ManipuladorArquivo {
    public static void leitor(String path) throws IOException{
        try (BufferedReader buffRead = new BufferedReader(new FileReader(path))) {
            String linha = "";
            while(true){
                if(linha != null) System.out.println(linha);
                else break;
                linha = buffRead.readLine();
            }
        }
    }
    
    public static void escritor(String path) throws IOException {
        try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path))) {
            String linha = "";
            Scanner input = new Scanner(System.in);
            System.out.println("Escreva algo: ");
            linha = input.nextLine();
            buffWrite.append(linha + "\n");
        }
    }
}
