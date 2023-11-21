package model.business;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Invoice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
