package testSystems;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import simulation.CelestialBody;
import simulation.Vector2D;

public class chaosSystemTest {

    private List<CelestialBody> system = new LinkedList<>();

    // Earth
    Color earthColour = new Color(140, 161, 237);
    CelestialBody earth = new CelestialBody(
        "Earth",
        5.972e24,
        12.742e6,
        new Vector2D(0, 0), 
        new Vector2D(0, 0),
        earthColour
    );

    // Moon orbiting Earth
    Color moonColour = new Color(204, 204, 204);
    CelestialBody moon = new CelestialBody(
        "Moon",
        7.342e22,
        3475e3,
        // new Vector2D(384.4e6, 0), // ~384,400 km (real scale)
        // new Vector2D(0, 1022)     // ~1 km/s     (real scale)
        new Vector2D(44.4e6, 0), 	 // ~384,400 km
        new Vector2D(0, -3022),      // ~1 km/s
        moonColour,
        earth
    );

    // Moon orbiting Earth
    CelestialBody moon2 = new CelestialBody(
        "Moon2",
        7.342e22,
        3475e3,
        // new Vector2D(384.4e6, 0), // ~384,400 km (real scale)
        // new Vector2D(0, 1022)     // ~1 km/s     (real scale)
        new Vector2D(44.4e6, 44.4e6), // ~384,400 km
        new Vector2D(3022, -3022),      // ~1 km/s
        moonColour,
        earth
    );

    // Moon orbiting Earth
    CelestialBody moon3 = new CelestialBody(
        "Moon3",
        4.342e20,
        2475e3,
        // new Vector2D(384.4e6, 0), // ~384,400 km (real scale)
        // new Vector2D(0, 1022)     // ~1 km/s     (real scale)
        new Vector2D(-44.4e6, -44.4e6), // ~384,400 km
        new Vector2D(0, 3022),      // ~1 km/s
        moonColour,
        earth
    );

    // Mars orbiting Earth
    Color marsColour = new Color(207, 82, 54);
    CelestialBody mars = new CelestialBody(
        "Mars",
        7.41693e23,
        7779e3,
        new Vector2D(7.4e6, 84.4e6),
        new Vector2D(2322, 0),
        marsColour,
        earth
    );

    // Mars orbiting Earth
    CelestialBody mars2 = new CelestialBody(
        "Mars2",
        6.41693e23,
        6779e3,
        new Vector2D(10.4e6, -82.4e6), // ~384,400 km
        new Vector2D(-2222, 0),
        marsColour,
        earth
    );

    // Mars orbiting Earth
    CelestialBody mars3 = new CelestialBody(
        "Mars3",
        6.41693e23,
        6779e3,
        new Vector2D(70.4e6, -2.4e6), // ~384,400 km
        new Vector2D(0, -2922),
        marsColour,
        earth
    );

    // Mars orbiting Earth
    CelestialBody mars4 = new CelestialBody(
        "Mars4",
        6.41693e23,
        6779e3,
        new Vector2D(-88.4e6, 8.4e6), // ~384,400 km
        new Vector2D(0, 2022),
        marsColour,
        earth
    );

    public chaosSystemTest() {
        
        this.system.add(earth);
        this.system.add(moon);
        this.system.add(moon2);
        this.system.add(moon3);
        this.system.add(mars);
        this.system.add(mars2);
        this.system.add(mars3);
        this.system.add(mars4);

    }

    public List<CelestialBody> getSystem() {
        return system;
    }
}
