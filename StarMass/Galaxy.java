import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Galaxy extends CelestialObject {
    private List<CelestialObject> celestialObjects;

    public Galaxy() {
        super();
        this.celestialObjects = new ArrayList<>();
    }

    public List<CelestialObject> getCelestialObjects() {
        return this.celestialObjects;
    }

    public void addCelestialObject(CelestialObject arg1) {
        this.celestialObjects.add(arg1);
    }

    public HashMap<String, Integer> computeMassRepartition() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Star", 0);
        map.put("Planet", 0);
        map.put("Other", 0);
        for (CelestialObject obj : this.celestialObjects) {
            if (obj instanceof Star) {
                map.put("Star", map.get("Star") + obj.getMass());
            } else if (obj instanceof Planet) {
                map.put("Planet", map.get("Planet") + obj.getMass());
            } else {
                map.put("Other", map.get("Other") + obj.getMass());
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Galaxy galaxy = new Galaxy();
        CelestialObject charron = new CelestialObject("Charron", -123.12, 392.238, 32.31, 157);
        CelestialObject lune = new CelestialObject("Lune", 3928.32, 327.239, -12.92, 3987);
        Star betelgeuse = new Star("Betelgeuse", 128.23, -12.82, 32.328, 1289.3, 538595);
        Star altair = new Star("Betelgeuse", 43894.34, -324.43, 9438.23, 123.54, 137273);
        Star bellatrix = new Star("Bellatrix", 584.34, 2103.32, -102.43, 413.2, 5483724);
        Planet naboo = new Planet("Naboo", 17.4389, 8349.1, 8943.92, betelgeuse, 32454);
        Planet tatooine = new Planet("Tatooine", 17.4389, 8349.1, 8943.92, betelgeuse, 2345);
        Planet mercure = new Planet("Mercure", 17.4389, 8349.1, 8943.92, altair, 19438);
        Planet venus = new Planet("Venus", 17.4389, 8349.1, 8943.92, altair, 9283);
        Planet mars = new Planet("Mars", 17.4389, 8349.1, 8943.92, altair, 2183);

        galaxy.addCelestialObject(lune);
        galaxy.addCelestialObject(charron);
        galaxy.addCelestialObject(mars);
        galaxy.addCelestialObject(mercure);
        galaxy.addCelestialObject(tatooine);
        galaxy.addCelestialObject(altair);
        galaxy.addCelestialObject(venus);
        galaxy.addCelestialObject(betelgeuse);
        galaxy.addCelestialObject(naboo);
        galaxy.addCelestialObject(bellatrix);

        System.out.println(galaxy.computeMassRepartition().toString());
    }
}