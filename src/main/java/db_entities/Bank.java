package db_entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity(name = "BANK")
public class Bank {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "NAMAE")
	private String name;
	
	// One to many -> Bank and CreditCard
	@OneToMany
	@JoinTable(name = "JND_BANK_CARD",
			joinColumns = @JoinColumn(name = "BANK_FK"),
			inverseJoinColumns = @JoinColumn(name = "CARD_FK") )
	private List<CreditCard> creditCards = new ArrayList<CreditCard>();
		
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addCard(CreditCard creditcard) {
		if (!creditCards.contains(creditcard)) {
			creditCards.add(creditcard);
		}
	}
	
	public String getName() {
		return name;
	}
	
	public List<CreditCard> getCards() {
		return creditCards;
	}
}