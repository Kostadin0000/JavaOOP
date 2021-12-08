public class Bus extends Vehicle {
    private final static double FUEL_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    public String driveWithPassengers(double distance) {
        super.addConsumption(FUEL_CONSUMPTION);
        String out = super.drive(distance);
        super.removeConsumption(FUEL_CONSUMPTION);
        return out;
    }
}
