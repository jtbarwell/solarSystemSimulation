package simulation;

public class Vector2D {
    public double x;
    public double y;
    public double a;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Vector2D(double x, double y, double a) {
        this.a = Math.toRadians(a);
        this.x = x * Math.cos(this.a);
        this.y = y * Math.sin(this.a);
    }

    public Vector2D add(Vector2D other) {
        return new Vector2D(this.x + other.x, this.y + other.y);
    }

    public Vector2D subtract(Vector2D other) {
        return new Vector2D(this.x - other.x, this.y - other.y);
    }

    public Vector2D scale(double scalar) {
        return new Vector2D(this.x * scalar, this.y * scalar);
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y);
    }

    public Vector2D normalize() {
        double mag = magnitude();
        return mag == 0 ? new Vector2D(0, 0) : new Vector2D(x / mag, y / mag);
    }

    @Override
    public String toString() {
        return String.format("Vector2D(%.2e, %.2e)", x, y);
    }
}
