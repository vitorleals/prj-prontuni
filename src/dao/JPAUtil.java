package dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	@Inject
    private static PersistenceProperties properties;
	
	private static EntityManagerFactory fabrica;
	
		static{
		fabrica = Persistence.createEntityManagerFactory("prontuni");
	}
	
	public static EntityManager getEntityManager()
	{
		return fabrica.createEntityManager();
	}
	
	
	
	public void fechaLojinha() {
		
		fabrica.close();
	}

}
