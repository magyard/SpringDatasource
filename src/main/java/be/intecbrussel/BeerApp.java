package be.intecbrussel;

import be.intecbrussel.model.Beer;
import be.intecbrussel.model.BeerOrder;
import be.intecbrussel.service.BeerOrderRepository;
import be.intecbrussel.service.BeerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BeerApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BeerApp.class, args);

        /*
        BeerRepository beerRepository = context.getBean("beerRepository", BeerRepository.class);
        Beer beer = beerRepository.getBeerById(20);
        System.out.println(beer);
         */

        /*
        BeerOrderRepository beerOrderRepository = context.getBean("beerorderrepository", BeerOrderRepository.class);
        BeerOrder beerOrder1 = new BeerOrder();
        beerOrder1.setId(2);
        beerOrder1.setName("Danny De Vos");
        beerOrderRepository.saveOrder(beerOrder1);
         */

        BeerOrderRepository beerOrderRepository = context.getBean("beerorderrepository", BeerOrderRepository.class);
        BeerOrder beerOrder = beerOrderRepository.getBeerOrderById(1);
        System.out.println(beerOrder.getName());


    }

}
