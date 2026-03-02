import java.util.*;

public abstract class Character {
    private final int maxHealth;
    private int currentHealth;
    private final String name;
    private static List<Character> allCharacters = new ArrayList<>();
    private Weapon weapon;

    public Character(String name, int maxHealth, Weapon weapon) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        allCharacters.add(this);
        this.weapon = weapon;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    protected void setCurrentHealth(int health) {
        this.currentHealth += health;
        if (this.currentHealth <= 0) {
            this.currentHealth = 0;
        }
        if (this.currentHealth > this.maxHealth) {
            this.currentHealth = this.maxHealth;
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        if (this.currentHealth <= 0) {
            return String.format("%s : KO", this.name);
        } else {
            return String.format("%s : %d/%d", this.name, this.currentHealth, this.maxHealth);
        }
    }

    public abstract void takeDamage(int health);

    public abstract void attack(Character charchter);

    public static String printStatus() {
        StringBuilder res = new StringBuilder();
        if (allCharacters.size() > 0) {
            res.append("------------------------------------------\n" +
                    "Characters currently fighting :" + "\n");
            for (Character charr : allCharacters) {
                res.append(" - " + charr.toString() + "\n");
            }
            res.append("------------------------------------------" + "\n");
            return res.toString();
        } else {
            res.append("------------------------------------------\n" +
                    "Nobody's fighting right now !\n" +
                    "------------------------------------------" + "\n");
            return res.toString();
        }
    }

    public static Character fight(Character char1, Character char2) {
        while (true) {
            char1.attack(char2);
            if (char2.getCurrentHealth() <= 0) {
                return char1;
            }
            char2.attack(char1);
            if (char1.getCurrentHealth() <= 0) {
                return char2;
            }
        }
    }
}
