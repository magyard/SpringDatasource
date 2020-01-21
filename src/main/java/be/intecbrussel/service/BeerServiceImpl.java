package be.intecbrussel.service;

import be.intecbrussel.model.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class BeerServiceImpl implements BeerService {

    private EntityManager em;

    @Autowired
    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public int orderBeer(String name, int beerId, int number) {

        return beer.getId();
    }
}
