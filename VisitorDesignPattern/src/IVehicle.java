public interface IVehicle {
    // Every vehicle that has gone under a full service
    // is supposed to let the Vehicle Inspector to calculate
    // the total Service Charge.
    int accept(IVehicleInspector vehicleInspector);
}
