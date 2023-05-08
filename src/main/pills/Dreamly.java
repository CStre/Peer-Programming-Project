package pills;

/**
 *    SoftGel Project Part 3
 * 
 * Title:           Dreamly
 * Files:           Dreamly.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 * 
 * @author          Sashe Nikolov
 * 		            Collin Streitman
 *       
 * 
 * Group Name:      SlayFam, Subteam B
 * Sprint:          5
 * @version         4/10/2023
 */

public abstract class Dreamly extends GelCap
{

    public static final Dreamly NULL = null;
    /**
     * Constructor for the dreamly class.
     * @param strength
     * @param size
     * @param color
     * @param casing
     * @param solution
     * @param active
     */
    public Dreamly(double strength, double size, String color, String casing, String solution, 
        String active)

    {
        super("Dreamly", strength, size, color, casing, solution, active);
    }
}

