package Pizza;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");
        String pizzaName = tokens[1];
        int toppings = Integer.parseInt(tokens[2]);
        tokens = scanner.nextLine().split(" ");
        String flourType = tokens[1];
        String technique = tokens[2];
        int weight = Integer.parseInt(tokens[3]);
        String command = scanner.nextLine();
        Pizza pizza = new Pizza(pizzaName, toppings);
        Dough dough = new Dough(flourType, technique, weight);
        pizza.setDough(dough);
        while (!command.equals("END")) {
            tokens = command.split(" ");
            String toppingtype = tokens[1];
            int weightInGrams = Integer.parseInt(tokens[2]);
            Topping topping = new Topping(toppingtype, weightInGrams);
            pizza.addTopping(topping);


            command = scanner.nextLine();
        }
        String finall = String.format("%.2f",pizza.getOverallCalories());
        System.out.println(pizza.getName() + " - " + finall);
    }
}
