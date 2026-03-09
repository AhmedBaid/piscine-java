package Singleton;

public class Excalibur {
    private String name = "Sword";
    private static final Excalibur instance = new Excalibur();

    private Excalibur() {
    }

    public static Excalibur getInstance() {
        return instance;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        System.out.println(Excalibur.getInstance().getName());
    }
}
