package simulation;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;


public class CelestialBody {
    private final String name;
    private final double mass; // kg
    private final double diameter; // meters (optional)
    private Vector2D position;
    private Vector2D velocity;
    private Vector2D acceleration;
    private CelestialBody parent = null;

    private Color colour;

    private List<Vector2D> trail = new LinkedList<>();
    private static final int MAX_TRAIL_SIZE = 500; // adjust for longer or shorter trails


    public void update(double dt) {
        velocity = velocity.add(acceleration.scale(dt));
        position = position.add(velocity.scale(dt));
        acceleration = new Vector2D(0, 0);

        // Add current position to trail
        trail.add(new Vector2D(position.x, position.y));
        if (trail.size() > MAX_TRAIL_SIZE) {
            trail.remove(0); // remove oldest point to limit trail length
        }
    }

    public List<Vector2D> getTrail() {
        return trail;
    }


    

    public CelestialBody(String name, double mass, double diameter, Vector2D position, Vector2D velocity, Color colour) {
        this.name = name;
        this.mass = mass;
        this.diameter = diameter;
        this.position = position;
        this.velocity = velocity;
        this.acceleration = new Vector2D(0, 0);
        this.colour = colour;
    }

    public CelestialBody(String name, double mass, double diameter, Vector2D position, Vector2D velocity, Color colour, CelestialBody parent) {
        this.name = name;
        this.mass = mass;
        this.diameter = diameter;
        this.position = position;
        this.velocity = velocity;
        this.acceleration = new Vector2D(0, 0);
        this.colour = colour;
        this.parent = parent;

        // handle position to orbit parent
        this.position = this.position.add(parent.getPosition());
        this.velocity = this.velocity.add(parent.getVelocity());

    }

    // Getters
    public String getName() { return name; }
    public double getMass() { return mass; }
    public double getDiameter() { return diameter; }
    public Vector2D getPosition() { return position; }
    public Vector2D getVelocity() { return velocity; }
    public Color getColour() { return colour; }
    public CelestialBody getParent() { return parent; }

    public void applyForce(Vector2D force) {
        Vector2D a = force.scale(1.0 / mass);
        acceleration = acceleration.add(a);
    }

    @Override
    public String toString() {
        // return String.format("%s: pos=%s, vel=%s", name, position, velocity);
        return name;
    }




}
