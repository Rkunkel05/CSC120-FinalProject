import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Game {

    public static ArrayList < Location > map;
    static boolean stillPlaying = true;
    public static ArrayList<NPC> NPCs;

    /**
     * Constructor for map
     */
    public void gameCreation() {
        // Creating a map and adding locations to it, initilizing NPCs, etc. 
        Game.map = new ArrayList < Location > ();
        map.add(new Location("Kingdom", "The kingdom is a busy, large city with ancient and elegant architecture. Bright banners are draped from the large castle in the center. You can see a bustling marketplace filled with stalls and merchants shouting deals.", 0010, true));
        map.add(new Location("Village", "The village is a cozy, port-side town. Children run around the cobblestone streets, weaving through stalls packed with goods ranging from fish to exotic fur pelts. This could be a perfect place to set up shop!", 0001, true));
        map.add(new Location("Forest", "The forest is a labyrinth of green foliage, with only a skinny, well-traveled pathway marking where to go. It would be easy to get lost here if you went off the pathway… Who knows what creatures await here…!", 1000, true));
        map.add(new Location("Ocean", "The beach is small and sandy, with waves gently coming in at a low tide. Looking out over the water, you find yourself reminiscing over past adventures taken in distant countries. There is not much else to do here. ", 0100, false));
        Location tavern = new Location("Tavern", "The tavern has a boisterous, loud atmosphere and is packed full of locals. A woman at the front counter gives you a smile, and she has a small nametag that reads 'Trish'. ", 0000, false);
        map.add(tavern);
        Game.NPCs = new ArrayList<NPC>();
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
    @SuppressWarnings("unlikely-arg-type")
    public static void main(String[] args) throws FileNotFoundException {
            // Initializing the game 
            Game game = new Game();
            game.gameCreation();
            
            System.out.println("Please select a character (warrior, merchant, friend)");
            Scanner typeInput = new Scanner(System.in);
            String characterType = typeInput.nextLine().toLowerCase();
            //need exception here to catch user error
            typeInput.close();
            Character Player = new Character(characterType);
            
            String currentLocationName = Player.getLocation();
            Location currentLocation = null;

            // Creating NPCs
            NPC Trish = new NPC("Trish", 0000);
            NPC fillerKingdom = new NPC("fillerKingdom", 0010);
            NPC fillerForest = new NPC("fillerForest", 1000);
            NPC fillerVillage = new NPC("fillerVillage", 0001);

            // Creating list of NPCs
            NPCs.add(Trish);
            NPCs.add(fillerKingdom);
            NPCs.add(fillerForest);
            NPCs.add(fillerVillage);

            for (Location location : Game.map) {
                if (location.getName().equalsIgnoreCase("Tavern")) {
                    currentLocation = location;
                    break;
                }
            }

            System.out.println("You find yourslf outside of a small tavern. A large, oak door remains propped open at the front of the building and you can hear lively chatter and music drifting out from inside.");
            System.out.println("What would you like to do? (for guidance, enter HELP)");

            do {
                Scanner userInput = new Scanner(System.in);
                String userChoice = userInput.nextLine().toLowerCase();
                          
                // Checks if player wants the help menu
                if (userChoice.contains("help")) {
                    game.showOptions();
        
                    // Checks if user wants to examine a location
                } else if (userChoice.contains("look") || userChoice.contains("around")) {
                    String description = "";
                    for (Location location: Game.map) {
                        if (location.getName().equalsIgnoreCase(currentLocationName)) {
                            description = currentLocation.getDescription();
                            System.out.println("You are at the " + location.getName() + ". " + description);
                            break;
                        }
                    }
        
                // Checks if user wants to sell at a location 
                    // Checks if user wants to sell at a location 
                } else if (userChoice.contains("sell") || userChoice.contains("trade")) {
                    if (currentLocation.hasTrading()) {
                        System.out.println("What would you like to trade?"); 
                        System.out.println("\n*********");
                        System.out.println("ITEMS FOR SALE: ");
                        boolean itemSold = false; 
                        for (Item item : Player.itemsList) { 
                            if (item.getsellableItem()) {
                                System.out.println("+ " + item);
                            }
                        }
                        System.out.println("*********\n");
                        if (Player.itemsList.isEmpty()) {
                            System.out.println("You have no items to sell.");
                        } else {

                            String sellingItem = userInput.nextLine().toLowerCase();
                            if (Player.itemsList.contains(sellingItem)) {
                                System.out.println("Sold!");
                                Player.itemsList.remove(sellingItem);
                                itemSold = true;
                            } else {
                                System.out.println("You don't have that item.");
                            }
                        }
                        if (itemSold) {
                            System.out.println("You made:  $" + "[insert however we're measuring profit]");
                            System.out.println("Current balance: $");
                        }
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

                // Checks if player wants to travel in a certain direction
                else if (userChoice.contains("travel") || userChoice.contains("go")) {
                    currentLocation = Player.travel(userChoice);
                    if (currentLocation != null) {
                        currentLocationName = currentLocation.getName();
                        System.out.println("You are now at the " + currentLocationName);
                    }
        
                // Case if the player wants to talk with an NPC
                } else if (userChoice.contains("talk")) {
                    // Call on dialogue.java class to run code 
                    NPC.talkToUser(userChoice, Player);
                
                // Case if the player wants to look at an object
                } else if (userChoice.contains("examine")) {
                    System.out.println("What would you like to examine?");
                    String examineItemName = userInput.nextLine().toLowerCase();
                    boolean itemFound = false;
                    for (Item item : Player.itemsList) {
                        if (item.getName().equalsIgnoreCase(examineItemName)) {
                            System.out.println(item.getDescription());
                            itemFound = true;
                            break;
                        }
                    }
                    if (!itemFound) {
                        System.out.println("You don't have that item in your inventory. Try picking it up first to examine it!");
                    }

                // Case if the player wants to pick up an item
                // I feel like the logic is flawed here... Do we maybe need a list of all items in the world...?
                } else if (userChoice.contains("grab")) {
                    System.out.println("What would you like to grab?");
                    String grabItemName = userInput.nextLine().toLowerCase();
                    // maybe make this a global list of all items...?
                    for (Item item : Player.itemsList) {
                        if (item.getName().equalsIgnoreCase(grabItemName)) {
                            Player.grab(item.getName());
                            break;
                        }
                    }
                
                // Case if the player wants to drop an item
                } else if (userChoice.contains("drop")) {
                    System.out.println("What would you like to drop?");
                    String dropItemName = userInput.nextLine().toLowerCase();
                    boolean itemFound = false;
                    for (Item item : Player.itemsList) {
                        if (item.getName().equalsIgnoreCase(dropItemName)) {
                            Player.drop(item.getName());
                            itemFound = true;
                            break;
                        }
                    }
                    if (!itemFound) {
                        System.out.println(dropItemName + " is not in your inventory!");
                    }


                // Case if the player puts in something the game does not understand
            }   else {    
                    System.out.println("I'm not sure what you mean by that, traveler. Please try again!");
                    stillPlaying = true;
                }
                
                //ends the game if the player has reached the goal assigned to their character type
                if (characterType == "merchant" && Player.getTrades()>5 && Player.getWealth()>100){
                    //character needs accessors for friends hashtable size and for wealth
                    stillPlaying = false;
                    System.out.println("Congrats! You have completed " + Player.getTrades() + " trades and made $" + Player.getWealth() + "!");
                }
                else if (characterType == "warrior" && Player.battlesWon>=5){
                    stillPlaying = false;
                    System.out.println("Congrats! You have won " + Player.battlesWon + " battles!");
                }
                else if (characterType == "friend"){
                    stillPlaying = false;
                    System.out.println("Congrats! You have made " + Player.getfriends() + " friends!");
                }
                

            } while (stillPlaying);
        }
}


