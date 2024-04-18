public class Item {
    
    public static Object item;
    private String name;
    private String description;
    private String action;
    
    /**
     * // Constructor for Item
     * @param String n is the name
     * @param String d is the description
     * @param String a is the action
     */
    public Item(String n, String d, String a) {
        this.name= n;
        this.description = d;
        this.action = a;
    }

    /**
     * // Various getters
     */
    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getAction() {
        return this.action;
    }

    /**
     * // Nicely formats description of item
     */
    public String toString() {
        return this.getClass().getCanonicalName() + " called " + this.name + ". " + this.description;
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