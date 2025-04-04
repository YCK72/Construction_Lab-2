public class AltVehicleInspection implements IVehicleInspector {
    
    @Override
    public int visit(Car car) {
        int serviceCharge = 0;
        if(car.getColor()=="Black"){
            serviceCharge += 150;
        }else{
            serviceCharge += 55;
        }
        System.out.println("Service Charge for Car: " + serviceCharge);
        return serviceCharge;
    }

    @Override
    public int visit(Van van) {
        int serviceCharge = 0;
        if(van.getNumberOfDoors()>4){
            serviceCharge += 750;
        }else{
            serviceCharge += 150;
        }
        System.out.println("Service Charge for Van: " + serviceCharge);
        return serviceCharge;
    }

    @Override
    public int visit(Motorbike motorbike) {
        int serviceCharge = 0;
        if(motorbike.getEngineCapacity()>=200){
            serviceCharge += 450;
        }else{
            serviceCharge += 100;
        }
        System.out.println("Service Charge for Motorbike: " + serviceCharge);
        return serviceCharge;
    }
}
