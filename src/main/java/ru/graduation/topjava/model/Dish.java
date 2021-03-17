package ru.graduation.topjava.model;

import java.util.Date;

public class Dish extends AbstractNamedEntity {

    private Integer price;
    private Restaurant restaurant;
    private Date date;

    public Dish() {
    }

    public Dish(String name, Integer price, Date date) {
        this(null, name, price, date);
    }

    public Dish(Integer id, String name, Integer price, Date date) {
        super(id, name);
        this.price = price;
        this.date = date;
    }
}
