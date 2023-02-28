/**
 * Title:           GelCap
 * Files:           GelCap.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 * 
 * @author:         Collin Streitman, 
 *                  Ella Fulton, 
 *                  Sashe Nikolov
 * 
 * Group Name:      SlayFam, Subteam B
 * @version:        2/22/2023
 */

package pills;
public abstract class GelCap
{
    protected String name;
    protected double strength;
    protected double size;
    protected String color;
    protected String casing;
    protected String solution;
    protected String active;

    /**
     * This is the class constructor for the GelCap class. It is just setting 
     * the protected variables. It then called the manifacture method that 
     * returns two strings telling the user manufacturing has started 
     * and finished.
     * 
     * @param name
     * @param strength
     * @param size
     * @param color
     */
    public GelCap(String name, double strength, double size, String color)
    {
        this.name = name;
        this.strength = strength;
        this.size = size;
        this.color = color;

        manufacture();

    }

    /**
     * This is the toString() that currently returns a formatted string with
     * the strength of the medication at two decimal places and the name of
     * the medication.
     * 
     * @return String
     */
    public String toString()
    {
        String s = String.format("%.2f mg ", getStrength());
        return s + getName() + "Pill";
    }

     /**
     * This is the description() that currently returns a formatted string
     * including the name of the medication,the strength and size formatted to 
     * two decimal places, the color, the casing, the solution, and the active
     * ingredients.
     * 
     * @return String
     */
    public String description()
    {
        String str = String.format("%.2f", getStrength());
        String siz = String.format("%.2f", getSize());

        return getName() + " Pill"
            + "\n\tStrength: " + str 
            + "\n\tSize: " + siz 
            + "\n\tColor: " + getColor()
            + "\n\tCasing: " + getCasing()
            + "\n\tSolution: " + getSolution()
            + "\n\tActive: " + getActive();
    }

     /**
     * This is the getter for name.
     *  
     * @return String name
     */
    public String getName()
    {
        return name;
    }

    /**
     * This is the getter for strength.
     * 
     * @return double strength
     */
    public double getStrength()
    {
        return strength;
    }

    /**
     * This is the getter for size.
     * 
     * @return double size
     */
    public double getSize()
    {
        return size;
    }

     /**
     * This is the getter for color.
     * 
     * @return String color
     */
    public String getColor()
    {
        return color;
    }

     /**
     * This is the getter for casting.
     * 
     * @return String casting
     */
    public String getCasing()
    {
        return casing;
    }

     /**
     * This is the getter for solution.
     * 
     * @return String solution
     */
    public String getSolution()
    {
        return solution;
    }

     /**
     * This is the getter for active.
     * 
     * @return String active
     */
    public String getActive()
    {
        return active;
    }

     /**
     * This is the manufacture() that currently prints a string letting the
     * user know the method was called and then runs the addCasting(), 
     * addSolution(), and addActive() before printing another statement letting
     * the user know the method is done. 
     * 
     * @return 
     */
    protected void manufacture()
    {
        System.out.print("Manufacturing...\n");
        addCasing();
        addSolution();
        addActive();
        System.out.print("...completed manufacturing\n");
    }

    /**
     * This is a protected abstract method called casing.
     */
    protected abstract void addCasing();

    /**
     * This is a protected abstract method called solution.
     */
    protected abstract void addSolution();

    /**
     * This is a protected abstract method called active.
     */
    protected abstract void addActive();
}
