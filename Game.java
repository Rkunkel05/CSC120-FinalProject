import java.util.*;

public class Game {
    
    private ArrayList <Location>map;

    public void gameCreation() {
        // Creating a map and adding locations to it, initilizing NPCs, etc. 
        this.map = new ArrayList<Location>();
        map.add(new Location("Kingdom", "[info about kingdom]", 0, 0,1, 0, true));
        map.add(new Location("Village", "[info about village]",0, 0, 0, 1, true));
        map.add(new Location("Forest", "[info about forest]", 1,0,0,0, true));
        map.add(new Location("Ocean", "[info about ocean]", 0,1,0,0, false));
    }

    // game loop
    public static void main(String[] args) {
        // Initializing the game 
        Game game = new Game(); 
        game.gameCreation();
        System.out.println(game.map);
        // Initializing the NPCs
        Character Trish = new Character();

        // Creating the player character
        Character Player = new Character();

            // start text sequence w/ trish 
            // chosing what direction to go in 
            // exploring, trading, talking, give away key item x4
            // end of game --> whoever you got the most stats with = besties wahoo! (:
        }
    }


