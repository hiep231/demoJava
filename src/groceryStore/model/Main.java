package groceryStore.model;

import groceryStore.service.*;

import java.time.LocalDate;
import java.util.*;

public class Main {
    static Common common = new Common();
    static CategoryService categoryService = new CategoryService();
    static ProductService productService = new ProductService();
    static OrderItemService orderItemService = new OrderItemService();
    static BillService billService = new BillService();

    static List<Product> listProduct = new ArrayList<>();
    static List<Category> listCategory = new ArrayList<>();
    static List<Bill> listBill = new ArrayList<>();
    static List<OrderItem> listOrderItems = new ArrayList<>();
    public static void main(String[] args) {
        Category c1 = new Category("CAT1H2","GAO",2);
        Category c2 = new Category("CAT9H3","LAO",3);
        listCategory.add(c1);
        listCategory.add(c2);

        Product p1 = new Product("PRO2K4","ST14",15.00, LocalDate.now(),"http://school.com","CAT1H2");
        Product p2 = new Product("PRO1J6","J2B",25.00, LocalDate.now(),"http://school.com","CAT9H3");
        listProduct.add(p1);
        listProduct.add(p2);

        while (true) {
            System.out.println("Menu");
            System.out.println("1.Category  2.Product  3.OrderItems   4.Bill   5.out");
            System.out.println("Enter your choice menu: ");
            String choiceModel = common.scanner.next();
            if (choiceModel.equals("1")) {
                Boolean exist = categoryService.handleCategory(listCategory);
                if (exist){
                    continue;
                }
            }
            if (choiceModel.equals("2")) {
                Boolean exist = productService.handleProduct(listProduct, listCategory);
                if (exist) {
                    continue;
                }
            }
            if (choiceModel.equals("3")) {
                Boolean exist = orderItemService.handleOrderItem(listProduct, listOrderItems);
                if (exist) {
                    continue;
                }
            }
            if (choiceModel.equals("4")) {
                Boolean exist = billService.handleBill(listBill, listProduct, listOrderItems);
                if (exist) {
                    continue;
                }
            }
            if (choiceModel.equals("5")) {
                break;
            }
        }
    }
}