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
    public float co2Emissions() {
        return 8887 * (1 + (0.1f * (numberOfDoors - 2)));
    }
    @Override
    public int accept(IVehicleInspector vehicleInspector) {
        return vehicleInspector.visit(this);
    }
    @Override
    public String toString() {
        return "Van [Storage Capacity=" + storageCapacity + ", Number Of Doors=" + numberOfDoors + "]";
    }
}
