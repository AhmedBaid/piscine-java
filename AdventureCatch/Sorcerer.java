import java.util.Objects;

public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int max, int healCapacity, Weapon w) {
        super(name, max, w);
        this.healCapacity = healCapacity;
    }

    public int getHealCapacity() {
        return this.healCapacity;
    }

    @Override
    public void attack(Character chart) throws DeadCharacterException {
        if (this.getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        if (Objects.nonNull(this.getWeapon())) {
            heal(this);
            chart.takeDamage(this.getWeapon().getDamage());
        } else {
            heal(this);
            chart.takeDamage(10);
        }
    }

    @Override
    public void takeDamage(int nb) throws DeadCharacterException {
        if (this.getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        if (this.getCurrentHealth() - nb >= 0) {
            this.setCurrentHealth(this.getCurrentHealth() - nb);
        } else {
            this.setCurrentHealth(0);
        }

    }

    public void heal(Character cha) throws DeadCharacterException {
        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        if (cha.getCurrentHealth() + healCapacity > cha.getMaxHealth()) {
            cha.setCurrentHealth(cha.getMaxHealth());
        } else {

            cha.setCurrentHealth(cha.getCurrentHealth() + this.healCapacity);
        }
    }

    @Override
    public String toString() {
        if (this.getCurrentHealth() != 0) {
            return String.format("%s is a sorcerer with %d HP. It can heal %d HP. He has the weapon %s", this.getName(),
                    this.getCurrentHealth(),
                    this.healCapacity, this.getWeapon().toString());
        } else {
            return String.format("%s is a dead sorcerer. So bad, it could heal %d HP. He has the weapon %s",
                    this.getName(),
                    this.healCapacity, this.getWeapon().toString());
        }
    }
}