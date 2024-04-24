import java.util.ArrayList;
public class Character {
    double size;
    int location;
    ArrayList < Item > itemsList;

    /**
     * Constructor for character
     */
    public Character() {
        ArrayList < Item > itemsList;
        this.location = 0000;
    }

    /** 
     * Getters
     */
    public String getLocation() {
        if (this.location == (0000)) {
            return "Tavern";
        } else if (this.location == (1000)) {
            return "Forest";
        } else if (this.location == (0100)) {
            return "Ocean";
        } else if (this.location == (0010)) {
            return "Village";
        } else {
            return "Kingdom";
        }
    }

    /** 
     * @param itemName is the item that is being grabbed
     * Checks if inventory has space (10) and adds item to it. Otherwise throws error 
     */
    public void grab(String itemName) {
        if (itemsList.size() <= 9) {
            System.out.println(itemName + " grabbed!");
            itemsList.add(new Item(itemName, "", "", false));
        } else {
            throw new RuntimeException("Your inventory is full! Try dropping an item first.");
        }
    }

    /**
     * @param itemName is the item that is being dropped
     * Checks if the item is in the inventory and removes it. Otherwise throws error 
     */
    public void drop(String itemName) {
        for (Item item: itemsList) {
            if (item.getName().equals(itemName)) {
                itemsList.remove(item);
            }
        }
        throw new RuntimeException(itemName + " is not in your inventory!");
    }

    /**
     * @param itemName is the item that is being examined 
     * Prints the description of the item 
     */
    public void examine(String itemName) {
        // Check if the item exists in the character's inventory
        boolean itemFound = false;
        for (Item item: itemsList) {
            if (item.getName().equals(itemName)) {
                System.out.println(item.getDescription());
                itemFound = true;
                break;
            }
        }
        if (!itemFound) {
            System.out.println(itemName + " is not in your inventory! Pick it up first to examine it.");
        }
    }

    /**
     * @param item is the item to be used 
     */
    public void use(String item) {
        System.out.println("");
        this.drop(item);
    }

    /**
     * @param direction is the direction the player wants to travel in
     * Updates the character's location based on the given direction
     */
    public void travel(String direction) {
        switch (direction.toLowerCase()) {
            case "north":
                this.location += 1000;
                break;
            case "south":
                this.location -= 1000;
                break;
            case "east":
                this.location += 1;
                break;
            case "west":
                this.location -= 1;
                break;
            default:
                System.out.println("Invalid direction!");
        }
    }

    /**
     * Prints the contents of the inventory
     */
    public void printInventory() {
        System.out.println("\n");
        System.out.println("*********");
        System.out.println("INVENTORY:");
        if (itemsList.size() == 0) {
            System.out.println("Empty");
            System.out.println("*********");
            System.out.println("\n");
        } else {
            for (Item item: itemsList) {
                System.out.println("+ " + item);
            }
            System.out.println("*********");
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        Character character = new Character();
        System.out.println(character.getLocation());
        character.travel("north");
        System.out.println(character.getLocation());
    }
}
