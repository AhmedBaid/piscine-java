import java.util.Objects;

public class Star extends CelestialObject {
    private double magnitude;

    public Star() {
        this.setX(0.0);
        this.setY(0.0);
        this.setZ(0.0);
        this.setName("Soleil");
        this.magnitude = 0.0;
    }

    public Star(String name, double x, double y, double z, double magnitude) {
        this.setX(x);
        this.setY(y);
        this.setZ(z);
        this.setName(name);
        this.magnitude = magnitude;
    }

    public double getMagnitude() {
        return this.magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    @Override
    public String toString() {
        return String.format("%s shines at the %.3f magnitude", this.getName(), this.magnitude);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Star obj1 = (Star) obj;
        return Double.compare(this.getX(), obj1.getX()) == 0 && Double.compare(this.getY(), obj1.getY()) == 0
                && Double.compare(this.getZ(), obj1.getZ()) == 0 && this.getName().equals(obj1.getName())
                && Double.compare(this.magnitude, obj1.magnitude) == 0
                && obj1 != null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getX(), this.getY(), this.getZ(), this.getName(), this.magnitude);
    }

    public static void main(String[] args) {
        Star star = new Star();
        Star star2 = new Star();
        Star proxima = new Star("Proxima", 18.389, 832.32, 218, 0.4);

        System.out.println(star.toString());
        System.out.println(proxima.toString());
        System.out.println(star.equals(star2));
        System.out.println(star.equals(proxima));
    }
}