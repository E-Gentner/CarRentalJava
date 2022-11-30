/*
 * Ethan Gentner 
*/
package finalProj;

public class Account {
	//Initial Variables
	private String creditcard_num;
	private String company_name;
	private boolean prime_customer;
	
	//Constructor
	public Account(String creditcard_num, String company_name, boolean prime_customer) {
		this.creditcard_num = creditcard_num;
		this.company_name = company_name;
		this.prime_customer = prime_customer;
	}
	
	//Methods
	public String getCreditCardNum() {
		return creditcard_num;
	}
	
	public String getCompanyName() {
		return company_name;
	}
	
	public boolean getPrimeCustomer() {
		return prime_customer;
	}
	
	public String toString() {
		return (company_name + "(Card #: " + creditcard_num + "), Prime Customer: " + prime_customer);
	}
}
