import java.util.Objects;

public class Templar extends Character implements Tank, Healer {
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }

    public int getHealCapacity() {
        return this.healCapacity;
    }

    public int getShield() {
        return this.shield;
    }

    public void heal(Character charr) throws DeadCharacterException {
        if (charr.getCurrentHealth() == 0) {
            throw new DeadCharacterException(charr);
        }
        charr.setCurrentHealth(healCapacity);
    }

    @Override
    public String toString() {
        if (this.getCurrentHealth() != 0) {
            return String.format(
                    "%s is a strong Templar with %d HP. It can heal %d HP and has a shield of %d. He has the weapon %s",
                    this.getName(),
                    this.getCurrentHealth(), this.healCapacity, this.shield, this.getWeapon().toString());
        } else {
            return String.format(
                    "%s has been beaten, even with its %d shield. So bad, it could heal %d HP. He has the weapon %s",
                    this.getName(),
                    this.shield, this.healCapacity, this.getWeapon().toString());
        }
    }

    @Override
    public void takeDamage(int health) throws DeadCharacterException {
        if (this.getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        this.setCurrentHealth(-(health - this.shield));
    }

    @Override
    public void attack(Character charr) throws DeadCharacterException {
        if (charr.getCurrentHealth() == 0) {
            throw new DeadCharacterException(charr);
        }
        this.heal(this);
        if (Objects.nonNull(this.getWeapon())) {
            charr.takeDamage(this.getWeapon().getDamage());
        } else {
            charr.takeDamage(6);
        }
    }
}