public class Location extends Base {
        private boolean hasTrading;
        private int location;
        private boolean hasFight;

        /**
         * @param Name defines the name of the location
         * @param Description defines a description for the location
         * @param location defines what direction the location is in
         * @param hasTrading indicates whether or not you can trade at this location
         * @param hasFight indicates whether or not you can fight at this location
         * Constructor 
         */
        public Location(String Name, String Description, int location, boolean hasTrading, boolean hasFight) {
            super (Name, Description);
            this.location = location;
            this.hasTrading = hasTrading;
            this.hasFight = hasFight;
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
        public boolean hasFight() {
            return hasFight;
        }

        /**
         * Setters
         */
        public void setLocation(int location) {
            this.location = location;
        }
    }

