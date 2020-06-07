import java.util.Scanner;

public class Date {   //Assuming all Months are 30 Days
	int Day,Month,Year;
	
	Date(int givenDay,int givenMonth,int givenYear){
		this.Day=givenDay;
		this.Month=givenMonth;
		this.Year=givenYear;
}
	Date(){}//empty constructor
	
	public  void printDate() {
		System.out.println(this.Day+"/"+this.Month+"/"+this.Year);
		
	}	
	
	
	public  Date dateAfterDays( int duration) {
		
		 this.Day+=duration;
	      while(this.Day>30){
	    	  this.Day-=30;
	    	  this.Month++;
	             if(this.Month>12){
	            	 this.Month=1;
	            	 this.Year++;
		
         	}
         }
	      return this;
	 }
  }
