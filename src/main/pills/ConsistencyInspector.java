package pills;

/**
 *      SoftGel Project Part 3
 * 
 * Title:           ConsistencyInspector
 * Files:           ConsistencyInspector.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 * 
 * @author          Hannah Boulet,
 *                  Tayo Olofintuyi
 * 
 * Group Name:      SlayFam, Subteam 1
 * Sprint:          5
 * @version         4/10/2023
 */

public class ConsistencyInspector extends Inspector
{
    private int adultCount;
    private int childCount;

    /**
     * Inspect method for AdultAcheAway.
     *
     * @param e AdultAcheAway object.
     */
    public void inspect(AdultAcheAway e)
    {
        adultCount++;
    }

    /**
     * Inspect method for ChildAcheAway.
     *
     * @param e ChildAcheAway object.
     */
    public void inspect(ChildAcheAway e)
    {
        childCount++;
    }

    /**
     * Inspect method for AdultDreamly.
     *
     * @param e AdultDreamly object.
     */ 
    public void inspect(AdultDreamly e)
    {
        adultCount++;
    }

    /**
     * Inspect method for ChildDreamly.
     *
     * @param e ChildDreamly object.
     */ 
    public void inspect(ChildDreamly e)
    {
        childCount++;
    }

    /**
     * report method that uses consistency method and reports back.
     *
     * @return Print statements for whether or not pills are consistent. 
     */ 
    public String report()
    {
        if (soFarConsistent()) 
        {
            return "The pills are consistent ";
        } 
        else 
        {
            return "The pills are not consistent";
        }
    }

    /**
     * Resets the count of adult and child pills.
     */ 
    public void reset()
    {
        adultCount = 0;
        childCount = 0;
    }

    /**
     * soFarConsistent method checks the consistency of the pills.
     * @return true or false based on consistency.
     */
    public boolean soFarConsistent()
    {
        return (!((adultCount > 0) && (childCount > 0)));
    }
}
