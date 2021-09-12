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
import javax.persistence.ManyToMany;

@Entity(name = "ADDRESS")
public class Address {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "STREET")
	private String street;
	
	@Column(name = "NUMBER")
	private Integer number;
	

	// Many to many -> Address and Person
	@ManyToMany
	@JoinTable(name = "jnd_adr_per",
			joinColumns = @JoinColumn(name = "ADDRESS_FK"),
			inverseJoinColumns = @JoinColumn(name = "PERSON_FK"))
	private List<Person> peoples = new ArrayList<Person>();
	
	// Setters
	public void setStreet(String street) {
		this.street = street;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public void addPerson(Person person) {
		
		if (!peoples.contains(person)) {
			peoples.add(person);
		}
	}
	
	
	// Getters
	public String getStreet() {
		return street;
	}
	
	
	public Integer getNumber() {
		return number;
	}
	
	public List<Person> getPeoples() {
		return peoples;
	}
	
}
