public class Item extends Base {

    private String action;
    private boolean specialItem;
    private boolean sellableItem;
    private int price;
    
    /**
     * Constructor for Item
     * @param String n is the name
     * @param String d is the description
     * @param String a is the action
     * @param boolean specialItem represents if the item goes to a specific NPC
     * @param int price is how much the item is worth
     */
    public Item(String n, String d, String a, boolean questItem, boolean sellableItem, int price) {
        super (n, d);
        this.action = a;
        this.specialItem = questItem;
        this.sellableItem = sellableItem;
        this.price = price;
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

    public int getPrice() {
        return this.price;
    }
}