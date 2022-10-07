package br.com.escola.modelo.entidade;

public class Matricula {

    private int id;
    private Curso curso;
    private Aluno aluno;

    public Matricula(int id) {
        this.id = id;

    }

    public Matricula(int id, Curso curso, Aluno aluno) {
        this.curso = curso;
        this.aluno = aluno;
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
