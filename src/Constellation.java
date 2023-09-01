import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JComponent;

// this class hopefully will draw lines between the stars and call the drawOn() method of each star
public class Constellation extends JComponent {
    private final Color CONNECTION_COLOR = Color.WHITE;
    private ArrayList<Star> stars;
    private String name;

    public Constellation() {
        stars = new ArrayList<Star>();
    }

    public Constellation(String name) {
        this();
        this.name = name;
    }

    public ArrayList<Star> getStars() {
        return stars;
    }

    public void addStar(Star star) {
        stars.add(star);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // Draw each star by calling their drawOn() methods
        for(Star star : stars) {
            // TODO: implement drawOn() method
            star.drawOn(g2);
        }

        // Draw lines between stars
        g2.setColor(CONNECTION_COLOR);
        for(Star star : stars) {
            for(int i : star.getConnections()) {
                Star connectedStar = getStarByID(i);
                g2.drawLine((int) star.getX(), (int) star.getY(), (int) connectedStar.getX(), (int) connectedStar.getY());
            }
        }
    }

    private Star getStarByID(int id) {
        for(Star star : stars) {
            if(star.getId() == id) {
                return star;
            }
        }
        return null;
    }
}
