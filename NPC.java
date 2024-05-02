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
     */
    public NPC(String name, int location, int npcArmour, int npcLife, int skill) {
        this.itemsList = new ArrayList < > ();
        this.location = location;
        this.name = name;
        this.npcArmour = npcArmour;
        this.npcLife = npcLife;
        this.skill = skill;

    }

    /*
     * Getters
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
        } else if (this.location == 0010) {
            return "Village";
        } else {
            return "Kingdom";
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
     * @param userChoice is the input from the player 
     * Splits the player's input up into a list of words and checks those to see if there is a mention of an NPC. Checks to see if the player is in the same location as the NPC, and if they are, prints out the NPC's default dialogue.
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
        System.out.println("That character does not exist or is not in the same location as you are!");
    }

    /**
     * @param userChoice is the input from the player 
     * Splits the player's input up into a list of words and checks those to see if there is a mention of an NPC. Checks to see if the player is in the same location as the NPC, and if they are, prints out the NPC's fight dialogue.
     */
    public static void fightDialogue(String userChoice, Character Player) throws FileNotFoundException {
        for (NPC NPC: Game.NPCs) {
            String[] words = userChoice.split("\\s+");
            for (String word: words) {
                if (word.equalsIgnoreCase(NPC.getName())) {
                    if (Player.getLocation().equals(NPC.getLocation())) {
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
        System.out.println("That character does not exist or is not in the same location as you are!");
    }

    /**
     * @param userChoice is the input from the player 
     * Splits the player's input up into a list of words and checks those to see if there is a mention of an NPC. Checks to see if the player is in the same location as the NPC, and if they are, prints out the NPC's trade dialogue.
     */
    public static void tradeDialogue(String userChoice, Character Player) throws FileNotFoundException {
        for (NPC NPC: Game.NPCs) {
            String[] words = userChoice.split("\\s+");
            for (String word: words) {
                if (word.equalsIgnoreCase(NPC.getName())) {
                    if (Player.getLocation().equals(NPC.getLocation())) {
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
        System.out.println("That character does not exist or is not in the same location as you are!");
    }

    /**
     * @return string
     * Trade an object 
     */
    public static String tradeObject() {
        Hashtable < String, Boolean > collection;
        return "";
    }

    //collection creates a hashtable to store items in inventory as well as whether or not they are already in inventory
    /**
     * 
     * @param item is hte item to be added
     * Adds an item to the inventory
     */
    public void addItem(String item) {
        this.inventory.put(item, true);
    }

    /**
     * 
     * @param item is the item to be removed
     * @return item being removed 
     * Removes an item from the inventory 
     */
    public String removeItem(String item) {
        this.inventory.remove(item);
        return item;
    } // return the item that we removed

    /**
     * @param item is the item being checked
     * @return whether or not the inventory contains the item
     * Checks whether ot not a given item is in the inventory 
     */
    public boolean containsItem(String item) {
        return this.inventory.containsKey(item);
    }

    /**
     * @param item is the item being checked
     * @return whether or not the item is currently in inventory, false otherweise
     * Checks if an item is available
     */
    public boolean isAvailable(String item) {
        return this.inventory.get(item);
    } 
}