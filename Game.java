import java.util.*;

public class Game {
    
    private ArrayList <Location>map;
    private boolean Running = true;

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
        while (Running) {
            gameCreation();
        }
    }
}


