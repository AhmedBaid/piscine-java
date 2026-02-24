public class CelestialObject {
    public double x;
    public double y;
    public double z;
    public String name;

    public CelestialObject() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.name = "Soleil";
    }

    public CelestialObject(String name, double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public static void main(String[] args) {
        CelestialObject defaultStar = new CelestialObject();
        System.out.println(defaultStar.x);
        System.out.println(defaultStar.y);
        System.out.println(defaultStar.z);
        System.out.println(defaultStar.name);

        CelestialObject earth = new CelestialObject("Terre", 0.43, 0.98, 1.43);
        System.out.println(earth.x);
        System.out.println(earth.y);
        System.out.println(earth.z);
        System.out.println(earth.name);
    }
}