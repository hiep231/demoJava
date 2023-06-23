package groceryStore.model;

public class OrderItem {
    String productId;
    String quality;

    public OrderItem() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "productId='" + productId + '\'' +
                ", quality='" + quality + '\'' +
                '}';
    }
}
