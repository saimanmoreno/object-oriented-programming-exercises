package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import factory.ConnectionFactory;
import java.sql.SQLException;
import modelo.Contato;
 
public class ContatoDAO {
 
    public void save(Contato contato){
 
        /*
        * Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base de dados
        */
        String sql = "INSERT INTO contatos(nome,idade,dataCadastro) VALUES(?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            //Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            //Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);

            //Adiciona o valor do primeiro parâmetro da sql
            pstm.setString(1, contato.getNome());
            //Adicionar o valor do segundo parâmetro da sql
            pstm.setInt(2, contato.getIdade());
            //Adiciona o valor do terceiro parâmetro da sql
            pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

            //Executa a sql para inserção dos dados
            pstm.execute();

        }catch (Exception e) {

            System.out.println(e.getMessage());

        }finally{

            //Fecha as conexões
            try{
                if(pstm != null)pstm.close();
                if(conn != null)conn.close();

            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
 
    public void removeById(int id){
 
        String sql = "DELETE FROM contatos WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{

            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            //Fecha as conexões
            try{
                if(pstm != null)pstm.close();
                if(conn != null)conn.close();

            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
 
    public void update(Contato contato){
 
        String sql = "UPDATE contatos SET nome = ?, idade = ?, dataCadastro = ?  WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {

            //Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            //Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);

            //Adiciona o valor do primeiro parâmetro da sql
            pstm.setString(1, contato.getNome());
            //Adicionar o valor do segundo parâmetro da sql
            pstm.setInt(2, contato.getIdade());
            //Adiciona o valor do terceiro parâmetro da sql
            pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

            pstm.setInt(4, contato.getId());

            //Executa a sql para inserção dos dados
            pstm.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            //Fecha as conexões
            try{
                if(pstm != null)pstm.close();
                if(conn != null)conn.close();

            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
 
    public List<Contato> getContatos(){
 
        String sql = "SELECT * FROM contatos";

        List<Contato> contatos = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstm = null;

        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {

            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            //Enquanto existir dados no banco de dados, faça
            while(rset.next()){
                Contato contato = new Contato();

                //Recupera o id do banco e atribui ele ao objeto
                contato.setId(rset.getInt("id"));

                //Recupera o nome do banco e atribui ele ao objeto
                contato.setNome(rset.getString("nome"));

                //Recupera a idade do banco e atribui ele ao objeto
                contato.setIdade(rset.getInt("idade"));

                //Recupera a data do banco e atribui ela ao objeto
                contato.setDataCadastro(rset.getDate("dataCadastro"));

                //Adiciono o contato recuperado, a lista de contatos
                contatos.add(contato);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{

            try{

                if(rset != null) rset.close();
                if(pstm != null) pstm.close();
                if(conn != null) conn.close();

            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return contatos;
    }
}
