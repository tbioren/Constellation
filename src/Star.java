import java.awt.Color;
import java.awt.Graphics2D;


/**
 * Is a star. It gets drawn on the screen.
 */
public class Star {
    private static final int STAR_SPOKES = 6;
    private int id;
    private int x;
    private int y;
    private double size;
    private Color color;
    private int[] connections;

    public Star() {
    }

    /**
     * Prints out the properties of the star to the console.
     */
    public String toString() {
        String output = "Star [id=" + id + ", x=" + x + ", y=" + y + ", size=" + size + ", color=" + color + ", [";
        for(int i : connections) {
            output += i + ", ";
        }
        output = output.substring(0, output.length()-2) + "]";
        return output;
    }

    /**
     * Draws the star to the screen.
     * @param g2 Grahpics2D object to be passed
     */
    public void drawOn(Graphics2D g2) {
        g2.setColor(color);
        for(int i=0; i < STAR_SPOKES; i++) {
            int endX = x + (int)(size*Math.cos((2 * Math.PI/STAR_SPOKES) * i));
            int endY = y + (int)(size*Math.sin((2 * Math.PI/STAR_SPOKES) * i));
            g2.drawLine(x, y, endX, endY);
        }
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public double getSize() {
        return size;
    }
    public void setSize(double size) {
        this.size = size;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = Color.decode(color);
    }
    public int[] getConnections() {
        return connections;
    }
    public void setConnections(int[] connections) {
        this.connections = connections;
    }
}