package com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @OneToOne
    private User user;

    @OneToMany(fetch = FetchType.EAGER)
    private List<LineItem> items;

    public Cart() {
        this.user = new User();
        this.items = new ArrayList<LineItem>();
    }

    public Cart(User user, LineItem item) {
        this();

        this.user = user;
        this.items.add(item);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<LineItem> getItems() {
        return items;
    }

    public void setItems(List<LineItem> items) {
        this.items = items;
    }

    public void addItem(LineItem item) {
        this.items.add(item);
    }

    public void removeItem(Long productId) {
        items.removeIf(lineItem -> lineItem.getItem().getProductId().equals(productId));
    }

    public void removeAll() {
        this.items.clear();
    }

    public int getQuantity() {
        int quantity = 0;
        for (LineItem item : items) {
            quantity += item.getQuantity();
        }
        return quantity;
    }

    public Double getTotal() {
        Double total = 0.0;
        for (LineItem item : items) {
            total += item.getTotal();
        }
        return total;
    }

}
