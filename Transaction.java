/*
 * Ethan Gentner 
*/
package finalProj;

public class Transaction {
	//Initial Variables
	private String creditcard_num;
	private String company_name;
	private String vehicle_type;
	private String rental_period;
	private String miles_driven;
	private String rental_cost;
	
	//Constructor
	public Transaction(String creditcard_num, String company_name, String vehicle_type,
						String rental_period, String miles_driven, String rental_cost) {
		this.creditcard_num = creditcard_num;
		this.company_name = company_name;
		this.vehicle_type = vehicle_type;
		this.rental_period = rental_period;
		this.miles_driven = miles_driven;
		this.rental_cost = rental_cost;
	}
	
	//To String
	public String toString() {
		return (company_name + "(card # " + creditcard_num + "), Car: " + vehicle_type +", " +
				rental_period + ", " + miles_driven + " mi., $" + rental_cost);
	}
}
