package pills;

/**
 *   SoftGel Project Part 3
 * 
 * Title:           FailureInspector
 * Files:           FailureInspector.java
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

public class FailureInspector extends Inspector
{
    private int nullCount;
    private int totalCount;

    /**
     * inspect method for AdultAcheAway.
     * @param e AdultAche Away object.
     */  
    public void inspect(AdultAcheAway e)
    {
        totalCount++;
    }


    /**
     * inspect method for ChildAcheAway.
     * @param e ChildAcheAway object.
     */ 
    public void inspect(ChildAcheAway e)
    {
        totalCount++;
    }

    /**
     * inspect method for NullAcheAway.
     * @param e NullAcheAway object.
     */ 
    public void inspect(NullAcheAway e)
    {
        totalCount++;
        nullCount++;
    }

    /**
     * Inspect method for AdultDreamly.
     * @param e AdultDreamly object.
     */
    public void inspect(AdultDreamly e)
    {
        totalCount++;
    }

    /**
     * Inspect method for ChildDreamly.
     * @param e ChildDreamly object.
     */  
    public void inspect(ChildDreamly e)
    {
        totalCount++;
    }

    /**
     * inspect method for NullDreamly.
     * @param e NullDreamly object.
     */
    public void inspect(NullDreamly e)
    {
        totalCount++; 
        nullCount++;
    }

    /**
     * report method that will report on the failure rate.
     * @return print statement that states fail rate.
     */ 
    public String report()
    {
        return "The failure rate is " + getFailRate() + "%";
    }

    /**
     * reset method sets pill counts to 0.
     */ 
    public void reset()
    {
        nullCount = 0;
        totalCount = 0;
    }

    /**
     * method to get fail rate of pills.
     * @return fail rate.
     */
    public double getFailRate()
    {
        if (totalCount == 0) 
        {
            return 0;
        }
        else 
        {
            return (double) nullCount / totalCount * 100;
        }
    }

}
