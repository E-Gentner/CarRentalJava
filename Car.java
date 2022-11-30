/*
 * Ethan Gentner 
*/
package finalProj;

public class Car extends Vehicle {
	private int seatingCapacity;
	
	public Car(String description, int mpg, int seatingCapacity, String vin) {
		super(description, mpg, vin);
		this.seatingCapacity = seatingCapacity;
	}

	public String toString() {
		return (getDescription() + "(Car)    MPG:" + getMpg() +
				"    Seating: " + seatingCapacity + "    Vin:" + getVIN());
	}
}
