package com.game;

public enum HotelTypeEnum {
  SILVER(200,50,"SILVER"),
  GOLD(300,150,"GOLD"),
  PLATINUM(500,300,"PLATINUM"),
  NONE(0,0,"NONE");
  
  int value ;
  int rent ;
  String typeName;
  
  private HotelTypeEnum( int value ,  int rent, String typeName) {
	  this.value = value ;
	  this.rent = rent ; 
	  this.typeName = typeName ; 
  }
  
  
  public static HotelTypeEnum nextUpgradeHotelType(HotelTypeEnum hotelType) {
	  
	  HotelTypeEnum upgradeHotelType = null ; 
	  
	  switch(hotelType) {
	    
	  case SILVER : upgradeHotelType = HotelTypeEnum.GOLD;
	                break ;
	   
	  case GOLD :   upgradeHotelType = HotelTypeEnum.PLATINUM;
	                break;
	                
	  case PLATINUM : upgradeHotelType = HotelTypeEnum.NONE ;
	                  break;
	    
	   default : upgradeHotelType = HotelTypeEnum.NONE ;
	  
	  }
	  
	  return upgradeHotelType  ;
	  
  }
  
  public static int getValue(HotelTypeEnum hotelType) {
	  
	  int value  = 0 ;
	  
	  for(HotelTypeEnum ht : HotelTypeEnum.values()) {
		  if(ht.equals(hotelType)) {
			  value = ht.value ;
			  break;
		  }
	  }
	  
	  return value ;
	  
  }
  
  public static int getRent(HotelTypeEnum hotelType) {
	  
	  int rent  = -1 ;
	  
	  for(HotelTypeEnum ht : HotelTypeEnum.values()) {
		  if(ht.equals(hotelType)) {
			  rent = ht.rent ;
			  break;
		  }
	  }
	  
	  return rent ;
	  
  }
  
  
}
