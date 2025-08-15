package ecommerce.example.ecommerce.model;

public class ProductAdminModel {

    private HomeModel home;
    private CategoryModel category;

    public ProductAdminModel() {}

    public ProductAdminModel(HomeModel home, CategoryModel category) {
        this.home = home;
        this.category = category;
    }

    public HomeModel getHome() {
        return home;
    }

    public void setHome(HomeModel home) {
        this.home = home;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }
}
