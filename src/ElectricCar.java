public class ElectricCar extends Car{
    private double batteryCapacity, chargeTime, drivingRange;

    ElectricCar(String make, String model, String type, String colour, int year, int seats, double costPerDay,
                double tyreSize, double weight, double batteryCapacity, double chargeTime, double drivingRange){
        setMake(make);
        setModel(model);
        setType(type);
        setColour(colour);
        setYear(year);
        setSeats(seats);
        setCostPerDay(costPerDay);
        setTyreSize(tyreSize);
        setWeight(weight);
        setBatteryCapacity(batteryCapacity);
        setChargeTime(chargeTime);
        setDrivingRange(drivingRange);
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
