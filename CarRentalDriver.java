//CarRentalDriver.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
/**
* <h1>Car Rental Driver</h1>
* The Car Rental Program opens a window with a menu system.
* It contains a menuBar which has multiple options.
* The user can select a car and enter their personal Details. 
* These details can be saved and opened.
* You can also search for a customer.
* @author  Christopher Daly
*/


public class CarRentalDriver extends JFrame implements ActionListener {
	/**
   * This method is used to create an ArrayList, two buttons, a label, a menu bar,
   * and create an object from PersonRequirments and Vehicle.
   */
	
	private JButton colourButton;
    private JButton colourButton2;
    private JLabel chooseLabel;
    
	private JMenuBar menuBar;
	String operation;
	PersonRequirments newPerson = new PersonRequirments();
	int count;
	Vehicle vehicle = new Vehicle();
	
	ArrayList<PersonRequirments> customers = new ArrayList<PersonRequirments>();
	
	/**
   * This is the main method which makes use of jFrame and jMenu method.
   * @param args Unused.
   * @return Nothing.
   */
	public static void main (String args [])
	{	
		CarRentalDriver frame = new CarRentalDriver();
		CarRentalDriver menu = new CarRentalDriver ();
		menu.setVisible(true);
	}//End Main
	
	/**
   * This is the method which sets everything for the Frame
   * @param cPane Get the cpane
   * @param setTitle This is used to set the title of the window.
   * @param setSize This is used to set the size of the window.
   * @param setLocation This is used to set the location of the window.
   * @param setDefaultCloseOperation This is used the close operation.
   * @param createFileMenu This is used to call the createFileMenu.
   * @param createRentalMenu This is used to call the createRentalMenu.
   * @param createCurrentRentalMenu This is used to call the createCurrentRentalMenu.
   * @return Nothing.
   */
	public CarRentalDriver(){
		Container cPane;
		setTitle("Car Rental System");
		setSize(300, 300);
		setLocation(600,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		cPane = getContentPane( );
        cPane.setLayout(new FlowLayout());
        
        chooseLabel = new JLabel( "If you want you can select a background colour: ");
        cPane.add(chooseLabel);
		
		//JMenuBar
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//Call FileMenu + NewRentalMenu + CurrentRentalMenu
		createFileMenu();
		createNewRentalMenu();
		createCurrentRentalMenu();	
			
		//create and place two colour buttons on the frame
        colourButton = new JButton("Yellow");
        cPane.add(colourButton);
        colourButton.addActionListener(this);

        colourButton2 = new JButton("Green");
        cPane.add(colourButton2);
        colourButton2.addActionListener(this);
	}//End Driver

	/**
   * This is the Save method is used to save the objects (Details Entered).
   * It Writes them to the object customers.
   * and saves it to the file called person.dat
   * @throws IO Exception 
   */
    public void save() throws IOException {
      	ObjectOutputStream os;
      	os = new ObjectOutputStream(new FileOutputStream ("person.dat"));
      	os.writeObject(customers);
      	os.close();
    }//End Save

	/**
   * This is the Open method is used to Open the objects (Details Entered).
   * It Opens the person.dat file.
   * @return contents of array list
   */
    public void open() {
      	count = 0;
      	try{
      	  ObjectInputStream is;
      	  is = new ObjectInputStream(new FileInputStream ("person.dat"));
          customers  = (ArrayList<PersonRequirments>) is.readObject();
      	  is.close();  	
      	   }
      	catch(Exception e){
      		JOptionPane.showMessageDialog(null,"open didn't work");
      		e.printStackTrace();	
      	   }
    }//End Open 
      
	/**
   * This is the Display method is used to Display the objects (Details Entered).
   * It Displays them through a JText Area
   */
    public void display(){
      	JTextArea area = new JTextArea();
      	area.setText("All Customers:\n");
      	
 		for(PersonRequirments p:customers){
      	    area.append(p.getFName() + " "+ p.getSName()+"\n" +
      	    					"is renting a " + p.getRented() + " for " + p.getNumOfDays() + " days"+
      	    					"\nAt a total cost of " + p.getTotalPrice() + "\n\n");
 			}
 			showMessage(area);
		}//End Display
		
	/**
   * This is the createFileMenu method.
   * It contains a file menu,
   * In this file menu there is a save, open, and exit option.
   */
	public void createFileMenu(){
		
		//JMenu  - New Rental
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		//JMenuItem - Save
		JMenuItem saveItem = new JMenuItem("Save");
      	fileMenu.add(saveItem);
      	saveItem.addActionListener(this);
      	
      	//JMenuItem - Open
      	JMenuItem openItem = new JMenuItem("Open");
      	fileMenu.add(openItem);
      	openItem.addActionListener(this);
      	
		//JMenuItem - Exit
		JMenuItem exitItem = new JMenuItem("Exit");
		fileMenu.add(exitItem);
		exitItem.addActionListener(this);
	}//End createFileMenu for JMenu + JMenuItems
	
	/**
   * This is the createNewRentalMenu method.
   * It contains a New Rental menu,
   * In this New Rental menu there is a Book Car Rental, and exit option.
   */
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
	}//End createNewRentalMenu for JMenu + JMenuItems
	
	/**
   * This is the createCurrentRentalMenu method.
   * It contains a Current Rental menu,
   * In this Current Rental menu there is a View All Customers, Find Customer, and exit option.
   */
	public void createCurrentRentalMenu(){
		
		//JMenu  - Current Rental
		JMenu currentRentalMenu = new JMenu("Currently Rented");
		menuBar.add(currentRentalMenu);
					
		//JMenuItem - View all Customers
		JMenuItem viewAllCustomerItem = new JMenuItem("View All Customers");
		currentRentalMenu.add(viewAllCustomerItem);
		viewAllCustomerItem.addActionListener(this);
		
		//JMenuItem - Find Customer
		JMenuItem findCustomerItem = new JMenuItem("Find Customer");
		currentRentalMenu.add(findCustomerItem);
		findCustomerItem.addActionListener(this);
		
		//JMenuItem - Exit
		JMenuItem exitItem = new JMenuItem("Exit");
		currentRentalMenu.add(exitItem);
		exitItem.addActionListener(this);
	}//End createCurrentRentalMenu for JMenu + JMenuItems
	
	
	/**
   * This is the actionPerformed method.
   * There are action commands for Exit, Book Car Rental, Find Customer, View All Customers, Save and Open
   */
	public void actionPerformed(ActionEvent e){
		
		/**
   		* This ActionCommand allows the user to exit the program
  		*/
		if (e.getActionCommand().equals("Exit"))
			{
				JOptionPane.showMessageDialog(null,"Thanks for using this System... Goodbye!");
				System.exit(0);
			}//End Exit
			
		/**
   		* This ActionCommand allows the user to Book a car rental
  		*/	
		else if (e.getActionCommand().equals("Book car Rental"))
			{	
					//Create a list of Vehicles
					Vehicle v1,v2,v3,v4;
					LinkedList<Vehicle> fleet;
					
					//Add them to list fleet
					fleet = new LinkedList();
					
					//Attributes of Vehicle 1
					v1 = new Vehicle("Ford","Fiesta", 1.4, 60);
					fleet.add(v1);
					
					//Attributes of Vehicle 2
					v2 = new Vehicle("Toyota","Auris", 1.2, 50);
					fleet.add(v2);
				
					//Attributes of Vehicle 3
					v3 = new Vehicle("Lamborghini","Murcielago", 6.2, 500);
					fleet.add(v3);
						
					//Attributes of Vehicle 4
					v4 = new Vehicle("Audi","A5", 3.0, 90);
					fleet.add(v4);
						
				operation = JOptionPane.showInputDialog("Please select a car A, B, C, or D:\n\n" 
													+ v1.toString()+ "\n\n" 
													+ v2.toString() + "\n\n" 
													+ v3.toString() + "\n\n"
													+ v4.toString());
				
				/**
   				* A switch is here to allow the user to select a vehicle
  				*/																	
				switch(operation) {
					
					//If Make + Model 1 selected:
					case "a":
						JOptionPane.showMessageDialog(null, "You Have Selected a " + v1.getMake() + " " + v1.getModel(), "Congratulations", JOptionPane.PLAIN_MESSAGE);
					break;
				
					//If Make + Model 2 selected:
					case "b":
						JOptionPane.showMessageDialog(null, "You Have Selected a " + v2.getMake() + " " + v2.getModel(), "Congratulations", JOptionPane.PLAIN_MESSAGE);
					break;
				
					//If Make + Model 3 selected:
					case "c":
						JOptionPane.showMessageDialog(null, "You Have Selected a " + v3.getMake() + " " + v3.getModel(), "Congratulations", JOptionPane.PLAIN_MESSAGE);
					break;
				
					//If Make + Model 4 selected:
					case "d":
						JOptionPane.showMessageDialog(null, "You Have Selected a " + v4.getMake() + " " + v4.getModel(), "Congratulations", JOptionPane.PLAIN_MESSAGE);
					break;
				
				}//End Switch
				
			/**
   			*After car make + model is selected ask the user these Personal Details:
   			*Call Object newPerson:
  			*/
			newPerson.setNumOfDays(Integer.parseInt(JOptionPane.showInputDialog("Please enter the Amount of days you wish to rent this car: ")));
			newPerson.setFName(JOptionPane.showInputDialog("Please enter your Forename: "));
			newPerson.setSName(JOptionPane.showInputDialog("Please enter your Surname: "));
			newPerson.setCardNum(JOptionPane.showInputDialog("Please enter your Credit-Card number: "));
			newPerson.setMobileNum(JOptionPane.showInputDialog("Please enter your Mobile-Number: "));
			
			
			/**Set the rented car they chose to newPerson*/
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

			/**Put Make + Model selected to string, along with all Personal Details and display:
			 */
			JOptionPane.showMessageDialog(null,(newPerson.toString())
										, "Personal Details Entered", JOptionPane.PLAIN_MESSAGE);
							
					customers.add(newPerson);
					count++;
			}//END BOOK CAR RENTAL
			
	/**If find customer is selected	
	 */	
	else if (e.getActionCommand().equals("Find Customer")){
		String searchCustomer = JOptionPane.showInputDialog(null,"Please Enter the surname customer you wish to find:");
		
		count = 0;
      	try{
      	  ObjectInputStream is;
      	  is = new ObjectInputStream(new FileInputStream ("person.dat"));
          customers  = (ArrayList<PersonRequirments>) is.readObject();
      	  is.close();  	
      	   }
      	catch(Exception a){
      		JOptionPane.showMessageDialog(null,"open didn't work");
      		a.printStackTrace();	
      	   }		
      	
 		for(PersonRequirments p:customers){	
 			if (p.getSName().equals(searchCustomer)) {	
      	   /* area.append(p.getFName() + " "+ p.getSName()+"\n" +
      	    					"is renting a " + p.getRented() + " for " + p.getNumOfDays() + " days"+
      	    					"\nAt a total cost of " + p.getTotalPrice() + "\n\n");
 			}
 			showMessage(area);*/
 			      	JOptionPane.showMessageDialog(null, p.getFName() + " "+ p.getSName()+"\n" +
      	    			"is renting a " + p.getRented() + " for " + p.getNumOfDays() + " days"+
      	    			"\nAt a total cost of " + p.getTotalPrice() + "\n\n");
 			}
		}
	}
	
	else if (e.getActionCommand().equals("View All Customers")){
	 		open();	//Open File created
         	display();	//Display it
	}
	
	/**If Save is selected
	 **/
	else if (e.getActionCommand() .equals ("Save")){
      	// NEW BLOCK OF ERROR-HANDLING HERE:
      	 try{
      	 	save();
      	 	showMessage("Data saved successfully");
      	 } //End try
      	 
      	 catch (IOException f){
      	 	showMessage("Not able to save the file:\n"+
      	 	"Check the console printout for clues to why ");
      	 	f.printStackTrace();
      	 }//End catch
     }//End  else if
      	
     /**If open is selected
      **/
     else if (e.getActionCommand() .equals ("Open")){
      	 open();	//Open File created
         display();	//Display it
      	}//End Open
      
     /**If colourButton is selected
      */
     else if (e.getSource() == colourButton ) {
    	    getContentPane().setBackground(Color.yellow);
     	}//End colourButton 
     	
     /**If colourButton is selected
      */
     else if (e.getSource() == colourButton2) {
         	getContentPane().setBackground(Color.green);
         }//End colourButton1
}

	/** utility methods to make the code easier 
	 */
      public void showMessage (String s){
      	JOptionPane.showMessageDialog(null,s);
      }
      
      public void showMessage (JTextArea s){
      	JOptionPane.showMessageDialog(null,s);
      }
}//End Program
