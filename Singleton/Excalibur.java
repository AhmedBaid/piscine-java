class Excalibur {
    private String name = "Sword";
    private static final Excalibur INSTANCE = new Excalibur();

    private Excalibur() {
    }

    private Excalibur(String name) {
        this.name = name;
    }

    public static Excalibur getInstance() {
        return INSTANCE;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        System.out.println(Excalibur.getInstance().getName());
    }
}
