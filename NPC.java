import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;

class NPC {
    Scanner conversation = new Scanner(System.in);
    String userInput;
    String name;
    int npcArmour;
    int npcLife;
    int location;
    int skill;
    ArrayList < Item > itemsList;
    private Hashtable < String, Boolean > inventory;

    /**
     * Constructor for NPC
     * @param name is the name
     * @param location is the location
     * @param npcArmour is the armour stats 
     * @param npcLife is the health
     * @param skill is how much skill it has
     */
    public NPC(String name, int location, int npcArmour, int npcLife, int skill) {
        this.itemsList = new ArrayList < > ();
        this.location = location;
        this.name = name;
        this.npcArmour = npcArmour;
        this.npcLife = npcLife;
        this.skill = skill;

    }

    /**
     * Getter
     * @return the requested information
     */
    public String getName() {
        return this.name;
    }

    public String getLocation() {
        if (this.location == 0000) {
            return "Tavern";
        } else if (this.location == 1000) {
            return "Forest";
        } else if (this.location == 0100) {
            return "Ocean";
        } else if (this.location == 0001) {
            return "Village";
        } else if (this.location == 0010) {
            return "Kingdom";
        } else {
            return "";
        }
    }

    public int getArmour() {
        return this.npcArmour;
    }

    public int getLife() {
        return this.npcLife;
    }

    public int getSkill() {
        return this.skill;
    }

    /**
     * Splits the player's input up into a list of words and checks those to see if there is a mention of an NPC. Checks to see if the player is in the same location as the NPC, and if they are, prints out the NPC's default dialogue.
     * @param userChoice is the input from the player 
     * @param Player is the player's information
     */
    public static void talkToUser(String userChoice, Character Player) throws FileNotFoundException {
        for (NPC NPC: Game.NPCs) {
            String[] words = userChoice.split("\\s+");
            for (String word: words) {
                if (word.equalsIgnoreCase(NPC.getName())) {
                    if (Player.getLocation().equals(NPC.getLocation())) {
                        File npcDialogue = new File("Dialogue.txt");
                        Scanner fileReader = new Scanner(npcDialogue);
                        while (fileReader.hasNextLine()) {
                            String data = fileReader.nextLine();
                            if (data.contains(NPC.getName()) && data.contains("default:")) {
                                System.out.println(NPC.getName() + ": " + data.substring(data.indexOf("default: ") + "default: ".length()));
                            }
                        }
                        fileReader.close();
                        return;
                    }
                }
            }
        }
        System.out.println("You must specify a character to talk to!");
    }

    /**
     * Splits the player's input up into a list of words and checks those to see if there is a mention of an NPC. Checks to see if the player is in the same location as the NPC, and if they are, prints out the NPC's fight dialogue.
     * @param userChoice is the input from the player 
     * @param Player is the player's information
     */
    public static void fightDialogue(String userChoice, Character Player) throws FileNotFoundException {
        boolean npcFound = false; 
        for (NPC NPC: Game.NPCs) {
            String[] words = userChoice.split("\\s+");
            for (String word: words) {
                if (word.equalsIgnoreCase(NPC.getName())) {
                    if (Player.getLocation().equals(NPC.getLocation())) {
                        npcFound = true; 
                        File npcDialogue = new File("Dialogue.txt");
                        Scanner fileReader = new Scanner(npcDialogue);
                        while (fileReader.hasNextLine()) {
                            String data = fileReader.nextLine();
                            if (data.contains(NPC.getName()) && data.contains("fight:")) {
                                System.out.println(NPC.getName() + ": " + data.substring(data.indexOf("fight: ") + "fight: ".length()));
                            }
                        }
                        fileReader.close();
                        return;
                    }
                }
            }
        }
        System.out.println("You must specify a character to fight with!");
    }

    /**
     *  Splits the player's input up into a list of words and checks those to see if there is a mention of an NPC. Checks to see if the player is in the same location as the NPC, and if they are, prints out the NPC's trade dialogue.
     * @param userChoice is the input from the player 
     * @param Player is the player's information
     */
    public static void tradeDialogue(String userChoice, Character Player) throws FileNotFoundException {
        boolean npcFound = false; 
        for (NPC NPC: Game.NPCs) {
            String[] words = userChoice.split("\\s+");
            for (String word: words) {
                if (word.equalsIgnoreCase(NPC.getName())) {
                    if (Player.getLocation().equals(NPC.getLocation())) {
                        npcFound = true; 
                        File npcDialogue = new File("Dialogue.txt");
                        Scanner fileReader = new Scanner(npcDialogue);
                        while (fileReader.hasNextLine()) {
                            String data = fileReader.nextLine();
                            if (data.contains(NPC.getName()) && data.contains("trade:")) {
                                System.out.println(NPC.getName() + ": " + data.substring(data.indexOf("trade: ") + "trade: ".length()));
                            }
                        }
                        fileReader.close();
                        return;
                    }
                }
            }
        }
        System.out.println("You must specify a character to trade with!");
    }

    /**
     * @return string
     * Trade an object 
     */
    public static String tradeObject() {
        Hashtable < String, Boolean > collection;
        return "";
    }

     /**
      * Adds an item to the inventory
      * @param item item being added
      */
    public void addItem(String item) {
        this.inventory.put(item, true);
    }

    /**
     * Removes an item from the inventory
     * @param item item being removed
     * @return removed item
     */
    public String removeItem(String item) {
        this.inventory.remove(item);
        return item;
    } // return the item that we removed

    /**
     * Checks whether or not a given item is in the inventory 
     * @param item is the item being checked
     * @return whether or not the inventory contains the item
     */
    public boolean containsItem(String item) {
        return this.inventory.containsKey(item);
    }

    /**
     * Checks if an item is available
     * @param item is the item being checked
     * @return whether or not the item is currently in inventory, false otherweise
     */
    public boolean isAvailable(String item) {
        return this.inventory.get(item);
    } 
}