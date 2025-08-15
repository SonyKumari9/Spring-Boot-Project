package ecommerce.example.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="login")
public class LoginModel implements Serializable{
	
		
	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)		
		private int id;
		private String name;
		private String email;
		private String password;
		private String mobile;
		private String address;
//		@Column(name = "image_url")
//		private String imageUrl;
		
		@Column(name = "image_url", columnDefinition = "TEXT")
		private String imageUrl;


		private String memberSince;
		
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
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
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getImageUrl() {
			return imageUrl;
		}
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		public String getMemberSince() {
			return memberSince;
		}
		public void setMemberSince(String memberSince) {
			this.memberSince = memberSince;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		
		
		

}
