// Parent class with default, generic actions that other classes can inherit from 

public class Base {
    private String name;
    private String description;

    // Constructor
    public Base(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

     /**
     * // Nicely formats description
     */
    public String toString() {
        return this.getClass().getCanonicalName() + " called " + this.name + ". " + this.description;
       }
}
