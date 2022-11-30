/*
 * Ethan Gentner 
*/
package finalProj;

public class CarRates extends VehicleRates {

	public CarRates(double daily, double weekly, double monthly, double mileage, double insur) {
		super(daily, weekly, monthly, mileage, insur);
	}

	public String toString() {
		return ("Daily Rate: $" + getDailyRate() + ", Weekly Rate: $" + getWeeklyRate() + ", Monthly Rate: $" + getMonthlyRate() 
				+ ", Cost Per Mile: $" + getMileageCharge() + ", Daily Insurance Cost: $" + getDailyInsurRate());
	}
}
