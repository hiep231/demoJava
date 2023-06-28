package groceryStore.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Product> listProduct = new ArrayList<>();
        List<Category> listCategory = new ArrayList<>();
        List<Bill> listBill = new ArrayList<>();
        List<OrderItem> listOrderItems = new ArrayList<>();

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
            String choiceModel = scanner.next();
            if (choiceModel.equals("1")) {
                Boolean exist = category(listCategory);
                if (exist){
                    continue;
                }
            }
            if (choiceModel.equals("2")) {
                Boolean exist = product(listProduct, listCategory);
                if (exist) {
                    continue;
                }
            }
            if (choiceModel.equals("3")) {
                Boolean exist = orderItem(listProduct, listOrderItems);
                if (exist) {
                    continue;
                }
            }
            if (choiceModel.equals("4")) {
                Boolean exist = bill(listBill, listProduct, listOrderItems);
                if (exist) {
                    continue;
                }
            }
            if (choiceModel.equals("5")) {
                break;
            }
        }
    }

//    --------------------------------------SERVICE--------------------------------------

    //    ----------------------------------------Category---------------------------------------------
    public static Boolean category(List<Category> listCategory){
        while (true) {
            String prefix_category = "CAT";
            char digit1 = generateRandomDigit();
            char UpperLetter = generateRandomUppercaseLetter();
            char digit2 = generateRandomDigit();
            String id_category = prefix_category + digit1 + UpperLetter + digit2;

            System.out.println("Category");
            System.out.println("1.Create  2.Update  3.Delete   4.View ");
            System.out.println("Enter your choice category: ");
            String choiceCategory =  scanner.next();
            if (choiceCategory.equals("1")) {
                System.out.println("Enter name category: ");
                String nameCategory =  scanner.next();
                System.out.println("Enter quantity category: ");
                Integer quantityCategory =  scanner.nextInt();
                Category create = createCategory(listCategory, id_category, nameCategory, quantityCategory);
                System.out.println("Create done!!!");
                continue;
            }
            if (choiceCategory.equals("2")) {
                System.out.println("Enter the category ID to update: ");
                String categoryIdToUpdate = scanner.next();
                Category categoryToUpdate = findCategoryById(listCategory, categoryIdToUpdate);
                if (categoryToUpdate != null) {
                    System.out.println("Enter name category update: ");
                    String nameCategory =  scanner.next();
                    System.out.println("Enter quantity category update: ");
                    Integer quantityCategory =  scanner.nextInt();
                    Category update = updateCategory(listCategory, categoryIdToUpdate, nameCategory, quantityCategory);
                    System.out.println("Update done!!!");
                    continue;
                }
                System.out.println("Category not found!");
            }
            if (choiceCategory.equals("3")) {
                System.out.println("Enter the category ID to delete: ");
                String categoryIdToDelete = scanner.next();
                Category categoryToDelete = findCategoryById(listCategory, categoryIdToDelete);
                if (categoryToDelete != null) {
                    Category delete = deleteCategory(listCategory, categoryIdToDelete);
                    System.out.println("Delete done!!!");
                    continue;
                }
                System.out.println("Category not found!");
            }
            if (choiceCategory.equals("4")) {
                System.out.println(viewCategory(listCategory));
                continue;
            }
            break;
        }
        return true;
    }
    public static Category createCategory(List<Category> listCategory, String id, String name, Integer quantity) {
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        category.setQuantity(quantity);
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
    public static Category updateCategory(List<Category> listCategory, String categoryId , String name, Integer quantity) {
        Category categoryToUpdate = findCategoryById(listCategory, categoryId);
        if (categoryToUpdate != null) {
            categoryToUpdate.setName(name);
            categoryToUpdate.setQuantity(quantity);
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
        return null;
    }
    public static List<Category> viewCategory(List<Category> listCategory) {
        return listCategory;
    }

    //    ----------------------------------------------Product----------------------------------------
    public static Boolean product(List<Product> listProduct, List<Category> listCategory) {
        while (true) {
            String prefix = "PRO";
            char digit1 = generateRandomDigit();
            char UpperLetter = generateRandomUppercaseLetter();
            char digit2 = generateRandomDigit();
            String id_product = prefix + digit1 + UpperLetter + digit2;

            System.out.println("Product");
            System.out.println("1.Create  2.Update  3.Delete   4.View ");
            System.out.println("Enter your choice product: ");
            String choiceProduct = scanner.next();
            if (choiceProduct.equals("1")) {
                System.out.println("Enter Category ID: ");
                String choiceCategoryId = scanner.next();
                Category category = findCategoryById(listCategory, choiceCategoryId);
                System.out.println("Enter name product: ");
                String  nameProduct = scanner.next();
                System.out.println("Enter price product: ");
                Double  priceProduct = checkDouble();
                System.out.println("Enter link image product: ");
                String  linkProduct = scanner.next();
                Product create = createProduct(listProduct, id_product, nameProduct, priceProduct, linkProduct, category.getId());
                System.out.println("Create done!!!");
                continue;
            }
            if (choiceProduct.equals("2")) {
                System.out.println("Enter Category ID: ");
                String choiceCategoryId = scanner.next();
                Category categoryToUpdate = findCategoryById(listCategory, choiceCategoryId);
                if (categoryToUpdate != null) {
                    System.out.println("Enter Product ID: ");
                    String productId = scanner.next();
                    Product productToUpdate = findProductById(listProduct, productId);
                    if (productToUpdate != null) {
                        System.out.println("Enter name product update: ");
                        String  nameProduct = scanner.next();
                        System.out.println("Enter price product: ");
                        Double  priceProduct = checkDouble();
                        System.out.println("Enter link image product: ");
                        String  linkProduct = scanner.next();
                        Product update = updateProduct(listProduct, productToUpdate.getId(), nameProduct, priceProduct, linkProduct, categoryToUpdate.getId());
                        System.out.println("Update done!!!");
                        continue;
                    }
                    System.out.println("Product id not found");
                    continue;
                }
                System.out.println("Category id not found");
                continue;
            }
            if (choiceProduct.equals("3")) {
                System.out.println("Enter Product ID: ");
                String choiceProductId = scanner.next();
                Product productToDelete = findProductById(listProduct, choiceProductId);
                if (productToDelete != null){
                    Product delete = deleteProduct(listProduct, choiceProductId);
                    System.out.println("Delete done!!!");
                    continue;
                }
                System.out.println("Product id not found!");
                continue;
            }
            if (choiceProduct.equals("4")) {
                System.out.println(viewProduct(listProduct));
                continue;
            }
            break;
        }
        return true;
    }
    public static Product createProduct(List<Product> listProduct, String productId, String name, Double price, String image, String categoryId) {
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
    public static Product updateProduct(List<Product> listProduct, String productId, String name, Double price, String image, String categoryId) {
        Product productToUpdate = findProductById(listProduct,productId);
        if (productToUpdate != null) {
            productToUpdate.setId(productId);
            productToUpdate.setName(name);
            productToUpdate.setPrice(price);
            productToUpdate.setExpiration(LocalDate.now());
            productToUpdate.setImage(image);
            productToUpdate.setCategoryId(categoryId);
            return productToUpdate;
        }
        return null;
    }
    public static Product deleteProduct(List<Product> listProduct, String productId) {
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
    //    -----------------------------------------------------Order-----------------------------------------------------
    public static Boolean orderItem(List<Product> listProduct, List<OrderItem> listOrderItems) {
        while (true) {
            System.out.println("order");
            System.out.println("1.Create  2.View ");
            System.out.println("Enter your choice order: ");
            String choiceOrder = scanner.next();
            if (choiceOrder.equals("1")) {
                System.out.println("Enter ID Product: ");
                String id_product = scanner.next();
                Product product = findProductById(listProduct, id_product);
                if (product != null) {
                    System.out.println("Enter quantity order: ");
                    Integer quantityOrder = scanner.nextInt();
                    OrderItem create = createOrderItem(listProduct, listOrderItems, id_product, quantityOrder);
                    System.out.println("Create orderItem done!!!");
                    continue;
                }
            }
            if (choiceOrder.equals("2")) {
                System.out.println(viewOderItem(listOrderItems));
                continue;
            }
            break;
        }
        return true;
    }
    public static OrderItem createOrderItem(List<Product> listProduct, List<OrderItem> listOrderItems, String productId, Integer quantity) {
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
    public static List<OrderItem> viewOderItem(List<OrderItem> listOrderItems) {
        return listOrderItems;
    }
    //    ----------------------------------------------------bill-------------------------------------------
    public static Boolean bill(List<Bill> listBill, List<Product> listProduct, List<OrderItem> listOrderItems) {
        while (true) {
            String prefix = "BIL";
            char digit1 = generateRandomDigit();
            char UpperLetter = generateRandomUppercaseLetter();
            char digit2 = generateRandomDigit();
            String id_bill = prefix + digit1 + UpperLetter + digit2;
            System.out.println("Bill");
            System.out.println("1.Create  2.View ");
            System.out.println("Enter your choice bill: ");
            String choiceBill = scanner.next();
            if (choiceBill.equals("1")) {
                System.out.println("Enter customer name: ");
                String customerName = scanner.next();
                Bill create = createBill(listBill, listProduct, id_bill, customerName, listOrderItems);
                System.out.println("Create bill done!!!");
                continue;
            }
            if (choiceBill.equals("2")) {
                System.out.println(viewBill(listBill));
                continue;
            }
            break;
        }
        return true;
    }
    public static Double totalAmount(List<Product> listProduct, List<OrderItem> listOrderItems) {
        Double totalAmount = 0.00;
        for( OrderItem orderItem : listOrderItems) {
            for (Product product : listProduct ){
                if (orderItem.productId.equals(product.id)) {
                    totalAmount = totalAmount + product.getPrice() * orderItem.getQuantity();
                }
            }
        }
        return totalAmount;
    }
    public static Bill createBill(List<Bill> listBill, List<Product> listProduct, String id, String customerName, List<OrderItem> listOrderItems) {
        Bill bill = new Bill();
        System.out.println("Enter promotion price: ");
        Double promotionPrice = checkDouble();
        bill.setId(id);
        bill.setCustomerName(customerName);
        bill.setOrderItems(listOrderItems);
        Double totalAmount = totalAmount(listProduct, listOrderItems);
        bill.setTotalAmount(totalAmount);
        bill.setPromotionPrice(promotionPrice);
        bill.setTotalBill(promotionPrice, totalAmount);
        bill.setTime(getTime());
        String payment = inputPayment();
        if (checkPayment(payment)) {
            bill.setPayment(payment);
        }
        listBill.add(bill);
        return bill;
    }
    public static List<Bill> viewBill(List<Bill> listBill){
        return listBill;
    }
    //    -------------------------------------------------Common------------------------------------------
    private static String getTime() {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd-MM-yyy // HH:mm:ss");
        return time.format(timeFormat);
    }
    private static String inputPayment() {
        String payment;
        System.out.println("Enter customer choice payment: ");
        payment = scanner.next();
        return payment;
    }
    private static boolean checkPayment(String payment) {
        return payment.equals("cod") || payment.equals("momo") || payment.equals("zalopay");
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
    public static Double checkDouble(){
        Double priceProduct = null;
        while (true) {
            try {
                priceProduct = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                scanner.next();
            }
        }
        return priceProduct;
    }
}