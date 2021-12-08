package Farm.animals;

import Farm.animals.Animal;
import Farm.foods.Food;

public abstract class Mammal extends Animal {
    private String livingRegion;

    protected Mammal(String animalName, String animalType, Double animalWeight,String livingRegion) {
        super(animalName, animalType, animalWeight,livingRegion);
    }

}
