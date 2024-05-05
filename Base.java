// Parent class with default, generic actions that other classes can inherit from 

public class Base {
    private String name;
    private String description;

    /**
     * @param name is the name of the object
     * @param description is the description of the object
     */
    public Base(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Getters
     * @return information that was requested
     */
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Sets name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets description
     * @param description
     */
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
