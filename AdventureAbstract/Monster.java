
public class Monster extends Character {
    public Monster(String name, int maxHealth) {
        super(name, maxHealth);
    }

    @Override
    public String toString() {
        if (this.getCurrentHealth() <= 0) {
            return String.format("%s is a monster and is dead", this.getName());
        } else {
            return String.format("%s is a monster with %d HP", this.getName(), this.getCurrentHealth());
        }
    }

    @Override
    public void takeDamage(int health) {
        int reducedDamage = (int) (health * 0.8);
        this.setCurrentHealth(-reducedDamage);
    }

    @Override
    public void attack(Character charchter) {
        charchter.takeDamage(7);
    }

    public static void main(String[] args) {
        Templar alistair = new Templar("Alistair", 18, 2, 4);
        Sorcerer morrigan = new Sorcerer("Morrigan", 21, 5);
        Monster dragon = new Monster("Dragon", 12);

        dragon.attack(alistair);
        dragon.attack(morrigan);

        alistair.attack(dragon);
        morrigan.attack(dragon);

        System.out.println(Character.printStatus());
    }
}