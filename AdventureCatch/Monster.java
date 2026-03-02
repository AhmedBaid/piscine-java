import java.util.Objects;

public class Monster extends Character {
    public Monster(String name, int maxHealth, Weapon weapon) {
        super(name, maxHealth, weapon);
    }

    @Override
    public String toString() {
        if (this.getCurrentHealth() <= 0) {
            return String.format("%s is a monster and is dead. He has the weapon %s", this.getName(),
                    this.getWeapon().toString());
        } else {
            return String.format("%s is a monster with %d HP. He has the weapon %s", this.getName(),
                    this.getCurrentHealth(), this.getWeapon().toString());
        }
    }

    @Override
    public void takeDamage(int health) throws DeadCharacterException {
        int reducedDamage = (int) (health * 0.8);
        this.setCurrentHealth(-reducedDamage);
        if (this.getCurrentHealth() <= 0) {
            throw new DeadCharacterException(this);
        }
    }

    @Override
    public void attack(Character charchter) throws DeadCharacterException {
        if (charchter.getCurrentHealth() == 0) {
            throw new DeadCharacterException(charchter);
        }
        if (Objects.nonNull(this.getWeapon())) {
            charchter.takeDamage(this.getWeapon().getDamage());
        } else {
            charchter.takeDamage(7);
        }
    }
}