package no.hvl.dat250.jpa.basicexample;

import db_entities.*;

public final class EntityCreator {
	
	
	public Person createPerson(String name) {
		Person person = new Person();
		person.setName(name);
		return person;
	}
	
	
	public Address createAddress(String street, Integer number) {
		Address address = new Address();
		address.setStreet(street);
		address.setNumber(number);
		return address;
	}
	
	public CreditCard creatCreditCard(Integer number, Integer limit, Integer balance) {
		CreditCard creditCard = new CreditCard();
		creditCard.setNumber(number);
		creditCard.setLimit(limit);
		creditCard.setBalance(balance);
		return creditCard;
	}
	
	public Pincode createPincode(String code, Integer count) {
		Pincode pincode = new Pincode();
		pincode.setPincode(code);
		pincode.setCount(count);
		return pincode;
	}
	
	public Bank createBank(String name) {
		Bank bank = new Bank();
		bank.setName(name);
		return bank;
	}
	
	public void relationshipHandler(Person person, Address address, CreditCard creditCard, Pincode pincode, Bank bank) {
		// This function is incomplete
		
		
		// Many to many -> Person and Address
		person.addAddr(address);
		address.addPerson(person);
		
		// One to many -> Person and CreditCard
		person.addCreditCard(creditCard);
		
		
		creditCard.setPincode(pincode);
		creditCard.setBank(bank);
		
		// One to many -> Bank and CreditCard
		creditCard.getBank().addCard(creditCard);
	}
}
