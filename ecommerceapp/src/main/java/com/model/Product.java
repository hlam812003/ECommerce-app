package com.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private String description;
    private String type;
    private double price;
    private String size;
    private String color;
    private String material;
    private String brand;
    private String category;
    private String tags;
    private String imageUrl;
    private LocalDate releaseDate;

    public Product() {
        this.productId = null;
        this.name = "";
        this.description = "";
        this.type = "";
        this.price = 0;
        this.size = "";
        this.color = "";
        this.material = "";
        this.brand = "";
        this.category = "";
        this.tags = "";
        this.imageUrl = "";
        this.releaseDate = LocalDate.of(1000, 1, 1);
    }

    public Product(Long productId, String name, String description, String type, float price, String size,
            String color, String material, String brand, String category, String tags, String imageUrl,
            LocalDate releaseDate) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.type = type;
        this.price = price;
        this.size = size;
        this.color = color;
        this.material = material;
        this.brand = brand;
        this.category = category;
        this.tags = tags;
        this.imageUrl = imageUrl;
        this.releaseDate = releaseDate;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrls) {
        this.imageUrl = imageUrls;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
