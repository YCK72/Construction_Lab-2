public class Act2VehicleService {
    private static Act2VehicleService instance;
    private IVehicleInspector inspector;

    private Act2VehicleService() {}

    static {
        instance = new Act2VehicleService();
        String inspectorType = System.getProperty("vi", "default");
        instance.inspector = VehicleFactory.getVehicleInspector(inspectorType);
    }
    public static Act2VehicleService getInstance()  {
        return instance;
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
