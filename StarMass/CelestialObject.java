import java.util.Objects;

public class CelestialObject {
    private static final double KM_IN_ONE_AU = 150000000;
    private double x;
    private double y;
    private double z;
    private String name;
    private int mass;

    public CelestialObject() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.name = "Soleil";
        this.mass = 0;
    }

    public CelestialObject(String name, double x, double y, double z, Integer mass) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
        this.mass = mass;
    }

    public String toString() {
        return String.format("%s is positioned at (%.3f, %.3f, %.3f)", this.name, this.x, this.y, this.z);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        CelestialObject obj1 = (CelestialObject) obj;
        return Double.compare(this.x, obj1.x) == 0 && Double.compare(this.y, obj1.y) == 0
                && Double.compare(this.z, obj1.z) == 0 && this.name.equals(obj1.name)
                && obj1 != null;
    }

    public int hashCode() {
        return Objects.hash(x, y, z, name);
    }

    public static double getDistanceBetween(CelestialObject obj1, CelestialObject obj2) {
        return Math
                .sqrt(Math.pow((obj1.x - obj2.x), 2) + Math.pow((obj1.y - obj2.y), 2) + Math.pow((obj1.z - obj2.z), 2));
    }

    public static double getDistanceBetweenInKm(CelestialObject obj1, CelestialObject obj2) {
        return getDistanceBetween(obj1, obj2) * KM_IN_ONE_AU;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return this.z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMass() {
        return this.mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }
}