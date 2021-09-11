package dao;

import factory.ConnectionFactory;
import java.awt.List;
import modelo.Usuario;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class UsuarioDAO { 

    private Connection connection;
    Long id;
    String nome;
    String cpf;
    String email;
    String telefone;

    public UsuarioDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 

    public void adiciona(Usuario usuario){ 
        String sql = "INSERT INTO usuario(nome,cpf,email,telefone) VALUES(?,?,?,?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getTelefone());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
    } 
    
    public void remove(int id){ 
        String sql = "DELETE FROM usuario WHERE id=?";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
    } 
    
    public void update(Usuario usuario){ 
        String sql = "UPDATE usuario SET nome = ?, cpf = ?, email = ?, telefone =? WHERE id = ?";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getTelefone());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
    } 
    
    /**
     *
     * @return
     */
    public ArrayList<Usuario> getUsuarios(){ 
        
        String sql = "SELECT * FROM usuarios";
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rset = stmt.executeQuery();
            while(rset.next()){
                Usuario usuario = new Usuario();
                usuario.setId(rset.getLong("id"));
                usuario.setNome(rset.getString("Nome"));
                usuario.setCpf(rset.getString("Cpf"));
                usuario.setEmail(rset.getString("Email"));
                usuario.setTelefone(rset.getString("Telefone"));
                usuarios.add(usuario);
            }
            rset.close();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        return usuarios;
    } 
}