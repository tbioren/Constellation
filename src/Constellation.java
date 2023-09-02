import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

/**
 * Holds stars and draws them.
 */
public class Constellation {
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

    private Point getAverageStarLocation() {
        int xAccumulator=0, yAccumulator=0;
        for(Star s : stars) {
            xAccumulator += s.getX();
            yAccumulator += s.getY();
        }
        return new Point(xAccumulator/stars.size(), yAccumulator/stars.size());
    }

    public void paintComponent(Graphics2D g2) {
        // Draw each star by calling their drawOn() methods
        for(Star star : stars) {
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
        Point avgPoint = getAverageStarLocation();
        g2.drawString(name,(int) avgPoint.getX(), (int) avgPoint.getY());
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
