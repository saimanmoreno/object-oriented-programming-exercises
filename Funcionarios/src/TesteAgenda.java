import java.util.Date;
 
import dao.ContatoDAO;
import java.util.Scanner;
import modelo.Contato;

public class TesteAgenda {
 
    public static Scanner scan = new Scanner(System.in);
    
    public static void main(String args[]){

        ContatoDAO contatoDAO = new ContatoDAO();

        //Cria um contato e salva no banco
        Contato contato = new Contato();
        System.out.print("Nome >> "); contato.setNome(scan.nextLine());
        System.out.print("Idade >> "); contato.setIdade(scan.nextInt());
        contato.setDataCadastro(new Date());

        contatoDAO.save(contato);

        //Atualiza o contato com id = 1 com os dados do objeto contato1
        Contato contato1 = new Contato();
        contato1.setId(1);
        contato1.setNome("NOME NOVO");
        contato1.setIdade(32);
        contato1.setDataCadastro(new Date());

        contatoDAO.update(contato1);

        //Remove o contato com id = 1

        contatoDAO.removeById(1);

        //Lista todos os contatos do banco de dados

        for(Contato c : contatoDAO.getContatos()) System.out.println("NOME: " + c.getNome());
    }
}
