public class VehicleService {
    IVehicleInspector inspector;

    // Using Dependency Injection (DI) to decouple the inspector
    VehicleService(IVehicleInspector inspector) {
        this.inspector = inspector;
    }
    
    /* Returns the total Service charge for all the vehicles
       that have gone through a full Service process */
    public int calculateTotal(IVehicle[] vehicles) {
        int total = 0;
        for(IVehicle vehicle : vehicles){
            total += vehicle.accept(inspector);
        }
        return total;
    }
}
