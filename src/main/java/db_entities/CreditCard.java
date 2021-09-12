package db_entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CreditCard {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "NUMBER")
	private Integer number;
	
	@Column(name = "LIMIT")
	private Integer limit;
	
	@Column(name = "BALANCE")
	private Integer balance;
	
	private Pincode pincode; 
	
	private Bank bank; 
	

		
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	public void setPincode(Pincode pincode) {
		this.pincode = pincode;
	}
	
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	
	public void setLimit (Integer limit) {
		this.limit = limit;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}

		
	public Bank getBank() {
		return bank;
	}
	
	public Pincode getPincode() {
		return pincode;
	}
	
	public Integer getBalance() {
		return balance;
	}
	
	public Integer getLimit() {
		return limit;
	}
	
	public Integer getNumber() {
		return number;
	}
	
	
}