
import java.util.Objects;

public class Templar extends Character implements Healer, Tank {
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int max, int heal, int shield, Weapon w) {
        super(name, max, w);
        this.healCapacity = heal;
        this.shield = shield;

    }

    public int getHealCapacity() {
        return this.healCapacity;
    }

    @Override
    public void attack(Character chart) throws DeadCharacterException {
        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        if (Objects.nonNull(this.getWeapon())) {
            heal(this);
            chart.takeDamage(this.getWeapon().getDamage());
        } else {
            heal(this);
            chart.takeDamage(6);
        }
    }

    @Override
    public void takeDamage(int nb) throws DeadCharacterException {
        if (this.getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        if (this.getCurrentHealth() - (nb - this.shield) >= 0) {
            this.setCurrentHealth(this.getCurrentHealth() - (nb - this.shield));
        } else {
            this.setCurrentHealth(0);
        }

    }

    public void heal(Character cha) throws DeadCharacterException {
        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        if (cha.getCurrentHealth() + this.healCapacity > cha.getMaxHealth()) {
            cha.setCurrentHealth(cha.getMaxHealth());
        } else {

            cha.setCurrentHealth(cha.getCurrentHealth() + this.healCapacity);
        }
    }

    public int getShield() {
        return this.shield;
    }

    @Override
    public String toString() {
        if (this.getCurrentHealth() != 0) {
            return String.format(
                    "%s is a strong Templar with %d HP. It can heal %d HP and has a shield of %d. He has the weapon %s",
                    this.getName(), this.getCurrentHealth(),
                    this.healCapacity, this.shield, this.getWeapon().toString());
        } else {
            return String.format(
                    "%s has been beaten, even with its %d shield. So bad, it could heal %d HP. He has the weapon %s",
                    this.getName(),
                    this.shield, this.healCapacity, this.getWeapon().toString());
        }
    }
}