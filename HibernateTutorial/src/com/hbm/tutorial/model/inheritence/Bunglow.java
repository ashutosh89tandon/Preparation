package com.hbm.tutorial.model.inheritence;

import javax.persistence.Entity;

@Entity
public class Bunglow extends House {

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
