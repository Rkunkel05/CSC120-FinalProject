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

     public int getLocation() {
      return this.location;
     }

    /**
     * @param String userChoice 
     * @return
     */

     // Failing check to see if userChoice contains certain key words
     // Logic issue...? Would fight / trade deserve different dialogue options instead...? Feels strange to condense into one 
    public static void talkToUser(String userChoice, Character Player) throws FileNotFoundException {
      for (NPC NPC : Game.NPCs) {
        System.out.println("Checking NPC: " + NPC.getName());
        String[] words = userChoice.split("\\s+");
        for (String word : words) {
          System.out.println("Checking word: " + word);
          if (word.equalsIgnoreCase(NPC.getName())) {
            System.out.println("NPC Found: " + NPC.getName());
            if (Player.getLocation().equals(NPC.getLocation())) {
              System.out.println("Player and NPC are in the same location.");
              File npcDialogue = new File("Dialogue.txt");
              Scanner fileReader = new Scanner(npcDialogue);
              while (fileReader.hasNextLine()) {
                  String data = fileReader.nextLine();
                  if (data.contains(NPC.getName())) {
                    // checking if user wants to fight to print fight dialogue
                      if (userChoice.contains("fight") && data.contains("fight: ")) {
                          System.out.println("Contains mention of fight");
                          System.out.println(data.substring(data.indexOf("fight: ") + "fight: ".length()));
                          break;
                    // checking if user wants to trade to print trade fialogue
                      } else if (userChoice.contains("trade") && data.contains("trade: ")) {
                        System.out.println("Contains mention of trade");
                          System.out.println(data.substring(data.indexOf("trade: ") + "trade: ".length()));
                          break;
                    // checking if user just wants to talk and prints default dialogue 
                      } else if (data.contains("default: ")) {
                        System.out.println("Contains mention of default");
                          System.out.println(data.substring(data.indexOf("default: ") + "default: ".length()));
                          break;
                      }
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
