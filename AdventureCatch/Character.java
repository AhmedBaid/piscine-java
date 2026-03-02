
import java.util.ArrayList;
import java.util.List;

public abstract class Character {

    private final int maxHealth;
    private int currentHealth;
    private final String name;
    private static List<Character> allCharacters = new ArrayList<>();
    private Weapon weapon;

    protected void setCurrentHealth(int i) {
        this.currentHealth = i;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public String getName() {
        return name;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public Character(String name, int maxHealth, Weapon w) {
        this.maxHealth = maxHealth;
        this.name = name;
        this.currentHealth = maxHealth;
        allCharacters.add(this);
        this.weapon = w;
    }

    @Override
    public String toString() {
        if (this.currentHealth == 0) {
            return String.format("%s : KO", this.name);
        } else {
            return String.format("%s : %d/%d", this.name, this.currentHealth, this.maxHealth);
        }

    }

    public abstract void takeDamage(int nb) throws DeadCharacterException;

    public abstract void attack(Character chart) throws DeadCharacterException;

    public static String printStatus() {
        if (allCharacters.size() == 0) {
            return String.format(
                    "------------------------------------------\nNobody's fighting right now !\n------------------------------------------\n");

        } else {
            StringBuilder str = new StringBuilder();
            str.append("------------------------------------------\nCharacters currently fighting :\n");
            for (Character elem : allCharacters) {
                str.append(" - " + elem.toString() + "\n");
            }
            str.append("------------------------------------------\n");
            return str.toString();
        }
    }

    public static Character fight(Character char1, Character char2) {
        Character a = (Character) char1;
        Character b = (Character) char2;
        while (true) {
            try {

                a.attack(b);

            } catch (Exception e) {
            }
            if (b.getCurrentHealth() == 0) {
                return a;
            }
            try {

                b.attack(a);
            } catch (Exception e) {
            }
            if (a.getCurrentHealth() == 0) {
                return b;
            }
        }
    }
}