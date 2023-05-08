package pills;

/**
 *    Project SoftGel Part 3 
 * 
 * Title:           ChildAcheAway
 * Files:           ChildAcheAway.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 * 
 * @author          Collin Streitman,
 *                  Hannah Boulet,
 *                  Sashe Nikolov,
 *                  Ella Fulton
 * 
 * Group Name:      SlayFam, Subteam 2
 * Sprint:          5
 * @version         4/02/2023
 */

public class ChildAcheAway extends AcheAway
{
    public final static double STRENGTH = 415.00;
    public final static double SIZE = 3.25;
    public final static String COLOR = "cyan";

    /**
     * Constructor for the ChildAcheAway class.
     * @param casing Child ache away casing.
     * @param solution Child ache away solution.
     * @param active Child ache away active.
     */
    public ChildAcheAway(String casing, String solution, String active)
    {
        super(STRENGTH, SIZE, COLOR, casing, solution, active);
    } 

    /**
     * Accept method using the inspector.
     * @param insp Inspector object.
     */
    public void accept(Inspector insp)
    {
        insp.inspect(this);       
    }
}
