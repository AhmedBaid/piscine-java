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
            return String.format("%s is a strong Templar with %d HP. It can heal %d HP and has a shield of <shield>.",
                    this.getName(),
                    this.getCurrentHealth(), this.healCapacity);
        } else {
            return String.format(
                    "%s has been beaten, even with its %d shield. So bad, it could heal %d HP.",
                    this.getName(),
                    this.shield, this.healCapacity);
        }
    }

    public static void main(String[] args) {
        Templar alistair = new Templar("Alistair", 20, 5, 4);
        Templar roderick = new Templar("Roderick", 10, 3, 2);

        Character.fight(alistair, roderick);

        alistair.heal(alistair);

        System.out.println(Character.printStatus());
    }
}