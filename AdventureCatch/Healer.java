public interface Healer {
    void heal(Character charr) throws DeadCharacterException;

    int getHealCapacity();
}