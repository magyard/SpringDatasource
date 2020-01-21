package be.intecbrussel.service;

import be.intecbrussel.model.BeerOrder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository("beerorderrepository")
public class BeerOrderRepositoryImpl implements BeerOrderRepository {

    private EntityManager em;

    @PersistenceContext
    public void setEmf(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public int saveOrder(BeerOrder beerOrder)  {
        em.persist(beerOrder);
        return beerOrder.getId();
    }

    @Transactional
    public BeerOrder getBeerOrderById(int id) {
            BeerOrder order = em.find(BeerOrder.class, id);
            return order;

    }
}
