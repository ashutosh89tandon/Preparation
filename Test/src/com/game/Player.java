package com.game;

public class Player {
	private Long totalAmount ; 
	private static Long id ;
	private String name ; 
	private int cellKey ; 
	private boolean isValidPlayer ; 
	
	static {
		id = 0L;
	}
	public Player() {
		totalAmount = 1000L ; 
		cellKey = 0 ;
		id++ ;
		name = "player_"+id;
		isValidPlayer = true ; 
	}

	public static Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	

	public Long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getCellKey() {
		return cellKey;
	}

	public void setCellKey(int cellKey) {
		this.cellKey = cellKey;
	}

	public boolean isValidPlayer() {
		return isValidPlayer;
	}

	public void setValidPlayer(boolean isValidPlayer) {
		this.isValidPlayer = isValidPlayer;
	}

	@Override
	public String toString() {
		return "Player [totalAmount=" + totalAmount + ", name=" + name + ", cellKey=" + cellKey + "]";
	}

	
	


	
	
}
