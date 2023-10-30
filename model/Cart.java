package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<LineItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<LineItem> getItems() {
        return items;
    }

    public void setItems(List<LineItem> lineItems) {
        this.items = lineItems;
    }

    public void addItem(LineItem item) {
        this.items.add(item);
    }

    public void removeItem(String code) {
        items.removeIf(lineItem -> lineItem.getItem().getCode().equals(code));
    }

    public void removeAll() {
        this.items.clear();
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (LineItem item : items) {
            total += item.getItem().getPrice() * item.getQuantity();
        }
        return total;
    }
}
