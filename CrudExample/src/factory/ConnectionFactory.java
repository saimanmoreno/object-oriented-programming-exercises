package factory; 

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 

public class ConnectionFactory {
     public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/projetojava","root","");
        }         
        catch(SQLException excecao) {
            System.out.println("Erro na conexão com a database: "+excecao.getMessage());
            throw new RuntimeException(excecao);
        }
     }
}
