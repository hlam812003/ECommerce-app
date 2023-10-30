package model; 

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String country;
    private boolean isAdmin;
    private List<Integer> invoiceNumbers;

    public User() {
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.password = "";
        this.address = "";
        this.country = "";
        this.isAdmin = false;
        this.invoiceNumbers = new ArrayList<>();
    }

    public User(String firstName, String lastName, String email, String password, String address, String country, boolean isAdmin, List<Integer> invoiceNumbers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.country = country;
        this.isAdmin = isAdmin;
        this.invoiceNumbers = invoiceNumbers;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public List<Integer> getInvoiceNumbers() {
        return invoiceNumbers;
    }

    public void setInvoiceNumbers(List<Integer> invoiceNumbers) {
        this.invoiceNumbers = invoiceNumbers;
    }

    public void addInvoiceNumber(int num) {
        this.invoiceNumbers.add(num);
    }

    public void deleteInvoiceNumber(int num) {
        this.invoiceNumbers.remove(Integer.valueOf(num));
    }

    public double getMoneySpent() {
        return 0.0;
    }
}
