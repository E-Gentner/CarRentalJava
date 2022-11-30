/*
 * Ethan Gentner 
*/
package finalProj;

import java.util.ArrayList;

public class Transactions {
	private ArrayList<Transaction> transactions;
	private int current;
	
	public Transactions() {
		transactions = new ArrayList<>(); 
		current = 0;
	}
	
	public void add (Transaction tran) {
		transactions.add(tran);
	}
	
	//Iterators
	public void reset() {
		current = 0;
	}
	
	public boolean hasNext() {
		if(current < transactions.size()) {
			if (transactions.get(current) != null) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	
	public Transaction getNext() {
		Transaction transaction = transactions.get(current);
		if(hasNext()) {
			current++;
		}
		return transaction;
	}
}
