package be.intecbrussel.service;

import be.intecbrussel.model.Beer;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;


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

    public List<Beer> getBeerByAlchol(float alcohol) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Beer> query = em.createQuery("select b from Beer b where b.alcohol =?1", Beer.class);

        query.setParameter(1, alcohol);

        return query.getResultList();
    }

    public void updateBeer (Beer b) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn = em.getTransaction();

        try {

            txn.begin();

            Beer beerToBeModified = em.find(Beer.class, b.getId());

            beerToBeModified.setAlcohol(b.getAlcohol());
            beerToBeModified.setBrewer(b.getBrewer());
            beerToBeModified.setCategory(b.getCategory());
            beerToBeModified.setName(b.getName());
            beerToBeModified.setPrice(b.getPrice());
            beerToBeModified.setStock(b.getStock());
            beerToBeModified.setVersion(b.getVersion());

            txn.commit();
        }

        catch (Exception e) {
            txn.rollback();
            throw e;
        }





    }


}
