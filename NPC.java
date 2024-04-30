import java.util.Scanner;
import java.util.ArrayList;
class NPC {

  Scanner conversation = new Scanner(System.in);
  String userInput;
  String name;
  int location;
  ArrayList<Item> itemsList;

  /**
     * Constructor for NPC
     */
    public NPC(int location) {
      this.itemsList = new ArrayList<>();
      this.location = location;
  }

  public static String haveConversation(){
    System.out.println("Hi! My name is" + name ". What's yours?");
    if (userInput == )

  //   public void dialogue(String userChoice) {
  //     for (String NPC : NPCs) {
  //       if (userChoice.contains(NPC)) {
  //           if (currentLocationName == character.getLocation()) {
  //               try {
  //                   // Print dialogue for the specific NPC
  //                   File npcDialogue = new File("Dialogue.txt");
  //                   Scanner fileReader = new Scanner(npcDialogue);
  //                   // Loop until we run out of lines
  //                   while (fileReader.hasNextLine()) {
  //                       String data = fileReader.nextLine();
  //                       if String data.contains(character.getName()) {
  //                           System.out.println(" + " + data);
  //                       }
  //                   }
  //                   // Tidy up
  //                   fileReader.close();
        
  //               } catch (FileNotFoundException e) {
  //                   System.out.println("An error occurred.");
  //                   e.printStackTrace();
  //               }  
  //       } else {
  //           System.out.println("That character is not in the same location as you are!");
  //       } 
  //       } else {
  //           System.out.println("That character does not exist!");
  //     }
  //     }
  //     }
  // }

  public static String tradeObject(){
    //restock, inventory, new arrayList for this class
    // inventory stores certain amount of things 
  }
  
  public static void main(String[] args){
  
  }
  
}
