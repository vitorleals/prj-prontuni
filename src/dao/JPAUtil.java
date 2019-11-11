package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	// usar a estratégia SINGLETON

		private JPAUtil() {
			super();
		}
		
		// criar a fábrica de EntityManager para o banco da aplicação
		private static EntityManagerFactory fabrica = 
							Persistence.createEntityManagerFactory("prontuni");


	public static EntityManager getEntityManager() {
		return fabrica.createEntityManager();
	}
	
	public static EntityManager criarEntityManager()
	{
		return fabrica.createEntityManager();
		
	}

	public void fechaLojinha() {

		fabrica.close();
	}

}
