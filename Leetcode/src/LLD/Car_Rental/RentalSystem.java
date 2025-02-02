package LLD.Car_Rental;

import LLD.Car_Rental.Payment.CreditCardPaymentProcessor;
import LLD.Car_Rental.Payment.PaymentProcessor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class RentalSystem {

    private static RentalSystem instance;
    private final Map<String, Car> cars;
    private final Map<String, Reservation> reservations;
    private final PaymentProcessor paymentProcessor;


    public RentalSystem() {
        this.cars = new ConcurrentHashMap<>();
        this.reservations = new ConcurrentHashMap<>();
        this.paymentProcessor = new CreditCardPaymentProcessor();
    }

    public static synchronized RentalSystem getInstance() {
        if (instance == null) {
            instance = new RentalSystem();
        }
        return instance;
    }

    public void addCar(Car car) {
        cars.put(car.getLicense_plate(), car);
    }

    public void removeCar(String licensePlate) {
        cars.remove(licensePlate);
    }

    public List<Car> searchCars(String make, String model, LocalDate startDate, LocalDate endDate) {
        List<Car> availableCars = new ArrayList<>();
        for (Car car : cars.values()) {
            if (car.getMake().equalsIgnoreCase(make) && car.getModel().equalsIgnoreCase(model) && car.isAvailable()) {
                if (isCarAvailable(car, startDate, endDate)) {
                    availableCars.add(car);
                }
            }
        }
        return availableCars;
    }

    private boolean isCarAvailable(Car car, LocalDate startDate, LocalDate endDate) {

        for (Reservation reservation:reservations.values()){
            if (reservation.getCar().equals(car) && reservation.getEndDate().isAfter(startDate) && reservation.getStartDate().isBefore(endDate)){
                return false;
            }
        }
        return true;
    }

    public synchronized Reservation makeReservation(Customer customer, Car car, LocalDate startDate, LocalDate endDate) {
        if (isCarAvailable(car,startDate,endDate)){
            String reservationId = generateReservationId();
            Reservation reservation =new Reservation(reservationId,car,customer,startDate,endDate);
            reservations.put(reservationId,reservation);
            System.out.println("Car sucessfully reserved from "+startDate.toString()+" to "+endDate.toString());
            car.setAvailable(false);
            return reservation;
        }else {
            System.out.println("Car is not available for the mentioned dates!!!");
            return null;
        }
    }

    public boolean processPayment(Reservation reservation) {
        return paymentProcessor.processPayment(reservation.getTotalPrice());
    }

    private String generateReservationId() {
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public synchronized void cancelReservation(String reservationId) {
        Reservation reservation = reservations.remove(reservationId);
        if (reservation != null) {
            reservation.getCar().setAvailable(true);
        }
    }
}
