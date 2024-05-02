import java.util.Scanner;
import java.util.Random;

public class Fight {
    
    Character player;
    NPC npc;
    boolean fight;
    int npcInt;
    String npcAction;
    int npcLife;
    int npcArmour;
    int npcSkill;

    public Fight(Character player, NPC npc) {
        this.player = player;
        this.npc = npc;
        this.fight = true;
        this.npcLife = npc.getLife();
        this.npcArmour = npc.getArmor();
        this.npcSkill = npc.getSkill();
        System.out.println("You are fighting " + npc.getName());

        Scanner action = new Scanner(System.in);
        Random random = new Random();

        while (fight){
            String npcAction;
            System.out.println("You may either block or attack:");
            String playerAction = action.nextLine().toLowerCase();
            System.out.println("You chose: " + playerAction);
            //randomly picks an action for the npc to take
            int ncpInt = random.nextInt(2); 
            if (npcInt == 0) {
                npcAction = "attack";
            }
            else {
                npcAction = "block";
            }
            System.out.println(npc.getName() + " chose: " + npcAction);
            
            if (playerAction.equals("attack") && npcAction.equals("attack")){
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

            if (playerAction.equals("attack") && npcAction.equals("block")){
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

            if (playerAction.equals("block") && npcAction.equals("attack")){
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
            if (player.health <= 0) {
                Game.stillPlaying = false;
                fight = false;
            }

            if (npcLife == 0) {
                System.out.println("You defeated " + npc.getName() + "!");
                
            }
            System.out.println("YOUR STATS\nhealth: " + player.health + "\nskill: " + player.skill + "\narmour: " + player.armour);
            System.out.println("OPP STATS\nhealth: " + npcLife + "\nskill: " + npc.skill + "\narmour: " + npcArmour);
        }
        action.close();
    }
}
