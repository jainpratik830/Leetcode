package LLD.Parking_Lot;

import LLD.Parking_Lot.Vehicle.Vehicle;
import LLD.Parking_Lot.Vehicle.VehicleType;

public class ParkingSpot {

    private final int spotNumber;
    private final VehicleType vehicleType;
    public Vehicle vehicle;

    public ParkingSpot(int spotNumber, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public synchronized void parkVehicle(Vehicle vehicle){
        if (isAvailable() && vehicle.getVehicleType() == vehicleType) {
            this.vehicle = vehicle;
        } else {
            throw new IllegalArgumentException("Invalid vehicle type or spot already occupied.");
        }

    }

    public synchronized void unParkVehicle(Vehicle vehicle){
        this.vehicle=null;
    }

    public VehicleType getVehicleType(){
        return this.vehicleType;
    }

    public int getSpotNumber() {
        return spotNumber;
    }
}
