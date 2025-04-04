public class Motorbike implements IVehicle {
    private int engineCapacity;
    private String brand;

    public Motorbike(int engineCapacity, String brand) {
        this.engineCapacity = engineCapacity;
        this.brand = brand;
    }
    public int getEngineCapacity() {
        return engineCapacity;
    }
    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    @Override
    public int accept(IVehicleInspector vehicleInspector) {
        return vehicleInspector.visit(this);
    }
}
