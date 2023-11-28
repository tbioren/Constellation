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

    // public void paintComponent(Graphics g) {
    //     Graphics2D g2 = (Graphics2D) g;
    //     for(Constellation c : constellations) {
    //         c.paintComponent(g2);
    //     }
    // }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for(Constellation c : constellations) {
            // Draw stars
            for(int i=0; i < c.size(); i++) {
                g2.setColor(c.getStarAtIndex(i).getColor()); 
                int spokes = c.getStarAtIndex(i).STAR_SPOKES;
                double starSize = c.getStarAtIndex(i).getSize();
                int starX = (int) c.getStarAtIndex(i).getX();
                int starY = (int) c.getStarAtIndex(i).getY();
                for(int j=0; j < spokes; j++) {
                    int endX = starX + (int)(starSize*Math.cos((2 * Math.PI/spokes) * j));
                    int endY = starY + (int)(starSize*Math.sin((2 * Math.PI/spokes) * j));
                    g2.drawLine(starX, starY, endX, endY);
                }

                // Draw the connections from this star
                g2.setColor(c.CONNECTION_COLOR);
                for(int j : c.getStarAtIndex(i).getConnections()) {
                    Star connectedStar = c.getStarByID(j);
                    g2.drawLine((int) c.getStarAtIndex(i).getX(), (int) c.getStarAtIndex(i).getY(), (int) connectedStar.getX(), (int) connectedStar.getY());
                }
            }            
        }
    }
}