public class Character {
    public final int maxHealth;
    public int currentHealth;
    public final String name;

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    
    public String getName() {
        return name;
    }

    public Character(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    @Override
    public String toString() {
        if (this.currentHealth <= 0) {
            return String.format("%s : KO", this.name);
        } else {
            return String.format("%s : %d/%d", this.name, this.currentHealth, this.maxHealth);
        }
    }

    public void takeDamage(int health) {
        if (this.currentHealth - health >= 0) {
            this.currentHealth -= health;
        } else {
            this.currentHealth = 0;
        }
    }

    public void attack(Character charchter) {
        charchter.takeDamage(9);
    }

    public static void main(String[] args) {
        Character aragorn = new Character("Aragorn", 20);
        Character uruk = new Character("Uruk", 5);

        System.out.println(aragorn.toString());
        System.out.println(uruk.toString());

        aragorn.attack(uruk);

        System.out.println(uruk.toString());

        aragorn.takeDamage(12);

        System.out.println(aragorn.toString());
    }
}
