import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 * NightSky class holds the constellations and calls their paintComponent methods.
 */
public class NightSky extends JComponent{
    private ArrayList<Constellation> constellations;
    
    public NightSky() {
        constellations = new ArrayList<Constellation>();
    }

    public void addConstellation(Constellation c) {
        constellations.add(c);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for(Constellation c : constellations) {
            c.paintComponent(g2);
        }
    }
}