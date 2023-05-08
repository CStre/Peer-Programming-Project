package pills;

/**
 *   SoftGel Project Part 3
 * 
 * Title:           GelCap
 * Files:           GelCap.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 *
 * @author          Ella Fulton
 *
 * Group Name:      Slay Fam
 * Sprint:          3
 * @version         4/09/2023
 */

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
     * @param casing
     * @param solution
     * @param active
     */
    public GelCap(String name, double strength, double size, String color, String casing, 
        String solution, String active)
    {
        this.name = name;
        this.strength = strength;
        this.size = size;
        this.color = color;
        this.casing = casing;
        this.solution = solution;
        this.active = active;
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
        return "GelCap { name: " + getName()
            + ", color: " + getColor()
            + ", size: " + getSize()
            + ", strength: " + getStrength() + " }";
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
        String str = String.format("%.1f", getStrength());
        String siz = String.format("%.1f", getSize());

        return getName() + " pill"
            + ", color: " + getColor()
            + ", size: " + siz
            + ", strength: " + str;
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
     * accept method using inspector object.
     * @param insp Inspector object.
     */ 
    public abstract void accept(Inspector insp);
}
