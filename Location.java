// Basically creates different locations with a name, direction, and brief overview attached to them
// has[blank] to check if an action can be completed (ex. hasTrading, etc. )
import java.util.Scanner;

public class Location {
    public String direction;
    public String name;
    public String overview;

    // Constructor for a location 
    public Location(String name, String direction, String overview) {
        this.name = name;
        this.direction = direction;
        this.overview = overview;
    }

    // Getters
    public String getDirection() {
        return this.direction;
    }

    public String getName() {
        return this.name;
    }

    public String getOverview() {
        return this.overview;
    }

    // Returns nicely formatted string 
    public String toString() {
        return this.getClass().getCanonicalName();
    }

    // move to player class; Call upon Locations 
    public void travel(a) {
        if (a.contains("WEST")) {
            System.out.println("You have reached " + Kingdom.getName());
        } else if (a.contains("SOUTH")) {
            System.out.println("You have reached " + Ocean.getName());
        } else if (a.contains("NORTH")) {
            System.out.println("You have reached " + Forest.getName());
        } else if (a.contains("EAST")) {
            System.out.println("You have reached " + Village.getName());
        }
        
    }

    // Exploring / Looking around
    // Create NPCs associated w/ location 

    public static void main(String[] args) {
        Location Kingdom = new Location("Kingdom", "West", "[info about kingdom]");
        Location Village = new Location("Village", "East", "[info about village]");
        Location Forest = new Location("Forest", "North", "[info about forest]");
        Location Ocean = new Location("Ocean", "South", "[info about ocean]");
        System.out.println(Kingdom.getName()+ " is a " + Kingdom.toString() + " located " + Kingdom.getDirection() + ". "+ Kingdom.getOverview());
        System.out.println(Village.getName()+ " is a " + Village.toString() + " located " + Village.getDirection()+ ". "+ Kingdom.getOverview());
        System.out.println(Forest.getName()+ " is a " + Forest.toString() + " located " + Forest.getDirection()+ ". "+ Kingdom.getOverview());
        System.out.println(Ocean.getName()+ " is a " + Ocean.toString() + " located " + Ocean.getDirection()+ ". "+ Kingdom.getOverview());
        // System.out.println("Where direction would you like to travel in?");
        // Scanner input = new Scanner(System.in);
        // String a = input.nextLine().toUpperCase();
        // Move to player class 
        // travel(a);
    }
}
