import java.util.Objects;

public class Planet extends CelestialObject {
    private Star centerStar;

    public Planet() {
        super();
        this.centerStar = new Star();
    }

    public Planet(String name, double x, double y, double z, Star star) {
        super(name,x,y,z);
        this.centerStar = star;
    }

    public Star getCenterStar() {
        return this.centerStar;
    }

    public void setCenterStar(Star star) {
        this.centerStar = star;
    }

    @Override
    public String toString() {
        return String.format("%s circles around %s at the %.3f AU", this.getName(), this.centerStar.getName(),
                getDistanceBetween(this, this.centerStar));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Planet obj1 = (Planet) obj;
        return Double.compare(this.getX(), obj1.getX()) == 0 && Double.compare(this.getY(), obj1.getY()) == 0
                && Double.compare(this.getZ(), obj1.getZ()) == 0 && this.getName().equals(obj1.getName())
                && Double.compare(this.centerStar.getX(), obj1.centerStar.getX()) == 0
                && Double.compare(this.centerStar.getY(), obj1.centerStar.getY()) == 0
                && Double.compare(this.centerStar.getZ(), obj1.centerStar.getZ()) == 0
                && this.centerStar.getName().equals(obj1.centerStar.getName())
                && obj1 != null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getX(), this.getY(), this.getZ(), this.getName(), this.centerStar.getX(),
                this.centerStar.getY(), this.centerStar.getZ(), this.centerStar.getName());
    }

    public static void main(String[] args) {
        Planet earth = new Planet();
        Planet naboo = new Planet("Naboo", 17.4389, 8349.1, 8943.92,
                new Star("Betelgeuse", 128.23, -12.82, 32.328, 1289.3));

        System.out.println(naboo.toString());
        System.out.println(earth.toString());
        System.out.println(naboo.getCenterStar().toString());
    }
}