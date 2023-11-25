/*Alright, folks. Here's the game plan: I'm gonna make the program read a fake CSV file.
 * The file will be preformatted following formatting rules in the readme.md file.
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import java.awt.Color;

/**
 * Constellation project. This is a project for CSSE220 students. The project should read information from a text file
 * and draw constellations on screen. 
 */
public class App 
{
    // TODO: Use message chaining
    // TODO: The current goal is to create a constellation, add stars to it individually,
    // then update the attributes of those stars after they're created. Next, I'm gonna
    // use message chains in the drawing
    public static void main( String[] args ) throws FileNotFoundException {
        JFrame frame;
        // Frame width and height. Change to make window bigger and smaller.
        final int FRAME_WIDTH = 1024;
        final int FRAME_HEIGHT = 1024;
        // Points to constellation file.
        File constellationFile = new File("resources/Constellation.txt");
        // Read the file and convert it to a string
        Scanner fr = new Scanner(constellationFile);
        String constellationString = "";
        while(fr.hasNextLine()) constellationString += fr.nextLine() + "\n";
        fr.close();
        // Split the constellation file string into individual constellations by splitting at "!!!"
        String[] constellationStrings = constellationString.split("!!!");
        // Create an ArrayList of constellations
        ArrayList<Constellation> constellations = new ArrayList<Constellation>();
        // Read constellation information from string and create constellation objects
        for(String currStr : constellationStrings) {
            // Only read a string if it isn't empty. I'm doing this because String.split("!!!") leaves some blank strings.
            if(!currStr.isEmpty()) {
                // Create and name the constellation
                int firstQuote = currStr.indexOf("\"") + 1;
                int secondQuote = currStr.indexOf("\"", firstQuote);
                Constellation currConstellation = new Constellation(currStr.substring(firstQuote, secondQuote));    //Get the name of the constellation
                // Split the information for stars into individual Strings
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
                        tempStar.setConnections(connections.stream().mapToInt(i -> i).toArray());   // Set the connections of the star
                        currConstellation.addStar(tempStar);    // Add the star to the constellation
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
        // frame.add(constellations.get(1));
        frame.setVisible(true);
        NightSky ns = new NightSky();
        for(Constellation c : constellations) {
            ns.addConstellation(c);
        }
        frame.add(ns);
    }
}
