public class AltVehicleService {
    
    IVehicleInspector inspector;

    public AltVehicleService(String prop) {
	// PROBLEM 1: We are new'ing up a specific implementation
	// of our Inspection Service - you know how to fix this!
	inspector = VehicleFactory.getVehicleInspector(prop);
    }
    
    /* Returns the total Service charge for all the vehicles
       that have gone through a full Service process */
    public int calculateTotal(IVehicle[] vehicles) {
        int total = 0;
        for(IVehicle vehicle : vehicles){
            total = total + vehicle.accept(inspector);
        }
        return total;
    }
}
