import java.util.ArrayList;
import java.util.Hashtable;
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

    private Hashtable <String, Integer> friends;
    //way to store number of trades, either just an increasing int or an arraylist
    int trades;

    ArrayList <Item> itemsList;
    int battlesWon = 0;
    int battlesLost = 0;
    int food = 0;
    int bread = 0;

    /**
     * Constructor for Character
     * @param type player's class
     */
    public Character(String type) {
        ArrayList <Item> itemsList = new ArrayList <>();
        Hashtable <String, Integer> friends = new Hashtable <String, Integer>();
        this.location = 0000;
        if (type == "merchant"){ 
            skill = 3;
            charisma = 5;
            wealth = 13.00;
            health = 10;
        }
        else if (type == "warrior"){ 
            skill = 6;
            charisma = 2;
            wealth = 13.00;
            health = 10;
        }
        else if (type == "friend"){ 
            skill = 2;
            charisma = 6;
            wealth = 13.00;
            health = 10;
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
    public double getLost(){
        return battlesLost;
    }
    public double getWon(){
        return battlesWon;
    }

    /** 
     * Checks if inventory has space (10) and adds item to it. Otherwise throws error 
     * @param itemName is the item that is being grabbed
     */
    public void grab(Item item) {
        if (itemsList.size() <= 9) {
            System.out.println(item.getName() + " grabbed!");
            boolean itemAdd = itemsList.add(item);
            if (item.getName() == "Sword"){
              skill += 4;
              System.out.println("Your skill has increased by 4!");
            }
            else if (item.getName() == "Waterbottle"){
              System.out.println("");
            }
            else if (item.getName() == "Helmet"){
                System.out.println("");
            }
            else if (item.getName() == ""){
            System.out.println("");
            }
            else if (item.getName() == ""){
                System.out.println("");
            }
            else if (item.getName() == ""){
            System.out.println("");
            }
            else if (item.getName() == ""){
                System.out.println("");
            }
            else if (item.getName() == ""){
            System.out.println("");
            }
        } else {
            throw new RuntimeException("Your inventory is full! Try dropping an item first.");
        }
    }

    /**
     * Checks if the item is in the inventory and removes it. 
     * @param itemName is the item that is being dropped
     */
    public void drop(Item itemName) {
        for (Item item: itemsList) {
            if (item.getName().equals(itemName)) {
                itemsList.remove(item);
                if (item.getName() == "Sword"){
                    skill -= 4;
                    System.out.println("Your skill has decreased by 4 :(");
                  }
                  else if (item.getName() == "Waterbottle"){
                    System.out.println("");
                  }
                  else if (item.getName() == "Helmet"){
                      System.out.println("");
                  }
                  else if (item.getName() == ""){
                  System.out.println("");
                  }
                  else if (item.getName() == ""){
                      System.out.println("");
                  }
                  else if (item.getName() == ""){
                  System.out.println("");
                  }
                  else if (item.getName() == ""){
                      System.out.println("");
                  }
                  else if (item.getName() == ""){
                  System.out.println("");
                  }
            }
        }
        throw new RuntimeException(itemName + " is not in your inventory!");
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
    public void use(Item item) {
        for (Item itemID: itemsList) {
            if (itemID.equals(item)) {
                if (item.getName() == "Enchanted Fishing Rod"){
                    if (this.getLocation() == "Ocean"){
                        System.out.println("Fishing.....");
                        Random random = new Random();
                        int fish = random.nextInt(4);
                        if (fish != 3){
                            System.out.println("You did not catch anything :(");
                        }
                        else {
                            System.out.println("You caught a fish!");
                            food += 2;
                        }
                    }
                    else {
                        System.out.println("You cannot fish unless you are in the ocean!");
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
                this.location = location.location();
                return location;
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
