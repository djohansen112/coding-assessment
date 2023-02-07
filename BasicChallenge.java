import java.util.ArrayList;
import java.util.Scanner;

public class BasicChallenge {
	
	//Globals
	ArrayList<Vehicle> garage;  //initialised the garage for the main method to use
	static int menu = 0; //holds the menu selection for the main menu
	static Scanner input = new Scanner(System.in); //initialise the Scanner object, a single instantiation is used, then closed at the end rather than making multiple
	
	//Begin methods
	public static int displayMenu() { //displays a menu and returns a selection
		
		int temp = 0; //returns this at the end
		
		System.out.println("Please select from the following menu:");
		System.out.println("1. Create new vehicle");
		System.out.println("2. Add used vehicle");
		System.out.println("3. Update mileage");
		System.out.println("4. List vehicles");
		System.out.println("5. List service history");
		System.out.println("6. Exit");

		try {
			temp = input.nextInt();
		} catch(Exception e) {
			System.out.println("An error occured!");
			System.exit(0);
		}
		
		return temp;					
	}
	
	public static Vehicle newVehicle(int isNew){ //creates a new vehicle object and returns the instance
		
		String newType = "";
		int temp = 0;
		int value = 0;
		int initMileage = 0;
		String newUsed = "New";
		
		System.out.println("Please select a type:");
		System.out.println("1. Truck");
		System.out.println("2. Car");
		System.out.println("3. Bus");
		System.out.println("4. Motorbike");
		System.out.println("5. Back to menu");

		try {
		
			temp = input.nextInt();
		
		} catch(Exception e) {
			System.out.println("An error occured!");
			System.exit(0);
		}
				
		System.out.println("Please enter a value for this vehicle:");
		
		try {
			value = input.nextInt();
		} catch(Exception e) {
				System.out.println("An error occured!");
				System.exit(0);
		}
		
		if(isNew == 2) {
		
			newUsed = "Used";
		
			System.out.println("Please enter initial mileage for this vehicle:");
			try {
				initMileage = input.nextInt();
			} catch(Exception e) {
					System.out.println("An error occured!");
					System.exit(0);
			}
		
		}
		
		switch (temp) {
			case 1: //truck selection
				newType = "Truck";
				System.out.println(newUsed + " Truck added");
				break;
			case 2: //car selection
				newType = "Car";
				System.out.println(newUsed + " Car added");
				break;
			case 3://Bus selection
				newType = "Bus";
				System.out.println(newUsed + " Bus added");
				break;
			case 4://Bike selection
				newType = "Bike";
				System.out.println(newUsed + " Bike added");
				break;
			case 5:
				displayMenu();
				break;
			default:
				System.out.println("Please make a valid selection");
		}
		
		//return either a new  or used vehicle
		if(isNew == 2) {
			Vehicle newVehicle = new Vehicle(newType, value, initMileage);
			return newVehicle;
		} else {
			Vehicle newVehicle = new Vehicle(newType, value);
			return newVehicle;
		}
		
	}//end newVehicle()	
	
	
	//Begin MAIN method
	public static void main(String[] args) { //Main method
		
		//create a garage for the vehicles
		ArrayList<Vehicle> garage = new ArrayList<Vehicle>();
		
		System.out.println("Welcome to the Vehicle Tracker 2000!");
		
		//display the menu
		while(menu != 6){
			switch(displayMenu()) {
				case 1: //Make a new vehicle
					garage.add(newVehicle(1));
					break;
				case 2: //Make a used vehicle 
					garage.add(newVehicle(2));
					break;
				case 3: //update a vehicle mileage
					System.out.println("Please select a vehicle to update:");
					int index = input.nextInt();
					System.out.println("Current mileage is: " + garage.get(index).getMileage());
					System.out.println("Updated mileage:");
					int newMileage = input.nextInt();
					garage.get(index).setMileage(newMileage);
					break;
				case 4://List all vehicles in the garage
					System.out.println("Vehicles in the garage:");
					System.out.println("------------------------------------------------------------");
					System.out.println("*Index \t Type\t Tyres\t Current value \t"+ "Current Mileage\t*");
					
					//iterate through the vehicle list and populate table
					for (int i=0; i < garage.size(); i++) { 
						
						System.out.println("*" + i +" \t "+ garage.get(i).getType() +" \t " + garage.get(i).getTyres()+" \t " + garage.get(i).getValuation() +"  \t "+ garage.get(i).getMileage() + "\t\t*");	
								
					}
					System.out.println("------------------------------------------------------------");
					break;
				case 5: //List service history of vehicles
					System.out.println("Please select a vehicle to list the service history:");
					int serviceIndex = input.nextInt();
					garage.get(serviceIndex).getService();
					break;
				case 6: //exit the app
					System.out.println("Thanks for using the app");
					System.exit(0);
				default:
					System.out.println("Not a valid response, please try again");
			}
		}//end menu loop

		input.close(); //clean up the open Scanner
	
	} //end main
} //end BasicChallenge class

