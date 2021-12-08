package Second;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        List<Birthable> list = new ArrayList<>();

        while (!command.equals("End")) {

            String[] tokens = command.split(" ");
            String nameOfCommand = tokens[0];

            if (nameOfCommand.equals("Pet")) {

                String name = tokens[1];
                String birthDate = tokens[2];
                Pet pet = new Pet(name, birthDate);
                list.add(pet);

            } else if (nameOfCommand.equals("Citizen")) {

                String name = tokens[1];
                int age = Integer.parseInt(tokens[2]);
                String id = tokens[3];
                String birthDate = tokens[4];
                Citizen citizen = new Citizen(name, age, id, birthDate);
                list.add(citizen);

            }


            command = scanner.nextLine();
        }
        String year = scanner.nextLine();
        boolean isTrue = false;
        for (Birthable birthable : list) {
            if (birthable.getBirthDate().endsWith(year)) {
                System.out.println(birthable.getBirthDate());
            }
            isTrue = true;
        }
        if (!isTrue) {
            System.out.println("<no output>");
        }

    }
}
