package be.intecbrussel.service;

import be.intecbrussel.model.Beer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;


@Repository("beerRepository")
public class BeerRepositoryImpl implements BeerRepository {

    private EntityManagerFactory emf;

    //Spring Boots injects a entity manager bean that itself has already made
    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Beer getBeerById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn = em.getTransaction();
        try {
            txn.begin();
            Beer beer = em.find(Beer.class, id);
            txn.commit();
            return beer;
        }
        catch (Exception e) {
            txn.rollback();
            throw e;
        }
        /*
        finally {
            if(em != null) {
                em.close();
            }
        }
        */
    }


}
