import java.io.File;
import java.io.FileInputStream;
import javax.swing.JFrame;
import java.awt.Color;

public class App 
{
    public static void main( String[] args ) {
        JFrame frame;
        final int FRAME_WIDTH = 1024;
        final int FRAME_HEIGHT = 1024;

        /*
        The goal of this part of the program is to:
        1. Create a Constellation object
        2. Read the Constellation.json file
        3. Populate the Constellation object line by line with the data from the file
        */
        Constellation constellation = new Constellation();
        File constellationFile = new File("src/main/resources/Constellation.json");

        // Create the frame
        frame = new JFrame("Constellation");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(constellation);
    }
}
