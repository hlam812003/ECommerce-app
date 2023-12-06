package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Invoice {
    @Id
    private String invoiceId;
    
    @OneToMany (targetEntity = LineItem.class)
    private List<LineItem> items;
    @Temporal(jakarta.persistence.TemporalType.DATE)
    private Date invoiceDateTime;
    @ManyToOne
    private User user;
    public Invoice() {
        this.invoiceId = "";
        this.user = new User();
        this.items = new ArrayList<>();
        this.invoiceDateTime = new Date();
    }

    public Invoice(String invoiceId, User user, List<LineItem> items, Date invoiceDateTime) {
        this.invoiceId = invoiceId;
        this.user = user;
        this.items = items;
        this.invoiceDateTime = invoiceDateTime;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
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

    public Date getInvoiceDateTime() {
        return invoiceDateTime;
    }

    public void setInvoiceDateTime(Date invoiceDateTime) {
        this.invoiceDateTime = invoiceDateTime;
    }

    public double getInvoiceTotal() {
        double total = 0.0;
        for (LineItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }
}
