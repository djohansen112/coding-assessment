
/*public class backup {

	import java.util.ArrayList;
import java.util.Scanner;

	public class Challenge1 {
				
		ArrayList<Vehicle> garage; //= new ArrayList<Vehicle>();
		static int newMileage = 0;
		static int menu = 0;
		
		public static int displayMenu() { //displays a menu, takes and returns a selection
			
			System.out.println("Please select from the following menu:");
			System.out.println("1. Create new vehicle");
			System.out.println("2. List vehicles");
			System.out.println("3. Update mileage");
			System.out.println("4. Exit");
			
			Scanner menuInput = new Scanner(System.in);
			return menuInput.nextInt();	
		}
		
		public static Vehicle newVehicle(){ //creates a new vehicle entry using Vehicle constructor
			
			String newType = "";

			Scanner vehicleInput = new Scanner(System.in);

			System.out.println("Please select a type:");
			System.out.println("1. Truck");
			System.out.println("2. Car");
			System.out.println("3. Bus");
			System.out.println("4. Motorbike");
			System.out.println("5. Back to menu");

			switch (vehicleInput.nextInt()) {
			case 1: //truck selection
				newType = "Truck";
				System.out.println("New Truck added");
				break;
			case 2: //car selection
				newType = "Car";
				System.out.println("New Car added");
				break;
			case 3://Bus selection
				newType = "Bus";
				System.out.println("New Bus added");
				break;
			case 4://Bike selection
				newType = "Bike";
				System.out.println("New Bike added");
				break;
			case 5:
				displayMenu();
				break;
			default:
				System.out.println("Please make a valid selection");
			}

			System.out.println("Please enter a value for this vehicle:");

			Scanner valueInput = new Scanner(System.in);
			
			Vehicle newVehicle = new Vehicle(newType, valueInput.nextInt());
			
			return newVehicle;
		}	
		
		public static int mileageMenu() {
			
			Scanner vehicleInput = new Scanner(System.in);
			
			System.out.println("Please select a vehicle to update:");

			int index = vehicleInput.nextInt();
			
			Scanner milesInput = new Scanner(System.in);
			
			System.out.println("Updated mileage:");

			newMileage = milesInput.nextInt();
			
			return index;
		}
		
		public static void main(String[] args) {
			
		
			//create a garage for the vehicles
			ArrayList<Vehicle> garage = new ArrayList<Vehicle>();
			
			System.out.println("Welcome to the Vehicle Tracker 2000!");
			
			//display the menu
			while(menu != 4){
				switch(displayMenu()) {
					case 1: //Make a new vehicle
						garage.add(newVehicle());
						break;
					case 2: //List all vehicles in the garage
						System.out.println("Vehicles in the garage:");
						System.out.println("------------------------------------------------------------");
						System.out.println("*Index \t Type\t Tyres\t Current value \t"+ "Current Mileage\t*");
						
						for (int i=0; i < garage.size(); i++) { //iterate through the vehicle list
							System.out.println("*" + i +" \t "+ garage.get(i).getType() +" \t " + garage.get(i).getTyres()+" \t " + garage.get(i).getValuation() +"  \t "+ garage.get(i).getMileage() + "\t*");	
						}
						
						System.out.println("------------------------------------------------------------");
						break;
					case 3: //update a vehicle mileage
						garage.get(mileageMenu()).setMileage(newMileage);
						System.out.println("Mileage updated");
						break;
					case 4:
						System.out.println("Thanks for using the app");
						System.exit(0);
					default:
						System.out.println("Not a valid response, please try again");
				}
		}
		}

	}


}
*/