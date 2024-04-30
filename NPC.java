import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

class NPC {

    Scanner conversation = new Scanner(System.in);
    String userInput;
    String name;
    int location;
    ArrayList < Item > itemsList;

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

    public static String tradeObject() {
      return "";
        //restock, inventory, new arrayList for this class
        // inventory stores certain amount of things 
    }
}
