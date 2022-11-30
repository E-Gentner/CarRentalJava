package finalProj;

import java.util.Scanner;

public class ManagerUI implements UserInterface{
	private boolean quit  = false;
	
	public void start(Scanner input) {
		int selection;
		
		while(!quit) {
			displayMenu();
			selection = getSelection(input);
			execute(selection, input);
		}
	}

	private void execute(int selection, Scanner input) {
		int vehType;
		String creditCardNum;
		String[] displayLines = null;
		
		switch(selection) {
			//View/Update Rates
			case 1: vehType = getVehicleType(input);
					VehicleRates vehRates = setVehicleRates(input, vehType);
					switch(vehType) {
						case 1: displayLines = SystemInterface.updateCarRates(vehRates); break;
						case 2: displayLines = SystemInterface.updateSuvRates(vehRates); break;
						case 3: displayLines = SystemInterface.updateTruckRates(vehRates); break;
					}
					displayResults(displayLines);
					break;
			
			//View Vehicles
			case 2:	displayLines = SystemInterface.getAllVehicles();
					displayResults(displayLines);
					break;
				
			//Add account
			case 3:	creditCardNum = getCreditCardNum(input);
					String companyName = getName(input);
					boolean primeCustomer = getPrimeCust(input);
					displayLines = SystemInterface.addAccount(creditCardNum, companyName, primeCustomer);
					displayResults(displayLines);
					break;
					
				
			//View Reservations
			case 4: displayLines = SystemInterface.getAllReservations();
					displayResults(displayLines);
					break;
			
			//View Accounts
			case 5: displayLines = SystemInterface.getAllAccounts();
					displayResults(displayLines);
					break;
			//View Transactions
			case 6: displayLines = SystemInterface.getAllTransactions();
					displayResults(displayLines);
					break;
			//Quit
			case 7: quit = true;
		}
	}
	
	private void displayMenu() {
		System.out.println("Main Menu - Manager");
		System.out.println("1 - View/Update Rates			... allows updating of rental and insurance rates");
		System.out.println("2 - View All Vehicles			... displays all vehicles of the agency");
		System.out.println("3 - Add Account					... allows entry of a new customer account");
		System.out.println("4 - View All Reservations		... displays all current reservations");
		System.out.println("5 - View All Accounts			... displays all customer accounts");
		System.out.println("6 - View Transactions			... displays all transactions");
		System.out.println("7 - Quit");
	}
	
	private int getSelection(Scanner input) {
		int selection = 0;
		boolean stop = false;
		
		while(!stop) {
			System.out.println("Please Enter 1 - 8 according to the option you would like to choose.");
			selection = input.nextInt();
			if(selection <1 || selection > 8) {
				System.out.println("Number not valid please select a valid option.");
			}
			else {
				stop = true;
			}
		}
		return selection;
	}
	
	private int getVehicleType(Scanner input) {
		int vehType = 0;
		boolean stop = false;
		
		while(!stop) {
			System.out.println("Enter a vehicle type:");
			System.out.println("1 - Car");
			System.out.println("2 - SUV");
			System.out.println("3 - Truck");
			vehType = input.nextInt();
			if(vehType <1 || vehType > 3) {
				System.out.println("Number is invalid slection.");
			}
			else {
				stop = true;
			}
		}
		return vehType;
	}
	
	private VehicleRates setVehicleRates(Scanner input, int vehType) {
		double dailyRate;
		double weeklyRate;
		double monthlyRate;
		double mileageRate;
		double insurRate;
		VehicleRates rates = null;
		
		System.out.println("Please enter the new daily rate");
		dailyRate = input.nextDouble();
		System.out.println("Please enter the new weekly rate");
		weeklyRate = input.nextDouble();
		System.out.println("Please enter the new monthly rate");
		monthlyRate = input.nextDouble();
		System.out.println("Please enter the new mileage rate");
		mileageRate = input.nextDouble();
		System.out.println("Please enter the new daily insurance rate");
		insurRate = input.nextDouble();
		
		switch(vehType) {
		case 1: rates = new CarRates(dailyRate, weeklyRate, monthlyRate, mileageRate, insurRate); break;
		case 2: rates = new SUVRates(dailyRate, weeklyRate, monthlyRate, mileageRate, insurRate); break;
		case 3: rates = new TruckRates(dailyRate, weeklyRate, monthlyRate, mileageRate, insurRate); break;
		}
		return rates;
	}
	
	private String getCreditCardNum(Scanner input) {
		String creditCardNum = "";
		boolean stop = false;
		
		while(!stop) {
			System.out.println("Please enter a credit card number:");
			creditCardNum = input.next();
			if(creditCardNum == null) {
				System.out.println("Error: Please try again");
			}
			else {
				stop = true;
			}
		}
		return creditCardNum;
	}
	
	private String getName(Scanner input) {
		String name = null;
		System.out.println("Please enter the name of the company");
		name = input.next();
		return name;
	}
	
	private boolean getPrimeCust(Scanner input) {
		boolean primeCust;
		System.out.println("Would you like to be a prime customer:");
		System.out.println("'true' for yes, 'false' for no");
		primeCust = input.nextBoolean();
		return primeCust;
	}
	
	private void displayResults(String[] lines) {
		for(String line: lines) {
			System.out.println(line);
		}
	}
}
