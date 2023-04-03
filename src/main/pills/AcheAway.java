/**
 *   SoftGel Project Part 2
 * 
 * Title:           AcheAway
 * Files:           AcheAway.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 * 
 * @author          Ella Fulton,
 *                  Tayo Olofintuyi
 * 
 * Group Name:      SlayFam, Subteam A
 * Sprint:          2
 * @version         4/02/2023
 */

package pills;

public abstract class AcheAway extends GelCap
{
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
