package be.intecbrussel;

import be.intecbrussel.model.Beer;
import be.intecbrussel.model.BeerOrder;
import be.intecbrussel.service.BeerOrderRepository;
import be.intecbrussel.service.BeerRepository;
import be.intecbrussel.service.BeerRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class BeerApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BeerApp.class, args);


        BeerRepositoryImpl beerRepository = context.getBean("beerRepository", BeerRepositoryImpl.class);


        Beer beer = new Beer();
        beer.setId(4);
        beer.setName("TheNewComer");

        beerRepository.updateBeer(beer);

        /*
        List<Beer> list = beerRepository.getBeerByAlchol(0);
        list.forEach(b -> System.out.println(b.getName()));
        */


        /*
        BeerOrderRepository beerOrderRepository = context.getBean("beerorderrepository", BeerOrderRepository.class);
        //cannot use context.getBean() to create a BeerOrder instance. BeerOrder is an entity but not a bean
        BeerOrder beerOrder1 = new BeerOrder();
        beerOrder1.setId(3);
        beerOrder1.setName("Femke van Hoogstaal");
        beerOrderRepository.saveOrder(beerOrder1);
        */



        /*
        BeerOrderRepository beerOrderRepository = context.getBean("beerorderrepository", BeerOrderRepository.class);
        BeerOrder beerOrder = beerOrderRepository.getBeerOrderById(2);
        System.out.println(beerOrder.getName());
        */



    }

}
