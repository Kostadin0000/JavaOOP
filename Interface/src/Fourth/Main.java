package Fourth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        List<Citizen> citizenList = new ArrayList<>();
        List<Rebel> rebelList = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");

            if (tokens.length == 4) {

                //"<name> <age> <id> <birthdate
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];
                String birthDate = tokens[3];
                Citizen citizen = new Citizen(name, age, id, birthDate);
                citizen.buyFood();
                citizenList.add(citizen);
            } else {
                //  "<name> <age><group>"
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String group = tokens[2];
                Rebel rebel = new Rebel(name, age, group);
                rebel.buyFood();
                rebelList.add(rebel);

            }
        }

        String command = scanner.nextLine();
        int sum = 0;
        while (!command.equals("End")) {
            for (Rebel rebel : rebelList) {
                if (rebel.getName().equals(command)) {
                    sum += rebel.getFood();
                }
            }
            for (Citizen citizen : citizenList) {
                if (citizen.getName().equals(command)) {
                    sum += citizen.getFood();
                }
            }


            command = scanner.nextLine();
        }
        System.out.println(sum);
    }
}
