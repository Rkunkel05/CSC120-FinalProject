import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;

class NPC {

    Scanner conversation = new Scanner(System.in);
    String userInput;
    String name;
    int location;
    ArrayList < Item > itemsList;
    private Hashtable<String, Boolean> inventory; 

    /**
     * Constructor for NPC
     */
    public NPC(String name, int location) {
        this.itemsList = new ArrayList < > ();
        this.location = location;
        this.name = name;
    }

    /*
     * Getters
     */
     public String getName() {
      return this.name;
     }

     public String getLocation() {
      if (this.location == (0000)) {
          return "Tavern";
      } else if (this.location == (1000)) {
          return "Forest";
      } else if (this.location == (0100)) {
          return "Ocean";
      } else if (this.location == (0010)) {
          return "Village";
      } else {
          return "Kingdom";
      }
  }

    /**
     * @param userChoice is the input from the player 
     * Splits the player's input up into a list of words and checks those to see if there is a mention of an NPC. Checks to see if the player is in the same location as the NPC, and if they are, prints out the NPC's default dialogue.
     */
    public static void talkToUser(String userChoice, Character Player) throws FileNotFoundException {
      for (NPC NPC : Game.NPCs) {
        String[] words = userChoice.split("\\s+");
        for (String word : words) {
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
      for (NPC NPC : Game.NPCs) {
        String[] words = userChoice.split("\\s+");
        for (String word : words) {
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
      for (NPC NPC : Game.NPCs) {
        String[] words = userChoice.split("\\s+");
        for (String word : words) {
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

    public static String tradeObject() {
        private Hashtable<String, Boolean> collection; 
  //collection creates a hashtable to store items in inventory as well as whether or not they are already in inventory

  public static String tradeObject(){
    //restock, inventory, new arrayList for this class
    // inventory stores certain amount of things 
    public void addItem(String item){
      this.inventory.put(item, true);

    }
     public String removeItem(String item){
       this.inventory.remove(item);
      return item;

    } // return the item that we removed

    public boolean containsItem(String item){
      return this.inventory.containsKey(item);
    }
      // returns true if the title appears as a key in the Libary's collection, false otherwise
    public boolean isAvailable(String item){
      return this.inventory.get(item);
    } // returns true if the item is currently in inventory, false otherwise
  
      return "";
    }
}
