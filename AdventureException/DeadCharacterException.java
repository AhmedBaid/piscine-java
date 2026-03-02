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
        Weapon feu = new Weapon("Boule de feu", 7);
        Sorcerer triss = new Sorcerer("Triss Merigold", 30, 5, feu);
        Templar geralt = new Templar("Geralt de Riv", 28, 2, 5, feu);
        DeadCharacterException exceptionTriss = new DeadCharacterException(triss);
        DeadCharacterException exceptionGeralt = new DeadCharacterException(geralt);

        System.out.println(exceptionTriss.getMessage());
        System.out.println(exceptionGeralt.getMessage());
    }
}