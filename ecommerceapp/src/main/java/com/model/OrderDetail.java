package com.model;

import java.util.Date;

public class OrderDetail {
    private String firstName;
    private String lastName;
    private String companyName;
    private String countryName;
    private String streetAddress;
    private String postCode;
    private String cityName;
    private String emailAddress;
    private String phoneNumber;
    private double totalAmount;
    private double subtotalAmount;
    private double shipping;
    private Date orderDate;
    private String paymentMethod;
    
    public OrderDetail() { 
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
        this.shipping = 0.0;
        this.orderDate = new Date();
        this.paymentMethod = "";
    }

    public OrderDetail(String firstName, String lastName, String companyName, String countryName, String streetAddress, String postCode, String cityName, String emailAddress, String phoneNumber, double totalAmount, double subtotalAmount, double shipping, Date orderDate, String paymentMethod) {
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
        this.shipping = shipping;
        this.orderDate = orderDate;
        this.paymentMethod = paymentMethod;
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

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount + this.shipping;
    }    

    public double getSubtotalAmount() {
        return subtotalAmount;
    }

    public void setSubtotalAmount(double subtotalAmount) {
        this.subtotalAmount = subtotalAmount;
    }

    public double getShipping() {
        return shipping;
    }

    public void setShipping(double shipping) {
        this.shipping = shipping;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
