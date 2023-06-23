package groceryStore.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> listProduct = new ArrayList<>();
        List<Category> listCategory = new ArrayList<>();
        List<Bill> listBill = new ArrayList<>();

        String prefix = "PRO";
        char digit1 = generateRandomDigit();
        char UpperLetter = generateRandomUppercaseLetter();
        char digit2 = generateRandomDigit();
        String id_product = prefix + digit1 + UpperLetter + digit2;

        String prefix_category = "CAT";
        String id_category = prefix_category + digit1 + UpperLetter + digit2;

        String prefix_bill = "BIL";
        String id_bill = prefix_bill + digit1 + UpperLetter + digit2;

        String prefix_order = "ORD";
        String id_order = prefix_bill + digit1 + UpperLetter + digit2;

        Category gao = new Category();
        gao.setId(id_category);
        gao.setName("ST15");
        gao.setQuality("8");
        listCategory.add(gao);
        while (true) {
            Scanner myObj = new Scanner(System.in);
            String choiceCategory;
            System.out.println("Category");
            System.out.println("1.Create  2.Update  3.Delete   4.View ");
            System.out.println("Enter your choice category: ");
            choiceCategory = myObj.nextLine();
            if (choiceCategory.equals("1")) {
                Category Lua = createCategory(listCategory, id_category, "Lua Vang", "Trung binh");
                System.out.println("Create done!!!");
            } else if (choiceCategory.equals("2")) {
                Category updateGao = updateCategory(listCategory, gao, id_category, "ST01", "Kha");
                System.out.println("Update done!!!");
            } else if (choiceCategory.equals("3")) {
                Category deleteGao = deleteCategory(listCategory, gao);
                System.out.println("Delete done!!!");
            } else if (choiceCategory.equals("4")) {
                List<Category> viewCategory = viewCategory(listCategory);
                System.out.println(viewCategory);
            }else {
                break;
            }
        }

        Product com = new Product();
        com.setId(id_product);
        com.setName("suon");
        com.setPrice(35.000);
        com.setImage("https://w3school.com");
        com.setExpiration(LocalDate.now());
        com.setCategoryId(gao.getId());
        System.out.println(com.toString());

        while (true) {
            Scanner myObj = new Scanner(System.in);
            String choiceProduct;
            System.out.println("Product");
            System.out.println("1.Create  2.Update  3.Delete   4.View ");
            System.out.println("Enter your choice product: ");
            choiceProduct = myObj.nextLine();
            if (choiceProduct.equals("1")) {
                Product chao = createProduct(listProduct, id_product,"BI",70.00,LocalDate.now(),"https://elearning.vanlanguni.edu.vn/",gao.getId());
                System.out.println("Create done!!!");
            } else if (choiceProduct.equals("2")) {
                Product updateCom = updateProduct(listProduct,com,id_product,"suon cong",40.000,LocalDate.now(),"https://facebook.com",gao.getId());
                System.out.println("Update done!!!");
            } else if (choiceProduct.equals("3")) {
                Product deleteProduct = deleteProduct(listProduct,com);
                System.out.println("Delete done!!!");
            } else if (choiceProduct.equals("4")) {
                List<Product> viewProduct = viewProduct(listProduct);
                System.out.println(viewProduct);
            }else {
                break;
            }
        }

//        OrderItem order = new OrderItem();
//        order.setProductId(com.getId());
//        order.setQuality("cao");
//
//        OrderItem order1 = new OrderItem();
//        order1.setProductId(chao.getId());
//        order1.setQuality("Thap");
//
//        OrderItem order2 = new OrderItem();
//        order2.setProductId(chao.getId());
//        order2.setQuality("Vua");

////        delete Product
//        Product deleteProduct = deleteProduct(listProduct,newProduct);
////        view Product
//        List<Product> viewProduct = viewProduct(listProduct);




//

//
//        Product com = new Product();
//        com.setId(id_product);
//        com.setName("suon");
//        com.setPrice(35.000);
//        com.setImage("https://w3school.com");
//        LocalDate Date = LocalDate.now();
//        com.setExpiration(Date);
//        com.setCategoryId(id_category);
//        System.out.println(com.toString());
//
//        Product chao = new Product();
//        chao.setId(id_product);
//        chao.setName("HANH");
//        chao.setPrice(5.000);
//        chao.setImage("https://school.com");
//        chao.setExpiration(Date);
//        chao.setCategoryId(id_category);
//        System.out.println(chao.toString());
//
//
//
//        Category gao = new Category();
//        gao.setId(id_category);
//        gao.setName("ST15");
//        gao.setQuality("8");
////        System.out.println(gao.toString());
//
//        Category lua = new Category();
//        lua.setId(id_category);
//        lua.setName("ST15");
//        lua.setQuality("8");
////        System.out.println(lua.toString());
//
//        listCategory.add(gao);
//        listCategory.add(lua);
//
//
//
//        OrderItem order = new OrderItem();
//        order.setProductId(com.getId());
//        order.setQuality("cao");
//
//        OrderItem order1 = new OrderItem();
//        order1.setProductId(chao.getId());
//        order1.setQuality("Thap");
//
//        OrderItem order2 = new OrderItem();
//        order2.setProductId(chao.getId());
//        order2.setQuality("Vua");
//
//
//
//
//
//        Bill bill = new Bill();
//        bill.setId(id_bill);
//        bill.setCustomerName("Hiep");
//
//        String timeNow = getTime();
//        bill.setTime(timeNow);
//
//        List<OrderItem> orderItems = new ArrayList<>();
//        orderItems.add(order);
//        orderItems.add(order1);
//
//        bill.setOrderItems(orderItems);
//        bill.setTotalAmount(55.0);
//        bill.setPromotionPrice(5.0);
//        Double total = bill.getTotalAmount() - bill.getPromotionPrice();
//        bill.setTotalBill(bill.getTotalAmount(),bill.getPromotionPrice());
//        String payment = inputpayment();
//        if (checkPayment(payment)) {
//            bill.setPayment(payment);
//        }
//
////        System.out.println(bill.toString());
//
//
//
//////        CreateCategory
////        Category newCategory = createCategory(listCategory,"CAT1J1","ST22","7");
////        System.out.println(listCategory);
////
//////        update category
////        Category updateCategory = updateCategory(listCategory,gao,"CAT8S0","ST16","9");
//////        delete category
////        Category deleteCategory = deleteCategory(listCategory,newCategory");
////        System.out.println(listCategory);
//////        view category
////        List<Category> viewCategory = viewCategory(listCategory);
////        System.out.println(viewCategory);
//
//////        create product
////        Product newProduct = createProduct(listProduct,"PRO2U3","BI",70.00,LocalDate.now(),"https://elearning.vanlanguni.edu.vn/","id_category");
//////        update Product
////        Product updateProduct = updateProduct(listProduct,chao,"PRO2U3","BI",70.00,LocalDate.now(),"https://elearning.vanlanguni.edu.vn/","id_category");
//////        delete Product
////        Product deleteProduct = deleteProduct(listProduct,newProduct);
//////        view Product
////        List<Product> viewProduct = viewProduct(listProduct);
//
//
////        create bill
//
//        Bill newBill = createBill(listBill,id_bill,"Linh",order2,orderItems,90.0,9.0,payment);
//        System.out.println(listBill);
    }


    private static String getTime() {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd-MM-yyy // HH:mm:ss");
        return time.format(timeFormat);
    }
    private static String inputpayment() {
        Scanner myObj = new Scanner(System.in);
        String payment;
        System.out.println("Enter customer choice payment: ");
        payment = myObj.nextLine();
        return payment;
    };
    private static Boolean checkPayment(String payment) {
        if (payment.equals("COD") || payment.equals("MOMO") || payment.equals("ZaloPay")) {
            return true;
        } else {
            return false;
        }
    }

    private static char generateRandomDigit() {
        Random random = new Random();
        int digit = random.nextInt(10);
        return (char) (digit + '0');
    }

    private static char generateRandomUppercaseLetter() {
        Random random = new Random();
        int letter = random.nextInt(26);
        return (char) (letter + 'A');
    }

//    --------SERVICE---------

//    ----------------------------------------Category---------------------------------------------

    public static Category createCategory(List<Category> listCategory,String id, String name, String quality) {
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        category.setQuality(quality);
        listCategory.add(category);
        return category;
    }
    public static Category updateCategory(List<Category> listCategory,Category category ,String id, String name, String quality) {
        for (Category i : listCategory) {
            if ( i == category ) {
                i.setId(id);
                i.setName(name);
                i.setQuality(quality);
                return i;
            }
        }
        return null;
    }
    public static Category deleteCategory(List<Category> listCategory,Category category) {
        for (Category i : listCategory) {
            if ( i == category ) {
                listCategory.remove(i);
                return i;
            }
        }
        return null;
    }
    public static List<Category> viewCategory(List<Category> listCategory) {
        return listCategory;
    }


//    ----------------------------------------------Poduct----------------------------------------

    public static Product createProduct(List<Product> listProduct,String id, String name, Double price,LocalDate expiration,String image,String categoryId) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setExpiration(expiration);
        product.setImage(image);
        product.setCategoryId(categoryId);
        listProduct.add(product);
        return product;
    }
    public static Product updateProduct(List<Product> listProduct,Product product,String id, String name, Double price,LocalDate expiration,String image,String categoryId) {
        for (Product i : listProduct) {
            if ( i == product ) {
                i.setId(id);
                i.setName(name);
                i.setPrice(price);
                i.setExpiration(expiration);
                i.setImage(image);
                i.setCategoryId(categoryId);
                return i;
            }
        }
        return null;
    }
    public static Product deleteProduct(List<Product> listProduct,Product product) {
        for (Product i : listProduct) {
            if ( i == product ) {
                listProduct.remove(i);

            }
        }
        return null;
    }
    public static List<Product> viewProduct(List<Product> listProduct) {
        return listProduct;
    }

//    ----------------------------------------------------Orderbill-------------------------------------------

    public static Bill createBill(List<Bill> listBill,String id,String customerName,OrderItem order,List<OrderItem> orderItems ,Double totalAmount,Double promotionPrice,String payment) {
        Bill bill = new Bill();
        bill.setId(id);
        bill.setCustomerName(customerName);
        orderItems.add(order);
        bill.setOrderItems(orderItems);
        bill.setPromotionPrice(promotionPrice);
        bill.setTotalAmount(totalAmount);
        bill.setTotalBill(promotionPrice,totalAmount);
        bill.setTime(getTime());
        if (checkPayment(payment)) {
            bill.setPayment(payment);
        }
        listBill.add(bill);
        return bill;
    }
    public static List<Bill> viewBill(List<Bill> listBill){
        return listBill;
    }
}
