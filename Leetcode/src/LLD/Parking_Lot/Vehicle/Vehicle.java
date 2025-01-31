package LLD.Parking_Lot.Vehicle;

public abstract class Vehicle {

    protected VehicleType vehicleType;
    protected String licensePlate;

    public Vehicle(String licensePlate,VehicleType vehicleType){
        this.vehicleType= vehicleType;
        this.licensePlate=licensePlate;
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }


}
