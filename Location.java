// Basically creates different locations with a name, direction, and brief overview attached to them
// has[blank] to check if an action can be completed (ex. hasTrading, etc. )

public class Location extends Base {

        private int north, south, east, west;
        private boolean hasTrading;

        // Constructor
        // Logic w/ the ints for each direction is that the game can check if its a 1 or 0 to see if you can go that way to get there?
        // Logic w/ ints for each direction is that if the player inputs a certain direction ex. "East" the game checks to see their current coordinates + adds 1 to respective space to signify being East. When they leave that direction, it subtracts 1 so they are at (0,0,0,0) by default
        // Maybe we update location to just be 0000, then 0010 for west, etc.?
        public Location(String Name, String Description, int n, int s, int w, int e, boolean hasTrading) {
            super (Name, Description);
            this.north = n;
            this.south = s;
            this.west =  w;
            this.east = e;
            this.hasTrading = hasTrading;
        }

        // Getters
        public int getN() {
            return north;
        }

        public int getS() {
            return south;
        }

        public int getE() {
            return east;
        }

        public int getW() {
            return west;
        }

        public boolean hasTrading() {
            return hasTrading;
        }

        // Setters
        public void setS(int s) {
            this.south = s;
        }

        public void setN(int n) {
            this.north = n;
        }

        public void setE(int e) {
            this.east = e;
        }

        public void setW(int w) {
            this.west = w;
        }

        public static void main(String[] args) {
            Location Kingdom = new Location("Kingdom", "[info about kingdom]", 0, 0,1, 0, true);
            Location Village = new Location("Village", "[info about village]",0, 0, 0, 1, true);
            Location Forest = new Location("Forest", "[info about forest]", 1,0,0,0, true);
            Location Ocean = new Location("Ocean", "[info about ocean]", 0,1,0,0, false);
        }
}

// Brainstorming ideas for a potential travel method
    // public int travel(String direction) {
    //     if (direction == "north") {
    //         Player.setCoordinates(1000);
    //     } else if (direction == "south") {
    //         Player.setCoordinates(0100); 
    //     } else if (direction == "west") {
    //             Player.setCoordinates(0010);
    //     } else (direction == "east") {
    //         Player.setCoordinates(0001); 
    // }

