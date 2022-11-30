/*
 * Ethan Gentner 
*/
package finalProj;

public class ReservationDetails {
	String VIN;
	String creditCardNum;
	TimeSpan rentalPeriod;
	boolean insurance;

	public ReservationDetails(String VIN, String creditCardNum, TimeSpan rentalPeriod, boolean insurance){
		this.VIN = VIN;
	    this.creditCardNum = creditCardNum;
	    this.rentalPeriod = rentalPeriod;
	    this.insurance = insurance;
	}

	public String getVIN() {
		return VIN;
	}

	public String getCreditCardNum() {
		return creditCardNum;
	}

	public TimeSpan getRentalPeriod() {
		return rentalPeriod;
	}

	public boolean getInsurance() {
		return insurance;
	}
}
