package db_entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pincode {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "PINCODE")
	private String pincode;
	
	@Column(name = "COUNT")
	private Integer count;
	

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	public void setCount(Integer count) {
		this.count = count;
	}
	
	public String getPincode() {
		return pincode;
	}
	
	public Integer getCount() {
		return count;
	}
}