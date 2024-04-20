public class Item extends Base {
    
    public static Object item;
    private String action;
    
    /**
     * // Constructor for Item
     * @param String n is the name
     * @param String d is the description
     * @param String a is the action
     */
    public Item(String n, String d, String a) {
        super (n, d);
        this.action = a;
    }

    /**
     * // Getters
     */

    public String getAction() {
        return this.action;
    }

    public static void main(String[] args) {
        Item Waterbottle = new Item("Waterbottle", "It's something to drink from!", "Drinking... Refreshing!");
        Item Sword = new Item("Sword", "It's dangerous to go alone. Take this!", "Swish!");
        System.out.println(Waterbottle);
        System.out.println(Sword);
    }

    // Somehow increases skills in player class
    // Ex. Picking up a sword gives +2 attack 
    // Ex. Using a certain potion gives +2 of an effect 
    
}