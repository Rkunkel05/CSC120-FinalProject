public class Item extends Base {

    private String action;
    private boolean specialItem;
    
    /**
     * // Constructor for Item
     * @param String n is the name
     * @param String d is the description
     * @param String a is the action
     * @param boolean specialItem represents if the item goes to a specific NPC
     */
    public Item(String n, String d, String a, boolean specialItem) {
        super (n, d);
        this.action = a;
        this.specialItem = specialItem;
    }

    /**
     * // Getters
     */

    public String getAction() {
        return this.action;
    }

    public static void main(String[] args) {
        Item Waterbottle = new Item("Waterbottle", "It's something to drink from!", "Drinking... Refreshing!", false);
        Item Sword = new Item("Sword", "It's dangerous to go alone. Take this!", "Swish!", false);
        System.out.println(Waterbottle);
        System.out.println(Sword);
    }

    // Somehow increases skills in player class
    // Ex. Picking up a sword gives +2 attack 
    // Ex. Using a certain potion gives +2 of an effect 
    
}