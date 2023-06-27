package groceryStore.model;

public class OrderItem {
    String productId;
    Integer quantity;

    public OrderItem() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quality) {
        this.quantity = quality;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "productId='" + productId + '\'' +
                ", quality='" + quantity + '\'' +
                '}';
    }
}
