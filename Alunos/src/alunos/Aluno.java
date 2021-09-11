package alunos;
public class Aluno {

    private int noAluno;
    private String nomeAluno;
    private int idadeAluno;
    private String moradaAluno;
    private int telefAluno;
    private String nomeCurso;
    private int anoCurso;
    private String[] discCurso = new String[10];
    
    
    @Override
    public String toString(){
        return "Nome: "+this.nomeAluno+ "\nIdade: "+this.idadeAluno+ "\nNoAluno: "+this.noAluno+"\n"
                + "Morada: "+this.moradaAluno+ "\nTelefone: "+this.telefAluno+ "\nCurso: "+this.anoCurso+"º ano "+this.nomeCurso;
    }
    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public int getAnoCurso() {
        return anoCurso;
    }

    public void setAnoCurso(int anoCurso) {
        this.anoCurso = anoCurso;
    }

    public String[] getDiscCurso() {
        return discCurso;
    }

    public void setDiscCurso(String[] discCurso) {
        this.discCurso = discCurso;
    }

    
    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public int getIdadeAluno() {
        return idadeAluno;
    }

    public void setIdadeAluno(int idadeAluno) {
        this.idadeAluno = idadeAluno;
    }

    public int getNoAluno() {
        return noAluno;
    }

    public void setNoAluno(int noAluno) {
        this.noAluno = noAluno;
    }

    public String getMoradaAluno() {
        return moradaAluno;
    }

    public void setMoradaAluno(String moradaAluno) {
        this.moradaAluno = moradaAluno;
    }

    public int getTelefAluno() {
        return telefAluno;
    }

    public void setTelefAluno(int telefAluno) {
        this.telefAluno = telefAluno;
    }
}
