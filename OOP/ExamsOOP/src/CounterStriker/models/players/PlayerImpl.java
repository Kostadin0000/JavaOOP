package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {
    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    protected PlayerImpl(String username, int health, int armor, Gun gun) {
        setUsername(username);
        setHealth(health);
        setArmor(armor);
        setGun(gun);
        this.isAlive = true;
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.username = username;
    }

    private void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }

    private void setArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }

    private void setAlive(boolean alive) {
        isAlive = alive;
    }

    private void setGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public Gun getGun() {
        return gun;
    }

    @Override
    public boolean isAlive() {
        return this.getHealth() > 0;
    }

    @Override
    public void takeDamage(int points) {
        if (this.getArmor() - points < 0) {

            this.setArmor(0);
            this.setHealth(this.getHealth() - points);

            if (getHealth() < 0) {
                this.setAlive(false);
            }
        } else {
            this.setArmor(this.getArmor() - points);

        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s: %s", this.getClass().getSimpleName(), getUsername()))
                .append(System.lineSeparator());
        sb.append(String.format("--Health: %d",getHealth())).append(System.lineSeparator());
        sb.append(String.format("--Armor: %d",getArmor())).append(System.lineSeparator());
        sb.append(String.format("--Gun: %s",getGun().getName())).append(System.lineSeparator());
        return sb.toString();
    }

}
//The takeDamage() method decreases the Player's armor and health.
// First you need to reduce the armor. If the armor reaches 0, transfer the damage to health points.
// If the health points are less than or equal to zero, the player is dead.