public class Weapon {
    private final String name;
    private final int damage;

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    @Override
    public String toString() {
        return String.format("%s deals %d damages", this.name, this.damage);
    }

    public static void main(String[] args) {
        Weapon narsil = new Weapon("Narsil", 15);
        Weapon baguette = new Weapon("Baguette magique", 20);
        Weapon massue = new Weapon("Massue", 8);
        Monster troll = new Monster("Troll", 30, massue);
        Sorcerer dumbledore = new Sorcerer("Dumbledore", 25, 5, baguette);
        Templar alistair = new Templar("Alistair", 18, 2, 3, narsil);

        Character.fight(alistair, troll);

        System.out.println(Character.printStatus());
    }
}
