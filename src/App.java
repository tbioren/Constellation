/*Alright, folks. Here's the game plan: I'm gonna make the program read a fake CSV file.
 * The file will be preformatted following formatting rules in the readme.md file.
*/
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import java.awt.Color;

public class App 
{
    public static void main( String[] args ) throws FileNotFoundException {
        JFrame frame;
        final int FRAME_WIDTH = 1024;
        final int FRAME_HEIGHT = 1024;

        /*
        This section reads the provided Constellation.json file.
        It does this without an API so it's a little bit complicated.
        */
        Constellation constellation = new Constellation();
        File constellationFile = new File("src/resources/Constellation.json");
        // Convert the JSON to a string
        Scanner fr = new Scanner(constellationFile);
        String constellationString = "";
        while(fr.hasNextLine()) constellationString += fr.nextLine();
        fr.close();
        System.out.println(constellationString);
        // Create the frame
        frame = new JFrame("Constellation");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(constellation);
    }
}
