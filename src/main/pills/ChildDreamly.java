package pills;

/**
 *    Project SoftGel Part 3
 * 
 * Title:           ChildDreamly
 * Files:           ChildDreamly.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 * 
 * @author          Collin Streitman,
 *                  Ella Fulton
 * 
 * Group Name:      SlayFam, Subteam 2
 * Sprint:          5
 * @version         4/10/2023
 */

public class ChildDreamly extends Dreamly
{
    public final static double STRENGTH = 1.25;
    public final static double SIZE = 4.5;
    public final static String COLOR = "fuchsia";

    /**
     * ChildDreamly constructor.
     * @param casing Dreamly casing.
     * @param solution Dreamly solution.
     * @param active Dreamly active.
     */ 
    public ChildDreamly(String casing, String solution, String active)
    {
        super(STRENGTH, SIZE, COLOR, casing, solution, active);
    }

    /**
     * accept method for ChildDreamly that uses the inspector.
     *
     * @param insp Inspector object.
     */ 
    public void accept(Inspector insp)
    {
        insp.inspect(this);
    }
}

