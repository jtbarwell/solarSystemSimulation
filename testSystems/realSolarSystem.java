package testSystems;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import simulation.CelestialBody;
import simulation.Vector2D;

public class realSolarSystem {

    private List<CelestialBody> system = new LinkedList<>();

        // Sun at center
        Color sunColour = new Color(255, 228, 132);
        CelestialBody sun = new CelestialBody(
            "Sun",
            1.989e30,
            1.392e10,
            new Vector2D(0, 0),
            new Vector2D(0.0e5, 0),
            sunColour
        );


        // Mercury orbiting Sun
        Color mercuryColour = new Color(227, 226, 222);
        CelestialBody mercury = new CelestialBody(
            "Mercury",
            3.30104e23,
            4.8794e6,
            new Vector2D(0, -46.843e9),
            new Vector2D(-47870, 0),
            mercuryColour,
            sun
        );

        
        // Venus orbiting Sun
        Color venusColour = new Color(255, 228, 168);
        CelestialBody venus = new CelestialBody(
            "Venus",
            4.86732e24,
            12.104e6,
            new Vector2D(0, 1.08209475e11),
            new Vector2D(35020, 0),
            venusColour,
            sun
        );


        // Earth orbiting Sun
        Color earthColour = new Color(140, 161, 237);
        CelestialBody earth = new CelestialBody(
            "Earth",
            5.972e24,
            12.742e6,
            new Vector2D(1.496e11, 1.496e11, 23), 
            new Vector2D(29780, 29780, 23-90),
            earthColour,
            sun
        );

        // Moon orbiting Earth
		Color moonColour = new Color(204, 204, 204);
        CelestialBody moon = new CelestialBody(
            "Moon",
            7.342e22,
            3475e3,
            new Vector2D(384.4e6, 0),  // ~384,400 km (real scale)
            new Vector2D(0, 1022),     // ~1 km/s     (real scale)
            moonColour,
            earth
        );


        // Mars orbiting Sun
        Color marsColour = new Color(207, 82, 54);
        CelestialBody mars = new CelestialBody(
            "Mars",
            7.41693e23,
            7779e3,
            new Vector2D(2.28e11, 2.28e11, -50),
            new Vector2D(24080, 24080, -50-90),
            marsColour,
            sun
        );

        // Phobos orbiting Mars
        Color phobosColour = new Color(235, 210, 160);
        CelestialBody phobos = new CelestialBody(
            "Phobos",
            1.08e16,
            22533,
            new Vector2D(9.377e6, 0),
            new Vector2D(0, -2138),
            phobosColour,
            mars
        );

        // Deimos orbiting Mars
        Color deimosColour = new Color(212, 203, 186);
        CelestialBody deimos = new CelestialBody(
            "Deimos",
            1.5e15,
            12600,
            new Vector2D(-23.460e6, 0),
            new Vector2D(0, 1351),
            phobosColour,
            mars
        );

        
        // Jupiter orbiting Sun
        Color jupiterColour = new Color(227, 205, 150);
        CelestialBody jupiter = new CelestialBody(
            "Jupiter",
            1.899e27,
            139.82e6,
            new Vector2D(7.783e11, 7.783e11, 130),
            new Vector2D(13070, 13070, 130-90),
            jupiterColour,
            sun
        );

        // Io orbiting Jupiter
        Color ioColour = new Color(197, 222, 151);
        CelestialBody io = new CelestialBody(
            "Io",
            8.9319e22,
            3.64e6,
            new Vector2D(4.2169747e8, 4.2169747e8, 45),
            new Vector2D(17340, 17340, -45),
            ioColour,
            jupiter
        );

        // Europa orbiting Jupiter
        Color europaColour = new Color(240, 224, 223);
        CelestialBody europa = new CelestialBody(
            "Europa",
            4.79984e22,
            3.1216e6,
            new Vector2D(6.71e8, 6.71e8, 120),
            new Vector2D(13070, 13070, 120-90),
            europaColour,
            jupiter
        );

        // Ganymede orbiting Jupiter
        Color ganymedeColour = new Color(156, 156, 156);
        CelestialBody ganymede = new CelestialBody(
            "Ganymede",
            1.48e23,
            5.2682e6,
            new Vector2D(1.070214e9, 1.070214e9, -64),
            new Vector2D(10880, 10880, -64-90),
            ganymedeColour,
            jupiter
        );

        // Callisto orbiting Jupiter
        Color callistoColour = new Color(192, 194, 196);
        CelestialBody callisto = new CelestialBody(
            "Callisto",
            1.075938e23,
            4.8206e6,
            new Vector2D(1.883e9, 1.883e9, 253),
            new Vector2D(8204, 8204, 253-90),
            callistoColour,
            jupiter
        );

        // Amalthea orbiting Jupiter
        Color amaltheaColour = new Color(207, 58, 90);
        CelestialBody amalthea = new CelestialBody(
            "Amalthea",
            2.08e18,
            167000,
            new Vector2D(1.8136584e8, 1.8136584e8, 0),
            new Vector2D(26570, 26570, 0-90),
            amaltheaColour,
            jupiter
        );

        
        // Saturn orbiting Sun
        Color saturnColour = new Color(238, 240, 189);
        CelestialBody saturn = new CelestialBody(
            "Saturn",
            5.683e26,
            116.46e6,
            new Vector2D(1.433e12, 1.433e12, 300),
            new Vector2D(9690, 9690, 300-90),
            saturnColour,
            sun
        );

        // Titan orbiting Saturn
        Color titanColour = new Color(250, 216, 47);
        CelestialBody titan = new CelestialBody(
            "Titan",
            1.34518e23,
            5.1495e6,
            new Vector2D(1.22187e9, 1.22187e9, 253),
            new Vector2D(5570, 5570, 253-90),
            titanColour,
            saturn
        );

        
        // Uranus orbiting Sun
        Color uranusColour = new Color(189, 234, 242);
        CelestialBody uranus = new CelestialBody(
            "Uranus",
            8.681e25,
            50.724e6,
            new Vector2D(2.8968192e12, 2.8968192e12, 230),
            new Vector2D(6810, 6810, 230-90),
            uranusColour,
            sun
        );

        
        // Neptune orbiting Sun
        Color neptuneColour = new Color(88, 88, 224);
        CelestialBody neptune = new CelestialBody(
            "Neptune",
            1.0241e26,
            49.244e6,
            new Vector2D(4.4982529e12, 4.4982529e12, 10),
            new Vector2D(5430, 5430, 10-90),
            neptuneColour,
            sun
        );

        
        // Pluto orbiting Sun
        Color plutoColour = new Color(232, 214, 193);
        CelestialBody pluto = new CelestialBody(
            "Pluto",
            1.309e22,
            2.3766e6,
            new Vector2D(5.90638e12, 5.90638e12, 75),
            new Vector2D(4740, 4740, 75-90),
            plutoColour,
            sun
        );



    public realSolarSystem() {

        System.out.println(earth.getPosition().x);
        
        this.system.add(sun);

        this.system.add(mercury);

        this.system.add(venus);

        this.system.add(earth);
        this.system.add(moon);
        
        this.system.add(mars);
        this.system.add(phobos);
        this.system.add(deimos);

        this.system.add(jupiter);
        this.system.add(ganymede);
        this.system.add(europa);
        this.system.add(io);
        this.system.add(callisto);
        this.system.add(amalthea);

        this.system.add(saturn);
        this.system.add(titan);

        this.system.add(uranus);

        this.system.add(neptune);

        this.system.add(pluto);

    }

    public List<CelestialBody> getSystem() {
        return system;
    }
}
