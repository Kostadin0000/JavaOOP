package Shopping;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> map = new LinkedHashMap<>();

        String[] tokens = scanner.nextLine().split(";");
        String[] tokens2 = tokens[0].split("=");
        String name = tokens2[0];
        double money = Double.parseDouble(tokens2[1]);
        map.put(name, new ArrayList<>());
        Person person = new Person(name, money);
        tokens2 = tokens[1].split("=");
        name = tokens2[0];
        money = Double.parseDouble(tokens2[1]);
        map.put(name, new ArrayList<>());
        Person person2 = new Person(name, money);

        tokens = scanner.nextLine().split(";");
        tokens2 = tokens[0].split("=");
        name = tokens2[0];
        double cost = Double.parseDouble(tokens2[1]);
        Product product = new Product(name, cost);


        tokens2 = tokens[1].split("=");
        name = tokens2[0];
        cost = Double.parseDouble(tokens2[1]);
        Product product2 = new Product(name, cost);


        String command = scanner.nextLine();

        while (!command.equals("END")) {
            tokens = command.split(" ");
            name = tokens[0];
            String productt = tokens[1];
            if (name.equals(person.getName())) {
                if (productt.equals(product.getName())) {
                    person.buyProduct(product);
                    map.get(name).add(productt);
                } else {
                    person.buyProduct(product2);
                    map.get(name).add(productt);
                }
            } else {
                if (productt.equals(product.getName())) {
                    person2.buyProduct(product);
                    map.get(name).add(productt);
                } else {
                    person2.buyProduct(product2);
                    map.get(name).add(productt);
                }
            }


            command = scanner.nextLine();
        }
        for (String s : map.keySet()) {
            System.out.print(s + " - ");
            for (int i = 0; i < map.get(s).size(); i++) {
                if (i == map.get(s).size() - 1){
                System.out.print(map.get(s).get(i));
                }else{
                    System.out.print(map.get(s).get(i) + ", ");
                }

            }
            System.out.println();
        }
// for (String s : companyUsers.keySet()) {
//            System.out.printf("%s\n", s);
//            for (int i = 0; i < companyUsers.get(s).size(); i++) {
//                System.out.printf("-- %s\n", companyUsers.get(s).get(i));
//            }
//        }

    }
}
