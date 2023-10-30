package model;

import java.util.List;

public class Product {
    private String code;
    private String description;
    private double price;
    private String category;
    private String imageUrl;
    private List<String> sizes;

    public Product() {
        this.code = "";
        this.description = "";
        this.price = 0.0;
        this.category = "";
        this.imageUrl = "";
        this.sizes = null;
    }

    public Product(String code, String description, double price, String category, String imageUrl, List<String> sizes) {
        this.code = code;
        this.description = description;
        this.price = price;
        this.category = category;
        this.imageUrl = imageUrl;
        this.sizes = sizes;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getSizes() {
        return sizes;
    }

    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }
}

