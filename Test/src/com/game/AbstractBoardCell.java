package com.game;

import com.util.CellProcessor;

public abstract class AbstractBoardCell {
	protected String identifier;
	protected CellProcessor cellProcessor;
    
	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	} 
	
   
	abstract public void process(Player player) ;
	
}
