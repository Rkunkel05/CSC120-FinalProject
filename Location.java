// Basically creates different locations with a name, direction, and brief overview attached to them

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
    }
}
