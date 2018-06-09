package com.hbm.tutorial.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.hbm.tutorial.model.inheritence.Card;
import com.hbm.tutorial.model.inheritence.House;

@Entity 
public class Person 
{
	
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		
	}
	
	public Person() {
		super();
	}

	@OneToOne
	@JoinColumn (name="VEHICLE_ID")
	private Vehicle vehicle;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="PERSON_CAR" , joinColumns=@JoinColumn(name="PERSON_ID"), 
		inverseJoinColumns=@JoinColumn(name="CAR_ID"))
	private Collection<Car> carList=new ArrayList<Car>();
	
	@OneToMany
	@JoinTable(name="PERSON_CARD" , joinColumns=@JoinColumn(name="PERSON_ID"), 
		inverseJoinColumns=@JoinColumn(name="CARD_ID"))
	private Collection<Card> cardList=new ArrayList<Card>();
	
	@OneToMany
	@JoinTable(name="PERSON_HOUSE" , joinColumns=@JoinColumn(name="PERSON_ID"), 
		inverseJoinColumns=@JoinColumn(name="HOUSE_ID"))
	private Collection<House> houseList=new ArrayList<House>();
	
	
	public Collection<House> getHouseList() {
		return houseList;
	}

	public void setHouseList(Collection<House> houseList) {
		this.houseList = houseList;
	}

	public Collection<Card> getCardList() {
		return cardList;
	}

	public void setCardList(Collection<Card> cardList) {
		this.cardList = cardList;
	}

	@OneToMany(mappedBy="person")
	private Collection<Fruit> fruitList=new ArrayList<Fruit>();
	
	@ManyToMany(mappedBy="person")
	private Collection<Furniture> furnitureList =new ArrayList<Furniture>();

	
	
	public Collection<Furniture> getFurnitureList() {
		return furnitureList;
	}

	public void setFurnitureList(Collection<Furniture> furnitureList) {
		this.furnitureList = furnitureList;
	}

	public Collection<Car> getCarList() {
		return carList;
	}

	public void setCarList(Collection<Car> carList) {
		this.carList = carList;
	}

	public Collection<Fruit> getFruitList() {
		return fruitList;
	}

	public void setFruitList(Collection<Fruit> fruitList) {
		this.fruitList = fruitList;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String name;
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
