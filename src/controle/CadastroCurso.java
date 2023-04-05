package controle;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import modelo.Curso;
import persistencia.DaoCurso;
import util.Input;

public class CadastroCurso {

    protected DaoCurso daoCurso = new DaoCurso();

    public List<Curso> getCurso() {
        return daoCurso.findAll().stream().map(e -> (Curso) e).collect(Collectors.toList());
    }

    public Curso cadastrarCurso() {
        Curso c = new Curso();
        setarInformacoes(c);
        daoCurso.saveOrUpdate(c);
        return c;
    }

    public void setarInformacoes(Curso c) {
        if (c == null) {
            System.out.println("Falha ao inserir informações do curso\n");
            return;
        }

        System.out.println("Digite o nome: ");
        c.setNome(Input.nextLine());
        System.out.println("Digite a carga horária: ");
        c.setCargaHoraria(Input.nextInt());
    }

    public void editarCurso(Curso c) {
        if (c != null) {
            setarInformacoes(c);
            daoCurso.saveOrUpdate(c);
        }
    }

    public void ordenarLista(List lista) {
        System.out.println("1 - Ascendente: ");
        System.out.println("2 - Descendente: ");
        int op = Input.nextInt();
        if (op == 1) {
            Collections.sort(lista);
        } else {
            Collections.sort(lista, Collections.reverseOrder());
        }
    }

    public void listar() {
        List<Curso> Cursos = getCurso();
        if (Cursos == null || Cursos.isEmpty()) {
            System.out.println("Lista vazia\n");
        } else {
            ordenarLista(Cursos);
            System.out.println("\nCursos\n");
            int n = 1;
            for (Curso p : Cursos) {
                System.out.print("\n" + (n++) + ". " + p);
            }
        }
    }

    public void remover(Curso cu) {
        if (daoCurso.delete(cu)) {
            System.out.println("O cadastro: " + cu.getNome() + " - " + cu.getCargaHoraria() + " foi removido com sucesso!");
        } else {
            System.err.println("A remoção do curso falhou\n");
        }
    }

    public Curso pesquisar(String nome) {
        for (Curso p : getCurso()) {
            if (nome.compareTo(p.getNome()) == 0) {
                return p;
            }
        }
        System.out.println("Não foi encontrado Curso com o nome: " + nome);
        return null;
    }
}
