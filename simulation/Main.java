package simulation;
import javax.swing.*;

import testSystems.chaosSystemTest;
import testSystems.realSolarSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        Simulation sim = new Simulation();

        // chaosSystemTest system = new chaosSystemTest();
        realSolarSystem system = new realSolarSystem();

        for (CelestialBody body : system.getSystem()) {
            sim.addBody(body);
        }

        double scale = 4e6; // 500,000,000 metres per pixel

        // GUI setup
        SimulationPanel panel = new SimulationPanel(sim, scale);

        
        // --- JSlider setup ---
        JSlider speedSlider = new JSlider(JSlider.HORIZONTAL, 0, 2500, 0);
        speedSlider.setMajorTickSpacing(500);
        speedSlider.setMinorTickSpacing(100);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);
        speedSlider.setToolTipText("Simulation Speed: Sim seconds (x1440) per real second");


        

        JSlider zoomSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50); // 0 = zoomed out, 100 = zoomed in
        zoomSlider.setToolTipText("Zoom");

        zoomSlider.addChangeListener(e -> {
            double zoomFraction = zoomSlider.getValue() / 100.0; // 0.0 to 1.0
            panel.setZoomLevel(zoomFraction);
        });

        
        

        JComboBox<CelestialBody> bodySelector = new JComboBox<>();

        // Populate the combo box with all bodies
        for (CelestialBody body : system.getSystem()) {
            bodySelector.addItem(body);
        }

        // Add selection behavior
        bodySelector.addActionListener(e -> {
            CelestialBody selected = (CelestialBody) bodySelector.getSelectedItem();
            // panel.setFocusedBody(selected);
            panel.setFocusedBody(selected);
        });



        // Layout
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(new JLabel("Speed"), BorderLayout.NORTH);
        topPanel.add(speedSlider, BorderLayout.NORTH);
        topPanel.add(new JLabel("Zoom"), BorderLayout.WEST);
        topPanel.add(zoomSlider, BorderLayout.SOUTH);


        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(bodySelector, BorderLayout.SOUTH);


        JFrame frame = new JFrame("Solar System Simulation");
        frame.setLayout(new BorderLayout());
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        
        // --- Timer setup ---
        Timer timer = new Timer(33, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double simSecondsPerRealSecond = speedSlider.getValue() * 1440.0 / 30.0; // scale by FPS
                sim.update(simSecondsPerRealSecond);
                panel.repaint();
            }
        });

        timer.start();
    }
}
