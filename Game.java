import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Game {

    private ArrayList < Location > map;
    static boolean stillPlaying = true;

    /**
     * Constructor for map
     */
    public void gameCreation() {
        // Creating a map and adding locations to it, initilizing NPCs, etc. 
        this.map = new ArrayList < Location > ();
        map.add(new Location("Kingdom", "[info about kingdom]", 0010, true));
        map.add(new Location("Village", "[info about village]", 0001, true));
        map.add(new Location("Forest", "[info about forest]", 1000, true));
        map.add(new Location("Ocean", "[info about ocean]", 0100, false));
        map.add(new Location("Tavern", "[info about tavern]", 0000, false));
    }


    /**
     * Displays all available actions 
     */
    public void showOptions() {
        System.out.println("\n*********");
        System.out.println("GAME OPTIONS");
        try {
            File myFile = new File("GameOptions.txt");
            Scanner fileReader = new Scanner(myFile);
            // Loop until we run out of lines
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                System.out.println(" + " + data);
            }
            // Tidy up
            fileReader.close();
        
            } catch (FileNotFoundException e) { 
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    System.out.println("*********\n");
    }

    // game loop
    public static void main(String[] args) {
        // Initializing the game 
        Game game = new Game();
        game.gameCreation();
        System.out.println(game.map);
        Character Player = new Character();
        // Initializing the NPCs
        // Character Trish = new Character();

        System.out.println("You find yourslf outside of a small tavern. A large, oak door remains propped open at the front of the building and you can hear lively chatter and music drifting out from inside.");
        System.out.println("What would you like to do? (for guidance, enter HELP)");

        do {
            Scanner userInput = new Scanner(System.in);
            String userChoice = userInput.nextLine().toLowerCase();
            // Checks if user wants to enter a building
            if (userChoice.contains("enter")) {
                String currentLocationName = Player.getLocation();
                System.out.println("You enter the " + currentLocationName);
            } else if (userChoice.contains("help")) {
                game.showOptions();
            // checks if user wants to examine a location
            } else if (userChoice.contains("look") || userChoice.contains("around")) {
                String currentLocationName = Player.getLocation();
                String description = "";
                for (Location location: game.map) {
                    description = location.getDescription();
                    if (location.getName().equalsIgnoreCase(currentLocationName)) {
                        System.out.println("You are at the " + currentLocationName+ ". " + description);
                        break;
                    }
                }
            } else if (userChoice.equals("quit") || userChoice.equals("leave")) {
                System.out.println("Are you sure you want to quit? (y/n)");
                Scanner confirmInput = new Scanner(System.in);
                String confirmChoice = confirmInput.nextLine().toLowerCase();
                if (confirmChoice.equals("y") || confirmChoice.equals("yes")) {
                    System.out.println("Farewell traveler!");
                    stillPlaying = false;
                    userInput.close();
                    confirmInput.close();
                }
            } else {
                System.out.println("I'm not sure what you mean by that, traveler. Please try again!");
            }
        } while (stillPlaying);
    }
}
            // [where to go w/ code from here!]
            // start text sequence w/ trish 
            // chosing what direction to go in 
            // exploring, trading, talking, give away key item x4
            // end of game --> whoever you got the most stats with = besties wahoo! (:



