public class Truck extends Vehicle {
    private final static double FUEL_CONSUMPTION = 1.6;

    protected Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption +FUEL_CONSUMPTION, tankCapacity);
    }


    @Override
    public void fuel(double liters) {
        super.fuel(liters * 0.95);
    }
}
