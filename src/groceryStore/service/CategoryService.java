package groceryStore.service;


import groceryStore.model.Category;
import java.util.List;


interface CategoryServiceInterface {
    Boolean handleCategory(List<Category> listCategory);
    Category createCategory(List<Category> listCategory, String id, String name, Integer quantity);
    Category findCategoryById(List<Category> listCategory, String categoryId);
    Category updateCategory(List<Category> listCategory, String categoryId , String name, Integer quantity);
    Category deleteCategory(List<Category> listCategory, String categoryId);
}

public class CategoryService implements CategoryServiceInterface {
    static Common common = new Common();
    public Boolean handleCategory(List<Category> listCategory){
        while (true) {
            String prefix_category = "CAT";
            char digit1 = common.generateRandomDigit();
            char UpperLetter = common.generateRandomUppercaseLetter();
            char digit2 = common.generateRandomDigit();
            String id_category = prefix_category + digit1 + UpperLetter + digit2;
            System.out.println("-----------------------------------------------------");
            System.out.println("Category");
            System.out.println("1.Create  2.Update  3.Delete  4.View  5.Out");
            System.out.println("Enter your choice category: ");
            String choiceCategory =  common.scanner.next();
            if (choiceCategory.equals("1")) {
                System.out.println("Create category");
                System.out.println("Enter name category: ");
                String nameCategory =  common.scanner.next();
                System.out.println("Enter quantity category: ");
                Integer quantityCategory =  common.checkInterger();
                Category create = createCategory(listCategory, id_category, nameCategory, quantityCategory);
                if (create != null){
                    System.out.println("Create done!!!");
                    continue;
                }
            }
            if (choiceCategory.equals("2")) {
                System.out.println("Update category");
                System.out.println("Enter category Id to update: ");
                String categoryIdToUpdate = common.scanner.next();
                Category categoryToUpdate = findCategoryById(listCategory, categoryIdToUpdate);
                if (categoryToUpdate != null) {
                    System.out.println("Enter name category update: ");
                    String nameCategory =  common.scanner.next();
                    System.out.println("Enter quantity category update: ");
                    Integer quantityCategory =  common.checkInterger();
                    Category update = updateCategory(listCategory, categoryIdToUpdate, nameCategory, quantityCategory);
                    if (update != null){
                        System.out.println("Update done!!!");
                        continue;
                    }
                }
                System.out.println("Category Id not found!");
                continue;
            }
            if (choiceCategory.equals("3")) {
                System.out.println("Delete category");
                System.out.println("Enter category Id to delete: ");
                String categoryIdToDelete = common.scanner.next();
                Category categoryToDelete = findCategoryById(listCategory, categoryIdToDelete);
                if (categoryToDelete != null) {
                    Category delete = deleteCategory(listCategory, categoryIdToDelete);
                    if (delete != null){
                        System.out.println("Delete done!!!");
                        continue;
                    }
                }
                System.out.println("Category Id not found!");
                continue;
            }
            if (choiceCategory.equals("4")) {
                System.out.println("View category");
                System.out.println(listCategory);
                continue;
            }
            if (choiceCategory.equals("5")) {
                break;
            }
        }
        return true;
    }
    public Category createCategory(List<Category> listCategory, String id, String name, Integer quantity) {
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        category.setQuantity(quantity);
        listCategory.add(category);
        return category;
    }
    public Category findCategoryById(List<Category> listCategory, String categoryId) {
        for (Category category : listCategory) {
            if (category.getId().equals(categoryId)) {
                return category;
            }
        }
        return null;
    }
    public Category updateCategory(List<Category> listCategory, String categoryId , String name, Integer quantity) {
        Category categoryToUpdate = findCategoryById(listCategory, categoryId);
        if (categoryToUpdate != null) {
            categoryToUpdate.setName(name);
            categoryToUpdate.setQuantity(quantity);
            return categoryToUpdate;
        }
        return null;
    }
    public Category deleteCategory(List<Category> listCategory, String categoryId) {
        Category categoryToDelete = findCategoryById(listCategory, categoryId);
        if (categoryToDelete != null) {
            listCategory.remove(categoryToDelete);
            return categoryToDelete;
        }
        return null;
    }
}
