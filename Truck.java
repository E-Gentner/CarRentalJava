/*
 * Ethan Gentner 
*/
package finalProj;

public class Truck extends Vehicle{
	int loadCapacity;

	public Truck(String description, int mpg, int loadCapacity, String vin) {
		super(description, mpg, vin);
		this.loadCapacity = loadCapacity;
	}

	public String toString() {
		return (getDescription() + "(Car)    MPG: " + getMpg() + 
				"    Load Capacity: " + loadCapacity+ "    Vin:" + getVIN());
	}
}
