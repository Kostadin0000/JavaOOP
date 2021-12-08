public class Car extends Vehicle {
    private final static double FUEL_CONSUMPTION = 0.9;


    protected Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + FUEL_CONSUMPTION, tankCapacity);
    }
}
