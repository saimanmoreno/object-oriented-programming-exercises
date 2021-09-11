package teste2;

import static javafx.application.Platform.exit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author pc
 */
public class Login {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JLabel jUserName = new JLabel("Usuario");
        JTextField userName = new JTextField();
        JLabel jPassword = new JLabel("Password");
        JTextField password = new JPasswordField();
        
        Object[] ob = {jUserName, userName, jPassword, password};
        int result = JOptionPane.showConfirmDialog(null, ob, "LOGIN", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String userNameValue = userName.getText();
            String passwordValue = password.getText();
            System.out.println("Nome:"+userNameValue+"\nPassword:"+passwordValue);
        }else{
            exit();
        }
    }
    
}
