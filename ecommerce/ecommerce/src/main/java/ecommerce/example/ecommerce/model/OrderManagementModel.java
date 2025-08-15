package ecommerce.example.ecommerce.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders_management")
public class OrderManagementModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customer;
    private String mobile;
    private String address;
    private String payment;
    private Double deliveryCharge;
    private Double discount;
    private Double finalTotal;
    private Double total;
    private String status; // Pending, Shipped, Cancelled
    private LocalDate date;
    private String vendor; // optional: for multivendor support

    @ElementCollection
    @CollectionTable(name = "order_products_management", joinColumns = @JoinColumn(name = "order_id"))
    private List<OrderedProductModel> products;

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomer() { return customer; }
    public void setCustomer(String customer) { this.customer = customer; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPayment() { return payment; }
    public void setPayment(String payment) { this.payment = payment; }

    public Double getDeliveryCharge() { return deliveryCharge; }
    public void setDeliveryCharge(Double deliveryCharge) { this.deliveryCharge = deliveryCharge; }

    public Double getDiscount() { return discount; }
    public void setDiscount(Double discount) { this.discount = discount; }

    public Double getFinalTotal() { return finalTotal; }
    public void setFinalTotal(Double finalTotal) { this.finalTotal = finalTotal; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public List<OrderedProductModel> getProducts() { return products; }
    public void setProducts(List<OrderedProductModel> products) { this.products = products; }

    public String getVendor() { return vendor; }
    public void setVendor(String vendor) { this.vendor = vendor; }
}
