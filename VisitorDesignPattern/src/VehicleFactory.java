public class VehicleFactory {
    
    private VehicleFactory() {}
    
    public static IVehicleInspector getVehicleInspector(String prop) {
        if ("alt".equals(prop)) {
            return new AltVehicleInspection();
        } else {
            return new VehicleInspection();
        }
    }
}
