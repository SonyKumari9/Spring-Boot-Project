package ecommerce.example.ecommerce.model;

public class HomeDashboardOrderDTO {
    private String product;
    private double amount;
    private String status;
    private String date; // ✅ NEW

    // Constructor for orders (no date)
    public HomeDashboardOrderDTO(String product, double amount, String status) {
        this.product = product;
        this.amount = amount;
        this.status = status;
    }

    // ✅ Constructor for deliveries (with date)
    public HomeDashboardOrderDTO(String product, double amount, String status, String date) {
        this.product = product;
        this.amount = amount;
        this.status = status;
        this.date = date;
    }

    public String getProduct() {
        return product;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }
}
