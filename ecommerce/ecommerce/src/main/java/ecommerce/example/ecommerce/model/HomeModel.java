package ecommerce.example.ecommerce.model;

import javax.persistence.*;

@Entity
@Table(name = "home_db")
public class HomeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Product Details
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "brand")
    private String brand;

    @Column(name = "gender")
    private String gender;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "price")
    private double price;

    @Column(name = "discount")
    private double discount;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "available")
    private boolean available;

    @Column(name = "seller")
    private String seller;

    @Column(name = "color")
    private String color;

    @Column(name = "size")
    private String size;

    // ✅ New Fields
    @Column(name = "model_name")
    private String modelName;

    @Column(name = "idea_for")
    private String ideaFor;

    @Column(name = "application_area")
    private String applicationArea;

    @Column(name = "applied_for")
    private String appliedFor;

    @Column(name = "composition")
    private String composition;

    @Column(name = "ideal_usage")
    private String idealUsage;

    @Column(name = "shelf_life")
    private String shelfLife;

    @Column(name = "container_type")
    private String containerType;

    @Column(name = "net_quantity")
    private String netQuantity;

    @Column(name = "instruction")
    private String instruction;

    public HomeModel() {}

    
    
    

    
    

    public String getModelName() { return modelName; }
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setModelName(String modelName) { this.modelName = modelName; }

    public String getIdeaFor() { return ideaFor; }
    public void setIdeaFor(String ideaFor) { this.ideaFor = ideaFor; }

    public String getApplicationArea() { return applicationArea; }
    public void setApplicationArea(String applicationArea) { this.applicationArea = applicationArea; }

    public String getAppliedFor() { return appliedFor; }
    public void setAppliedFor(String appliedFor) { this.appliedFor = appliedFor; }

    public String getComposition() { return composition; }
    public void setComposition(String composition) { this.composition = composition; }

    public String getIdealUsage() { return idealUsage; }
    public void setIdealUsage(String idealUsage) { this.idealUsage = idealUsage; }

    public String getShelfLife() { return shelfLife; }
    public void setShelfLife(String shelfLife) { this.shelfLife = shelfLife; }

    public String getContainerType() { return containerType; }
    public void setContainerType(String containerType) { this.containerType = containerType; }

    public String getNetQuantity() { return netQuantity; }
    public void setNetQuantity(String netQuantity) { this.netQuantity = netQuantity; }

    public String getInstruction() { return instruction; }
    public void setInstruction(String instruction) { this.instruction = instruction; }
}
