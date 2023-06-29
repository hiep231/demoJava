package groceryStore.model;


import java.util.List;

public class Bill {
    private String id;
    private String customerName;
    private List<OrderItem> orderItems;
    private Double promotionPrice;
    private Double totalAmount;
    private Double totalBill;
    private String time;
    private String payment;

    public Bill() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(Double promotionPrice,Double totalAmount) {
        this.totalBill = totalAmount - promotionPrice;
    }

    public Double getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(Double promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id='" + id + '\'' +
                ", customerName='" + customerName + '\'' +
                ", orderItems=" + orderItems +
                ", promotionPrice=" + promotionPrice +
                ", totalAmount=" + totalAmount +
                ", totalBill=" + totalBill +
                ", time='" + time + '\'' +
                ", payment='" + payment + '\'' +
                '}';
    }
}

