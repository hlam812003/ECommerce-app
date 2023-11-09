package model.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Invoice {
    private String invoiceId;
    private User user;
    private List<LineItem> items;
    private Date invoiceDateTime;

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
