package no.hvl.dat250.jpa.basicexample;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import db_entities.*;

public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "todos";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // read the existing entries and write to console
        Query q = em.createQuery("select t from Todo t");
        List<Todo> todoList = q.getResultList();
        for (Todo todo : todoList) {
            System.out.println(todo);
        }
        System.out.println("Size: " + todoList.size());

        // create new todo
        em.getTransaction().begin();
        Todo todo = new Todo();
        todo.setSummary("This is a test");
        todo.setDescription("This is a test");
        em.persist(todo);
       
        
        Boolean addNewPerson = false;
        if (addNewPerson) {
        	EntityCreator eCreator = new EntityCreator();

	        Person person = eCreator.createPerson("Max Mustermann");
	        Address address = eCreator.createAddress("Inndalsveien", 28);
	        CreditCard creditCard = eCreator.creatCreditCard(12345, -5000, -10000);
	        Pincode pincode = eCreator.createPincode("123", 1);
	        Bank bank = eCreator.createBank("Pengebank");
	        eCreator.relationshipHandler(person, address, creditCard, pincode, bank);
	        
	        CreditCard creditCard2 = eCreator.creatCreditCard(123, 1, 2000);
	        creditCard2.setPincode(pincode);
	        creditCard2.setBank(bank);
	        bank.addCard(creditCard2);
	        person.addCreditCard(creditCard2);

	        
	        
	        em.persist(person);
	        em.persist(address);
	        em.persist(creditCard);
	        em.persist(creditCard2);
	        em.persist(pincode);
	        em.persist(bank);
        }   
        em.getTransaction().commit();
        em.close();
    }
}
