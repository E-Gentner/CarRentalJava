/*
 * Ethan Gentner 
*/
package finalProj;

import java.util.*;

import asignmentThree.Car;
import asignmentThree.Suv;
import asignmentThree.Truck;
import asignmentThree.Vehicles;

public class AgencyRentalProgram {
	public static void main(String[] args) {
		 
		//Current Rates hard coded
		CurrentRates agencyRates = new CurrentRates(new CarRates(24.95, 169.95, 514.95, 0.16, 14.95),
													new SUVRates(29.95, 189.95, 679.95, 0.16, 14.95),
													new TruckRates(36.95, 224.95, 687.95, 0.26, 21.95));
		
		//Empty vehicle collection and populate call
		Vehicles agencyVehicles = new Vehicles();
		populate(agencyVehicles);
		
		//Account and Transaction creation
		Accounts accounts = new Accounts();
		Transactions transactions = new Transactions();
		
		//Establish UI
		Scanner input = new Scanner(System.in);
		UserInterface ui;
		boolean quit = false;
		
		//Create Requested UI and start
		while(!quit) {
			ui = getUI(input);
			
			if(ui == null) {
				quit = true;
			}
			else { 
				if(!SystemInterface.initialized()) {
					SystemInterface.initSystem(agencyRates, agencyVehicles, accounts, transactions);
				}
				ui.start(input);
			}
		}
	}
	
	public static UserInterface getUI(Scanner input) {
		boolean validSelection = false;
		UserInterface ui = null;
		
		while(!validSelection) {
			System.out.println("1-Employee, 2-Manager, 3-Quit:");
			
			int selection = input.nextInt();
			if(selection == 1) {
				ui =  new EmployeeUI();
				validSelection = true;
			}
			else
			if(selection == 2) {
				ui = new ManagerUI();
				validSelection = true;
			}
			else
			if(selection == 3) {
				ui = null;
				validSelection = true;
			}
			else {
				System.out.println("Invalid slection - please reenter");
			}
		}
		return ui;
	}
	
	public static void populate(Vehicles vehs) {
		vehs.add(new Car("Chevrolet Camaro - 2018", 30, 2, "KH4GM4564GQ"));
		vehs.add(new Car("Ford Fusion - 2018", 34, 4, "AB4EG5689GM"));
		vehs.add(new Car("Ford Fusion Hybrid", 32, 4, "KV4EG3245RV"));
		vehs.add(new Car("Chevrolet Impala - 2019 ", 30, 4, "RK3MB3366YH"));
		vehs.add(new Suv("Honda Odyssey - 2020", 28, 7, 6, "VM9RF2635TD"));
		vehs.add(new Suv("Dodge Caravan - 2019", 25, 5, 4, "QK3FT4273NE"));
		vehs.add(new Suv("Ford Expedition - 2018", 20, 5, 3, "JK2HL8264HY"));
		vehs.add(new Truck("Ten-Foot", 12, 2810, "EJ5KU2437BD"));
		vehs.add(new Truck("Eighteen-Foot", 10, 5950, "KG4MD5372RK"));
		vehs.add(new Truck("Twenty-Four-Foot", 8, 6500, "EB2WR3082OB"));
		vehs.add(new Truck("Twenty-Four-Foot", 8, 6510, "TV3GH4390FK"));
	}
	
}
