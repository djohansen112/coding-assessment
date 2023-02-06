import java.util.ArrayList;
import java.util.List;


/* New vehicle object that creates a car type object. Takes two constructors - one for new and one for used vehicles. 
 * Maintains a service record per instance of each Major, Minor and Tyre service done
*/
public class Vehicle {
	
	List<int[]> serviceHistory = new ArrayList<int[]>();
	private String type = "INVALID";
	private int tyres = 0;
	private int valuation = 0;
	protected int mileage = 0;
	protected int lastMinor = 0, lastMajor = 0, lastTyres = 0; 
	
	//************Vehicle constructor*************
	public Vehicle(String type, int valuation){
		
		this.valuation = valuation;
		this.type = type;
		
		setTyres(type);
		setMileage(0);
		System.out.println("New vehicle added to garage\n");
		
	}
	public Vehicle(String type, int valuation, int initMileage){
		
		this.valuation = valuation;
		this.type = type;
		
		setTyres(type);
		setMileage(initMileage);
		System.out.println("Used vehicle added to garage\n");
	}
	
	//************getters************
	public String getType() {
		return type;
	}
	
	public int getTyres() {
		return tyres;
	}
		
	public int getValuation() {
		return valuation;
	}
	
	public int getMileage() {
		return mileage;
	}
	
	public void getService() {
		
		for (int i = 0; i <= serviceHistory.size(); i++) { 
	
			System.out.println("Service history for " + getType() + " with index " + i);
			
			if(serviceHistory.get(i)[0] > 0)
			System.out.println("Minor Service at:" + serviceHistory.get(i)[0]);
			
			if(serviceHistory.get(i)[1] > 0)
			System.out.println("Major Service at:" + serviceHistory.get(i)[1]);
			
			if(serviceHistory.get(i)[2] > 0)
			System.out.println("Tyre  change at:" + serviceHistory.get(i)[2]);
			
		}
	}
	
	//************setters************
	private void setTyres(String type) {
			
		if(type == "Truck")
			tyres = 10;
		if(type == "Car")
			tyres = 4;
		if(type == "Bus")
			tyres = 6;
		if(type == "Bike")
			tyres = 2;	
	}

	public void setMileage(int newMileage) { //updates mileage and performs interval history calculations

		int updateValue = 0;
		
		int newMinor = 0;
		int newMajor = 0;
		int newTyres = 0;
		//get the vehicle mileage and add it to the vehicle unless it is smaller than current miles
		
		if(newMileage < mileage) {
			System.out.println("It looks like you have not entered a valid mileage update.");
		}
		else {
			
			mileage = newMileage;
			//more than 35k then change tyres
			if(mileage > (lastTyres + 35000)){
				System.out.println("Vehicle is due for a tyre change. Tyre service completed.");
				lastTyres = mileage;
				newTyres = lastTyres;
			}
			
			//more than 24k major service, more than 12k but not 24,  then minor, otherwise no service
			if(mileage > (lastMajor + 24000)){
				System.out.println("Vehicle is due for a major service. Major service completed.");
				lastMajor = mileage;
				newMajor = lastMajor;
			} else if (mileage > (lastMinor + 12000) && mileage > (lastMajor + 12000)){
				System.out.println("Vehicle is due for a minor service. Minor service completed.");
				lastMinor = mileage;
				newMinor = lastMinor;
			} else {
				System.out.println("No maintenance required");
			}
			

			int[] serviceRecord = {newMinor, newMajor, newTyres};
			
			serviceHistory.add(serviceRecord);
			
			
			//Update valuation once it completes first depreciation interval
			if(mileage>15000) {		
				
				for(int valueMileage = 0; valueMileage <= mileage; valueMileage += 15000) {
					
					updateValue += 2000;
				}
			
				valuation -= updateValue;
				
				System.out.println("Vehicle depreciated by $" + updateValue);
				
				if (valuation <= 0) {
					System.out.println("Time to retire this vehicle. Scrap value only");
					valuation = 0;
				}
			}
			
		System.out.println("Mileage updated");	
	}}
	
	
} //end Vehicle class