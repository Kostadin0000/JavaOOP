import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rank = scanner.nextLine();
        String type = scanner.nextLine();
        int sum = CardRank.valueOf(rank).getValue() + CardType.valueOf(type).getValue();

        System.out.printf("Card name: %s of %s; Card power: %d",rank,type,sum);

    }
}
