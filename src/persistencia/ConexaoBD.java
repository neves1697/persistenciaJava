package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoBD {

    private static EntityManagerFactory emFactoryObj;
    private static EntityManager entityManager;
    private static final String PERSISTENCE_UNIT_NAME = "Aula15032023PU";

    public static void criarConexao() {
        emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        entityManager = emFactoryObj.createEntityManager();
    }

    public static EntityManager getConnection() {
        if (entityManager == null) {
            criarConexao();
        }
        return entityManager;
    }

}
