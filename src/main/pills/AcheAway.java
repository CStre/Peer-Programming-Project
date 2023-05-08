package pills;

/**
 *   SoftGel Project Part 3
 * 
 * Title:           AcheAway
 * Files:           AcheAway.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 * 
 * @author          Sashe Nikolov
 *                  
 * 
 * Group Name:      SlayFam, Subteam 2
 * Sprint:          5
 * @version         4/06/2023
 */

public abstract class AcheAway extends GelCap
{
    // AcheAway null object
    public static final AcheAway NULL = null;

    /**
     * Constructor for the AcheAway class.
     * @param strength
     * @param size
     * @param color
     * @param casing
     * @param solution
     * @param active
     */
    public AcheAway(double strength, double size, String color, String casing, String solution, 
        String active)
    {
        super("AcheAway", strength, size, color, casing, solution, active);
    }

}
