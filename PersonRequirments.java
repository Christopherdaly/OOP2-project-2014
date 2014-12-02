//PersonRequirments.java
public class PersonRequirments{
	private String sName;
	private String fName;
	private String cardNum;
	private int mobileNum;
	private int numOfDays;
	private int totalPrice;
//	private int totalPrice;
	public Vehicle rented;	
	
//no-args Constructor
public PersonRequirments(){
	sName = "Unknown";
	fName = "Unknown";
	cardNum = "Unknown";
	mobileNum = 0;
	numOfDays = 0;
	totalPrice = 0;
	rented = new Vehicle();
}//end no-args constructor

//full-args constructor
public PersonRequirments (String sName, String fName, String cardNum, int mobileNum, String make, String model, int litreEngine, int price, int numOfDays){
	this.sName = sName;
	this.fName = fName;
	this.cardNum = cardNum;
	this.mobileNum = mobileNum;
	this.numOfDays = numOfDays;
	this.totalPrice = totalPrice;
	rented = new Vehicle(make, model, litreEngine, price);
	//tPrice = new Vehicle(totalPrice);
}//end full-args constructor


//Mutator Methods
public void setSName(String sName){
		this.sName = sName;
	}
	public void setFName(String fName){
		this.fName = fName;
	}
	public void setCardNum(String cardNum){
		this.cardNum = cardNum;
	}
	public void setMobileNum(int mobileNum){
		this.mobileNum = mobileNum;
	}
	public void setNumOfDays(int numOfDays){
		this.numOfDays = numOfDays;
	}
	public void setTotalPrice(int totalPrice){
		totalPrice = numOfDays * rented.getPrice();
		this.totalPrice = totalPrice;		
	}
	
	public double getTotalPrice(){
		return totalPrice = numOfDays * rented.getPrice();
	}
	
	
	public void setRented(String make, String model, int litreEngine, int price){
  		rented.setMake(make);
  		rented.setModel(model);
  		rented.setLitreEngine(litreEngine);
  		rented.setPrice(price);
  	}//End Mutator-Methods


public void setRented(Vehicle v){
  		rented=v;
  	}//End Mutator-Methods


	//Accessor-Methods
	public String getSName(){
		return sName;
	}
	public String getFName(){
		return fName;
	}
	public String getCardNum(){
			return cardNum;
	}
	public int getMobileNum(){
		return mobileNum;
	}
	public int getNumOfDays(){
		return numOfDays;
	}
	//public int getTotalPrice(){
	//	return totalPrice;
//	}
	public Vehicle getRented(){
	    return rented;
	}//End Accessor-Methods

	//toString Method
	public String toString(){

				String message = String.format("Number of days you want the car for: %d \nTotal Price %.2f \nSurname: %s \nForename: %s \nCredit Card Number: %s \nMobile Number: %d \nCurrently Renting: %s "
								,numOfDays,getTotalPrice(), sName, fName, cardNum, mobileNum, rented.toString());
		return message;
		
		 /*public String toString() {
	     return "\nSurname: " + sName + 
	            "\nForename: " + fName +
	            "\nCard Number: " + cardNum +
	            "\nMobile Number: " + mobileNum +
	            "\nCurrently rented by: " + rented.toString();*/
	}

}