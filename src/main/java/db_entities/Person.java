package db_entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Person {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "NAME")
	private String name;

	// Many to many -> Person and Address
	@ManyToMany
	@JoinTable(name = "jnd_per_adr",
			joinColumns = @JoinColumn(name = "PERSON_FK"),
			inverseJoinColumns = @JoinColumn(name = "ADRESS_FK"))
	private List<Address> addresses = new ArrayList<Address>();
	
	
	// One to many -> Person and CreditCard
	@OneToMany
	@JoinTable(name = "JND_PERSON_CARD",
			joinColumns = @JoinColumn(name = "PERSON_FK"),
			inverseJoinColumns = @JoinColumn(name = "CARD_FK") )
	private List<CreditCard> creditCards = new ArrayList<CreditCard>();
	
	
	
	
	// Setters
	public void setName(String name) {	this.name = name; 	}
	
	
	public void addAddr(Address adr) {

		if (!addresses.contains(adr)) {
			addresses.add(adr);
		}
	}
	
	public void addCreditCard(CreditCard creditCard) {
		if (!creditCards.contains(creditCard)) {
			creditCards.add(creditCard);
		}
	}
	
	// Getters
	
	public String getName() {
		return name;
	}
	
	public List<Address> getAddresses() {
		return addresses;
	}
	
	public List<CreditCard> getCreditCards() {
		return creditCards;
	}
	
	
	
}
