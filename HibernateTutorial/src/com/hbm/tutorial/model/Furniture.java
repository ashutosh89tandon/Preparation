package com.hbm.tutorial.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Furniture 
{
	@ManyToMany
	@JoinColumn(name="PERSON_ID")
	private Collection<Person> person=new ArrayList<Person>();
	
	public Collection<Person> getPerson() {
		return person;
	}
	public void setPerson(Collection<Person> person) {
		this.person = person;
	}
	public int getFurinitureId() {
		return furinitureId;
	}
	public void setFurinitureId(int furinitureId) {
		this.furinitureId = furinitureId;
	}
	public String getFurnitureName() {
		return furnitureName;
	}
	public void setFurnitureName(String furnitureName) {
		this.furnitureName = furnitureName;
	}
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int furinitureId;
	private String furnitureName;
	
	
}
