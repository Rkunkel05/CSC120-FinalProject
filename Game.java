import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Game {

    public static ArrayList < Location > map;
    static boolean stillPlaying = true;
    public static ArrayList < NPC > NPCs;
    public static ArrayList < Item > worldItems;

    Item FishingRod;
    Item RoyalAmulet;
    Item GlowingBlossom;

    /**
     * Constructor for map
     */
    public void gameCreation() {
        // Creating a map and adding locations to it
        Game.map = new ArrayList < Location > ();
        map.add(new Location("Kingdom", "The kingdom is a busy, large city with ancient and elegant architecture. Bright banners are draped from the large castle in the center. You can see a bustling marketplace filled with stalls and merchants shouting deals. However, before you can enter far into the city, a woman stumbles into you! You don't need to look closely to recognize her as the kingdom's princess! You can... \n + Talk with her \n + Trade with her \n + Fight her", 0010, true, true));
        map.add(new Location("Village", "The village is a cozy, port-side town. Children run around the cobblestone streets, weaving through stalls packed with goods ranging from fish to exotic fur pelts. A woman with a basket on her hip approaches you with a smile and introduces herself as Mei. You can... \n + Talk with her \n + Trade with her \n + Fight her", 0001, true, true));
        map.add(new Location("Forest", "The forest is a labyrinth of green foliage, with only a skinny, well-traveled pathway marking where to go. Before you can set off into the forest, a forest creature named Nedali jumps out and stops you! You can... \n + Talk with her \n + Trade with her \n + Fight her", 1000, true, true));
        map.add(new Location("Ocean", "The beach is small and sandy, with waves gently coming in at a low tide. Looking out over the water, you find yourself reminiscing over past adventures taken in distant countries. There is not much else to do here. ", 0100, false, false));
        Location tavern = new Location("Tavern", "The tavern has a boisterous, loud atmosphere and is packed full of locals. A woman at the front counter gives you a smile, and she has a small nametag that reads 'Trish'.", 0000, false, false);
        map.add(tavern);

        // Creating a list of all NPCs
        Game.NPCs = new ArrayList < NPC > ();

        // Creating a list of all world items
        Game.worldItems = new ArrayList < Item > ();

        // Creating items for the game
        Item FishingRod = new Item("Enchanted Fishing Rod", "The fishing rod shimmer with a faint sparkle and seemingly hums with power. This would be a perfect gift for someone who likes fishing!", "SWISH! Maybe you'll catch a big one!", true, true, 10);
        Item RoyalAmulet = new Item("Royal Amulet", "An ancient amulet that shimmers with ancient powers. This gift would be perfect for royalty!", "Holding the amulet in your hand you can feel it hum with energy!", true, true, 20);
        Item GlowingBlossom = new Item("Glowing Blossom", "A delicate flower that emits a soft, ethereal glow. This gift would be perfect for someone who is connected to nature!", "A soft, etheral glow is emitted, illuminating the surrounding area with magical light", true, true, 5);
        worldItems.add(FishingRod);
        worldItems.add(RoyalAmulet);
        worldItems.add(GlowingBlossom);
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
    public static void main(String[] args) throws FileNotFoundException {
        // Initializing the game 
        Game game = new Game();
        game.gameCreation();

        Scanner typeInput = new Scanner(System.in);
        String characterType;
        
        do {
            System.out.println("Please select a character (warrior, merchant, friend)");
            characterType = typeInput.nextLine().toLowerCase();

            if (!(characterType.equals("warrior") || characterType.equals("merchant") || characterType.equals("friend"))) {
                System.out.println("Invalid character type. Please choose from warrior, merchant, or friend.");
            }
        } while (!(characterType.equals("warrior") || characterType.equals("merchant") || characterType.equals("friend")));

        // Now characterType contains the valid character type selected by the player
        System.out.println("You have chosen: " + characterType);
        Character Player = new Character(characterType);

        String currentLocationName = Player.getLocation();
        Item FishingRod = game.FishingRod;
        Item RoyalAmulet = game.RoyalAmulet;
        Item GlowingBlossom = game.GlowingBlossom;
        Player.grab(FishingRod);
        Player.grab(RoyalAmulet);
        Player.grab(GlowingBlossom);
        Location currentLocation = null;

        // Creating NPCs
        // Tavern NPC
        NPC Trish = new NPC("Trish", 0000, 10, 10, 10);
        // Kingdom NPC
        NPC Princess = new NPC("Princess", 0010, 5, 10, 4);
        // Forest NPC
        NPC Nedali = new NPC("Nedali", 1000, 10, 8, 6);
        // Village NPC
        NPC Mei = new NPC("Mei", 0001, 3, 7, 2);

        // Creating list of NPCs
        NPCs.add(Trish);
        NPCs.add(Princess);
        NPCs.add(Nedali);
        NPCs.add(Mei);

        for (Location location: Game.map) {
            if (location.getName().equalsIgnoreCase("Tavern")) {
                currentLocation = location;
                break;
            }
        }

        System.out.println("You find yourslf outside of a small tavern. A large, oak door is propped open at the front of the building and you can hear lively chatter and music drifting out from inside.");
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
            } else if (userChoice.contains("sell") || userChoice.contains("trade")) {
                boolean npcFound = false;
                if (currentLocation.hasTrading()) {
                    for (NPC NPC : Game.NPCs) {
                        String[] words = userChoice.split("\\s+");
                        for (String word : words) {
                            if (word.equalsIgnoreCase(NPC.getName())) {
                                if (Player.getLocation().equals(NPC.getLocation())) {
                                    npcFound = true;
                                    System.out.println("What would you like to trade?");
                                    System.out.println("\n*********");
                                    System.out.println("ITEMS FOR SALE: ");
                                    boolean itemSold = false;
    
                                    for (Item item : Player.itemsList) {
                                        if (item.getsellableItem()) {
                                            System.out.println("+ " + item.getName());
                                        }
                                    }
                                    System.out.println("*********\n");
            
                                    String sellingItem = userInput.nextLine().toLowerCase();
                                    boolean found = false;
                                    for (Item item : Player.itemsList) {
                                        if (item.getName().equalsIgnoreCase(sellingItem)) {
                                            Player.itemsList.remove(item);
                                            itemSold = true;
                                            found = true;
            
                                            Player.wealth += item.getPrice();
                                            Player.trades += 1;
            
                                            NPC.tradeObject();
                                            break;
                                        }
                                    }
                                    if (!found) {
                                        System.out.println("You don't have that item.");
                                    }
            
                                    if (itemSold) {
                                        NPC.tradeDialogue(userChoice, Player);
                                        System.out.println("Sold!");
                                        System.out.println("Current balance: $" + Player.getWealth());
                                    }
                                }
                            }
                        }
                    }
                    if (!npcFound) {
                        System.out.println("You are either not in the same location as that character or need to specify someone to trade with!");
                    }
                }
            }

            // Quit game
            else if (userChoice.equals("quit")) {
                System.out.println("Are you sure you want to quit? (y/n)");
                Scanner confirmInput = new Scanner(System.in);
                String confirmChoice = confirmInput.nextLine().toLowerCase();
                if (confirmChoice.equals("y") || confirmChoice.equals("yes")) {
                    System.out.println("Farewell traveler!");
                    stillPlaying = false;
                    userInput.close();
                    confirmInput.close();
                } else {
                    System.out.println("Returning to the game...");
                }
            }

            // Checks if player wants to travel in a certain direction
            else if (userChoice.contains("travel") || userChoice.contains("go") || userChoice.contains("enter")) {
                currentLocation = Player.travel(userChoice);
                if (currentLocation != null) {
                    currentLocationName = currentLocation.getName();
                    System.out.println("You are now at the " + currentLocationName);
                }

                // Case if the player wants to talk with an NPC
            } else if (userChoice.contains("talk")) {
                boolean npcFound = false;
                for (NPC npc: Game.NPCs) {
                    if (npc.getLocation().equalsIgnoreCase(currentLocationName)) {
                        npcFound = true;
                        NPC.talkToUser(userChoice, Player);
                        break;
                    }
                }
                if (!npcFound) {
                    System.out.println("You are either not in the same location as that character or need to specify someone to talk to!");
                }
            }

            // Case if the player wants to fight with an NPC
            else if (userChoice.contains("fight")) {
                boolean npcFound = false;
                if (currentLocation.hasFight()) {
                    System.out.println("Which NPC do you want to fight? (Enter the NPC's name)");
                    String npcName = userInput.nextLine().trim().toLowerCase();
                    NPC npcToFight = null;
                    for (NPC npc : Game.NPCs) {
                        if (npc.getLocation().equalsIgnoreCase(currentLocationName) && npc.getName().equalsIgnoreCase(npcName)) {
                            npcFound = true;
                            npcToFight = npc;
                            break;
                        }
                    }
                    if (npcFound) { 
                        NPC.fightDialogue(userChoice, Player);
                        Fight fight = new Fight(Player, npcToFight);
                        NPCs.remove(npcToFight);
                    } else {
                        System.out.println("You are either not in the same location as that character or need to specify someone to fight with!");
                    }
                }
                

                // Case if the player wants to look at an object
            } else if (userChoice.contains("examine")) {
                System.out.println("What would you like to examine?");
                String examineItemName = userInput.nextLine().toLowerCase();
                boolean itemFound = false;
                for (Item item: Player.itemsList) {
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
                boolean itemFound = false;
                String grabItemName = userInput.nextLine().toLowerCase();
                for (Item item: Game.worldItems) {
                    if (item.getName().equalsIgnoreCase(grabItemName)) {
                        Player.grab(item);
                        itemFound = true;
                        break;
                    }
                }
                if (!itemFound) {
                    System.out.println("You can't pick up an item that doesn't exist!");
                }

                // Case if the player wants to drop an item
            } else if (userChoice.contains("drop")) {
                System.out.println("What would you like to drop?");
                String dropItemName = userInput.nextLine().toLowerCase();
                boolean itemFound = false;
                for (Item item: Player.itemsList) {
                    if (item.getName().equalsIgnoreCase(dropItemName)) {
                        Player.drop(item);
                        itemFound = true;
                        break;
                    }
                }
                if (!itemFound) {
                    System.out.println(dropItemName + " is not in your inventory!");
                }


                // Case if the player wants to view their inventory
            } else if (userChoice.contains("inventory")) {
                Player.printInventory();

                // Case if the player wants to use an item
            } else if (userChoice.contains("use")) {
                boolean itemFound = false;
                System.out.println("What would you like to use?");
                String useItemName = userInput.nextLine().toLowerCase();
                for (Item item: Player.itemsList) {
                    if (item.getName().equalsIgnoreCase(useItemName)) {
                        Player.use(item);
                        itemFound = true;
                        break;
                    }
                }
                if (!itemFound) {
                    System.out.println(useItemName + " is not in your inventory!");
                }
            }

            // Case if player wants to check overall stats
            else if (userChoice.contains("stats")) {
                Player.Stats();
            }

            // Case if the player puts in something the game does not understand
            else {
                System.out.println("I'm not sure what you mean by that, traveler. Please try again!");
                stillPlaying = true;
            }

            //ends the game if the player has reached the goal assigned to their character type
            // Changing this temporarily for presentation day 
            // if (characterType == "merchant" && Player.getTrades() > 5 && Player.getWealth() > 100)
            // System.out.println("Congrats! You have completed " + Player.getTrades() + " trades and made $" + Player.getWealth() + "! \n Excellent work, traveler!");
            if (characterType.equals("merchant") && Player.getTrades() >= 3) {
                //character needs accessors for friends hashtable size and for wealth
                stillPlaying = false;
                System.out.println("Congrats! You have completed " + Player.getTrades() + " trades! \nExcellent work, traveler!");
            } 
            // else if (characterType == "warrior" && Player.battlesWon >= 5)
            else if (characterType.equals("warrior") && Player.battlesWon >= 3) {
                stillPlaying = false;
                System.out.println("Congrats! You have won " + Player.battlesWon + " battles! \nExcellent work, traveler!");
            } else if (characterType.equals("friend") && Player.getfriends() >= 4) {
                stillPlaying = false;
                System.out.println("Congrats! You have made " + Player.getfriends() + " friends! \nExcellent work, traveler!");
            }

        } while (stillPlaying);
        typeInput.close();
    }
}