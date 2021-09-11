package alunos;

import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

public class Alunos {

    public static void main(String[] args) {
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("SimSum", Font.PLAIN, 14)));
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", new ColorUIResource(255, 255, 255));
        UI.put("Panel.background", new ColorUIResource(255, 255, 255));
        
        ArrayList<Aluno> listaAlunos = new ArrayList<>();
        Aluno aluno = new Aluno();
        
        int op = 0;
                
        do { 
            //MENU PRINCIPAL
            op = Integer.parseInt((String) JOptionPane.showInputDialog(null, "(1) Adicionar Aluno\n"
                + "(2) Listar Alunos\n"
                + "(3) Alterar Alunos\n"
                + "(4) Remover Aluno\n"
                + "(0) Sair", "MENU",JOptionPane.PLAIN_MESSAGE));
            switch(op){
                case 1: adicionar(aluno, listaAlunos); break;
                case 2: listar(listaAlunos); break;
                case 3: alterar(aluno, listaAlunos); break;
                case 4: remover(aluno, listaAlunos); break;
                case 0: break;
                default: JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }while(op!=0);
    }

    private static void adicionar(Aluno aluno, ArrayList<Aluno> listaAlunos) {
        aluno.setNomeAluno(JOptionPane.showInputDialog("Nome do Aluno: "));
        aluno.setNoAluno(Integer.parseInt(JOptionPane.showInputDialog("Numero do Aluno: ")));
        aluno.setIdadeAluno(Integer.parseInt(JOptionPane.showInputDialog("Idade do Aluno: ")));
        aluno.setMoradaAluno(JOptionPane.showInputDialog("Morada do Aluno: "));
        aluno.setNomeCurso(JOptionPane.showInputDialog("Curso do Aluno: "));
        aluno.setAnoCurso(Integer.parseInt(JOptionPane.showInputDialog("Ano de Curso: ")));
        listaAlunos.add(aluno);
        JOptionPane.showMessageDialog(null, "Aluno "+aluno.getNomeAluno()+" adicionado com sucesso");
    }

    private static void listar(ArrayList<Aluno> listaAlunos) {
        JOptionPane.showMessageDialog(null, listaAlunos);
    }

    private static void alterar(Aluno aluno, ArrayList<Aluno> alunos) {
    }

    private static void remover(Aluno aluno, ArrayList<Aluno> alunos) {
    }

}
