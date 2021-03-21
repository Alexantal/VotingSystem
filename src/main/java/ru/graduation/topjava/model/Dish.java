package ru.graduation.topjava.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "dishes", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "date", "restaurant_id"},
        name = "dishes_unique_name_date_restaurant_idx")})
public class Dish extends AbstractNamedEntity {

    @Column(name = "price", nullable = false)
    @Range(min = 10, max = 5000)
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @NotNull
    private Restaurant restaurant;

    @Column(name = "date", nullable = false, columnDefinition = "timestamp default now()")
    @NotNull
    private Date date;

    public Dish() {
    }

    public Dish(Integer id, String name, Integer price, Date date) {
        super(id, name);
        this.price = price;
        this.date = date;
    }

    public Integer getPrice() {
        return price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Date getDate() {
        return date;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
