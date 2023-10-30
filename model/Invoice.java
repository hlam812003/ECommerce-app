package model;

import java.util.Date;
import java.util.List;

public class Invoice {
    private User user;
    private List<LineItem> lineItems;
    private Date invoiceDate;
    private int invoiceNumber;
    private double invoiceTotal;

    public Invoice() {
        this.user = null;
        this.lineItems = null;
        this.invoiceDate = null;
        this.invoiceNumber = 0;
        this.invoiceTotal = 0.0;
    }

    public Invoice(User user, List<LineItem> lineItems, Date invoiceDate, int invoiceNumber, double invoiceTotal) {
        this.user = user;
        this.lineItems = lineItems;
        this.invoiceDate = invoiceDate;
        this.invoiceNumber = invoiceNumber;
        this.invoiceTotal = invoiceTotal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public double getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setInvoiceTotal(double invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }
}
