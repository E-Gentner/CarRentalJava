/*
 * Ethan Gentner 
*/
package finalProj;

public class TimeSpan {
	//Instance variables
		private char timeUnit;
		private int numUnits;
		
		//Constructor
		public TimeSpan(char timeUnit, int numUnits) {
			this.timeUnit = timeUnit;
			this.numUnits = numUnits;
		}
		
		//Getter Methods
		public char getTimeUnit() {
			return timeUnit;
		}
		
		public int getNumUnits() {
			return numUnits;
		}
}
