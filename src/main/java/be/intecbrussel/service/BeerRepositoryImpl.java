package be.intecbrussel.service;

import be.intecbrussel.model.Beer;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Repository("beerRepository")
public class BeerRepositoryImpl implements BeerRepository {

    private EntityManager em;

    //Spring Boots injects a entity manager bean that itself has already made
    @PersistenceContext
    public void setEmf(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public Beer getBeerById(int id) {

            Beer beer = em.find(Beer.class, id);
            return beer;
    }

    @Transactional
    public List<Beer> getBeerByAlchol(float alcohol) {
        TypedQuery<Beer> query = em.createQuery("select b from Beer b where b.alcohol =?1", Beer.class);

        query.setParameter(1, alcohol);

        return query.getResultList();
    }

    @Transactional
    public void updateBeer (Beer b) {
            Beer beerToBeModified = em.find(Beer.class, b.getId());

            beerToBeModified.setAlcohol(b.getAlcohol());
            beerToBeModified.setBrewer(b.getBrewer());
            beerToBeModified.setCategory(b.getCategory());
            beerToBeModified.setName(b.getName());
            beerToBeModified.setPrice(b.getPrice());
            beerToBeModified.setStock(b.getStock());
            beerToBeModified.setVersion(b.getVersion());

    }


}
