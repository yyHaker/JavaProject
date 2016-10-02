package com.yy.pattern.mediator;
import javax.swing.*;
import java.awt.Color;
import com.yy.pattern.gui.*;


/*======================================*/
/* This class acts as an mediator class */
/* in the mediator design pattern       */
/*======================================*/


public class BusinessMediator{

   private HotelGUI    hotelGui;
   private AirlineGUI  airlineGui;
   private TourGUI     tourGui;
   private TouriststoreGUI tourstoreGui;

   public void registerHotelGUI(HotelGUI hg){
      hotelGui = hg;
   }
   public void registerAirlineGUI(AirlineGUI ag){
      airlineGui = ag;
   }
   public void registerTourGUI(TourGUI tg){
      tourGui = tg;
   }
   public void registerTourstoreGUI(TouriststoreGUI tsg){
	   tourstoreGui=tsg;
   }


  public void addAllCandidateCus(String option, String text){
  	 if(option.compareTo(AirlineGUI.AIR)==0){
  	    hotelGui.addCandidateCustomer(text);
  	    tourGui.addCandidateCustomer(text);
  	    tourstoreGui.addCandidateCustomer(text);
     }
     else if(option.compareTo(HotelGUI.HOTEL)==0){
	    airlineGui.addCandidateCustomer(text);
	    tourGui.addCandidateCustomer(text);
	    tourstoreGui.addCandidateCustomer(text);
     }
     else if(option.compareTo(TourGUI.TOUR)==0){
	    hotelGui.addCandidateCustomer(text);
	    airlineGui.addCandidateCustomer(text);
	    tourstoreGui.addCandidateCustomer(text);
     }
     else if(option.compareTo(TouriststoreGUI.TOURISTSTORE)==0){
    	 airlineGui.addCandidateCustomer(text);
 	     tourGui.addCandidateCustomer(text);
 	     hotelGui.addCandidateCustomer(text);
     }
  }

  //update all other User interfaces
  public void updateALlGuis(String option, String text){
	 if(option.compareTo(AirlineGUI.AIR)==0){
	     hotelGui.displayInfoToScreen(text);
	     tourGui.displayInfoToScreen(text);
	     tourstoreGui.displayInfoToScreen(text);
      }
      else if(option.compareTo(HotelGUI.HOTEL)==0){
	  	 airlineGui.displayInfoToScreen(text);
	  	 tourGui.displayInfoToScreen(text);
	  	 tourstoreGui.displayInfoToScreen(text);
      }
      else if(option.compareTo(TourGUI.TOUR)==0){
	  	 hotelGui.displayInfoToScreen(text);
	  	 airlineGui.displayInfoToScreen(text);
	  	 tourstoreGui.displayInfoToScreen(text);
      }
      else if(option.compareTo(TouriststoreGUI.TOURISTSTORE)==0){
    	   hotelGui.displayInfoToScreen(text);
  	       tourGui.displayInfoToScreen(text);
  	       airlineGui.displayInfoToScreen(text);
      }
  }
}