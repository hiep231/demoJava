package groceryStore.service;

import groceryStore.model.Category;
import groceryStore.model.OrderItem;
import groceryStore.model.Product;
import java.util.List;


interface OrderItemServiceInterface{
    Boolean handleOrderItem(List<Product> listProduct, List<OrderItem> listOrderItems);
    OrderItem createOrderItem(List<Product> listProduct, List<OrderItem> listOrderItems, String productId, Integer quantity);
}
public class OrderItemService implements OrderItemServiceInterface {
    static Common common = new Common();
    static ProductService productService = new ProductService();
    public Boolean handleOrderItem(List<Product> listProduct, List<OrderItem> listOrderItems) {
        while (true) {
            System.out.println("-----------------------------------------------------");
            System.out.println("order");
            System.out.println("1.Create  2.View  3.Out");
            System.out.println("Enter your choice order: ");
            String choiceOrder = common.scanner.next();
            if (choiceOrder.equals("1")) {
                System.out.println("Create order");
                System.out.println("Enter ID Product: ");
                String id_product = common.scanner.next();
                Product product = productService.findProductById(listProduct, id_product);
                if (product != null) {
                    System.out.println("Enter quantity order: ");
                    Integer quantityOrder = common.checkInterger();
                    OrderItem create = createOrderItem(listProduct, listOrderItems, id_product, quantityOrder);
                    if (create != null){
                        System.out.println("Create orderItem done!!!");
                        continue;
                    }
                }
                System.out.println("Product id not found");
                continue;
            }
            if (choiceOrder.equals("2")) {
                System.out.println("View order");
                System.out.println(listOrderItems);
                continue;
            }
            if (choiceOrder.equals("3")) {
                break;
            }
        }
        return true;
    }
    public OrderItem createOrderItem(List<Product> listProduct, List<OrderItem> listOrderItems, String productId, Integer quantity) {
        for ( Product product : listProduct) {
            if (product.id.equals(productId)) {
                OrderItem orderItem = new OrderItem();
                orderItem.setProductId(productId);
                orderItem.setQuantity(quantity);
                listOrderItems.add(orderItem);
                return orderItem;
            }
        }
        return null;
    }
}
