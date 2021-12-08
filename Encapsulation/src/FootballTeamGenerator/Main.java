package FootballTeamGenerator;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isTrue = false;
        String command = scanner.nextLine();
        LinkedHashMap<String, Team> map = new LinkedHashMap<>();

        while (!command.equals("END")) {
            String[] tokens = command.split(";");
            String firstWord = tokens[0];

            if (firstWord.equals("Team")) {
                String newTeamName = tokens[1];
                map.putIfAbsent(newTeamName, new Team(newTeamName));
            } else if (firstWord.equals("Add")) {
                String teamName = tokens[1];
                String playerName = tokens[2];
                int endurance = Integer.parseInt(tokens[3]);
                int sprint = Integer.parseInt(tokens[4]);
                int dribble = Integer.parseInt(tokens[5]);
                int passing = Integer.parseInt(tokens[6]);
                int shooting = Integer.parseInt(tokens[7]);
                if (!map.containsKey(teamName)) {
                    System.out.printf("Team %s does not exist.%n", teamName);
                } else {
                    try {
                        Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                        map.get(teamName).addPlayer(player);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            } else if (firstWord.equals("Remove")) {
                String teamName = tokens[1];
                String playerName = tokens[2];
                for (int i = 0; i < map.size(); i++) {
                    map.get(teamName).removePlayer(playerName);
                    break;
                }
            } else if (firstWord.equals("Rating")) {
                String teamName = tokens[1];
                if (map.containsKey(teamName)) {
                    double sum = map.get(teamName).getRating();
                    System.out.printf("%s - %.0f%n", teamName, sum);
                } else {
                    System.out.printf("Team %s does not exist.%n", teamName);
                }
            }
            command = scanner.nextLine();
        }
    }
}