package Farm.animals;

import Farm.foods.Food;

import java.text.DecimalFormat;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private String livingRegion;
    private int foodEaten;

    protected Animal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.livingRegion = livingRegion;
    }

    protected String getAnimalType() {
        return animalType;
    }

    public abstract void makeSound();

    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("##.##");

        return String.format("%s[%s, %s, %s, %d]",
                animalType,
                animalName,
                decimalFormat.format(animalWeight),
                livingRegion,
                foodEaten);
    }
}
