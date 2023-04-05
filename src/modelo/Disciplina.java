package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Disciplina extends Entidade implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Integer id;
    private String descricao;
    @ManyToOne
    private Curso curso;

    @ManyToMany(mappedBy = "disciplinas")
    private List<Aluno> alunos;

    public Disciplina() {
        curso = new Curso();
        alunos = new ArrayList<>();
    }

    public Disciplina(Integer id, String descricao, Curso curso, ArrayList<Aluno> alunos) {
        this.id = id;
        this.descricao = descricao;
        this.curso = curso;
        this.alunos = alunos;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "id=" + id + ", descricao=" + descricao + ", curso=" + curso + ", alunos=" + alunos + '}';
    }
}
