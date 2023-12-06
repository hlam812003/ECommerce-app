package TEST;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String productId;
    private String name;
    private String description;
    private String type;
    private float price;
    private String size;
    private String color;
    private String material;
    private String brand;
    private List<String> categories;
    private List<String> tags;
    private List<String> imageUrls;
    @Temporal(jakarta.persistence.TemporalType.DATE)
    private Date releaseDate;

    public Product() {
        this.productId = "";
        this.name = "";
        this.description = "";
        this.type = "";
        this.price = 0.0f;
        this.size = "";
        this.color = "";
        this.material = "";
        this.brand = "";
        this.categories = new ArrayList<>();
        this.tags = new ArrayList<>();
        this.imageUrls = new ArrayList<>();
        this.releaseDate = new Date();
    }

    public Product(String productId, String name, String description, String type, float price, String size, 
                   String color, String material, String brand, List<String> categories, List<String> tags, 
                   List<String> imageUrls, Date releaseDate) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.type = type;
        this.price = price;
        this.size = size;
        this.color = color;
        this.material = material;
        this.brand = brand;
        this.categories = categories;
        this.tags = tags;
        this.imageUrls = imageUrls;
        this.releaseDate = releaseDate;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
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

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}

