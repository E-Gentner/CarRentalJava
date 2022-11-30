/*
 * Ethan Gentner 
*/
package finalProj;

public class CurrentRates {
	private VehicleRates[] rates = new VehicleRates[3];

	public CurrentRates(CarRates carRate, SUVRates suvRate, TruckRates truckRate) {
		rates[0] = carRate;
		rates[1] = suvRate;
		rates[2] = truckRate;
	}
	
	
	public VehicleRates getCarRates() {
		return rates[0];
	}
	
	public VehicleRates getSUVRates() {
		return rates[1];
	}
	
	public VehicleRates getTruckRates() {
		return rates[2];
	}
	
	public void setCarRates(VehicleRates r) {
		rates[0] = r;
	}
	
	public void setSUVRates(VehicleRates r) {
		rates[1] = r;
	}
	
	public void setTruckRates(VehicleRates r) {
		rates[2] = r;
	}
	
	
	public double calcEstimatedCost(int vehicleType, TimeSpan estimatedRentalPeriod, int estimatedNumMiles,
									boolean dailyInsur, boolean primeCustomer) {
		double estCost = 0;
		int miles = 0;
		double insurCost = 0;
		int estDays = 0;
		
		//Calculate days from Timespan object
		if(estimatedRentalPeriod.getTimeUnit() == 'w' || estimatedRentalPeriod.getTimeUnit() == 'W') {
			estDays = estimatedRentalPeriod.getNumUnits() * 7;
		}
		else if(estimatedRentalPeriod.getTimeUnit() == 'm' || estimatedRentalPeriod.getTimeUnit() == 'M') {
			estDays = estimatedRentalPeriod.getNumUnits() * 30;
		}
		else {
			estDays = estimatedRentalPeriod.getNumUnits();
		}
		
		//Estimated Cost from days
		estCost = estCost + (rates[vehicleType].getDailyRate() * estDays);
		
		//Insurance Cost
		if(dailyInsur == true) {
			insurCost = estDays * rates[vehicleType].getDailyInsurRate();
			estCost = estCost + insurCost;
		}
		
		//Prime Customer and estimated miles driven cost
		if(primeCustomer == true) {
			if(estimatedNumMiles >= 100) {
				miles = estimatedNumMiles - 100;
				estCost = estCost + (miles * rates[vehicleType].getMileageCharge());
			}
		}
		else {
			miles = estimatedNumMiles;
			estCost = estCost + (miles * rates[vehicleType].getMileageCharge());
		}
		return estCost;
	}
	
	public double calcActualCost(VehicleRates rates, int numDaysUsed, int numMilesDriven,
								 boolean dailyInsur, boolean primeCustomer) {
		double totalCost = 0;
		int miles = 0;
		double insurCost = 0;
		double weeklyProrate = rates.getWeeklyRate()/7;
		double monthlyProrate = rates.getMonthlyRate()/30;
		
		//Time used cost
		if(numDaysUsed < 7) {
			totalCost = totalCost + (rates.getDailyRate() * numDaysUsed);
		}
		else if(numDaysUsed >= 7 && numDaysUsed < 30) {
			//Calculates weekly cost then prorated cost
			totalCost = totalCost + ((numDaysUsed/7) * rates.getWeeklyRate());
			totalCost = totalCost + ((numDaysUsed%7) * weeklyProrate);
		}
		else {
			//Calculates monthly cost then prorated cost
			totalCost = totalCost + ((numDaysUsed/30) * rates.getMonthlyRate());
			totalCost = totalCost + ((numDaysUsed%30) * monthlyProrate);
		}
			
		//Insurance Cost
		if(dailyInsur == true) {
			insurCost = numDaysUsed * rates.getDailyInsurRate();
			totalCost = totalCost + insurCost;
		}
		
		//Prime Customer and miles driven cost
		if(primeCustomer == true) {
			if(numMilesDriven >= 100) {
				miles = numMilesDriven - 100;
				totalCost = totalCost + (miles * rates.getMileageCharge());
			}
		}
		else {
			miles = numMilesDriven;
			totalCost = totalCost + (miles * rates.getMileageCharge());
		}
		return totalCost;
	}
}
