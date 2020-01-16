package be.intecbrussel.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "beerorders")
public class BeerOrder {
    @Id
    @Column(name = "Id")
    private int id;

    @Column(name = "Name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name ="BeerOrderId")
    private List<BeerOrderItem> items = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BeerOrderItem> getItems() {
        return items;
    }

    public void setItems(List<BeerOrderItem> items) {
        this.items = items;
    }
}
