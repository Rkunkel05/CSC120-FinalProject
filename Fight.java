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
    int startHealth;

   /**
    * Creates a fight
    * @param player is the player's information
    * @param npc is the npc's information
    */
    public Fight(Character player, NPC npc) {
        this.player = player;
        this.npc = npc;
        this.fight = true;
        this.npcLife = npc.getLife();
        this.npcArmour = npc.getArmour();
        this.npcSkill = npc.getSkill();
        this.startHealth = player.health;

        System.out.println("You are fighting " + npc.getName());

        Scanner action = new Scanner(System.in);
        Random random = new Random();

        // Fight loop 
        while (fight) {
            String npcAction;
            System.out.println("You may either block or attack:");
            String playerAction = action.nextLine().toLowerCase();
            System.out.println("You chose: " + playerAction);
            // Randomly picks an action for the npc to take
            int npcInt = random.nextInt(2);
            if (npcInt == 0) {
                npcAction = "attack";
            } else {
                npcAction = "block";
            }
            System.out.println(npc.getName() + " chose: " + npcAction);

            if (playerAction.equals("attack") && npcAction.equals("attack")) {
                if (player.skill > npcSkill) {
                    npcLife -= 2;
                    player.health -= 1;
                } else if (player.skill < npcSkill) {
                    npcLife -= 1;
                    player.health -= 2;
                } else if (player.skill == npcSkill) {
                    npcLife -= 1;
                    player.health -= 1;
                }
            } else if (playerAction.equals("attack") && npcAction.equals("block")) {
                if (player.skill > npcArmour) {
                    if (npcArmour >= 2) {
                        npcArmour -= 2;
                    } else {
                        npcLife -= 1;
                    }
                } else if (player.skill == npcArmour) {
                    if (npcArmour != 0) {
                        npcLife -= 1;
                    }
                }
            } else if (playerAction.equals("block") && npcAction.equals("attack")) {
                if (npcSkill > player.armour) {
                    if (player.armour >= 2) {
                        player.armour -= 2;
                    } else {
                        player.health -= 1;
                    }
                } else if (npcSkill == player.armour) {
                    if (player.armour != 0) {
                        player.health -= 1;
                    }
                }
            }

            if (player.health <= 0) {
                System.out.println("You lost the battle! Try again next time.");
                Game.stillPlaying = false;
                fight = false;
            }
            else if (startHealth - player.health == 5){
                player.battlesLost -= 1;
                fight = false;
                System.out.println("Your health is too low to keep fighting! \n You were defeated by " + npc.getName() + ":(");
            }

            if (npcLife <= 0) {
                System.out.println("You defeated " + npc.getName() + "!");
                player.battlesWon += 1;
                fight = false;
            }
            else {
                System.out.println("YOUR STATS\nhealth: " + player.health + "\nskill: " + player.skill + "\narmour: " + player.armour);
                System.out.println("OPP STATS\nhealth: " + npcLife + "\nskill: " + npcSkill + "\narmour: " + npcArmour);
            }
        }
    }
}