package TEST;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class LineItem {
    @OneToOne
    private Product item;
    private int quantity;

    public LineItem() {
        this.item = new Product();
        this.quantity = 0;
    }

    public LineItem(Product item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return this.item.getPrice() * this.quantity;
    }
}

