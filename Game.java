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
        map.add(new Location("Kingdom", "The kingdom is a busy, large city with ancient and elegant architecture. Bright banners are draped from the large castle in the center. You can see a bustling marketplace filled with stalls and merchants shouting deals.", 0010, true));
        map.add(new Location("Village", "The village is a cozy, port-side town. Children run around the cobblestone streets, weaving through stalls packed with goods ranging from fish to exotic fur pelts. This could be a perfect place to set up shop!", 0001, true));
        map.add(new Location("Forest", "The forest is a labyrinth of green foliage, with only a skinny, well-traveled pathway marking where to go. It would be easy to get lost here if you went off the pathway… Who knows what creatures await here…!", 1000, true));
        map.add(new Location("Ocean", "The beach is small and sandy, with waves gently coming in at a low tide. Looking out over the water, you find yourself reminiscing over past adventures taken in distant countries. There is not much else to do here. ", 0100, false));
        map.add(new Location("Tavern", "The tavern has a boisterous, loud atmosphere and is packed full of locals. A woman at the front counter gives you a smile. ", 0000, false));
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
            Character Player = new Character();
            String currentLocationName = Player.getLocation();
            Location currentLocation = null;

            System.out.println("You find yourslf outside of a small tavern. A large, oak door remains propped open at the front of the building and you can hear lively chatter and music drifting out from inside.");
            System.out.println("What would you like to do? (for guidance, enter HELP)");

            do {
                Scanner userInput = new Scanner(System.in);
                String userChoice = userInput.nextLine().toLowerCase();
        
                // Checks if user wants to enter a building
                if (userChoice.contains("enter")) {
                    System.out.println("You enter the " + currentLocationName);
                } else if (userChoice.contains("help")) {
                    game.showOptions();
        
                 // Checks if user wants to examine a location
                } else if (userChoice.contains("look") || userChoice.contains("around")) {
                    String description = "";
                    for (Location location: game.map) {
                        description = location.getDescription();
                        if (location.getName().equalsIgnoreCase(currentLocationName)) {
                            System.out.println("You are at the " + currentLocationName + ". " + description);
                            break;
                        }
                    }
        
                // Checks if user wants to sell at a location 
                // Currently having a problem where it does not let you trade regardless of whether or not the location hasTrading = true
                } else if (userChoice.contains("sell") || userChoice.contains("trade")) {
                    if (currentLocation != null && currentLocation.hasTrading()) {
                        System.out.println("What would you like to trade?");
                    } else {
                        System.out.println("You cannot trade here traveler! Try going to a different location that has a marketplace.");
                    }
                    
                // Quit game
                } else if (userChoice.equals("quit")) {
                    System.out.println("Are you sure you want to quit? (y/n)");
                    Scanner confirmInput = new Scanner(System.in);
                    String confirmChoice = confirmInput.nextLine().toLowerCase();
                    if (confirmChoice.equals("y") || confirmChoice.equals("yes")) {
                        System.out.println("Farewell traveler!");
                        stillPlaying = false;
                        userInput.close();
                        confirmInput.close();
                    }
                    else {
                        System.out.println("Returning to the game...");
                    }
                } 

                // Checks if user wants to travel in a certain direction
                else if (userChoice.contains("travel") || userChoice.contains("go")) {
                    Player.travel(userChoice);
        
                // Case if the user puts in something the game does not understand
                } else {    
                    System.out.println("I'm not sure what you mean by that, traveler. Please try again!");
                    stillPlaying = true;
                }
            } while (stillPlaying);
        }
    }
        



