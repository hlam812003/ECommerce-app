package model;

public class LineItem {
    private Product item;
    private int quantity;
    private String itemSize;

    public LineItem() {
        this.item = null;
        this.quantity = 0;
        this.itemSize = "";
    }

    public LineItem(Product item, int quantity, String itemSize) {
        this.item = item;
        this.quantity = quantity;
        this.itemSize = itemSize;
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

    public String getItemSize() {
        return itemSize;
    }

    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }
}
