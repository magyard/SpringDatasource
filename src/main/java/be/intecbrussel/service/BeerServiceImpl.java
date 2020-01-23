package be.intecbrussel.service;

import be.intecbrussel.model.Beer;
import be.intecbrussel.model.BeerOrder;
import be.intecbrussel.model.BeerOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class BeerServiceImpl implements BeerService {

    private EntityManager em;
    private BeerOrderRepository beerOrderRepository;

    @Autowired
    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Autowired
    public void setBeerOrderRepository(BeerOrderRepository beerOrderRepository) {
        this.beerOrderRepository = beerOrderRepository;
    }

    //making an order based on the client's name, beer id, and the desired quantity of this very beer
    public int orderBeer(String name, int beerId, int number) {
        //finding a beer based on the id
        Beer beer = em.find(Beer.class, beerId);

        //making an order item from the previously found beer
        BeerOrderItem beerOrderItem = new BeerOrderItem();
        beerOrderItem.setBeer(beer);
        beerOrderItem.setNumber(number);

        //a list containing a single item
        List<BeerOrderItem> listOfBeerItems = new ArrayList<>();
        listOfBeerItems.add(beerOrderItem);
        //no method provided in the repository to save an order item
        //order item is saved nonetheless thanks to the cascading style in the BeerOrder entity

        //making an order
        BeerOrder beerOrder = new BeerOrder();
        beerOrder.setName(name);
        beerOrder.setItems(listOfBeerItems);
        beerOrderRepository.saveOrder(beerOrder);

        return beerOrder.getId();

    }
}
