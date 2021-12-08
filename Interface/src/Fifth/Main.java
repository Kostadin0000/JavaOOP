package Fifth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> callableList = new ArrayList<>();
        List<String> urls = new ArrayList<>();
        String[] tokens = scanner.nextLine().split(" ");
        for (int i = 0; i < tokens.length; i++) {
            callableList.add(tokens[i]);
        }
        tokens = scanner.nextLine().split(" ");
        for (int i = 0; i < tokens.length; i++) {
            urls.add(tokens[i]);
        }
        Smartphone smartphone = new Smartphone(callableList,urls);
        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());

    }
}
