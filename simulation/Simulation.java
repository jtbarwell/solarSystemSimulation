package simulation;
import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final List<CelestialBody> bodies = new ArrayList<>();

    public void addBody(CelestialBody body) {
        bodies.add(body);
    }

    public void update(double dt) {
        for (CelestialBody body : bodies) {
            body.applyForce(new Vector2D(0, 0)); // Reset acceleration
        }

        for (int i = 0; i < bodies.size(); i++) {
            for (int j = i + 1; j < bodies.size(); j++) {
                CelestialBody a = bodies.get(i);
                CelestialBody b = bodies.get(j);
                Vector2D force = Physics.gravitationalForce(a, b);
                a.applyForce(force);
                b.applyForce(force.scale(-1));
            }
        }

        for (CelestialBody body : bodies) {
            body.update(dt);
        }
    }

    public void printStatus() {
        for (CelestialBody body : bodies) {
            System.out.println(body);
        }
    }

    public List<CelestialBody> getBodies() {
        return bodies;
    }
}
