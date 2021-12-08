import java.text.DecimalFormat;

public class Vehicle {

    protected double fuelQuantity;
    protected double fuelConsumption;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.tankCapacity = tankCapacity;
        this.setFuel(fuelQuantity);
        this.fuelConsumption = fuelConsumption;
    }

    private void setFuel(double fuelQuantity) {
        validateFuel(fuelQuantity);
        validateTankCapacity(fuelQuantity);
        this.fuelQuantity = fuelQuantity;
    }

    private void validateFuel(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
    }

    private void validateTankCapacity(double fuel) {
        if (fuel > tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
    }

    public String drive(double distance) {
        double fuelNeeded = this.fuelConsumption * distance;
        if (this.fuelQuantity < fuelNeeded) {
            return this.getClass().getSimpleName() + " needs refueling";
        }
        setFuel(fuelQuantity -= fuelNeeded);

        DecimalFormat format = new DecimalFormat("##.##");

        return String.format(this.getClass().getSimpleName() + " travelled %s km", format.format(distance));

    }

    protected void addConsumption(double additional) {
        this.fuelConsumption += additional;
    }
    protected void removeConsumption(double subtracted) {
        this.fuelConsumption -= subtracted;
    }

    public void fuel(double liters) {
        validateFuel(liters);
        validateTankCapacity(liters);
        this.setFuel(fuelQuantity + liters);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), fuelQuantity);
    }
}
