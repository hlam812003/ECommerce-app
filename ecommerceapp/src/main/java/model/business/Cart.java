package model.business;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Cart implements Serializable {
    
    @OneToOne
    private User user;
    @OneToMany (targetEntity = LineItem.class)
    private List<LineItem> items;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    public Cart() {
        this.user = new User();
        this.items = new ArrayList<>();
    }

    public Cart(User user) {
        this.user = user;
        this.items = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<LineItem> getItems() {
        return items;
    }

    public void setItems(List<LineItem> items) {
        this.items = items;
    }

    public void addItem(LineItem item) {
        this.items.add(item);
    }

    public void removeItem(String productId) {
        items.removeIf(lineItem -> lineItem.getItem().getProductId().equals(productId));
    }

    public void removeAll() {
        this.items.clear();
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (LineItem item : items) {
            total += item.getTotalPrice(); // Use getTotalPrice from LineItem if available
        }
        return total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
