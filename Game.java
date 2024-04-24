import java.util.*;

public class Game {
    
    private ArrayList <Location>map;
    static boolean stillPlaying = true;

    public void gameCreation() {
        // Creating a map and adding locations to it, initilizing NPCs, etc. 
        this.map = new ArrayList<Location>();
        map.add(new Location("Kingdom", "[info about kingdom]", 0, 0,1, 0, true));
        map.add(new Location("Village", "[info about village]",0, 0, 0, 1, true));
        map.add(new Location("Forest", "[info about forest]", 1,0,0,0, true));
        map.add(new Location("Ocean", "[info about ocean]", 0,1,0,0, false));
    }

    public void showOptions() {
        
    }
    // game loop
    public static void main(String[] args) {
        // Initializing the game 
        Game game = new Game(); 
        game.gameCreation();
        System.out.println(game.map);
        // Initializing the NPCs
        // Character Trish = new Character();
        // // Creating the player character
        // Character Player = new Character();

        System.out.println("You find yourslf outside of a small tavern. A large, oak door remains propped open at the front of the building and you can hear lively chatter and music drifting out from inside.");
        System.out.println("What would you like to do?");

        do {
            Scanner userInput= new Scanner(System.in);
            String userChoice = userInput.nextLine().toLowerCase();
            if (userChoice.contains("enter")) {
                System.out.println("You enter the tavern. At the counter at the front is a woman who greets you with a smile.");
            } else if (userChoice.contains("examine") || userChoice.contains("around")) {
                // Basically want it to print the location's description
                String Location = Base.getName();
                System.out.println(Location.getName().getDescription());
                System.out.println();
            } else if (userChoice.equals("quit") || userChoice.equals("leave")) {
                System.out.println("Are you sure you want to quit? (y/n)");
                Scanner confirmInput= new Scanner(System.in);
                String confirmChoice = confirmInput.nextLine().toLowerCase();
                if (confirmChoice.equals("y") || confirmChoice.equals("yes")) {
                    System.out.println("Farewell traveler!");
                    stillPlaying = false; 
                    userInput.close();
                    confirmInput.close();
                } 
            else {
                System.out.println("Command not recognized. Please try again.");
        } while (stillPlaying);

            // start text sequence w/ trish 
            // chosing what direction to go in 
            // exploring, trading, talking, give away key item x4
            // end of game --> whoever you got the most stats with = besties wahoo! (:
        }
    }


