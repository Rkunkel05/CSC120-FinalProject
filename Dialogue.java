import java.util.Scanner;
import java.util.ArrayList;
class Dialogue {

  public void dialogue() {

  }
  public static void main(String[] arguments) {
    ArrayList<String> transcript = new ArrayList<String>();
   // System.out.print(file:welcomeMessage);
    // transcript.add("How many rounds?");
    Scanner input = new Scanner(System.in);
    int nRounds = input.nextInt();
    input.nextLine(); //clearing new line character
    transcript.add(String.valueOf(nRounds));
    System.out.println("Hi there! What would you like to do next?"); 
    //transcript.add("Hi there! What would you like to do next?");
    for (int i = 0; i < nRounds; i++){
       String user_input = input.nextLine();
     // transcript.add(user_input);
      System.out.println(dialogue);

//if user input is north, print forestMessage
//select either 
      
      //String strArray[];
        //String inputArray = new strArray[];
      // pass lines through a new array, print the arry
      //System.out.println("Transcript:" + )
      //if(userInput contains i):
        //print(f{"you" + input})
      //else input contains am:
        //print(f{"are" + input})
    }
    System.out.println("Goodbye.");
  }
}


// for (Character character : NPCs) {
//   if (userChoice.contains(character.getName())) {
//       if (currentLocationName == character.getLocation()) {
//           try {
//               // Print dialogue for the specific NPC
//               File npcDialogue = new File("Dialogue.txt");
//               Scanner fileReader = new Scanner(npcDialogue);
//               // Loop until we run out of lines
//               while (fileReader.hasNextLine()) {
//                   String data = fileReader.nextLine();
//                   if String data.contains(character.getName()) {
//                       System.out.println(" + " + data);
//                   }
//               }
//               // Tidy up
//               fileReader.close();
  
//           } catch (FileNotFoundException e) {
//               System.out.println("An error occurred.");
//               e.printStackTrace();
//           }  
//   } else {
//       System.out.println("That character is not in the same location as you are!");
//   } 
//   } else {
//       System.out.println("That character does not exist!");
// }
// }