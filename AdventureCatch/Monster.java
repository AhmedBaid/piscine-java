import java.util.Objects;

public class Monster extends Character {
    public Monster(String name, int ma, Weapon w) {
        super(name, ma, w);
    }

    @Override
    public void attack(Character chart) throws DeadCharacterException {
        if (this.getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        if (Objects.nonNull(this.getWeapon())) {
            chart.takeDamage(this.getWeapon().getDamage());
        } else {
            chart.takeDamage(7);
        }
    }

    @Override
    public String toString() {
        if (this.getCurrentHealth() > 0) {
            return String.format("%s is a monster with %d HP. He has the weapon %s", this.getName(),
                    this.getCurrentHealth(), this.getWeapon().toString());
        } else {
            return String.format("%s is a monster and is dead. He has the weapon %s", this.getName(),
                    this.getWeapon().toString());

        }

    }

    @Override
    public void takeDamage(int nb) throws DeadCharacterException {
        if (this.getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        if (this.getCurrentHealth() - (int) (nb * 0.8) >= 0) {
            this.setCurrentHealth(this.getCurrentHealth() - (int) (nb * 0.8));
        } else {
            this.setCurrentHealth(0);
        }
    }

}