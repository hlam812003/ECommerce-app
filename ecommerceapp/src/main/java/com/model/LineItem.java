package com.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class LineItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lineItemId;

    @OneToOne
    private Product item;
    private int quantity;

    public LineItem() {
        this.lineItemId = null;
        this.item = new Product();
        this.quantity = 0;
    }

    public LineItem(Long lineItemId, Product item, int quantity) {
        this.lineItemId = lineItemId;
        this.item = item;
        this.quantity = quantity;
    }

    public Long getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(Long lineItemId) {
        this.lineItemId = lineItemId;
    }

    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return this.item.getPrice() * this.quantity;
    }
}
