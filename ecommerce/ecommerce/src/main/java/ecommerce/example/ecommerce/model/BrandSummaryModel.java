package ecommerce.example.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Brand_filterdb")
public class BrandSummaryModel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String category;
	private String name;
	private String topbrandname;
	private String brandname;
	private  String letestbrandname;
	private String size;
	private String price;
	private String gender;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTopbrandname() {
		return topbrandname;
	}
	public void setTopbrandname(String topbrandname) {
		this.topbrandname = topbrandname;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public String getLetestbrandname() {
		return letestbrandname;
	}
	public void setLetestbrandname(String letestbrandname) {
		this.letestbrandname = letestbrandname;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
