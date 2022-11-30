/* 
 * Ethan Gentner 
*/
package finalProj;

public abstract class Vehicle {
	//Instance variables
		private String description;
		private int mpg;
		private String vin;
		private Reservation resv;
		private VehicleRates rates;
		
		
		//Constructor
		public Vehicle(String description, int mpg, String vin) {
			this.description = description;
			this.mpg = mpg;
			this.vin = vin;
			this.resv = null;
			rates = null;
		}
		
		//Getter Methods
		public String getDescription() {
			return description;
		}
		public int getMpg() {
			return mpg;
		}
		public String getVIN() {
			return vin;
		}
		
		//ToString for each vehicle type
		public abstract String toString();
		
		//Other Methods
		public Reservation getReservation() throws UnreservedVehicleException{
			if(resv == null) {
				throw new UnreservedVehicleException();
			}
			return resv;
		}
		
		public boolean isReserved() {
			if(resv == null) {
				return false;
			}
			return true;
		}
		
		public void reserve(Reservation r) throws ReservedVehicleException{
			if(resv != null) {
				throw new ReservedVehicleException();
			}
			else {
				this.resv = r;
			}
		}
		
		public void cancelReservation() throws UnreservedVehicleException{
			if(resv == null) {
				throw new UnreservedVehicleException();
			}
			else {
				resv = null;
				System.out.println("Reservation Canceled");
			}
		}
		
		public VehicleRates getQuotedRates() {
			return rates;
		}
		
		public void setQuotedRates(VehicleRates newRate) {
			rates = newRate;
		}
	}
