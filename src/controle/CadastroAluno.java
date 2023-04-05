package controle;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import modelo.Aluno;
import util.Input;
import persistencia.DaoAluno;

public class CadastroAluno {

    protected  DaoAluno daoAluno = new DaoAluno();

    public  List<Aluno> getAlunos() {
        return daoAluno.findAll().stream().map(e -> (Aluno) e).collect(Collectors.toList());
    }

    public  Aluno cadastrar() {
        Aluno al = new Aluno();
        setarInformacoes(al);
        daoAluno.saveOrUpdate(al);
        return al;
    }

    public  void editar(Aluno al) {
        if (al != null) {
            setarInformacoes(al);
            daoAluno.saveOrUpdate(al);
        }
    }

    public void setarInformacoes(Aluno al) {
        if (al == null) {
            System.out.println("Falha ao setar informações da Aluno!");
            return;
        }
        
        System.out.print("\n Digite o nome: ");
        al.setNome(Input.nextLine());
        System.out.print("\nDigite o RA: ");
        al.setRa(Input.next());
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
        List<Aluno> alunos = getAlunos();
        if (alunos == null || alunos.isEmpty()) {
            System.out.println("A Lista está Vazia!");
        } else {
            ordenarLista(alunos);
            System.out.println("\nCadastro Alunos");
            int n = 1;
            for (Aluno p : alunos) {
                System.out.print("\n" + (n++) + ". " + p);// p está chamando o toString da classe Aluno
            }
        }
    }

    public void remover(Aluno al) {
        if (daoAluno.delete(al)) {
            System.out.println("O cadastro: " + al.getNome() + " - " + al.getRa() + " foi removido com sucesso!");
        } else {
            System.err.println("Falha ao remover aluno!");
        }
    }

    public Aluno pesquisar(String ra) {
        for (Aluno p : getAlunos()) {
            if (ra.compareTo(p.getRa()) == 0) {
                return p;
            }
        }
        System.out.println("Não foi encontrado aluno com o RA: " + ra);
        return null;
    }
}
