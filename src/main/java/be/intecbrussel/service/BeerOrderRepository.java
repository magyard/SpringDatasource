package be.intecbrussel.service;

import be.intecbrussel.model.BeerOrder;

public interface BeerOrderRepository {

    int saveOrder(BeerOrder beerOrder);
    BeerOrder getBeerOrderById(int id);
}
