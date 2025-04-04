public class Van implements IVehicle {
    private int storageCapacity;
    private int numberOfDoors;

    public Van(int storageCapacity, int numberOfDoors) {
        this.storageCapacity = storageCapacity;
        this.numberOfDoors = numberOfDoors;
    }
    public int getStorageCapacity() {
        return storageCapacity;
    }
    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }
    public int getNumberOfDoors() {
        return numberOfDoors;
    }
    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
    @Override
    public int accept(IVehicleInspector vehicleInspector) {
        return vehicleInspector.visit(this);
    }
}
