package be.intecbrussel.service;

import be.intecbrussel.exceptions.InvalidBeerException;
import be.intecbrussel.exceptions.InvalidNumberException;
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
    public int orderBeer(String name, int beerId, int number) throws InvalidBeerException, InvalidNumberException{

        if (number < 0) throw new InvalidNumberException("Desired quantity is less than zero.");

        //finding a beer based on the id
        Beer beer = em.find(Beer.class, beerId);
        if (beer == null) throw new InvalidBeerException("Beer with this id does not exist.");

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

    //for placing orders of multiple sort of beers
    //the first array will hold the id, while the second will hold the quantity
    public int orderBeers(String name, int[][] order) throws InvalidBeerException, InvalidNumberException{

        //a list containing a single item
        List<BeerOrderItem> listOfBeerItems = new ArrayList<>();

        for(int j=0; j < order[0].length; j++) {
            //finding a beer based on the id
            Beer beer = em.find(Beer.class, order[0][j]);
            if (beer == null) throw new InvalidBeerException("Beer with this id does not exist.");
            //making an order item from the previously found beer
            BeerOrderItem beerOrderItem = new BeerOrderItem();
            beerOrderItem.setBeer(beer);
            beerOrderItem.setNumber(order[1][j]);
            if (beerOrderItem.getNumber() < 0) throw new InvalidNumberException("Desired quantity is less than zero.");
            //creating an item list
            listOfBeerItems.add(beerOrderItem);

        }
        //making an order
        BeerOrder beerOrder = new BeerOrder();
        beerOrder.setName(name);
        beerOrder.setItems(listOfBeerItems);
        beerOrderRepository.saveOrder(beerOrder);

        return beerOrder.getId();




    }
}
