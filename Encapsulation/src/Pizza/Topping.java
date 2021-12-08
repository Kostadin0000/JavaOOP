package Pizza;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (toppingType.equals("Meat") || toppingType.equals("Sauce") ||
                toppingType.equals("Veggies") || toppingType.equals("Cheese")) {
            this.toppingType = toppingType;
        } else {
            String msg = String.format("Cannot place %s on top of your pizza.", toppingType);
            throw new IllegalArgumentException(msg);
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 50) {
            this.weight = weight;
        } else {
            String msg = String.format("%s weight should be in the range [1..50].", this.toppingType);
            throw new IllegalArgumentException(msg);
        }
    }

    public double calculateCalories() {
        if (this.toppingType.equals("Meat")) {
            return (2 * weight) * 1.2;
        } else if (this.toppingType.equals("Veggies")) {
            return (2 * weight) * 0.8;
        } else if (this.toppingType.equals("Cheese")) {
            return (2 * weight) * 1.1;
        } else if (this.toppingType.equals("Sauce")) {
            return (2 * weight) * 0.9;
        }
        return 0;
    }

}
