package dao;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {

    @Inject
    private PersistenceProperties properties;
    
    private EntityManagerFactory fabrica;

    @PostConstruct
    public void postConstruct() {
        this.fabrica = Persistence.createEntityManagerFactory("prontuni", properties.get());
    }

    @Produces
    @RequestScoped
    public EntityManager createEntityManager() {
        return this.fabrica.createEntityManager();
    }

    public void closeEntityManager(@Disposes EntityManager manager) {
        manager.close();
    }
}
