public class Location {
    public String direction;

    // Constructor for a location 
    public Location(String direction) {
        this.direction = direction;
    }

    // Print/Create information about location
    // Exploring / Looking around
    // Create NPCs associated w/ location 

    public static void main(String[] args) {
        Location Kingdom = new Location("West");
        Location Village = new Location("East");
        Location Forest = new Location("North");
        Location Ocean = new Location("South");
    }
}
