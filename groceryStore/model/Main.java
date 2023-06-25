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
        List<OrderItem> listOrderItems = new ArrayList<>();
        Category c1 = new Category("CAT1H2","GAO","TOT");
        Category c2 = new Category("CAT9H3","LAO","TOT");
        listCategory.add(c1);
        listCategory.add(c2);

        Product p1 = new Product("PRO2K4","ST14",15.00,LocalDate.now(),"http://school.com","CAT1H2");
        Product p2 = new Product("PRO1J6","J2B",25.00,LocalDate.now(),"http://school.com","CAT9H3");
        listProduct.add(p1);
        listProduct.add(p2);

        while (true) {
            Scanner myObj = new Scanner(System.in);
            String choiceModel;
            System.out.println("Menu");
            System.out.println("1.Category  2.Product  3.OrderItems   4.Bill   out");
            System.out.println("Enter your choice menu: ");
            choiceModel = myObj.nextLine();

            if (choiceModel.equals("1")) {

                while (true) {
                    String prefix_category = "CAT";
                    char digit1 = generateRandomDigit();
                    char UpperLetter = generateRandomUppercaseLetter();
                    char digit2 = generateRandomDigit();
                    String id_category = prefix_category + digit1 + UpperLetter + digit2;

                    Scanner Obj = new Scanner(System.in);
                    String choiceCategory;
                    System.out.println("Category");
                    System.out.println("1.Create  2.Update  3.Delete   4.View ");
                    System.out.println("Enter your choice category: ");
                    choiceCategory =  Obj.nextLine();
                    if (choiceCategory.equals("1")) {
                        Category category = createCategory(listCategory, id_category, "Lua Vang", "Trung binh");
                        System.out.println("Create done!!!");
                    } else if (choiceCategory.equals("2")) {
                        Scanner myObj2 = new Scanner(System.in);
                        System.out.println("Enter the category ID to update: ");
                        String categoryIdToUpdate = myObj2.nextLine();
                        Category categoryToUpdate = findCategoryById(listCategory, categoryIdToUpdate);
                        if (categoryToUpdate != null) {
                            System.out.println("Enter the updated category name: ");
                            String updatedName = myObj2.nextLine();
                            Category update = updateCategory(listCategory, updatedName, "com", "Tot");
                            System.out.println("Update done!!!");
                        } else {
                            System.out.println("Category not found!");
                        }
                    } else if (choiceCategory.equals("3")) {
                        Scanner myObj3 = new Scanner(System.in);
                        System.out.println("Enter the category ID to update: ");
                        String categoryIdToDelete = myObj3.nextLine();
                        Category categoryToDelete = findCategoryById(listCategory, categoryIdToDelete);

                        if (categoryToDelete != null) {
                            System.out.println("Enter the delete category name: ");
                            String deleteName = myObj3.nextLine();
                            Category delete = deleteCategory(listCategory, deleteName);
                            System.out.println("Delete done!!!");
                        } else {
                            System.out.println("Category not found!");
                        }
                    } else if (choiceCategory.equals("4")) {
                        System.out.println(viewCategory(listCategory));
                    } else {
                        break;
                    }
                }
            }


            if (choiceModel.equals("2")) {
                while (true) {
                    String prefix = "PRO";
                    char digit1 = generateRandomDigit();
                    char UpperLetter = generateRandomUppercaseLetter();
                    char digit2 = generateRandomDigit();
                    String id_product = prefix + digit1 + UpperLetter + digit2;

                    Scanner Obj = new Scanner(System.in);
                    String choiceProduct;
                    System.out.println("Product---------------");
                    System.out.println("1.Create  2.Update  3.Delete   4.View ");
                    System.out.println("Enter your choice product: ");
                    choiceProduct = Obj.nextLine();
                    if (choiceProduct.equals("1")) {
                        Scanner myObj1 = new Scanner(System.in);
                        String choiceCategoryId;
                        System.out.println("Enter Category ID: ");
                        choiceCategoryId = myObj1.nextLine();
                        Category category = findCategoryById(listCategory, choiceCategoryId);

                        Product chao = createProduct(listProduct, id_product, "BI", 70.00, "https://elearning.vanlanguni.edu.vn/", category.getId());
                        System.out.println("Create done!!!");
                    } else if (choiceProduct.equals("2")) {
                        Scanner myObj2 = new Scanner(System.in);
                        String choiceCategoryId;
                        System.out.println("Enter Category ID: ");
                        choiceCategoryId = myObj2.nextLine();
                        Category category = findCategoryById(listCategory, choiceCategoryId);

                        Scanner myObj1 = new Scanner(System.in);
                        String productId;
                        System.out.println("Enter Product ID: ");
                        productId = myObj1.nextLine();

                        Product updateCom = updateProduct(listProduct, productId, "suon cong", 40.000, "https://facebook.com", category.getId());
                        System.out.println("Update done!!!");
                    } else if (choiceProduct.equals("3")) {
                        Scanner Obj3 = new Scanner(System.in);
                        String choiceProductId;
                        System.out.println("Enter Product ID: ");
                        choiceProductId = Obj3.nextLine();
                        Product deleteProduct = deleteProduct(listProduct, choiceProductId);
                        System.out.println("Delete done!!!");
                    } else if (choiceProduct.equals("4")) {
                        System.out.println(viewProduct(listProduct));
                    } else {
                        break;
                    }
                }
            }

            if (choiceModel.equals("3")) {
                while (true) {
                    Scanner Obj = new Scanner(System.in);
                    String choiceOrder;
                    System.out.println("order");
                    System.out.println("1.Create  2.View ");
                    System.out.println("Enter your choice order: ");
                    choiceOrder = Obj.nextLine();

                    if (choiceOrder.equals("1")) {
                        Scanner Obj1 = new Scanner(System.in);
                        String id_product;
                        System.out.println("Enter ID Product: ");
                        id_product = Obj1.nextLine();
                        OrderItem orderItem = createOrderItem(listProduct, listOrderItems, id_product, "Cao");
                        System.out.println("Create orderItem done!!!");
                    } else if (choiceOrder.equals("2")) {
                        System.out.println(viewOderItem(listOrderItems));
                    } else break;
                }
            }
            if (choiceModel.equals("4")) {
                while (true) {
                    String prefix = "BIL";
                    char digit1 = generateRandomDigit();
                    char UpperLetter = generateRandomUppercaseLetter();
                    char digit2 = generateRandomDigit();
                    String id_bill = prefix + digit1 + UpperLetter + digit2;

                    Scanner obj = new Scanner(System.in);
                    String choiceBill;
                    System.out.println("Bill");
                    System.out.println("1.Create  2.View ");
                    System.out.println("Enter your choice bill: ");
                    choiceBill = obj.nextLine();
                    if (choiceBill.equals("1")) {

                        Bill newBill = createBill(listBill, listProduct, id_bill, "Linh", listOrderItems);
                        System.out.println("Create bill done!!!");
                    } else if (choiceBill.equals("2")) {
                        System.out.println(viewBill(listBill));
                    } else break;
                }
            }
            if (choiceModel.equals("out")) {
                break;
            };
        }
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
    public static Category findCategoryById(List<Category> listCategory, String categoryId) {
        for (Category category : listCategory) {
            if (category.getId().equals(categoryId)) {
                return category;
            }
        }
        return null;
    }
    public static Category updateCategory(List<Category> listCategory,String categoryId , String name, String quality) {
        Category categoryToUpdate = findCategoryById(listCategory, categoryId);

        if (categoryToUpdate != null) {
            categoryToUpdate.setName(name);
            categoryToUpdate.setQuality(quality);
            return categoryToUpdate;
        }
        return null;
    }
    public static Category deleteCategory(List<Category> listCategory, String categoryId) {
        Category categoryToDelete = findCategoryById(listCategory, categoryId);

        if (categoryToDelete != null) {
            listCategory.remove(categoryToDelete);
            return categoryToDelete;
        }

        return null;  // Category not found
    }
    public static List<Category> viewCategory(List<Category> listCategory) {
        return listCategory;
    }


//    ----------------------------------------------Poduct----------------------------------------

    public static Product createProduct(List<Product> listProduct,String productId, String name, Double price,String image,String categoryId) {
        Product product = new Product();
        product.setId(productId);
        product.setName(name);
        product.setPrice(price);
        product.setExpiration(LocalDate.now());
        product.setImage(image);
        product.setCategoryId(categoryId);
        listProduct.add(product);
        return product;
    }
    public static Product findProductById(List<Product> listProduct, String ProductId) {
        for (Product product : listProduct) {
            if (product.getId().equals(ProductId)) {
                return product;
            }
        }
        return null;
    }
    public static Product updateProduct(List<Product> listProduct,String productId, String name, Double price,String image,String categoryId) {
        Product prosductToUpdate = findProductById(listProduct,productId);

        if (prosductToUpdate != null) {
            prosductToUpdate.setId(productId);
            prosductToUpdate.setName(name);
            prosductToUpdate.setPrice(price);
            prosductToUpdate.setExpiration(LocalDate.now());
            prosductToUpdate.setImage(image);
            prosductToUpdate.setCategoryId(categoryId);
            return prosductToUpdate;
        }
        return null;
    }
    public static Product deleteProduct(List<Product> listProduct,String productId) {
        Product productToDelete = findProductById(listProduct, productId);

        if (productToDelete != null) {
            listProduct.remove(productToDelete);
            return productToDelete;
        }

        return null;
    }
    public static List<Product> viewProduct(List<Product> listProduct) {
        return listProduct;
    }


//    ------------------------------------------------------Order-------------------------------------------------
    public static OrderItem createOrderItem(List<Product> listProduct,List<OrderItem> listOrderItems,String productId,String quality) {
        for ( Product product : listProduct) {
            if (product.id.equals(productId)) {
                OrderItem orderItem = new OrderItem();
                orderItem.setProductId(productId);
                orderItem.setQuality(quality);
                listOrderItems.add(orderItem);
                return orderItem;
            }
        }
        return null;
    }
    public static List<OrderItem> viewOderItem(List<OrderItem> listOrderItems) {
        return listOrderItems;
    }
//    ----------------------------------------------------Orderbill-------------------------------------------
    public static Double totalAmount(List<Product> listProduct, List<OrderItem> listOrderItems) {
        Double totalAmount = 0.00;
        for( OrderItem orderItem : listOrderItems) {
            for (Product product : listProduct ){
                if (orderItem.productId.equals(product.id)) {
                    totalAmount += product.getPrice();
                }
            }
        }
        return totalAmount;
    }
    public static Bill createBill(List<Bill> listBill,List<Product> listProduct,String id,String customerName,List<OrderItem> listOrderItems) {
        Bill bill = new Bill();
        bill.setId(id);
        bill.setCustomerName(customerName);
        bill.setOrderItems(listOrderItems);
        Double totalAmount = totalAmount(listProduct,listOrderItems);
        bill.setTotalAmount(totalAmount);

        Scanner myObj = new Scanner(System.in);
        Double promotionPrice;
        System.out.println("Enter promotion price: ");
        promotionPrice = myObj.nextDouble();

        bill.setPromotionPrice(promotionPrice);
        bill.setTotalBill(promotionPrice,totalAmount);
        bill.setTime(getTime());
        Scanner myObj1 = new Scanner(System.in);
        String payment;
        System.out.println("Bill");
        System.out.println("1.Create  2.View ");
        System.out.println("Enter your type payment: ");
        payment = myObj1.nextLine();
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
