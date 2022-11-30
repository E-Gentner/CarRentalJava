/*
 * Ethan Gentner 
*/
package finalProj;

public class Vehicles{

    private VehicleNode head;
    private VehicleNode current;

    public Vehicles(){
        head = null;
        current = null;
    }

    public void add(Vehicle veh){
    	if(head == null) {
    		head = new VehicleNode(veh, null);
    	}
    	else {
    		VehicleNode tempNode = head;
    		while(tempNode.getNext() != null) {
    			tempNode = tempNode.getNext();
    		}
    		tempNode.setNext(new VehicleNode(veh, null));
    	}
    }
    
    public Vehicle getVehicle(String vin) throws VinNotFoundException{
    	VehicleNode tempPtr = head;
    	if(head == null) {
    		throw new VinNotFoundException();
    	}
    	else {
    		while(tempPtr.getNext() != null) {
    			if(tempPtr.getVeh().getVIN().equalsIgnoreCase(vin)) {
    		    	Vehicle tempVeh = tempPtr.getVeh();
    		    	return tempVeh;
    			}
    			tempPtr = tempPtr.getNext();
    		}
    		throw new VinNotFoundException();
    	}
    }

    public void reset(){
        current = head;
    }

    public boolean hasNext(){
        if(current == null){
            return false;
        }
        return true;
    }

    public Vehicle getNext(){
    	Vehicle tempVeh = current.getVeh();
    	current = current.getNext();
    	return tempVeh;
    }

}
