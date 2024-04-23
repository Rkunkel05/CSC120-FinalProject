import java.util.ArrayList;
public class Character{
  double size;
  int XCoord = 0;
  int YCoord = 0;
  ArrayList<Item> itemsList;
  
    public Character(){
      ArrayList<Item> itemsList;
    }

    public void grab(String itemName) {
      if (itemsList.size() <= 9) {
          System.out.println(itemName + " grabbed!");
          itemsList.add(new Item(itemName, "", "", false));
      } else {
          throw new RuntimeException("Your inventory is full! Try dropping an item first.");
      }
  }

   public void drop(String itemName) {
    for (Item item : itemsList) {
      if (item.getName().equals(itemName)) {
          itemsList.remove(item);
    }
  }
    throw new RuntimeException(itemName + " is not in your inventory!");
  }

  void examine(String item){
    System.out.println("");
  }
  void use(String item){
    System.out.println("");
    this.drop(item);
  }
  boolean walk(String direction){
    System.out.println("" + direction);
    //store direction, move you to a place
    switch (direction.toLowerCase){
      case "north";
          this.yCoord++;
        case "north";
          this.yCoord++;
        case "north";
          this.yCoord++;
    }
    return true;

    // Brainstorming ideas for a potential travel method
    public int travel(String direction) {
        if (direction == "north") {
            Character.setLocation(1000);
        } else if (direction == "south") {
            Character.setLocation(0100); 
        } else if (direction == "west") {
                Character.setLocation(0010);
        } else if (direction == "east") {
            Character.setLocation(0001); 
    }
    
  }
  boolean fly(int x, int y){
    this.xCoord=x;
    this.yCoord=y;
     // int flyingRadius = 3
    if(Math.abs(this.x - x) >3 ||(Math.abs(this.y - y) > this.flyingRadius;
    
      return false;
  }
  Number shrink(){
    this.size = this.size/2;
    this.size = this.size/2;
    return 
  }
  Number grow(){
    this.size = this.size*2;
    this.size = this.size*2;
  }
  public void rest(){
    System.out.println("");
  }
  public void undo(){
    System.out.println("");
  }
  public void printInventory(){
    for (String item : this.itemsList);
  }
  public static void main(String[] args) {
     Character character = new Character();
      System.out.println(character);
 
      // public Character(
  }
}
