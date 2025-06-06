package simulation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class SimulationPanel extends JPanel {
    private Simulation simulation;
    private double scale; // meters per pixel
    public final double minScale = 1e2;
    public final double maxScale = 1e12;

    private CelestialBody focusedBody = null;

    public SimulationPanel(Simulation simulation, double scale) {
        this.simulation = simulation;
        this.scale = scale;

        setPreferredSize(new Dimension(1600, 1600));
        setBackground(Color.BLACK);

        // Click to focus on a body
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Vector2D clickedWorld = screenToWorld(e.getX(), e.getY());
                CelestialBody closest = null;
                double minDist = Double.MAX_VALUE;

                for (CelestialBody body : simulation.getBodies()) {
                    double dist = body.getPosition().subtract(clickedWorld).magnitude();
                    if (dist < body.getDiameter() * 2 && dist < minDist) {
                        closest = body;
                        minDist = dist;
                    }
                }

                focusedBody = closest;
                repaint();
            }
        });
    }

    public void setScale(double s) {
        this.scale = Math.max(minScale, Math.min(maxScale, s));
    }

    public void setZoomLevel(double zoomFraction) {
        double logMin = Math.log(minScale);
        double logMax = Math.log(maxScale);
        double logScale = logMin + (1 - zoomFraction) * (logMax - logMin);  // Inverted
        this.scale = Math.exp(logScale);
    }

    private Vector2D screenToWorld(int screenX, int screenY) {
        double worldX = (screenX - getWidth() / 2) * scale;
        double worldY = (getHeight() / 2 - screenY) * scale;
        if (focusedBody != null) {
            worldX += focusedBody.getPosition().x;
            worldY += focusedBody.getPosition().y;
        }
        return new Vector2D(worldX, worldY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        Vector2D cameraOffset = (focusedBody != null) ? focusedBody.getPosition() : new Vector2D(0, 0);

        for (CelestialBody body : simulation.getBodies()) {
            // Draw trail
            g2d.setColor(Color.GRAY);
            List<Vector2D> trail = body.getTrail();
            for (int i = 1; i < trail.size(); i++) {
                drawLine(g2d, trail.get(i - 1), trail.get(i), cameraOffset);
            }

            // Draw body
            Vector2D pos = body.getPosition();
            int screenX = (int)(getWidth() / 2 + (pos.x - cameraOffset.x) / scale);
            int screenY = (int)(getHeight() / 2 - (pos.y - cameraOffset.y) / scale);
            int size = Math.max((int)(body.getDiameter() / scale), 3);
            g2d.setColor(body.getColour());
            g2d.fillOval(screenX - size / 2, screenY - size / 2, size, size);
        }
    }

    private void drawLine(Graphics2D g2d, Vector2D p1, Vector2D p2, Vector2D offset) {
        int x1 = (int)(getWidth() / 2 + (p1.x - offset.x) / scale);
        int y1 = (int)(getHeight() / 2 - (p1.y - offset.y) / scale);
        int x2 = (int)(getWidth() / 2 + (p2.x - offset.x) / scale);
        int y2 = (int)(getHeight() / 2 - (p2.y - offset.y) / scale);
        g2d.drawLine(x1, y1, x2, y2);
    }

    public void setFocusedBody(CelestialBody body) {
        this.focusedBody = body;
        repaint();
    }
}
