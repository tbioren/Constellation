# The Constellation Project

**I AM AWARE THAT I SHOULDN'T USE THE JACKSON API. I'LL REMOVE IT WHEN I REFACTOR THE CODE**

## Project Requirements:
The Constellation Project loads constellations from datafiles (JSON files). The program then draws these constellations on screen. There is one datafile per "night sky" i.e. the program only loads one datafile. Each datafile contains a set of constellations. Each constellation gets a unique name and a set of stars. Each star has a location, size, color, and list of other stars that it is connected to. A completed constellation may look like this:![Alt text](ConstellationScreenshot.jpg "Example of what an output would look like")

## Some caveats:
- There may be data duplication if the datafiles say that star A is connected to star B and star B is connected to star A. This is acceptable because it's not your fault; it's the fault of the person providing the datafile. Having data duplication for any other reason is unacceptable.
- You don't have to implement anything with the names of the constellations provided in the datafiles. **Extra credit if you include the names of the constellations near the constellations on the window**