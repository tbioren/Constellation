/*Alright, folks. Here's the game plan: I'm gonna make the program read a fake CSV file.
 * The file will be preformatted following formatting rules in the readme.md file.
*/
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

import javax.swing.JFrame;
import java.awt.Color;

public class App 
{
    public static void main( String[] args ) throws FileNotFoundException {
        JFrame frame;
        final int FRAME_WIDTH = 1024;
        final int FRAME_HEIGHT = 1024;

        /*
        This section reads the provided Constellation.txt file.
        It does this without an API so it's a little bit complicated.
        */
        File constellationFile = new File("src/resources/Constellation.txt");
        // Convert the JSON to a string
        Scanner fr = new Scanner(constellationFile);
        String constellationString = "";
        while(fr.hasNextLine()) constellationString += fr.nextLine() + "\n";
        fr.close();
        String[] constellationStrings = constellationString.split("!!!");
        ArrayList<Constellation> constellations = new ArrayList<Constellation>();
        for(String currStr : constellationStrings) { 
            if(!currStr.isEmpty()) {
                int firstQuote = currStr.indexOf("\"") + 1;
                int secondQuote = currStr.indexOf("\"", firstQuote);
                Constellation currConstellation = new Constellation(currStr.substring(firstQuote, secondQuote));    //Get the name of the constellation
                String[] stars = currStr.substring(secondQuote+1).split("\n");  // Get the next lines
                for(String starStr : stars) {
                    if(!starStr.isEmpty()) {
                        String[] starComponents = starStr.split(",");
                        Star tempStar = new Star();
                        // Assign attributes to star from text file
                        tempStar.setId(Integer.parseInt(starComponents[0]));
                        tempStar.setX(Integer.parseInt(starComponents[1]));
                        tempStar.setY(Integer.parseInt(starComponents[2]));
                        tempStar.setSize(Double.parseDouble(starComponents[3]));
                        tempStar.setColor(starComponents[4].replaceAll("\"", ""));
                        // Get connections
                        starComponents[5] = starComponents[5].replace("[","");
                        starComponents[5] = starComponents[5].replace("]","");
                        String[] connectionStr = starComponents[5].split(" ");
                        ArrayList<Integer> connections = new ArrayList<Integer>();
                        for(String currNum : connectionStr) {
                            if(!currNum.isEmpty()) connections.add(Integer.parseInt(currNum));
                        }
                        tempStar.setConnections(connections.stream().mapToInt(i -> i).toArray());
                        currConstellation.addStar(tempStar);
                        System.out.println();
                    }
                }
                constellations.add(currConstellation);
                }
            }
        // Create the frame
        frame = new JFrame("Constellation");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        for(Constellation c : constellations) {
            frame.add(c);
        }
    }
}
