//package groceryStore.service;
//
//
//import groceryStore.model.Category;
//
//interface CategoryServiceInterface {
//    Category createCategory(String id, String name, String quality);
//    Category updateCategory(String id, String name, String quality);
//    Category deleteCategory(String id, String name, String quality);
//    Category viewCategory();
//}
//
//public class CategoryService implements CategoryServiceInterface {
//    @Override
//    public Category createCategory(String id, String name, String quality) {
//        Category category = new Category();
//        category.setId(id);
//        category.setName(name);
//        category.setQuality(quality);
//    }
//    public Category updateCategory(String id, String name, String quality) {
//        Category category = new Category();
//        category.setId(id);
//        category.setName(name);
//        category.setQuality(quality);
//    }
//    public Category deleteCategory(String id, String name, String quality) {
//        return "Category created successfully!";
//    }
//    public Category viewCategory() {
//        return "Category created successfully!";
//    }
//}
