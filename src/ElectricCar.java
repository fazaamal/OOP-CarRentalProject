public class ElectricCar extends Car{
    private double batteryCapacity, chargeTime, drivingRange;

    ElectricCar(String carId, String make, String model, String type, String colour, String fuel, String imgPath, int year, int seats, double costPerDay,
                double tyreSize, double weight, double batteryCapacity, double chargeTime, double drivingRange){
        super(carId, make, model, type, colour, fuel, imgPath, year, seats, costPerDay,
                tyreSize, weight);

        this.batteryCapacity = batteryCapacity;
        this.chargeTime = chargeTime;
        this.drivingRange = drivingRange;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public double getChargeTime() {
        return chargeTime;
    }

    public double getDrivingRange() {
        return drivingRange;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public void setChargeTime(double chargeTime) {
        this.chargeTime = chargeTime;
    }

    public void setDrivingRange(double drivingRange) {
        this.drivingRange = drivingRange;
    }
}
