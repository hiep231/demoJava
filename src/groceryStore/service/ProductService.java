package groceryStore.service;

import groceryStore.model.Category;
import groceryStore.model.Product;

import java.time.LocalDate;
import java.util.List;


interface ProductServiceInterface {
    Boolean handleProduct(List<Product> listProduct, List<Category> listCategory);
    Product createProduct(List<Product> listProduct, String productId, String name, Double price, String image, String categoryId);
    Product findProductById(List<Product> listProduct, String ProductId);
    Product updateProduct(List<Product> listProduct, String productId, String name, Double price, String image, String categoryId);
    Product deleteProduct(List<Product> listProduct, String productId);
}
public class ProductService implements ProductServiceInterface{
    static Common common = new Common();
    static CategoryService categoryService = new CategoryService();
    public Boolean handleProduct(List<Product> listProduct, List<Category> listCategory) {
        while (true) {
            String prefix = "PRO";
            char digit1 = common.generateRandomDigit();
            char UpperLetter = common.generateRandomUppercaseLetter();
            char digit2 = common.generateRandomDigit();
            String id_product = prefix + digit1 + UpperLetter + digit2;
            System.out.println("-----------------------------------------------------");
            System.out.println("Product");
            System.out.println("1.Create  2.Update  3.Delete  4.View  5.Out");
            System.out.println("Enter your choice product: ");
            String choiceProduct = common.scanner.next();
            if (choiceProduct.equals("1")) {
                System.out.println("Create product");
                System.out.println("Enter Category ID: ");
                String choiceCategoryId = common.scanner.next();
                Category category = categoryService.findCategoryById(listCategory, choiceCategoryId);
                System.out.println("Enter name product: ");
                String  nameProduct = common.scanner.next();
                System.out.println("Enter price product: ");
                Double  priceProduct = common.checkDouble();
                System.out.println("Enter link image product: ");
                String  linkProduct = common.scanner.next();
                Product create = createProduct(listProduct, id_product, nameProduct, priceProduct, linkProduct, category.getId());
                if (create != null){
                    System.out.println("Create done!!!");
                    continue;
                }
            }
            if (choiceProduct.equals("2")) {
                System.out.println("Update product");
                System.out.println("Enter Category ID: ");
                String choiceCategoryId = common.scanner.next();
                Category categoryToUpdate = categoryService.findCategoryById(listCategory, choiceCategoryId);
                if (categoryToUpdate != null) {
                    System.out.println("Enter Product ID: ");
                    String productId = common.scanner.next();
                    Product productToUpdate = findProductById(listProduct, productId);
                    if (productToUpdate != null) {
                        System.out.println("Enter name product update: ");
                        String  nameProduct = common.scanner.next();
                        System.out.println("Enter price product: ");
                        Double  priceProduct = common.checkDouble();
                        System.out.println("Enter link image product: ");
                        String  linkProduct = common.scanner.next();
                        Product update = updateProduct(listProduct, productToUpdate.getId(), nameProduct, priceProduct, linkProduct, categoryToUpdate.getId());
                        if (update != null){
                            System.out.println("Update done!!!");
                            continue;
                        }
                    }
                    System.out.println("Product id not found");
                    continue;
                }
                System.out.println("Category id not found");
                continue;
            }
            if (choiceProduct.equals("3")) {
                System.out.println("Delete product");
                System.out.println("Enter Product ID: ");
                String choiceProductId = common.scanner.next();
                Product productToDelete = findProductById(listProduct, choiceProductId);
                if (productToDelete != null){
                    Product delete = deleteProduct(listProduct, choiceProductId);
                    if (delete != null){
                        System.out.println("Delete done!!!");
                        continue;
                    }
                }
                System.out.println("Product id not found!");
                continue;
            }
            if (choiceProduct.equals("4")) {
                System.out.println("View product");
                System.out.println(listProduct);
                continue;
            }
            if (choiceProduct.equals("5")) {
                break;
            }
        }
        return true;
    }
    public Product createProduct(List<Product> listProduct, String productId, String name, Double price, String image, String categoryId) {
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
    public Product findProductById(List<Product> listProduct, String ProductId) {
        for (Product product : listProduct) {
            if (product.getId().equals(ProductId)) {
                return product;
            }
        }
        return null;
    }
    public Product updateProduct(List<Product> listProduct, String productId, String name, Double price, String image, String categoryId) {
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
    public Product deleteProduct(List<Product> listProduct, String productId) {
        Product productToDelete = findProductById(listProduct, productId);
        if (productToDelete != null) {
            listProduct.remove(productToDelete);
            return productToDelete;
        }
        return null;
    }
}
