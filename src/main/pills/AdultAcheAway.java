package pills;

/**
 *    Project SoftGel Part 3
 *
 * Title:           AdultAcheAway
 * Files:           AdultAcheAway.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 *
 * @author          Collin Streitman,
 *                  Hannah Boulet,
 *                  Sashe Nikolov,
 *                  Ella Fulton
 *
 * Group Name:      SlayFam, Subteam B
 * Sprint:          5
 * @version         4/02/2023
 */

public class AdultAcheAway extends AcheAway
{
    public final static double STRENGTH = 825.00;
    public final static double SIZE = 8.50;
    public final static String COLOR = "white";


    /**
     * Constructor for the AdultAcheAway class.
     * @param casing Ache Away casing
     * @param solution Ache Away solution
     * @param active Ache Away active
     */
    public AdultAcheAway(String casing, String solution, String active)
    {
        super(STRENGTH, SIZE, COLOR, casing, solution, active);
    }
     /**
     * Accept method using the inspector.
     * @param insp Inspector object
     */
    public void accept(Inspector insp)
    {
        insp.inspect(this);       
    }

}
