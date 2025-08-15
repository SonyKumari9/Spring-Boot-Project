package ecommerce.example.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="personalecommerce")
public class PersonalEcModel {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String fullName;
	private String email;
	private String mobile;
	private String city;
	private String state;
	private String pincode;
	private String votercard_no;
	@Lob
    @Column(length = 500000)
    private String profile;

    @Lob
    @Column(length = 500000)
    private String signature;
	private String country;
	private String profiledesc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getVotercard_no() {
		return votercard_no;
	}
	public void setVotercard_no(String votercard_no) {
		this.votercard_no = votercard_no;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProfiledesc() {
		return profiledesc;
	}
	public void setProfiledesc(String profiledesc) {
		this.profiledesc = profiledesc;
	}
	
	
	
	

}
