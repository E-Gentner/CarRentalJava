/*
 * Ethan Gentner 
*/
package finalProj;

public class Suv extends Vehicle{
	private int seatingCapacity;
	private int cargoCapacity;

	public Suv(String description, int mpg, int seatingCapacity, int cargoCapacity, String vin) {
		super(description, mpg, vin);
		this.seatingCapacity = seatingCapacity;
		this.cargoCapacity = cargoCapacity;
	}

	public String toString() {
		return (getDescription() + "(Car)    MPG:" + getMpg() +
				"    Seating: " + seatingCapacity + "    Storage: " + cargoCapacity + "cu. ft.    Vin:" + getVIN());
	}
}
