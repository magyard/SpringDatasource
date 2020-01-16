package be.intecbrussel.service;

import be.intecbrussel.model.Beer;

public interface BeerRepository {
    public Beer getBeerById(int id);
}
