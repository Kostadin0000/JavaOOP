import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Vehicle> map = new LinkedHashMap<>();

        map.put("Car", createVehicle(scanner.nextLine()));
        map.put("Truck", createVehicle(scanner.nextLine()));
        Bus bus = createBus(scanner.nextLine());

        map.put("Bus", bus);


        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String command = scanner.nextLine();

            String[] tokens = command.split(" ");
            double distance = Double.parseDouble(tokens[2]);
            if (command.contains("Drive") && command.contains("Bus")) {
                System.out.println(bus.driveWithPassengers(distance));

            } else if (command.contains("Drive")) {
                System.out.println(map.get(tokens[1]).drive(distance));

            } else {
                try {
                    map.get(tokens[1]).fuel(distance);
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        }

        for (Vehicle value : map.values()) {
            System.out.println(value.toString());
        }
    }

    private static Bus createBus(String nextLine) {
        String[] tokens = nextLine.split(" ");
        return new Bus(Double.parseDouble(tokens[1]),
                Double.parseDouble(tokens[2]),
                Double.parseDouble(tokens[3]));
    }

    private static Vehicle createVehicle(String nextLine) {
        String[] tokens = nextLine.split(" ");
        if (tokens[0].equals("Car")) {
            return new Car(Double.parseDouble(tokens[1]),
                    Double.parseDouble(tokens[2]),
                    Double.parseDouble(tokens[3]));
        } else if (tokens[0].equals("Truck")) {
            return new Truck(Double.parseDouble(tokens[1]),
                    Double.parseDouble(tokens[2]),
                    Double.parseDouble(tokens[3]));
        } else {
            return new Bus(Double.parseDouble(tokens[1]),
                    Double.parseDouble(tokens[2]),
                    Double.parseDouble(tokens[3]));
        }
    }
}
