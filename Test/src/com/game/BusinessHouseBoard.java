package com.game;

import java.util.HashMap;
import java.util.Map;

public class BusinessHouseBoard {
	
  private Map<Integer,AbstractBoardCell> cellMap ;
  

@SuppressWarnings("serial")
public BusinessHouseBoard(){
	  
	  cellMap = new HashMap<Integer,AbstractBoardCell>(){{
		  put(1,new JailCell());
		  put(2,new HotelCell());
		  put(3,new LotteryCell());
		  put(4,new HotelCell());
		  put(5,new EmptyCell());
		  put(6,new LotteryCell());
		  put(7,new HotelCell());
		  put(8,new LotteryCell());
		  put(9,new HotelCell());
		  put(10,new JailCell());
	  }};
  }

public Map<Integer, AbstractBoardCell> getCellMap() {
	return cellMap;
}

public void setCellMap(Map<Integer, AbstractBoardCell> cellMap) {
	this.cellMap = cellMap;
}
}
