public class Weapon {

    private final String name;
    private final int damage;

    public String getName() {
        return this.name;
    }

    public int getDamage() {
        return this.damage;
    }

    public Weapon(String name, int da) {
        this.name = name;
        this.damage = da;
    }

    @Override
    public String toString() {
        return String.format("%s deals %d damages", this.name, this.damage);
    }
}