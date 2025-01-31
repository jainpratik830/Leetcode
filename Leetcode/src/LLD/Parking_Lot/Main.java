package LLD.Parking_Lot;

import LLD.Parking_Lot.Vehicle.Car;
import LLD.Parking_Lot.Vehicle.Motorcycle;
import LLD.Parking_Lot.Vehicle.Truck;
import LLD.Parking_Lot.Vehicle.Vehicle;

public class Main {

    public static void main(String[] args){
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(new Level(1, 20,20,20));
        parkingLot.addLevel(new Level(2, 20,50,10));

        Vehicle car = new Car("ABC123");
        Vehicle truck = new Truck("XYZ789");
        Vehicle motorcycle = new Motorcycle("M1234");

        // Park vehicles
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(truck);
        parkingLot.parkVehicle(motorcycle);

        // Display availability
        parkingLot.displayAvailability();

        // Unpark vehicle
        parkingLot.unparkVehicle(motorcycle);

        // Display updated availability
        parkingLot.displayAvailability();
    }

}
