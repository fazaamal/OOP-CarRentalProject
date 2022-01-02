public class FuelCar extends Car{
    private String transmission, fuel;
    private double fuelCapacity, mpg;

    FuelCar(String make, String model, String type, String colour, String transmission, String fuel, String imgPath, int year, int seats, double costPerDay,
                double tyreSize, double weight, double fuelCapacity, double mpg){
        super(make, model, type, colour, fuel, imgPath, year, seats, costPerDay,
                tyreSize, weight);

        this.transmission = transmission;
        this.fuelCapacity = fuelCapacity;
        this.mpg = mpg;

    }

    public String getTransmission() {
        return transmission;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public double getMpg() {
        return mpg;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public void setMpg(double mpg) {
        this.mpg = mpg;
    }
}
