public class Act3VehicleService {
    private static Act3VehicleService instance;
    private IVehicleInspector inspector;
    private IEmissionsStrategy emissionsStrategy;

    private Act3VehicleService() {}

    static {
        instance = new Act3VehicleService();
        String inspectorType = System.getProperty("vi", "default");
        String emissionsStrategyType = System.getProperty("es", "null");
        instance.inspector = VehicleFactory.getVehicleInspector(inspectorType);
    switch (emissionsStrategyType) {
        case "one":
            instance.emissionsStrategy = new OneEmissionsStrategy();
            break;
        case "two":
            instance.emissionsStrategy = new TwoEmissionsStrategy();
            break;
        default:
            instance.emissionsStrategy = new NullEmissionsStrategy();
            break;
        }   
    }
    public static Act3VehicleService getInstance()  {
        return instance;
    }
        
        /* Returns the total Service charge for all the vehicles
        that have gone through a full Service process */
    public int calculateTotal(IVehicle[] vehicles) {
        int total = 0;
        for(IVehicle vehicle : vehicles){
            total += emissionsStrategy.computeEmissionsFee(vehicle) + vehicle.accept(inspector);
        }
        return total;
    }
}
