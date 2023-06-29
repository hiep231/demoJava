package groceryStore.service;

import groceryStore.model.Bill;
import groceryStore.model.OrderItem;
import groceryStore.model.Product;
import java.util.List;
import java.util.Scanner;

interface BillServiceInterface {
    Boolean handleBill(List<Bill> listBill, List<Product> listProduct, List<OrderItem> listOrderItems);
    Double totalAmount(List<Product> listProduct, List<OrderItem> listOrderItems);
    Bill createBill(List<Bill> listBill, List<Product> listProduct, String id, String customerName, List<OrderItem> listOrderItems);
}
public class BillService {
    static Common common = new Common();
    public Boolean handleBill(List<Bill> listBill, List<Product> listProduct, List<OrderItem> listOrderItems) {
        while (true) {
            String prefix = "BIL";
            char digit1 = common.generateRandomDigit();
            char UpperLetter = common.generateRandomUppercaseLetter();
            char digit2 = common.generateRandomDigit();
            String id_bill = prefix + digit1 + UpperLetter + digit2;
            System.out.println("-----------------------------------------------------");
            System.out.println("Bill");
            System.out.println("1.Create  2.View  3.Out");
            System.out.println("Enter your choice bill: ");
            String choiceBill = common.scanner.next();
            if (choiceBill.equals("1")) {
                System.out.println("Create bill");
                System.out.println("Enter customer name: ");
                String customerName = common.scanner.next();
                Bill create = createBill(listBill, listProduct, id_bill, customerName, listOrderItems);
                if (create != null){
                    System.out.println("Create bill done!!!");
                    continue;
                }
            }
            if (choiceBill.equals("2")) {
                System.out.println("View bill");
                System.out.println(listBill);
                continue;
            }
            if (choiceBill.equals("3")) {
                break;
            }
        }
        return true;
    }
    public Double totalAmount(List<Product> listProduct, List<OrderItem> listOrderItems) {
        Double totalAmount = 0.00;
        for( OrderItem orderItem : listOrderItems) {
            for (Product product : listProduct ){
                if (orderItem.getProductId().equals(product.id)) {
                    totalAmount = totalAmount + product.getPrice() * orderItem.getQuantity();
                }
            }
        }
        return totalAmount;
    }
    public Bill createBill(List<Bill> listBill, List<Product> listProduct, String id, String customerName, List<OrderItem> listOrderItems) {
        Bill bill = new Bill();
        System.out.println("Enter promotion price: ");
        Double promotionPrice = common.checkDouble();
        bill.setId(id);
        bill.setCustomerName(customerName);
        bill.setOrderItems(listOrderItems);
        Double totalAmount = totalAmount(listProduct, listOrderItems);
        bill.setTotalAmount(totalAmount);
        bill.setPromotionPrice(promotionPrice);
        bill.setTotalBill(promotionPrice, totalAmount);
        bill.setTime(common.getTime());
        String payment = common.inputPayment();
        if (common.checkPayment(payment)) {
            bill.setPayment(payment);
        }
        listBill.add(bill);
        return bill;
    }
}
