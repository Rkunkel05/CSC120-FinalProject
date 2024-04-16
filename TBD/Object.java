package TBD;
abstract class Object {
     // Location
    protected int x, y;
    
    // Physical characteristics
    protected double weight;
    protected double size;
        
    // Getters
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public double getWeight() {
        return this.weight;
    }
    
    public double getSize() {
        return this.size;
    }
    
    public String toString() {
        return this.getClass().getCanonicalName();
    }
    
    public void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
        System.out.println("The " + this.toString() + " is now located at (" + x +  "," + y + ")");
    }
       
    public void use() {

    }

    public void pickUp() {

    }

    public void drop() {

    }
    
    public static void main(String[] args) {
    Object myObj = new Object() {
            
    };
    }
    }
}
