import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;

public class Character {
    double size;
    int location;

    String type;
    int skill;
    int armour;
    int charisma;
    double wealth;
    int health;

    public Hashtable < String, Integer > friends;
    int trades;

    ArrayList < Item > itemsList;
    int battlesWon = 0;
    int battlesLost = 0;
    int food = 0;
    int bread = 0;

    /**
     * Constructor for Character
     * @param type player's class
     */
    public Character(String type) {
        this.itemsList = new ArrayList < > ();
        this.friends = new Hashtable < String, Integer > ();
        this.location = 0000;
        this.type = type;
        if (type.equals("merchant")) {
            this.skill = 3;
            this.charisma = 5;
            this.wealth = 13.00;
            this.health = 10;
            System.out.println("Your objective is to make 3 trades. Best of luck, traveler!");
        } else if (type.equals("warrior")) {
            this.skill = 5;
            this.charisma = 3;
            this.wealth = 13.00;
            this.health = 10;
            System.out.println("Your objective is to win 3 battles. Best of luck, traveler!");
    
        } else if (type.equals("friend")) {
            this.skill = 2;
            this.charisma = 6;
            this.wealth = 13.00;
            this.health = 10;
            System.out.println("Your objective is to make 3 friends. Best of luck, traveler!");
        }

    }

    /**
     * Getters
     * @return requested information
     */
    public String getLocation() {
        if (this.location == (0000)) {
            return "Tavern";
        } else if (this.location == (1000)) {
            return "Forest";
        } else if (this.location == (0100)) {
            return "Ocean";
        } else if (this.location == (0001)) {
            return "Village";
        } else if (this.location == (0010)) {
            return "Kingdom";
        } else {
            return "";
        }
    }

    public int getfriends() {
        return friends.size();
    }
    public double getWealth() {
        return wealth;
    }
    public double getTrades() {
        return trades;
    }
    public double getLost() {
        return battlesLost;
    }
    public double getWon() {
        return battlesWon;
    }
    public String getType() {
        return type;
    }

    /** 
     * Checks if inventory has space (10) and adds item to it. Otherwise throws error 
     * @param itemName is the item that is being grabbed
     */
    public void grab(String itemName) {
        boolean itemFound = false;
        for (Item item: Game.worldItems) {
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
     * Checks if the item is in the inventory and removes it. 
     * @param itemName is the item that is being dropped
     */
    public void drop(String itemName) {
        Iterator < Item > iterator = itemsList.iterator();
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
     * Prints the description of the item 
     * @param itemName is the item that is being examined 
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
    public void use(Item item, Character Player) {
        for (Item itemID: itemsList) {
            if (itemID.equals(item)) {
                if (item.getName().equalsIgnoreCase("Enchanted Fishing Rod")) {
                    if (Player.getLocation().equalsIgnoreCase("Ocean")) {
                        System.out.println("Fishing.....");
                        Random random = new Random();
                        int fish = random.nextInt(4);
                        if (fish != 3) {
                            System.out.println("You did not catch anything :(");
                        } else {
                            System.out.println("You caught a fish!");
                            food += 2;
                        }
                    } else {
                        System.out.println("You cannot fish unless you are in the ocean!");
                    }
                }
                if (itemID.equals(item)) {
                    if (item.getName().equalsIgnoreCase("Royal Amulet")) {
                        System.out.println("The amulet shimmers in your hand and a strange voice whispers guidance in your head");
                        if (Player.getType().equalsIgnoreCase("merchant")) {
                            System.out.println("Travel North, South, East, and West to complete four trades!");
                        } else if (Player.getType().equalsIgnoreCase("friend")) {
                            System.out.println("Travel North, South, East, and West to talk to and befriend four people!");
                        } else if (Player.getType().equalsIgnoreCase("warrior")) {
                            System.out.println("Travel North, South, East, and West to defeat opponents in four battles!");
                        }
                    }
                }
            }
            if (itemID.equals(item)) {
                if (item.getName().equalsIgnoreCase("Glowing Blossom")) {
                    if (Player.health < 10) {
                        System.out.println("A magical glow fills the air and you feel a warm sensation as the flower heals you!");
                        Player.health = 10;
                    } else {
                        System.out.println("Your health is already full!");
                    }
                }
            }
        }
    }

    /**
     * Updates the character's location based on the given direction
     * @param direction is the direction the player wants to travel in
     */
    public Location travel(String userChoice) {
        if (userChoice.contains("north")) {
            for (Location location : Game.map) {
                if (location.location() == 1000) {
                    System.out.println("You travel north.");
                    this.location = location.location();
                    return location;
                }
            }
        } else if (userChoice.contains("south")) {
            for (Location location : Game.map) {
                if (location.location() == 0100) {
                    System.out.println("You travel south.");
                    this.location = location.location();
                    return location;
                }
            }
        } else if (userChoice.contains("east")) {
            for (Location location : Game.map) {
                if (location.location() == 0001) {
                    System.out.println("You travel east.");
                    this.location = location.location();
                    return location;
                }
            }
        } else if (userChoice.contains("west")) {
            for (Location location : Game.map) {
                if (location.location() == 0010) {
                    System.out.println("You travel west.");
                    this.location = location.location();
                    return location;
                }
            }
        } else if (userChoice.contains("tavern")) {
            for (Location location : Game.map) {
                if (location.location() == 0000) {
                    System.out.println("You enter the tavern.");
                    this.location = location.location();
                    return location;
                }
            }
        } else {
            System.out.println("That is not a valid location! Try again.");
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

    /**
     * Prints the player's stats
     */
    public void Stats() {
        System.out.println("\n");
        System.out.println("*********");
        System.out.println("STATS:");
        if (this.type.equals("friend")) {
            System.out.println("You have made " + this.getfriends() + " friends!");
        } else if (this.type.equals("warrior")) {
            System.out.println("You have lost " + this.getLost() + "  battle(s)!");
            System.out.println("You have won " + this.getWon() + " battle(s)!");
        } else {
            System.out.println("You have: $" + this.getWealth());
            System.out.println("You have made " + this.getTrades() + " amount of trades!");
        }
        System.out.println("Skill: " + this.skill);
        System.out.println("Armour: " + this.armour);
        System.out.println("Health: " + this.health);
        System.out.println("Wealth: " + this.wealth);
        System.out.println("Charisma: " + this.charisma);

    }

    public static void main(String[] args) {
        Character character = new Character("merchant");
        System.out.println(character.getLocation());
        character.travel("north");
        System.out.println(character.getLocation());
    }
}