package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @OneToOne
    private Invoice invoice;
    private String firstName;
    private String lastName;
    private String companyName;
    private String countryName;
    private String streetAddress;
    private String postCode;
    private String cityName;
    private String emailAddress;
    private String phoneNumber;
    private Double totalAmount;
    private Double subtotalAmount;
    private Double taxAmount;
    private Double shippingAmount;
    private String paymentMethod;

    public OrderDetail() {
        this.invoice = new Invoice();
        this.firstName = "";
        this.lastName = "";
        this.companyName = "";
        this.countryName = "";
        this.streetAddress = "";
        this.postCode = "";
        this.cityName = "";
        this.emailAddress = "";
        this.phoneNumber = "";
        this.totalAmount = 0.0;
        this.subtotalAmount = 0.0;
        this.taxAmount = 0.0;
        this.paymentMethod = "";
    }

    public OrderDetail(Invoice invoice, String firstName, String lastName, String companyName, String countryName,
            String streetAddress, String postCode, String cityName, String emailAddress, String phoneNumber,
            Double totalAmount, Double subtotalAmount, Double taxAmount, Double shippingAmount, String paymentMethod) {
        this.invoice = invoice;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.countryName = countryName;
        this.streetAddress = streetAddress;
        this.postCode = postCode;
        this.cityName = cityName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.totalAmount = totalAmount;
        this.subtotalAmount = subtotalAmount;
        this.taxAmount = taxAmount;
        this.shippingAmount = shippingAmount;
        this.paymentMethod = paymentMethod;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount + this.taxAmount;
    }

    public Double getSubtotalAmount() {
        return subtotalAmount;
    }

    public void setSubtotalAmount(Double subtotalAmount) {
        this.subtotalAmount = subtotalAmount;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Double getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(Double shippingAmount) {
        this.shippingAmount = shippingAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
