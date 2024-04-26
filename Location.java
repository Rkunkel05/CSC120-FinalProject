// Basically creates different locations with a name, direction, and brief overview attached to them
// has[blank] to check if an action can be completed (ex. hasTrading, etc. )

import java.util.ArrayList;

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

        public static void main(String[] args) {
            Location Kingdom = new Location("Kingdom", "The kingdom is a busy, large city with ancient and elegant architecture. Bright banners are draped from the large castle in the center. You can see a bustling marketplace filled with stalls and merchants shouting deals.", 0010, true);
            Location Village = new Location("Village", "The village is a cozy, port-side town. Children run around the cobblestone streets, weaving through stalls packed with goods ranging from fish to exotic fur pelts. This could be a perfect place to set up shop!", 0001, true);
            Location Forest = new Location("Forest", "The forest is a labyrinth of green foliage, with only a skinny, well-traveled pathway marking where to go. It would be easy to get lost here if you went off the pathway… Who knows what creatures await here…!", 1000, true);
            Location Tavern = new Location("Tavern", "The tavern has a boisterous, loud atmosphere and is packed full of locals. A woman at the front counter gives you a smile, and she has a small nametag that reads 'Trish'. ", 0000, false);
            Location Ocean = new Location("Ocean", "The beach is small and sandy, with waves gently coming in at a low tide. Looking out over the water, you find yourself reminiscing over past adventures taken in distant countries. There is not much else to do here. ", 0100, false);
        }
    }

