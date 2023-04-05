package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Aluno extends Entidade implements Serializable, Comparable<Aluno> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, name = "nome_aluno", nullable = false)
    private String nome;

    @Column(length = 15, nullable = false, unique = true)
    private String ra;

    @ManyToMany
    private List<Disciplina> disciplinas;

    @ManyToMany(mappedBy = "alunos")
    private List<Curso> cursos;

    public Aluno() {
        disciplinas = new ArrayList<>();
        cursos = new ArrayList<>();
    }

    public Aluno(Integer id, String nome, String ra) {
        this.id = id;
        this.nome = nome;
        this.ra = ra;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        return "Aluno{" + "id=" + id + ", nome=" + nome + ", ra=" + ra + '}';
    }

    @Override
    public int compareTo(Aluno o) {
        return nome.compareToIgnoreCase(o.nome);
    }
}
