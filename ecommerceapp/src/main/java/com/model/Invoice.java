package com.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long invoiceId;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @OneToMany(fetch = FetchType.EAGER)
    private List<LineItem> items;

    private LocalDateTime invoiceDateTime;

    private boolean isProcessed;

    public Invoice() {
        this.invoiceId = null;
        this.user = new User();
        this.items = new ArrayList<LineItem>();
        this.invoiceDateTime = null;
        this.isProcessed = false;
    }

    public Invoice(Long invoiceId, User user, List<LineItem> items, LocalDateTime invoiceDateTime) {
        this.invoiceId = invoiceId;
        this.user = user;
        this.items = items;
        this.invoiceDateTime = invoiceDateTime;
        this.isProcessed = false;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
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

    public LocalDateTime getInvoiceDateTime() {
        return invoiceDateTime;
    }

    public void setInvoiceDateTime(LocalDateTime invoiceDateTime) {
        this.invoiceDateTime = invoiceDateTime;
    }

    public double getInvoiceTotal() {
        double total = 0.0;
        for (LineItem item : items) {
            total += item.getTotal();
        }
        return total;
    }

    public boolean getIsProcessed() {
        return isProcessed;
    }

    public void setIsProcessed(boolean isProcessed) {
        this.isProcessed = isProcessed;
    }
}
