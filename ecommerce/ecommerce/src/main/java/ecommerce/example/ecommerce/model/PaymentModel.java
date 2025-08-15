package ecommerce.example.ecommerce.model;
import javax.persistence.*;

@Entity
@Table(name = "payment_details_db")
public class PaymentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private String name;    
    private String mobile;
    private String mode;          
    private double amount;        
    private String details;       
    private String brand;         
    private int price;           
    private String imageUrl;      

    public PaymentModel() {
    }

    public PaymentModel(String name, String mobile, String mode, double amount, String details, String brand, int price, String imageUrl) {
        this.name = name;
        this.mobile = mobile;
        this.mode = mode;
        this.amount = amount;
        this.details = details;
        this.brand = brand;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
	public String toString() {
		return "PaymentModel [paymentId=" + paymentId + ", name=" + name + ", mobile=" + mobile + ", mode=" + mode
				+ ", amount=" + amount + ", details=" + details + ", brand=" + brand + ", price=" + price
				+ ", imageUrl=" + imageUrl + "]";
	}

}
