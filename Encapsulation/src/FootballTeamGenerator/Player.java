package FootballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    public void setName(String name) {
        if (name.trim().isEmpty()) {
            System.out.println("A name should not be empty.");
        } else {
            this.name = name;
        }
    }

    private void setEndurance(int endurance) {
        if (endurance >= 0 && endurance <= 100) {
            this.endurance = endurance;
        } else {
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        }
    }

    private void setSprint(int sprint) {
        if (sprint >= 0 && sprint <= 100) {
            this.sprint = sprint;
        } else {
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        }

    }

    private void setDribble(int dribble) {
        if (dribble >= 0 && dribble <= 100) {
            this.dribble = dribble;
        } else {
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }

    }

    private void setPassing(int passing) {
        if (passing >= 0 && passing <= 100) {
            this.passing = passing;
        } else {
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }

    }

    private void setShooting(int shooting) {
        if (shooting >= 0 && shooting <= 100) {
            this.shooting = shooting;
        } else {
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }

    }

    public String getName() {
        return name;
    }

    public double overallSkillLevel() {
        return ((this.dribble + this.endurance +
                this.passing + this.shooting + this.sprint) / 5.0);
    }
}
//+ 	Player (String, int, int, int, int, int)
//-	setName(String) : void
//+	getName(): String
//-	setEndurance (int) : void
//-	setSprint (int) : void
//-	setDribble (int) : void
//-	setPassing (int) : void
//-	setShooting (int) : void
//+	overallSkillLevel() : double