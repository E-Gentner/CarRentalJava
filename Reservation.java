/*
** Ethan Gentner
*/
package finalProj;

public class Reservation {
	//Instance variables
	private String companyName;
	private String creditCardNum;
	private TimeSpan rentalPeriod;
	private boolean insuranceSelected;
	
	//Constructor
	public Reservation(String companyName, String creditCardNum, TimeSpan rentalPeriod, boolean insuranceSelected) {
		this.companyName = companyName;
		this.creditCardNum = creditCardNum;
		this.rentalPeriod = rentalPeriod;
		this.insuranceSelected = insuranceSelected;
	}
	
	//Getter Methods
	public String getName() {
		return companyName;
	}
	
	public String getCreditCard() {
		return creditCardNum;
	}
	
	public TimeSpan getRentalPeriod() {
		return rentalPeriod;
	}
	
	public boolean getInsurance() {
		return insuranceSelected;
	}
	
	public String toString() {
		return "Reservation: Name: " + getName() + " CreditCardNumber: " + getCreditCard()
		+ "Rental Period: " + getRentalPeriod() + " Insurance: " + getInsurance();
	}
}
