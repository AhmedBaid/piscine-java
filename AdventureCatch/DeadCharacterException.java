public class DeadCharacterException extends Exception {
    private Character charr;

    public DeadCharacterException(Character charr) {
        this.charr = charr;
    }

    public String getMessage() {
        if (this.charr instanceof Monster) {
            return String.format("The monster %s is dead.", this.charr.getName());
        }
        if (this.charr instanceof Sorcerer) {
            return String.format("The sorcerer %s is dead.", this.charr.getName());
        }
        if (this.charr instanceof Templar) {
            return String.format("The templar %s is dead.", this.charr.getName());
        }
        return "";
    }

    public static void main(String[] args) {
        Weapon excalibur = new Weapon("Excalibur", 7);
        Weapon baton = new Weapon("Baton", 3);
        Templar arthur = new Templar("Arthur", 30, 5, 3, excalibur);
        Sorcerer merlin = new Sorcerer("Merlin", 28, 2, baton);

        try {
            arthur.takeDamage(50);
        } catch (DeadCharacterException e) {
            System.out.println(e.getMessage());
        }

        try {
            arthur.takeDamage(2);
        } catch (DeadCharacterException e) {
            System.out.println(e.getMessage());
        }
        try {
            arthur.attack(merlin);
        } catch (DeadCharacterException e) {
            System.out.println(e.getMessage());
        }
    }
}