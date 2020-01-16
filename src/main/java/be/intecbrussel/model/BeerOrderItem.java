package be.intecbrussel.model;

import javax.persistence.*;

@Entity
@Table (name="beerorderitems")
public class BeerOrderItem {
    @Id
    @Column(name = "Id")
    private int id;

    @ManyToOne
    @JoinColumn(name="BeerId")
    private Beer beer;

    @Column(name="Number")
    private int number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
