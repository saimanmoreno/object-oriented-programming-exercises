/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste3;

import static java.lang.System.exit;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author pc
 */
public class Registar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JLabel jUserName = new JLabel("User Name");
        JTextField nome = new JTextField();
        JLabel jPassword = new JLabel("Password");
        JTextField password = new JPasswordField();
        JLabel jEmail = new JLabel("Email");
        JTextField email = new JTextField();
        JLabel jSex = new JLabel("Sex");
        String[] item = new String[]{"Masculino", "Feminino"};
        JComboBox boxSex = new JComboBox(item);
        JLabel jUserTelef = new JLabel("Telefone");
        JTextField telefone = new JTextField();
        JLabel jUserMorada = new JLabel("Morada");
        JTextField userMorada = new JTextField();
        
        Object[] ob = {jUserName, nome, jPassword, password, jSex, boxSex, jEmail, email, 
            jUserTelef, telefone, jUserMorada, userMorada};
        int result = JOptionPane.showConfirmDialog(null, ob, "Registar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) {
            String userNameValue = nome.getText();
            String passwordValue = password.getText();
            String emailValue = email.getText();
            String sexValue = boxSex.getSelectedItem().toString();
            String morada = userMorada.getText();
            String telef = telefone.getText();
            System.out.println("Nome:"+userNameValue+"\nPassword:"+passwordValue+"\nEmail:"+emailValue+"\nSexo:"+sexValue+"\nMorada:"+morada+"\nTelefone:"+telef);
        }else{
            exit(1);
        }
    }
    
}
