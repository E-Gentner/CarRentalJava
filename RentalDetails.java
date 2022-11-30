/*
 * Ethan Gentner 
*/
package finalProj;

public class RentalDetails
{
   int vehicleType;
   int numMilesDriven;
   TimeSpan rentalPeriod;
   boolean insurance;
   boolean primeCust;

   public RentalDetails(int vehicleType, int numMilesDriven, TimeSpan rentalPeriod, boolean insurance, boolean primeCust)
   {
       this.vehicleType = vehicleType;
       this.numMilesDriven = numMilesDriven;
       this.rentalPeriod = rentalPeriod;
       this.insurance = insurance;
       this.primeCust = primeCust;
   }

   public int getVehicleType()
   {
       return vehicleType;
   }

   public int getNumMilesDriven()
   {
       return numMilesDriven;
   }

   public TimeSpan getTimePeriod()
   {
       return rentalPeriod;
   }

   public boolean getInsurance()
   {
       return insurance;
   }

   public boolean getPrimeCustomer()
   {
       return primeCust;
   }
}