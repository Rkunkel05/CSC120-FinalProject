public class Item extends Base {

    private String action;
    private boolean specialItem;
    private boolean sellableItem;
    
    /**
     * Constructor for Item
     * @param String n is the name
     * @param String d is the description
     * @param String a is the action
     * @param boolean specialItem represents if the item goes to a specific NPC
     */
    public Item(String n, String d, String a, boolean questItem, boolean sellableItem) {
        super (n, d);
        this.action = a;
        this.specialItem = questItem;
        this.sellableItem = sellableItem;
    }

    /**
     * // Getters
     */
    public String getAction() {
        return this.action;
    }

    public boolean getSpecialItem() {
        return this.specialItem;
    }

    public boolean getsellableItem() {
        return this.sellableItem;
    }
}