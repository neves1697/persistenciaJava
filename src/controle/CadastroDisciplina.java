package controle;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import modelo.Curso;
import modelo.Disciplina;
import persistencia.DaoCurso;
import persistencia.DaoDisciplina;
import util.Input;

public class CadastroDisciplina {

    protected DaoDisciplina daoDisciplina = new DaoDisciplina();
    protected DaoCurso daoCurso = new DaoCurso();

    public List<Disciplina> getDisciplina() {
        return daoDisciplina.findAll().stream().map(e -> (Disciplina) e).collect(Collectors.toList());
    }

    public Disciplina cadastrar() {
        Disciplina dc = new Disciplina();
        setarInformacoes(dc);
        daoDisciplina.saveOrUpdate(dc);
        return dc;
    }

    public void editar(Disciplina dc) {
        if (dc != null) {
            setarInformacoes(dc);
            daoDisciplina.saveOrUpdate(dc);
        }
    }

    public void setarInformacoes(Disciplina dc) {
        if (dc == null) {
            System.out.println("Falha ao setar informações da Disciplina!");
            return;
        }
        System.out.print("\nDescrição: ");
        dc.setDescricao(Input.nextLine());
        System.out.print("Id Curso: ");
        int ic = Input.nextInt();
        Curso cu = (Curso) daoCurso.findById(ic);
        dc.setCurso(cu);
    }

    public void ordenarLista(List list) {
        System.out.println("1 - Ascendente: ");
        System.out.println("2 - Descendente: ");
        int op = Input.nextInt();
        if (op == 1) {
            Collections.sort(list);
        } else {
            Collections.sort(list, Collections.reverseOrder());
        }
    }

    public void listar() {
        List<Disciplina> disciplina = getDisciplina();
        if (disciplina == null || disciplina.isEmpty()) {
            System.out.println("A Lista está Vazia!");
        } else {
            ordenarLista(disciplina);

            int n = 1;
            for (Disciplina p : disciplina) {
                System.out.print("\n" + (n++) + ". " + p);
            }

        }
    }

    public void remover(Disciplina dc) {
        if (daoDisciplina.delete(dc)) {
            System.out.println("O cadastro: " + dc.getDescricao() + " - " + dc.getCurso() + " foi removido com sucesso!");
        } else {
            System.err.println("Falha ao remover Disciplina!");
        }
    }

    public Disciplina pesquisar(String descricao) {
        for (Disciplina p : getDisciplina()) {
            if (descricao.compareTo(p.getDescricao()) == 0) {
                return p;
            }
        }
        System.out.println("Não foi encontrado Disciplina com o Curso: " + descricao);
        return null;
    }
}
