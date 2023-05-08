package pills;

/**
 *    Project SoftGel Part 3
 * 
 * Title:           AdultDreamly
 * Files:           AdultDreamly.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 * 
 * @author          Collin Streitman
 * 
 * Group Name:      SlayFam, Subteam 2
 * Sprint:          5
 * @version         4/10/2023
 */

public class AdultDreamly extends Dreamly
{
    public final static double STRENGTH = 5.2;
    public final static double SIZE = 12.24;
    public final static String COLOR = "tan";

    /**
     * Constructor for the AdultDreamly class.
     *
     * @param casing Dreamly casing.
     * @param solution Dreamly solution.
     * @param active Dreamly active.
     */ 
    public AdultDreamly(String casing, String solution, String active)
    {
        super(STRENGTH, SIZE, COLOR, casing, solution, active);
    }

    /**
     * Accept method using the inspector.
     *
     * @param insp The inspector object.
     */ 
    public void accept(Inspector insp)
    {
        insp.inspect(this);        
    }
}

