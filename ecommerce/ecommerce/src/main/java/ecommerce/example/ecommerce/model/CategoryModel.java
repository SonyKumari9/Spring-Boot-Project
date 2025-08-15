package ecommerce.example.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="categoy_db")
public class CategoryModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int categoryId;
	private String categoryTitle;
	private String categoryDescription;
	private String imageUrl;
	private String url;
	private String brand;
	private int price;
	private String author;
	
	
	
	
	
	@OneToMany(mappedBy = "category")
	private List<ProductModel> product = new ArrayList<>();
	
	public CategoryModel()
	{
		
	}
	
	public CategoryModel(int categoryId, String categoryTitle, String categoryDescription, String imageUrl, String url, String brand, int price, String author) {
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.categoryDescription = categoryDescription;
		this.imageUrl = imageUrl;
		this.url = url;
		this.brand = brand;
		this.price = price;
		this.author = author;
	}

	public CategoryModel(String categoryTitle, String categoryDescription,String imageUrl,String url,String brand,int price,String author,  List<ProductModel> products) {
		this.categoryTitle = categoryTitle;
		this.categoryDescription = categoryDescription;
		this.imageUrl = imageUrl;
		this.url = url;
		this.brand = brand;
		this.price = price;
		this.author = author;
		this.product = products;
		
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
	
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<ProductModel> getProduct() {
		return product;
	}

	public void setProduct(List<ProductModel> product) {
		this.product = product;
	}
	
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
	
	

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "CategoryModel [categoryId=" + categoryId + ", categoryTitle=" + categoryTitle + ", categoryDescription="
				+ categoryDescription + ", imageUrl=" + imageUrl + ", url=" + url + ", brand=" + brand + ", price="
				+ price + ", author=" + author + ", product=" + product + "]";
	}

	
	
	
	
	
	

	

	
	
	
	
	
	
	
	
	
	
	

}
