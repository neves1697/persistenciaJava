package main;

import controle.CadastroAluno;
import controle.CadastroDisciplina;
import controle.CadastroCurso;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import modelo.Aluno;
import modelo.Curso;

import modelo.Disciplina;
import persistencia.ConexaoBD;
import persistencia.DaoAluno;

import util.Input;
import util.Telas;

public class Aula15032023 {

    public static void main(String[] args) {

        int digitado = -1;
        Telas t = new Telas();
        do {
            CadastroAluno c = new CadastroAluno();
            CadastroCurso cadCurso = new CadastroCurso();
            CadastroDisciplina cadDisciplina = new CadastroDisciplina();

            try {

                t.opcoes();
                digitado = Input.nextInt();
            } catch (ArithmeticException e) {
                System.out.println("O " + digitado + " não é um número válido, digite um número válido\n" + e.getMessage());
                digitado = Input.nextInt();
            }

            switch (digitado) {
                case 1:
                    try {
                    c.cadastrar();
                } catch (Exception e) {
                    System.out.println("Erro ao cadastrare o aluno\n" + e.getMessage());
                }
                break;

                case 2:
                    try {
                    Aluno al = new Aluno();
                    c.editar(al);
                } catch (Exception e) {
                    System.out.println("Erro ao editar o aluno\n" + e.getLocalizedMessage());
                }
                break;

                case 3:
                    c.listar();
                    break;
                case 4:
                    try {
                    cadCurso.cadastrarCurso();
                } catch (Exception e) {
                    System.out.println("Erro ao cadastrar o curso\n" + e.getMessage());
                }
                break;

                case 5:
                    try {
                    Curso curso = new Curso();
                    cadCurso.editarCurso(curso);
                } catch (Exception e) {
                    System.out.println("Houve um erro ao editar o curso\n" + e.getMessage());
                }
                break;

                case 6:
                    cadCurso.listar();
                    break;

                case 7:                    
                    try {
                    cadDisciplina.cadastrar();
                } catch (Exception e) {
                    System.out.println("Houve um erro ao cadastrar a disciplina\n" + e.getMessage());
                }
                break;
                case 8:
                    try {
                    Disciplina dc = new Disciplina();
                    cadDisciplina.editar(dc);
                } catch (Exception e) {
                }
                break;

                case 9:
                    cadDisciplina.listar();
                    break;
                //default:
                //throw new AssertionError();

            }
        } while (digitado != 0);

    }
}
