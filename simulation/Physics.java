package simulation;
public class Physics {
    public static final double G = 6.67430e-11;

    public static Vector2D gravitationalForce(CelestialBody a, CelestialBody b) {
        Vector2D direction = b.getPosition().subtract(a.getPosition());
        double distance = direction.magnitude();
        if (distance == 0) return new Vector2D(0, 0); // avoid division by zero
        double forceMag = G * a.getMass() * b.getMass() / (distance * distance);
        return direction.normalize().scale(forceMag);
    }
}
