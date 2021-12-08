package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            System.out.println("A name should not be empty.");
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        for (int i = 0; i < this.players.size(); i++) {
            if (this.players.get(i).getName().equals(name)) {
                this.players.remove(i);
                return;
            }
        }
        System.out.printf("Player %s is not in %s team.%n", name, getName());
    }

    public double getRating() {
        if (this.players.size() == 0){
            return 0;
        }
        return (this.players.stream().mapToDouble(Player::overallSkillLevel).sum()) / this.players.size();
    }

}

//+	addPlayer(Player) : void

