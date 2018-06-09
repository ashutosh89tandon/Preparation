package com.hbm.tutorial.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hbm.tutorial.model.Car;
import com.hbm.tutorial.model.Fruit;
import com.hbm.tutorial.model.Furniture;
import com.hbm.tutorial.model.Person;
import com.hbm.tutorial.model.Vehicle;
import com.hbm.tutorial.model.inheritence.AadharCard;
import com.hbm.tutorial.model.inheritence.Bunglow;
import com.hbm.tutorial.model.inheritence.Card;
import com.hbm.tutorial.model.inheritence.House;
import com.hbm.tutorial.model.inheritence.PanCard;

public class SecondExample 
{
	public static void main(String args[])
	{
		Fruit fruit=new Fruit();
		fruit.setFruitName("Apple");
		Furniture furniture=new Furniture();
		furniture.setFurnitureName("Chair");
		
		Car car=new Car();
		car.setCarName("Suzuki");
		
		Card card=new Card();
		card.setCardName("Card");
		
		PanCard panCard=new PanCard();
		panCard.setCardName("PanCard");
		panCard.setAccNumber("ACC_NUMBER");
		
		AadharCard acard=new AadharCard();
		acard.setCardName("AadharCard");
		acard.setSsnNumber("SSN");
		
		House house=new House();
		house.setHouseName("House");
		
		Bunglow bunglow=new Bunglow();
		bunglow.setHouseName("Bunglow");
		bunglow.setDescription("A bunglow");
		
		Person user = new Person();
		user.setName("Ashutosh");
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Bajaj");
		user.setVehicle(vehicle);
		user.getCarList().add(car);
		user.getFruitList().add(fruit);
		car.setPerson(user);
		fruit.setPerson(user);
		user.getFurnitureList().add(furniture);
		furniture.getPerson().add(user);
		user.getCardList().add(card);
		user.getCardList().add(panCard);
		user.getCardList().add(acard);
		user.getHouseList().add(bunglow);
		user.getHouseList().add(house);
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		session.persist(user);
		session.save(vehicle);
		session.save(card);
		session.save(panCard);
		session.save(acard);
		session.save(house);
		session.save(bunglow);
		//session.save(car);
		session.save(fruit);
		session.save(furniture);
		session.getTransaction().commit();
		
		session.close();
		
		sessionFactory.close();
		
		
	}
}
