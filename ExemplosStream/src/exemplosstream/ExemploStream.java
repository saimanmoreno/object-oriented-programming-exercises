package exemplosstream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
 
public class ExemploStream
{
    public static void main(String[] args)
    {
        Cliente cliente = new Cliente("Saiman", 'M', "110406467083");
        
        try
        {
            FileOutputStream arquivoGrav = new FileOutputStream("Cliente.txt");
            ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);
            objGravar.writeObject(cliente);
            objGravar.flush();
            objGravar.close();
            arquivoGrav.flush();
            arquivoGrav.close();
            System.out.println("Objeto gravado com sucesso!");
        }catch(IOException e) {
            System.out.println("Erro: "+e.getMessage());
        }
        
        System.out.println("Recuperando objeto: ");
        try{
            FileInputStream arquivoLeitura = new FileInputStream("Cliente.txt");
            ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura);
            System.out.println(objLeitura.readObject());
            objLeitura.close();
            arquivoLeitura.close();
        }catch(IOException | ClassNotFoundException e) {
            System.out.println("Erro: "+e.getMessage());
        }
    }
 
}
