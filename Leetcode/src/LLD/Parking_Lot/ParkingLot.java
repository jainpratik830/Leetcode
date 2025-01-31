package LLD.Parking_Lot;

import LLD.Parking_Lot.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private final List<Level> levels;
    private static ParkingLot parkingLotInstance;

    private ParkingLot(){
        levels= new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance() {
        if (parkingLotInstance == null) {
            parkingLotInstance = new ParkingLot();
        }
        return parkingLotInstance;
    }

    public void addLevel(Level level){
        this.levels.add(level);
    }

    public boolean parkVehicle(Vehicle vehicle){
        for (Level level:levels){
            if (level.parkVehicle(vehicle)){
                System.out.println("Vehicle Parked Sucessfully");
                return true;
            }
        }

        System.out.println("No Spots Availavble!!");
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.unParkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        for (Level level : levels) {
            level.displayAvailability();
        }
    }

}
