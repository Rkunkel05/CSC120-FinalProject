import java.util.ArrayList;
public class Character implements Contract{
  double size;
  int XCoord = 0;
  int YCoord = 0;
    public Character(){
      ArrayList<String> itemsList;
      
    }
   public void grab (String item){
       this.itemsList.add(item);
      System.out.println(" grabbed!");
    }
   public void drop (){
    this.itemsList.remove(item);
    System.out.println("Item dropped!");
     return item;
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
      case "north"
          this.yCoord++
        case "north"
          this.yCoord++
        case "north"
          this.yCoord++;
    }
    return true;
    
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
    
    for (String item : this.itemsList)
  }
  public static void main(String[] args) {
     Character character = new Character;
      System.out.println(character);
 
      // public Character(
  }
}