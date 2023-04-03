/**
 *    Project SoftGel Part2
 * 
 * Title:           ChildAcheAway
 * Files:           ChildAcheAway.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 * 
 * @author:         Collin Streitman,
 *                  Hannah Boulet,
 *                  Sashe Nikolov
 * 
 * Group Name:      SlayFam, Subteam B
 * Sprint:          2
 * @version:        4/02/2023
 */

package pills;

public class ChildAcheAway extends AcheAway
{
    public final static double STRENGTH = 415.00;
    public final static double SIZE = 3.25;
    public final static String COLOR = "cyan";

    /**
     * Constructor for the ChildAcheAway class.
     * @param casing
     * @param solution
     * @param active
     */
    public ChildAcheAway(String casing, String solution, String active)
    {
        super(STRENGTH, SIZE, COLOR, casing, solution, active);
    }

}
