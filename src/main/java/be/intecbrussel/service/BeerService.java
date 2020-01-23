package be.intecbrussel.service;

import be.intecbrussel.exceptions.InvalidBeerException;
import be.intecbrussel.exceptions.InvalidNumberException;

public interface BeerService {

    public int orderBeer(String name, int beerId, int number) throws InvalidBeerException, InvalidNumberException;
    public int orderBeers(String name, int[][] order) throws InvalidBeerException, InvalidNumberException;
}
