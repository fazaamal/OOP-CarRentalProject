public class Car {
    private String carId, make, model, type, colour, imgPath, fuel;
    private int year, seats;
    private double costPerDay, tyreSize, weight;
    private boolean available = true;

    public Car(String carId, String make, String model, String type, String colour, String fuel, String imgPath, int year, int seats, double costPerDay, double tyreSize, double weight) {
        this.carId = carId;
        this.make = make;
        this.model = model;
        this.type = type;
        this.colour = colour;
        this.fuel = fuel;
        this.imgPath = imgPath;
        this.year = year;
        this.seats = seats;
        this.costPerDay = costPerDay;
        this.tyreSize = tyreSize;
        this.weight = weight;
    }

    public String getCarId() {
        return carId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public String getColour() {
        return colour;
    }

    public String getFuel() {
        return fuel;
    }

    public int getYear() {
        return year;
    }

    public int getSeats() {
        return seats;
    }

    public double getCostPerDay() {
        return costPerDay;
    }

    public double getTyreSize() {
        return tyreSize;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setCostPerDay(double costPerDay) {
        this.costPerDay = costPerDay;
    }

    public void setTyreSize(double tyreSize) {
        this.tyreSize = tyreSize;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
