//CarRentalDriver.java
import javax.swing.*;
import java.awt.event.*;

public class CarRentalDriver extends JFrame implements ActionListener {
	
	private JMenuBar menuBar;
		
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
		//Call File + Player
		createNewRentalMenu();
		createCurrentRentalMenu();
	}
	
	public void createNewRentalMenu(){
		
		//JMenu  - New Rental
		JMenu newRentalMenu = new JMenu("New Rental");
		menuBar.add(newRentalMenu);
		
		//JMenuItem - Cars
		JMenuItem carsItem = new JMenuItem("Cars to Rent");
		newRentalMenu.add(carsItem);
		
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
		
		//JMenuItem - Exit
		JMenuItem exitItem = new JMenuItem("Exit");
		currentRentalMenu.add(exitItem);
		exitItem.addActionListener(this);

	}
	
	public void actionPerformed(ActionEvent e){
		
		if (e.getActionCommand().equals("Exit"))
			{
				JOptionPane.showMessageDialog(null,"Thanks for using this System... Goodbye!");
				System.exit(0);
			}
	}
}