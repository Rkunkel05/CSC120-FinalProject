// Basically creates different locations with a name, direction, and brief overview attached to them
// has[blank] to check if an action can be completed (ex. hasTrading, etc. )

public class Location extends Base {
        private boolean hasTrading;
        private int location;

        // Constructor
        // Logic w/ the ints for each direction is that the game can check if its a 1 or 0 to see if you can go that way to get there?
        // Logic w/ ints for each direction is that if the player inputs a certain direction ex. "East" the game checks to see their current coordinates + adds 1 to respective space to signify being East. When they leave that direction, it subtracts 1 so they are at (0,0,0,0) by default
        // Maybe we update location to just be 0000, then 0010 for west, etc.?
        public Location(String Name, String Description, int location, boolean hasTrading) {
            super (Name, Description);
            this.location = location;
            this.hasTrading = hasTrading;
        }

        /**
         * Getters
         */
        public int location() {
            return location;
        }
        public boolean hasTrading() {
            return hasTrading;
        }

        /**
         * Setters
         */
        public void setLocation(int location) {
            this.location = location;
        }


        // 0000 = Original point
        // 1000 = North
        // 01000 = South
        // 0010 = East
        // 0001 = West
        public static void main(String[] args) {
            // Location Tavern = new Location("Tavern", "[info about tavern]", 0000, false);
            // Location Kingdom = new Location("Kingdom","[info about kingdom]", 0001, true);
            // Location Village = new Location("Village", "[info about village]",0010, true);
            // Location Forest = new Location("Forest", "[info about forest]", 1000, true);
            // Location Ocean = new Location("Ocean", "[info about ocean]", 0100, false);
        }
}

