import java.util.Scanner;
import java.util.Random;

public class Fight {
    
    Character player;
    NPC npc;
    boolean fight;
    int npcInt;
    String npcAction;
    int npcLife;
    int npcArmour = npc.armour;

    public Fight(Character player, NPC npc) {
        fight = true;
        System.out.println("You are fighting " + npc);
        Scanner action = new Scanner(System.in);
        while (fight == true){
            System.out.println("You may either block or attack:");
            String playerAction = action.nextLine().toLowerCase();
            System.out.println("You chose: " + playerAction);
            //randomly picks an action for the npc to take
            Random Action = new Random();
            int ncpInt = Action.ints(0,2).findFirst().getAsInt();
            if (npcInt == 0) {
                String npcAction = "attack";
            }
            else {
                String npcAction = "block";
            }
            System.out.println(npc + " chose: " + npcAction);
            
            if (playerAction == "attack" && npcAction == "attack"){
                if (player.skill > npc.skill){
                    npcLife -= 2;
                    player.health -= 1;
                }
                else if (player.skill < npc.skill){
                    npcLife -= 1;
                    player.health -= 2;
                }
                else if (player.skill == npc.skill){
                    npcLife -= 1;
                    player.health -= 1;
                }
            }

            if (playerAction == "attack" && npcAction == "block"){
                if (player.skill > npcArmour){
                    if (npcArmour >= 2){;
                        npcArmour -=2;
                    }
                    else {
                        npcLife -=1;
                    }
                }
                if (player.skill == npcArmour){
                    if (npcArmour != 0){;
                        npcLife -= 1;
                    }
                }
                //if the armour is greater than the skill nothing happens
            }

            if (playerAction == "block" && npcAction == "attack"){
                if (npc.skill > player.armour){
                    if (player.armour >= 2){;
                        player.armour -=2;
                    }
                    else {
                        player.health -=1;
                    }
                }
                if (player.skill == npcArmour){
                    if (player.armour != 0){;
                        player.health -= 1;
                    }
                }
                //if the armour is greater than the skill nothing happens
                //if both players pick block nothing happens
            }
            if (player.health <= 0){
                Game.stillPlaying = false;

            }
            System.out.println("YOUR STATS\nhealth: " + player.health + "\nskill: " + player.skill + "\narmour: " + player.armour);
            System.out.println("OPP STATS\nhealth: " + npcLife + "\nskill: " + npc.skill + "\narmour: " + npc.armour);
        }
        action.close();
    }
}
