package be.intecbrussel.service;

import be.intecbrussel.model.BeerOrder;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Repository("beerorderrepository")
public class BeerOrderRepositoryImpl implements BeerOrderRepository {

    private EntityManagerFactory emf;

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public int saveOrder(BeerOrder beerOrder)  {
        EntityManager em = emf.createEntityManager();
        EntityTransaction txn = em.getTransaction();
        try {

            em.persist(beerOrder);

            txn.begin();
            txn.commit();

        }
        catch (Exception e) {
            txn.rollback();
            throw e;
        }
        finally {
            if (em != null) em.close();
        }

        return beerOrder.getId();
    }

    public BeerOrder getBeerOrderById(int id) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction txn = em.getTransaction();
        try{
            BeerOrder order = em.find(BeerOrder.class, id);

            txn.begin();
            txn.commit();

            return order;
        }
        catch(Exception e) {
            txn.rollback();
            throw e;
        }
        finally {
            if (em != null) em.close();
        }
    }
}
