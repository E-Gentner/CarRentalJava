/*
 * Ethan Gentner 
*/
package finalProj;

public abstract class VehicleRates {
	private double daily_rate;
	private double weekly_rate;
	private double monthly_rate;
	private double mileage_charge;
	private double daily_insur_rate;
	
	
	public VehicleRates(double daily_rate, double weekly_rate, double monthly_rate, double mileage_charge,
						double daily_insur_rate) {
		this.daily_rate = daily_rate;
		this.weekly_rate = weekly_rate;
		this.monthly_rate = monthly_rate;
		this.mileage_charge = mileage_charge;
		this.daily_insur_rate = daily_insur_rate;
	}


	public double getDailyRate() {
		return daily_rate;
	}


	public double getWeeklyRate() {
		return weekly_rate;
	}


	public double getMonthlyRate() {
		return monthly_rate;
	}


	public double getMileageCharge() {
		return mileage_charge;
	}


	public double getDailyInsurRate() {
		return daily_insur_rate;
	}
	
	public abstract String toString();
}
