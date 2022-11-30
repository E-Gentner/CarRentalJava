/*
 * Ethan Gentner 
*/
package finalProj;

public class VehicleNode {
    private Vehicle veh;
    private VehicleNode next;
	
    public VehicleNode(Vehicle veh, VehicleNode next){
    this.veh = veh;
    this.next = next;
	}
    
	public Vehicle getVeh(){
		return veh;
    }
	
	public VehicleNode getNext(){
		return next;
    }
	
	public void setNext(VehicleNode nextNode){
		next = nextNode;
	}
}
