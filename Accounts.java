/*
 * Ethan Gentner 
*/
package finalProj;

import java.util.ArrayList;

public class Accounts {
	//Array list
	private ArrayList<Account> accounts;
	private int current;
	
	//Constructor
	public Accounts() {
		accounts = new ArrayList<>();
		current = 0;
	}
	
	//Methods
	public void add(Account acct) {
		accounts.add(acct);
	}
	
	public Account getAccount(String creditcard_num) {
		Account tempAcct = null;
		for(Account acct: accounts) {
			if(acct.getCreditCardNum().equals(creditcard_num)) {
				tempAcct = acct;
			}
		}
		return tempAcct;
	}
	
	//Iterators
	public void reset() {
		current = 0;
	}
	
	public boolean hasNext() {
		int b = 0;
		for(Account acct: accounts) {
			if (acct != null) {
				b++;
			}
		}
		return current < b;
	}
	
	public Account getNext() {
		Account account = accounts.get(current);
		if(hasNext()) {
			current++;
		}
		return account;
	}
}
