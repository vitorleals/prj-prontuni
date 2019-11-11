package dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	@Inject
	private static PersistenceProperties properties;

	 private static EntityManagerFactory fabrica;

	// static {
	/// fabrica = Persistence.createEntityManagerFactory("prontuni");
	// }

	public JPAUtil() {
		super();
	}

	static {
        try {
        	fabrica = Persistence.createEntityManagerFactory("prontuni");
             System.out.println("Entity Menager Test.............."+ fabrica);
        } catch (Throwable ex) {

            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);

          }
}
	
	
	// criar a f�brica de EntityManager para o banco da aplica��o
	//private static EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("prontuni");

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
