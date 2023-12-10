package com.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.hash.Pbkdf2PasswordHashImpl;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private boolean isVerified;
    private String verificationCode;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;
    private String shippingAddress;
    private String email;
    private String password;
    private boolean isAdmin;
    private LocalDateTime registerDate;

    private static Pbkdf2PasswordHashImpl passwordHash = new Pbkdf2PasswordHashImpl();

    public User() {
        this.userId = null;
        this.isVerified = false;
        this.verificationCode = "";
        this.firstName = "";
        this.lastName = "";
        this.gender = "";
        this.dateOfBirth = null;
        this.shippingAddress = "";
        this.email = "";
        this.password = "";
        this.isAdmin = false;
        this.registerDate = LocalDateTime.now();
    }

    public User(Long userId, boolean isVerified, String verificationCode, String firstName, String lastName,
            String gender, LocalDate dateOfBirth,
            String shippingAddress, String email, String password, boolean isAdmin, LocalDateTime registerDate) {
        this.userId = userId;
        this.isVerified = isVerified;
        this.verificationCode = verificationCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.shippingAddress = shippingAddress;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.registerDate = registerDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = passwordHash.generate(password.toCharArray());
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

}
