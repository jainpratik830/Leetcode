package LLD.Car_Rental;

public class Car {

    private final String make,model,year,license_plate;
    private final int rentalPricePerDay;

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    private boolean isAvailable;

    public CarType getCarType() {
        return carType;
    }

    private final CarType carType;

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public int getRentalPricePerDay() {
        return rentalPricePerDay;
    }



    public Car(String make, String model, String year, String license_plate, int rentalPricePerDay,CarType carType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.license_plate = license_plate;
        this.rentalPricePerDay = rentalPricePerDay;
        this.carType = carType;
        this.isAvailable =true;
    }

}
