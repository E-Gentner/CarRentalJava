package finalProj;

import java.util.Scanner;

public class EmployeeUI implements UserInterface{
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
		int vehType, numDaysUsed = 0, numMilesDriven = 0;
		String vin, creditCardNum; String[] displayLines = null;
		RentalDetails rentalDetails; ReservationDetails reservDetails;
		
		switch(selection) {
			case 1: vehType = getVehicleType(input);
					switch(vehType) {
						case 1: displayLines = SystemInterface.getCarRates(); break;
						case 2: displayLines = SystemInterface.getSuvRates(); break;
						case 3: displayLines = SystemInterface.getTruckRates(); break;
					}
					displayResults(displayLines);
					break;
				
			case 2: vehType = getVehicleType(input);
					switch(vehType) {
						case 1: displayLines = SystemInterface.getAvailCars(); break;
						case 2: displayLines = SystemInterface.getAvailSUVs(); break;
						case 3: displayLines = SystemInterface.getAvailTrucks(); break;
					}
					displayResults(displayLines);
					break;
				
			case 3: rentalDetails = getRentalDetails(input);
					displayLines = SystemInterface.estimatedRentalCost(rentalDetails);
					displayResults(displayLines);
					break;
			
			case 4: reservDetails = getReservationDetails(input);
					
					try {
						displayLines = SystemInterface.makeReservation(reservDetails);
					} catch (VinNotFoundException e) {
						System.out.println("Error: VIN was not found, please try again");
					} catch (ReservedVehicleException e) {
						System.out.println("Error: Vehicle is already reserved, please try another vehicle");
					}
					
					displayResults(displayLines);
					break;
			case 5: vin = getVIN(input);
					try {
						displayLines = SystemInterface.cancelReservation(vin);
					} catch (VinNotFoundException e1) {
						System.out.println("Error: VIN not found, please try again");
					} catch (UnreservedVehicleException e1) {
						System.out.println("Error: Vehicle not reserved, please try another vehicle");
					}
					displayResults(displayLines);
					break;
			case 6: creditCardNum = getCreditCardNum(input);
					displayLines = SystemInterface.getAccount(creditCardNum);
					displayResults(displayLines);
					break;
			case 7: creditCardNum = getCreditCardNum(input);
					vin = getVIN(input);
					try {
						displayLines = SystemInterface.processReturnedVehicle(vin, numDaysUsed, numMilesDriven);
					} catch (VinNotFoundException e) {
						System.out.println("Error: VIN not found, please try again");
					} catch (UnreservedVehicleException e) {
						System.out.println("Error: Vehicle not reserved, please try another vehicle");
					}
					displayResults(displayLines);
					break;
			case 8: quit = true;
		}
	}
	
	
	//Private methods
	private void displayMenu() {
		System.out.println("MAIN MENU - EMPLOYEE");
		System.out.println("1 - View Current Rates			... displays rental (and insurance rates)");
		System.out.println("                                    for one of cars, SUV's, or Trucks");
		System.out.println("2 - View Available Vehicles 	... displays available vehicles (cars, SUV's, or");
		System.out.println("                                    trucks)");
		System.out.println("3 - Calc Estimated Rental Cost  ... displays estimated rental cost for given vehicle");
		System.out.println("                                    type, rental period, expected miles driven,");
		System.out.println("                                    optional daily insurance, and if Prime Customer");
		System.out.println("4 - Make a reservation          ... creates a resevation for VIN, credit card num,");
		System.out.println("                                    rental period, and insur option");
		System.out.println("5 - Cancel Reservation          ... cancels a reservation by VIN");
        System.out.println("6 - View Corporate Account      ... displays account information for a given account number");
        System.out.println("                                    including all current reservations");
        System.out.println("7 - Process Returned Vehicle    ... requests VIN and actual number of miles driven and processes");
        System.out.println("                                    returned vehicle and displays total charge");
        System.out.println("8 - Quit");
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
	
	private String getVIN(Scanner input) {
		System.out.println("Enter the VIN for a vehicle:");
		String vin = input.next();
		return vin;
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

	private RentalDetails getRentalDetails(Scanner input) {
		int vehicleType, numMilesDriven;
		char timeChar; int timeNum = 0;
		TimeSpan time;
		boolean insur, primeCust, stop = false;
		RentalDetails rentDetails = null;
		
		while(!stop) {
			vehicleType = getVehicleType(input);
			System.out.println("Please enter a the estimated miles to be driven");
			numMilesDriven = input.nextInt();
			System.out.println("Please enter the amount of days, weeks, or months you will be using the vehicle:");
			System.out.println("d - days, w- weeks, m - months");
			timeChar = input.next().charAt(0);
			System.out.println("The amount of the time unit selected");
			timeNum = input.nextInt();
			System.out.println("Please enter 'true' if you selected insurance, or 'false' if you did not:");
			insur = input.nextBoolean();
			System.out.println("Please enter 'true' if you are a prime customer, or 'false' if you are not:");
			primeCust = input.nextBoolean();
			time = new TimeSpan(timeChar, timeNum);
			rentDetails = new RentalDetails(vehicleType, numMilesDriven, time, insur, primeCust);
			if(rentDetails != null) {
				stop = true;
			}
		}
		return rentDetails;
	}
	
	private ReservationDetails getReservationDetails(Scanner input) {
		String vin, creditCardNum;
		char timeChar; int timeNum = 0;
		TimeSpan time;
		boolean insur, stop = false;
		ReservationDetails resvDetails = null;
		
		while(!stop) {
			System.out.println("Please enter the VIN of the vehicle");
			vin = input.next();
			System.out.println("Please enter the Credit Card Number");
			creditCardNum = input.next();
			System.out.println("Please enter the amount of days, weeks, or months you will be using the vehicle:");
			System.out.println("d - days, w- weeks, m - months");
			timeChar = input.next().charAt(0);
			System.out.println("The amount of the time unit selected");
			timeNum = input.nextInt();
			System.out.println("Please enter 'true' if you selected insurance, or 'false' if you did not:");
			insur = input.nextBoolean();
			System.out.println("Please enter 'true' if you are a prime customer, or 'false' if you are not:");
			time = new TimeSpan(timeChar, timeNum);
			resvDetails = new ReservationDetails(vin, creditCardNum, time, insur);
			if(resvDetails != null) {
				stop = true;
			}
		}
		return resvDetails;
	}
	
	private void displayResults(String[] lines) {
		for(String line: lines) {
			System.out.println(line);
		}
	}
}
