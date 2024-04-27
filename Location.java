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
    }

