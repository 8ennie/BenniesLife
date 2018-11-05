package connectionToDatabase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetConnection {

	public static EntityManager entityManager;
	
	private static void createEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BenniesLifeApplication");
		entityManager = emf.createEntityManager();
	}
	
	public GetConnection(){
		createEntityManager();
	}
	
	
	public static EntityManager getEntityManager() {
		if (entityManager == null) {
			createEntityManager();
		}
			return entityManager;
		
	}
	
	
}
