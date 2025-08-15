package ecommerce.example.ecommerce.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@Entity
@Table(name = "orderdb_final")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String orderDate;
    private String status_delivered;
    private String status_shipped;
    private String status_received;
    private String orderId;
    private String title;
    private String price;
    @JsonProperty("delivery_charge")  
    private String deliveryCharge;
    private String name;
    private String mobile;
    private String location;
    private String city;
    private String pincode;
    private String product;
    private String status_orderd;
    private String step;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String address5;
    private String shipped_date;
    private String outdelivery_date;
    private String delivered_date;
    private String recieved_date;
    private String return_date;
    private String brand;
    private String size;
    private String imageUrl;
    private String address;
    private String payment;
    @JsonProperty("discount")
    private String discount;
    @JsonProperty("finalTotal")
    private String finalTotal;
    
    

    
    


    
    @ElementCollection
    @CollectionTable(
        name = "order_shipping_addresses",
        joinColumns = @JoinColumn(name = "order_id")
    )
    @Column(name = "address")
    private List<String> shippingAddresses;

   
    public List<String> getShippingAddresses() {
        return shippingAddresses;
    }

    public void setShippingAddresses(List<String> shippingAddresses) {
        this.shippingAddresses = shippingAddresses;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus_delivered() {
        return status_delivered;
    }

    public void setStatus_delivered(String status_delivered) {
        this.status_delivered = status_delivered;
    }

    public String getStatus_shipped() {
        return status_shipped;
    }

    public void setStatus_shipped(String status_shipped) {
        this.status_shipped = status_shipped;
    }

    public String getStatus_received() {
        return status_received;
    }

    public void setStatus_received(String status_received) {
        this.status_received = status_received;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(String deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getStatus_orderd() {
        return status_orderd;
    }

    public void setStatus_orderd(String status_orderd) {
        this.status_orderd = status_orderd;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getAddress4() {
		return address4;
	}

	public void setAddress4(String address4) {
		this.address4 = address4;
	}

	public String getAddress5() {
		return address5;
	}

	public void setAddress5(String address5) {
		this.address5 = address5;
	}

	public String getShipped_date() {
		return shipped_date;
	}

	public void setShipped_date(String shipped_date) {
		this.shipped_date = shipped_date;
	}

	public String getOutdelivery_date() {
		return outdelivery_date;
	}

	public void setOutdelivery_date(String outdelivery_date) {
		this.outdelivery_date = outdelivery_date;
	}

	public String getDelivered_date() {
		return delivered_date;
	}

	public void setDelivered_date(String delivered_date) {
		this.delivered_date = delivered_date;
	}

	public String getRecieved_date() {
		return recieved_date;
	}

	public void setRecieved_date(String recieved_date) {
		this.recieved_date = recieved_date;
	}

	public String getReturn_date() {
		return return_date;
	}

	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getFinalTotal() {
		return finalTotal;
	}

	public void setFinalTotal(String finalTotal) {
		this.finalTotal = finalTotal;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	
	
	
    
}
