package LLD.Car_Rental;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Reservation {

    private String reservationId;
    private Car car;
    private Customer customer;
    private LocalDate startDate,endDate;
    private int totalPrice;

    public Reservation(String reservationId, Car car, Customer customer, LocalDate startDate, LocalDate endDate) {
        this.reservationId = reservationId;
        this.car = car;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = calculateTotalPrice();
    }

    private int calculateTotalPrice() {
        int daysRented = (int) (ChronoUnit.DAYS.between(startDate, endDate) + 1);
        return car.getRentalPricePerDay() * daysRented;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
