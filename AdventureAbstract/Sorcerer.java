public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
    }

    public int getHealCapacity() {
        return this.healCapacity;
    }

    public void heal(Character charr) {
        charr.setCurrentHealth(healCapacity);
    }

    @Override
    public String toString() {
        if (this.getCurrentHealth() != 0) {
            return String.format("%s is a sorcerer with %d HP. It can heal %d HP.", this.getName(),
                    this.getCurrentHealth(), this.healCapacity);
        } else {
            return String.format("%s is a dead sorcerer. So bad, it could heal %d HP.", this.getName(),
                    this.healCapacity);
        }
    }

    @Override
    public void takeDamage(int health) {
        if (this.getCurrentHealth() - health >= 0) {
            this.setCurrentHealth(-health);
        } else {
            this.setCurrentHealth(-this.getCurrentHealth());
        }
    }

    @Override
    public void attack(Character charr) {
        this.heal(this);
        charr.takeDamage(10);
    }
}