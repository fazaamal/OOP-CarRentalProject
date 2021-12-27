public class PetrolCar extends Car{
    private String transmission;
    private double fuelCapacity, mpg;

    PetrolCar(String make, String model, String type, String colour, String transmission, int year, int seats, double costPerDay,
                double tyreSize, double weight, double fuelCapacity, double mpg){
        setMake(make);
        setModel(model);
        setType(type);
        setColour(colour);
        setYear(year);
        setSeats(seats);
        setCostPerDay(costPerDay);
        setTyreSize(tyreSize);
        setWeight(weight);
        setTransmission(transmission);
        setFuelCapacity(fuelCapacity);
        setMpg(mpg);
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
