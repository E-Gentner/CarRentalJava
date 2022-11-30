/*
 * Ethan Gentner 
*/
package finalProj;

public class SystemInterface {
	//Initial variables and Constructor
	private static CurrentRates veh_rates;
	private static Vehicles vehs;
	private static Accounts accts;
	private static Transactions trans;
  
	public static void initSystem(CurrentRates r, Vehicles v,
								  Accounts a, Transactions t){
		veh_rates = r;
		vehs = v;
		accts = a;
		trans = t;
	}
		
	
	//Rates Methods
	public static String[] getCarRates() {
		String[] vehRates = new String[1];
		vehRates[0] = veh_rates.getCarRates().toString();  
		return vehRates;
	}
	public static String[] getSuvRates() {
		String[] vehRates = new String[1];
		vehRates[0] = veh_rates.getSUVRates().toString();  
		return vehRates;
	}
	public static String[] getTruckRates() {
		String[] vehRates = new String[1];
		vehRates[0] = veh_rates.getTruckRates().toString();  
		return vehRates;
	}
	public static String[] updateCarRates(VehicleRates r) {
		String[] vehRates = new String[1];
		veh_rates.setCarRates(r);
		if(veh_rates.getCarRates() == r) {
			vehRates[0] = "Car Rates update confrimed: " + veh_rates.getCarRates();
		}
		else {
			vehRates[0] = "Car Rates failed to update";
		}
		return vehRates;
	}
	public static String[] updateSuvRates(VehicleRates r) {
		String[] vehRates = new String[1];
		veh_rates.setSUVRates(r);
		if(veh_rates.getSUVRates() == r) {
			vehRates[0] = "SUV Rates update confrimed: " + veh_rates.getSUVRates();
		}
		else {
			vehRates[0] = "SUV Rates failed to update";
		}		
		return vehRates;
	}
	public static String[] updateTruckRates(VehicleRates r) {
		String[] vehRates = new String[1];
		veh_rates.setTruckRates(r);
		if(veh_rates.getTruckRates() == r) {
			vehRates[0] = "Truck Rates update confrimed: " + veh_rates.getCarRates();
		}
		else {
			vehRates[0] = "Truck Rates failed to update";
		}
		return vehRates;
	}

	public static String[] estimatedRentalCost(RentalDetails renDetails) {
		String[] vehRates = new String[1];
		if(renDetails != null) {
			vehRates[0] = Double.toString(veh_rates.calcEstimatedCost(renDetails.getVehicleType(),
					                      renDetails.getTimePeriod(), renDetails.getNumMilesDriven(),
					                      renDetails.getInsurance(), renDetails.getPrimeCustomer()));
		}
		else {
			vehRates[0] = "No rental details found";
		}
		return vehRates;
	}
	public static String[] processReturnedVehicle(String vin, int num_days_used, int num_miles_driven) throws VinNotFoundException, UnreservedVehicleException {
		String[] vehRates = new String[1];
		Vehicle v = vehs.getVehicle(vin);
		Reservation res =  v.getReservation();
		String creditCardNum = res.getCreditCard();
		
		Account acct = null;
		boolean primeCust = false;
		boolean insur = false;
		if(accts.getAccount(creditCardNum) != null) {
			acct = accts.getAccount(creditCardNum);
			primeCust = acct.getPrimeCustomer();
			insur = res.getInsurance();
		}
		double cost = veh_rates.calcActualCost(v.getQuotedRates(), num_days_used, num_miles_driven, insur, primeCust);
		trans.add(new Transaction(creditCardNum, acct.getCompanyName(), v.getDescription(),
								  Integer.toString(num_days_used), Integer.toString(num_miles_driven), Double.toString(cost)));
		vehRates[0] = "Total Charge for VIN " + vin + " for " + num_days_used + " days, " + num_miles_driven + " miles @ " + 
					   v.getQuotedRates().getMileageCharge() + "/mile and daily insurance @ " + v.getQuotedRates().getDailyRate() + 
					   "/day (with 100 miles credit as Prime Customer) = $" + cost;
		return vehRates;
	}
	
	//Vehicle Methods
	public static String[] getAvailCars(){
		Vehicle v;
		int num_vehicles = 0;
		vehs.reset();
		while(vehs.hasNext()){
			v = vehs.getNext();
		    if(v instanceof Car && !v.isReserved())
		    	num_vehicles = num_vehicles + 1;
		    }
		String[] results = new String[num_vehicles];
		vehs.reset();
		int i = 0;
		while(vehs.hasNext()){
			v = vehs.getNext();
			if(v instanceof Car && !v.isReserved()){
				results[i] = v.toString();
		        i = i + 1;
		    }
		}
		return results;
	}
	public static String[] getAvailSUVs(){
		Vehicle v;
		int num_vehicles = 0;
		vehs.reset();
		while(vehs.hasNext()){
			v = vehs.getNext();
		    if(v instanceof Suv && !v.isReserved())
		    	num_vehicles = num_vehicles + 1;
		    }
		String[] results = new String[num_vehicles];
		vehs.reset();
		int i = 0;
		while(vehs.hasNext()){
			v = vehs.getNext();
			if(v instanceof Suv && !v.isReserved()){
				results[i] = v.toString();
		        i = i + 1;
		    }
		}
		return results;
	}
	public static String[] getAvailTrucks(){
		Vehicle v;
		int num_vehicles = 0;
		vehs.reset();
		while(vehs.hasNext()){
			v = vehs.getNext();
		    if(v instanceof Truck && !v.isReserved())
		    	num_vehicles = num_vehicles + 1;
		    }
		String[] results = new String[num_vehicles];
		vehs.reset();
		int i = 0;
		while(vehs.hasNext()){
			v = vehs.getNext();
			if(v instanceof Truck && !v.isReserved()){
				results[i] = v.toString();
		        i = i + 1;
		    }
		}
		return results;
	}
	public static String[] getAllVehicles(){
		Vehicle v;
		int num_vehicles = 0;
		vehs.reset();
		while(vehs.hasNext()){
			v = vehs.getNext();
		    if(v instanceof Vehicle) {
		    	num_vehicles = num_vehicles + 1;
		    }
		}
		String[] results = new String[num_vehicles];
		vehs.reset();
		int i = 0;
		while(vehs.hasNext()){
			v = vehs.getNext();
			if(v instanceof Vehicle){
				results[i] = v.toString();
		        i = i + 1;
		    }
		}
		return results;
	}
	
	//Reservation Methods
	public static String[] makeReservation(ReservationDetails resDetails) throws VinNotFoundException, ReservedVehicleException {
		String[] reservation = new String[1];
		Vehicle v = vehs.getVehicle(resDetails.getVIN());
		Reservation res  = new Reservation(resDetails.getVIN(), resDetails.getCreditCardNum(), resDetails.getRentalPeriod(), resDetails.getInsurance());
		v.reserve(res);
		
		if(v instanceof Car) {
			v.setQuotedRates(veh_rates.getCarRates());
		}
		else if(v instanceof Suv) {
			v.setQuotedRates(veh_rates.getSUVRates());
		}
		else if(v instanceof Truck) {
			v.setQuotedRates(veh_rates.getTruckRates());
		}
		
		//Displays COnfirmation message
		if(v.isReserved()) {
			reservation[0] = "Vehicle " + v + "is now Reserved.";
		}
		else {
			reservation[0] = "There was an error during the reservation.";
		}
		
		return reservation;
	}
	public static String[] cancelReservation(String vin) throws VinNotFoundException, UnreservedVehicleException {
		String[] reservation = new String[1];
		Vehicle v = vehs.getVehicle(vin);
		
		if(v.isReserved()) {
			reservation[0] = "Reservation for VIN: " + vin + ", was canceled.";
		}
		else {
			reservation[0] = "The vehicle with VIN: " + vin + ", there is no reservation for the Vehicle";
		}
		return reservation;
	}
	public static String[] getReservation(String vin) throws VinNotFoundException, UnreservedVehicleException{
		String[] reservation = new String[1];
		Vehicle v = vehs.getVehicle(vin);
		if(v.isReserved()) {
			reservation[0] = v.getReservation().toString();
		}
		else {
			reservation[0] = "The Vehicle with the VIN " + vin+ "is not currently reserved.";
		}
		return reservation;
	}
	public static String[] getAllReservations() {
		Vehicle v;
		int num_vehicles = 0;
		vehs.reset();
		while(vehs.hasNext()){
			v = vehs.getNext();
		    if(v.isReserved()) {
		    	num_vehicles = num_vehicles + 1;
		    }
		}
		String[] reservations = new String[num_vehicles];
		vehs.reset();
		int i = 0;
		while(vehs.hasNext()){
			v = vehs.getNext();
			if(v.isReserved()){
				reservations[i] = v.toString();
		        i = i + 1;
		    }
		}
		return reservations;
	}

	//Customer Accounts Methods
	public static String[] addAccount(String creditcard_num, String company_name, boolean prime_cust) {
		String[] acct = new String[1];
		Account account = new Account(creditcard_num, company_name, prime_cust);
		accts.add(account);
		
		acct[0] = "New account added, " + account.toString();
		return acct;
	}
	public static String[] getAccount(String creditcard_num) {
		String[] acct = new String[1];
		acct[0] = accts.getAccount(creditcard_num).toString();
		return acct;
	}
	public static String[] getAllAccounts() {
		Account a;
		int num_accounts = 0;
		accts.reset();
		while(accts.hasNext()){
			a = accts.getNext();
		    if(a instanceof Account) {
		    	num_accounts = num_accounts + 1;
		    }
		}
		String[] acct = new String[num_accounts];
		accts.reset();
		int i = 0;
		while(accts.hasNext()){
			a = accts.getNext();
			if(a instanceof Account){
				acct[i] = a.toString();
		        i = i + 1;
		    }
		}
		return acct;
	}
	
	//Transactions Methods
	public static String[] addTransaction(String creditcard_num, String company_name, String vehicle_type,
										  String rental_period, String miles_driven, String rental_cost) {
		String[] transac = new String[1];
		Transaction newTrans = new Transaction(creditcard_num, company_name, vehicle_type, rental_period, miles_driven, rental_cost);
		transac[0] = newTrans.toString();
		return transac;
	}
	public static String[] getAllTransactions() {
		Transaction t;
		int numTransac = 0;
		trans.reset();
		while(trans.hasNext()){
			t = trans.getNext();
		    if(t instanceof Transaction) {
		    	numTransac = numTransac+ 1;
		    }
		}
		String[] allTransac = new String[numTransac];
		trans.reset();
		int i = 0;
		while(trans.hasNext()){
			t = trans.getNext();
			if(t instanceof Transaction){
				allTransac[i] = t.toString();
		        i = i + 1;
		    }
		}
		return allTransac;
	}

}
