package be.intecbrussel;

import be.intecbrussel.model.Beer;
import be.intecbrussel.service.BeerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BeerApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BeerApp.class, args);
        BeerRepository beerRepository = context.getBean("beerRepository", BeerRepository.class);
        Beer beer = beerRepository.getBeerById(20);
        System.out.println(beer);
    }

}
