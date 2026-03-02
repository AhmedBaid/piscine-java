public class Templar extends Character implements Tank, Healer {
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }

    public int getHealCapacity() {
        return this.healCapacity;
    }

    public int getShield() {
        return this.shield;
    }

    public void heal(Character charr) {
        charr.setCurrentHealth(healCapacity);
    }

    @Override
    public String toString() {
        if (this.getCurrentHealth() != 0) {
            return String.format("%s is a strong Templar with %d HP. It can heal %d HP and has a shield of %d.",
                    this.getName(),
                    this.getCurrentHealth(), this.healCapacity, this.shield);
        } else {
            return String.format(
                    "%s has been beaten, even with its %d shield. So bad, it could heal %d HP.",
                    this.getName(),
                    this.shield, this.healCapacity);
        }
    }

    @Override
    public void takeDamage(int health) {
        this.setCurrentHealth(-(health - this.shield));
    }

    @Override
    public void attack(Character charchter) {
        this.heal(this);
        charchter.takeDamage(6);
    }
}