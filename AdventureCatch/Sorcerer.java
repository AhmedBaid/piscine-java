import java.util.Objects;

public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
    }

    public int getHealCapacity() {
        return this.healCapacity;
    }

    public void heal(Character charr) throws DeadCharacterException {
        if (this.getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        charr.setCurrentHealth(healCapacity);
    }

    @Override
    public String toString() {
        if (this.getCurrentHealth() != 0) {
            return String.format("%s is a sorcerer with %d HP. It can heal %d HP. He has the weapon %s", this.getName(),
                    this.getCurrentHealth(), this.healCapacity, this.getWeapon().toString());
        } else {
            return String.format("%s is a dead sorcerer. So bad, it could heal %d HP. He has the weapon %s",
                    this.getName(),
                    this.healCapacity, this.getWeapon().toString());
        }
    }

    @Override
    public void takeDamage(int health) throws DeadCharacterException {
        if (this.getCurrentHealth() - health >= 0) {
            this.setCurrentHealth(-health);
        } else {
            throw new DeadCharacterException(this);
        }
    }

    @Override
    public void attack(Character charr) throws DeadCharacterException {
        if (this.getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        this.heal(this);
        if (Objects.nonNull(this.getWeapon())) {
            charr.takeDamage(this.getWeapon().getDamage());
        } else {
            charr.takeDamage(10);
        }
    }
}