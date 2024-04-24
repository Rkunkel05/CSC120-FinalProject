// Basically creates different locations with a name, direction, and brief overview attached to them
// has[blank] to check if an action can be completed (ex. hasTrading, etc. )

public class Location extends Base {
        private boolean hasTrading;
        private int location;

        /**
         * @param Name defines the name of the location
         * @param Description defines a description for the location
         * @param location defines what direction the location is in
         * @param hasTrading indicates whether or not you can trade at this location
         * Constructor 
         */
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

