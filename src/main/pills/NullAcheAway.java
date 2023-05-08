package pills;

/**
 *   SoftGel Project Part 3
 * 
 * Title:           NullAcheAway
 * Files:           NullAcheAway.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 * 
 * @author          Sashe Nikolov,
 *		    		Collin Streitman,
 *		    		Ella Fulton
 *                   
 * Group Name:      SlayFam, Subteam 2
 * Sprint:          5
 * @version         4/10/2023
 */

public class NullAcheAway extends AcheAway
{
    /**
     * NullAcheAway constructor.
     */ 
    public NullAcheAway()
    {
        super(0, 0, "", "", "", "");
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


