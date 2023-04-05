package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Curso;
import modelo.Disciplina;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-04-04T21:43:19")
@StaticMetamodel(Aluno.class)
public class Aluno_ { 

    public static volatile ListAttribute<Aluno, Disciplina> disciplinas;
    public static volatile ListAttribute<Aluno, Curso> cursos;
    public static volatile SingularAttribute<Aluno, String> nome;
    public static volatile SingularAttribute<Aluno, Integer> id;
    public static volatile SingularAttribute<Aluno, String> ra;

}