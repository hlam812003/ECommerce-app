package model.business;

import jakarta.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity

public class User implements Serializable {
    private String userId;
    private String firstName;
    private String lastName;
    private String gender;
    private Date dateOfBirth;
    private String shippingAddress;
    private String email;
    private String password;
    private boolean isAdmin;
    private Date registerDate;

    public User() {
        this.userId = "";
        this.firstName = "";
        this.lastName = "";
        this.gender = "";
        this.dateOfBirth = new Date();
        this.shippingAddress = "";
        this.email = "";
        this.password = "";
        this.isAdmin = false;
        this.registerDate = new Date();
    }

    public User(String userId, String firstName, String lastName, String gender, Date dateOfBirth, 
                String shippingAddress, String email, String password, boolean isAdmin, Date registerDate) {
        this.userId = userId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
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
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public void updateProfile() {
        
    }
}
