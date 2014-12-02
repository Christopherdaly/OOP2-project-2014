//CarRentalDriver.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CarRentalDriver extends JFrame implements ActionListener {

	private JMenuBar menuBar;
	String operation;
	PersonRequirments newPerson = new PersonRequirments();
	Vehicle vehicle = new Vehicle();
	
	//Main
	public static void main (String args [])
	{	
		CarRentalDriver menu = new CarRentalDriver ();
		menu.setVisible(true);
	}//End Main
	
	public CarRentalDriver(){

		setTitle("Car Rental System");
		setSize(400, 400);
		setLocation(600,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//JMenuBar
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//Call NewRentalMenu + CurrentRentalMenu
		createNewRentalMenu();
		createCurrentRentalMenu();		
	}
	
	public void createNewRentalMenu(){
		
		//JMenu  - New Rental
		JMenu newRentalMenu = new JMenu("New Rental");
		menuBar.add(newRentalMenu);
		
		//JMenuItem - Cars
		JMenuItem carsItem = new JMenuItem("Book car Rental");
		newRentalMenu.add(carsItem);
		carsItem.addActionListener(this);
		
		//JMenuItem - Exit
		JMenuItem exitItem = new JMenuItem("Exit");
		newRentalMenu.add(exitItem);
		exitItem.addActionListener(this);
	}
	
	public void createCurrentRentalMenu(){
		
		//JMenu  - Current Rental
		JMenu currentRentalMenu = new JMenu("Currently Rented");
		menuBar.add(currentRentalMenu);
					
		//JMenuItem - View all Customers
		JMenuItem viewAllCustomerItem = new JMenuItem("View All Customers");
		currentRentalMenu.add(viewAllCustomerItem);
		
		//JMenuItem - Find Customer
		JMenuItem findCustomerItem = new JMenuItem("Find Customer");
		currentRentalMenu.add(findCustomerItem);
		findCustomerItem.addActionListener(this);
		
		//JMenuItem - Exit
		JMenuItem exitItem = new JMenuItem("Exit");
		currentRentalMenu.add(exitItem);
		exitItem.addActionListener(this);

	}
	
	public void actionPerformed(ActionEvent e){
		
		//To Exit Program
		if (e.getActionCommand().equals("Exit"))
			{
				JOptionPane.showMessageDialog(null,"Thanks for using this System... Goodbye!");
				System.exit(0);
			}
			
		//To Book Rental	
		else if (e.getActionCommand().equals("Book car Rental"))
			{	
				
						Vehicle v1,v2,v3,v4;
						LinkedList<Vehicle> fleet;
	
						fleet = new LinkedList();
	
						v1 = new Vehicle("Ford","Fiesta", 1.4, 60);
						fleet.add(v1);
						
						v2 = new Vehicle("Toyota","Auris", 1.2, 50);
						fleet.add(v2);
				
						v3 = new Vehicle("Lamborghini","Murcielago", 6.2, 500);
						fleet.add(v3);
						
						v4 = new Vehicle("Audi","A5", 3.0, 90);
						fleet.add(v4);
				
						
				operation = JOptionPane.showInputDialog("Please select a car A, B, C, or D:\n\n" 
													+ v1.toString()+ "\n\n" 
													+ v2.toString() + "\n\n" 
													+ v3.toString() + "\n\n"
													+ v4.toString());
																					
				switch(operation) {
					
					//If Make + Model 1 selected:
					case "a":
						JOptionPane.showMessageDialog(null, "You Have Selected a " + v1.getMake() + " " + v1.getModel(), "Congratulations", JOptionPane.PLAIN_MESSAGE);
					break;
				
					//If Make + Model selected:
					case "b":
						JOptionPane.showMessageDialog(null, "You Have Selected a " + v2.getMake() + " " + v2.getModel(), "Congratulations", JOptionPane.PLAIN_MESSAGE);
					break;
				
					//If Make + Model selected:
					case "c":
						JOptionPane.showMessageDialog(null, "You Have Selected a " + v3.getMake() + " " + v3.getModel(), "Congratulations", JOptionPane.PLAIN_MESSAGE);
					break;
				
					//If Make + Model selected:
					case "d":
						JOptionPane.showMessageDialog(null, "You Have Selected a " + v4.getMake() + " " + v4.getModel(), "Congratulations", JOptionPane.PLAIN_MESSAGE);
					break;
				
				}
        	//After car make + model is selected ask the user these Personal Details:
        	//Call Object newPerson:
			newPerson.setNumOfDays(Integer.parseInt(JOptionPane.showInputDialog("Please enter the Amount of days you wish to rent this car: ")));
			newPerson.setFName(JOptionPane.showInputDialog("Please enter your Forename: "));
			newPerson.setSName(JOptionPane.showInputDialog("Please enter your Surname: "));
			newPerson.setCardNum(JOptionPane.showInputDialog("Please enter your Credit-Card number: "));
			newPerson.setMobileNum(Integer.parseInt(JOptionPane.showInputDialog("Please enter your Mobile-Number: ")));
			//newPerson.setRented(v4);
			if(operation.equals ("a")){
							newPerson.setRented(v1);	
			}
			else if (operation.equals ("b")){
							newPerson.setRented(v2);	
			}	
			else if (operation.equals ("c")){
							newPerson.setRented(v3);	
			}
			else if (operation.equals ("d")){
							newPerson.setRented(v4);	
			}

			//Put Make + Model selected to string, along with all Personal Details:
			JOptionPane.showMessageDialog(null,(newPerson.toString())
										, "Personal Details Entered", JOptionPane.PLAIN_MESSAGE);							
				
			}
			
	else if (e.getActionCommand().equals("Find Customer")){
		
		//Reference - Sample code - FriendsArray2		
		String searchCustomer = JOptionPane.showInputDialog(null,"Please Enter the surname customer you wish to find:");

        if (!newPerson.getSName().equals(searchCustomer)) 
        	{
            JOptionPane.showMessageDialog(null, searchCustomer + " is not a current Customer" );
        	}
        	 
        else 
        	{
            JOptionPane.showMessageDialog(null,searchCustomer + " is currently renting a " + newPerson.rented /*newPerson.toString()*/);
        	}
		//End Reference - Sample code	
			
	}
}
}
