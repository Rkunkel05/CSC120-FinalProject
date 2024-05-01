import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
public class Character {
    double size;
    int location;
    
    String type;
    int skill;
    int armour;
    int charisma;
    double wealth;
    int health;

    private Hashtable <String, Integer> friends;
    //way to store number of trades, either just an increasing int or an arraylist
    int trades;

    ArrayList <Item> itemsList;
    int battlesWon;
    int battlesLost;

    /**
     * Constructor for character
     */
    public Character(String type) {
        this.itemsList = new ArrayList <>();
        @SuppressWarnings("unused")
        Hashtable <String, Integer> friends = new Hashtable <String, Integer>();
        this.location = 0000;
        if (type == "merchant"){ 
            skill = 3;
            charisma = 5;
            wealth = 13.00;
            health = 10;
        }
        if (type == "warrior"){ 
            skill = 5;
            charisma = 3;
            wealth = 13.00;
            health = 10;
        }
        if (type == "friend"){ 
            skill = 2;
            charisma = 6;
            wealth = 13.00;
            health = 10;
        }
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

    public int getfriends(){
        return friends.size();
    }

    public double getWealth(){
        return wealth;
    }

    public double getTrades(){
        return trades;
    }

    /** 
     * @param itemName is the item that is being grabbed
     * Checks if inventory has space (10) and adds item to it. 
     */
    public void grab(String itemName) {
        boolean itemFound = false;
        for (Item item : Game.worldItems) {
            if (item.getName().equalsIgnoreCase(itemName.toLowerCase())) {
                itemFound = true;
                if (itemsList.size() < 11) {
                    if (item.getName().equals("Sword")) {
                        skill += 4;
                    }
                    itemsList.add(item);
                    if (item.getSpecialItem() == false) {
                        System.out.println(itemName + " grabbed!");
                    }
                    return;
                } else {
                    System.out.println("Your inventory is full! Try dropping an item first.");
                    return;
                }
            }
        }
        if (!itemFound) {
            System.out.println("That's not an item!");
        }
    }

    /**
     * @param itemName is the item that is being dropped
     * Checks if the item is in the inventory and removes it. 
     */
    public void drop(String itemName) {
        Iterator<Item> iterator = itemsList.iterator();
        while (iterator.hasNext()) {
        Item item = iterator.next();
        if (item.getName().equalsIgnoreCase(itemName)) {
            if (!item.getSpecialItem()) {
                iterator.remove(); 
                System.out.println(itemName + " dropped!");
                return; 
            } else {
                // If the item is special, print an error message and return
                System.out.println("You can't drop " + itemName + "!");
                return;
            }
        }
    }
        // If the item is not found in the inventory, print an error message
        System.out.println(itemName + " is not in your inventory!");
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
    public void use(Item item) {
        System.out.println(item.getAction());
    }

    /**
     * @param direction is the direction the player wants to travel in
     * Updates the character's location based on the given direction
     */
    public Location travel(String userChoice) {
        if (userChoice.contains("north")) {
            for (Location location : Game.map) {
                if (location.location() == 1000) {
                    System.out.println("You travel north.");
                    return location;
                }
            }
        } else if (userChoice.contains("south")) {
            for (Location location : Game.map) {
                if (location.location() == 0100) {
                    System.out.println("You travel south.");
                    return location;
                }
            }
        } else if (userChoice.contains("east")) {
            for (Location location : Game.map) {
                if (location.location() == 0010) {
                    System.out.println("You travel east.");
                    return location;
                }
            }
        } else if (userChoice.contains("west")) {
            for (Location location : Game.map) {
                if (location.location() == 0001) {
                    System.out.println("You travel west.");
                    return location;
                }
            }
        } else if (userChoice.contains("tavern"))
        for (Location location : Game.map) {
            if (location.location() == 0000) {
                System.out.println("You enter the tavern.");
                return location;
            }
        }
        return null;
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
}
