import java.util.Scanner;
import java.util.Random;

public class Fight {
    
    Character player;
    NPC npc;
    boolean fight;
    int npcInt;
    String npcAction;

    public Fight() {
        fight = true;
        System.out.println("You are fighting " + npc);
        Scanner action = new Scanner(System.in);
        while (fight == true){
            System.out.println("You may either block or swing:");
            String playerAction = action.nextLine().toLowerCase();
            System.out.println("You chose: " + playerAction);
            Random Action = new Random();
            int ncpInt = Action.ints(0,2).findFirst().getAsInt();
            if (npcInt == 0) {
                String npcAction = "swing";
            }
            else {
                String npcAction = "block";
            }
            System.out.println(npc + " chose: " + npcAction);
            
        }
        action.close();
    }
}
