package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Aluno;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-04-04T21:43:19")
@StaticMetamodel(Curso.class)
public class Curso_ { 

    public static volatile ListAttribute<Curso, Aluno> alunos;
    public static volatile SingularAttribute<Curso, String> nome;
    public static volatile SingularAttribute<Curso, Integer> id;
    public static volatile SingularAttribute<Curso, Integer> cargaHoraria;

}