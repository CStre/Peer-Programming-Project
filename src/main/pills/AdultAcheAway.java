/**
 *    Project SoftGel Part2
 *
 * Title:           AdultAcheAway
 * Files:           AdultAcheAway.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 *
 * @author          Collin Streitman,
 *                  Hannah Boulet,
 *                  Sashe Nikolov
 *
 * Group Name:      SlayFam, Subteam B
 * Sprint:          2
 * @version         4/02/2023
 */

package pills;

public class AdultAcheAway extends AcheAway
{
    public final static double STRENGTH = 825.00;
    public final static double SIZE = 8.50;
    public final static String COLOR = "white";


    /**
     * Constructor for the AdultAcheAway class.
     * @param casing
     * @param solution
     * @param active
     */
    public AdultAcheAway(String casing, String solution, String active)
    {
        super(STRENGTH, SIZE, COLOR, casing, solution, active);
    }


}
