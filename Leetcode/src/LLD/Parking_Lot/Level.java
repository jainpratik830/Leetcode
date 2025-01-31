package LLD.Parking_Lot;

import LLD.Parking_Lot.Vehicle.Vehicle;
import LLD.Parking_Lot.Vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Level {

    private final List<ParkingSpot> parkingSpots;
    private final int level;


    public Level( int level,int bikeSpots,int carSpots,int truckSpots) {
        int i=0;
        int totolSpots = bikeSpots+carSpots+truckSpots;
        parkingSpots= new ArrayList<>(totolSpots);
        for (int j=0;j<carSpots;j++){
            parkingSpots.add(new ParkingSpot(i, VehicleType.CAR));
            i++;
        }
        for (int j=0;j<bikeSpots;j++){
            parkingSpots.add(new ParkingSpot(i, VehicleType.MOTORCYCLE));
            i++;
        }
        for (int j=0;j<truckSpots;j++){
            parkingSpots.add(new ParkingSpot(i, VehicleType.TRUCK));
            i++;
        }
        this.level = level;
    }

    public synchronized boolean parkVehicle(Vehicle vehicle){
        for (ParkingSpot p:parkingSpots){
            if (p.isAvailable() && p.getVehicleType()==vehicle.getVehicleType()){
                p.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unParkVehicle(Vehicle vehicle){
        for (ParkingSpot p:parkingSpots){
            if (!p.isAvailable() && p.vehicle.equals(vehicle)){
                p.unParkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public void displayAvailability(){
        System.out.println("Level "+level+" Availability:");
        for (ParkingSpot p:parkingSpots){
            System.out.println("Spot Number: "+p.getSpotNumber()+" "+ (p.isAvailable() ? "Is Available For": ("Occupied By ")+p.getVehicleType()));

        }
    }


}
