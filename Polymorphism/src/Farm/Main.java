package Farm;

import Farm.animals.*;
import Farm.foods.Food;
import Farm.foods.Meat;
import Farm.foods.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animalList = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split(" ");

            Animal animal = createAnimal(tokens);

            String line = scanner.nextLine();

            Food food = craeteFood(line.split(" "));

            animal.makeSound();
            try {
                animal.eat(food);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            animalList.add(animal);


            input = scanner.nextLine();
        }
        for (Animal animal1 : animalList) {
            System.out.println(animal1);
        }
    }

    private static Animal createAnimal(String[] tokens) {
        if (tokens[0].equals("Cat")) {
            //AnimalType} {AnimalName} {AnimalWeight} {AnimalLivingRegion} [{CatBreed} = Only if its cat]
            String animalType = tokens[0];
            String animalName = tokens[1];
            double animalWeight = Double.parseDouble(tokens[2]);
            String animalLivingRegion = tokens[3];
            String catBreed = tokens[4];
            return new Cat(animalName, animalType, animalWeight, animalLivingRegion, catBreed);
        } else if (tokens[0].equals("Zebra")) {
            String animalType = tokens[0];
            String animalName = tokens[1];
            double animalWeight = Double.parseDouble(tokens[2]);
            String animalLivingRegion = tokens[3];
            return new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
        } else if (tokens[0].equals("Tiger")) {
            String animalType = tokens[0];
            String animalName = tokens[1];
            double animalWeight = Double.parseDouble(tokens[2]);
            String animalLivingRegion = tokens[3];
            return new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
        } else {
            String animalType = tokens[0];
            String animalName = tokens[1];
            double animalWeight = Double.parseDouble(tokens[2]);
            String animalLivingRegion = tokens[3];
            return new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
        }
    }

    private static Food craeteFood(String[] tokens) {
        int quantity = Integer.parseInt(tokens[1]);
        return tokens[0].equals("Meat")
                ? new Meat(quantity)
                : new Vegetable(quantity);
    }

}
