package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Aluno;
import modelo.Curso;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-04-04T21:43:19")
@StaticMetamodel(Disciplina.class)
public class Disciplina_ { 

    public static volatile SingularAttribute<Disciplina, Curso> curso;
    public static volatile ListAttribute<Disciplina, Aluno> alunos;
    public static volatile SingularAttribute<Disciplina, Integer> id;
    public static volatile SingularAttribute<Disciplina, String> descricao;

}