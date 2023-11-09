import model;

import java.util.ArrayList;
import java.util.List;

public class Favorites {
    private User user;
    private List<Product> products;

    public Favorites() {
        this.user = new User();
        this.products = new ArrayList<>();
    }

    public Favorites(User user, List<Product> products) {
        this.user = user;
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(String productId) {
        this.products.removeIf(product -> product.getProductId().equals(productId));
    }
}

