//Vehicle.java
import java.io.*;
public class Vehicle implements Serializable {
	private String make;
	private String model;
	private double litreEngine;
	public int price;
	
	//Accessor methods
	public String getMake() { 
		return make;
	}
	public String getModel() { 
		return model;
	}
	public double getLitreEngine() { 
		return litreEngine;
	}
	public int getPrice() { 
		return price;
	}//End Accessor Methods

	
	//Mutator methods
	public void setMake(String make) {
			this.make = make;
	}	
	public void setModel(String model) {
			this.model = model;
	}
	public void setLitreEngine (double litreEngine) {
			this.litreEngine = litreEngine;
	}
	
	public void setPrice (int price) {
			this.price = price;
	}//End Mutator Methods
	
	/** full-args constructor, to create a Vehicle where everything is known
	 */
	public Vehicle(String make,String model, double litreEngine, int price) {
				setMake(make);
				setModel(model);
				setLitreEngine(litreEngine);
				setPrice(price);
	}//End full-args Constructor
	
	/** no-args constructor to create a default Vehicle
	 */
	public Vehicle() {
				this("Not Given","Not Given",0.0,0);
	}//End No-Args constructor
	
		
	/**String which returns all of the values of all of Vehicle's attributes
	 */
	public String toString() {
				return getMake() + " " + getModel() + "\n" +getLitreEngine() + " Litre " +  "€" + getPrice() + " per Day";
	}//End String

}