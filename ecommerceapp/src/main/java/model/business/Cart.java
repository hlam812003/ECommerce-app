package model.business;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private User user;
    private List<LineItem> items;

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
}
