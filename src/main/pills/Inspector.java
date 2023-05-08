package pills;

/**
 *   SoftGel Project Part 2
 * 
 * Title:           Inspector
 * Files:           Inspector.java
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

public abstract class Inspector 
{

    /**
     * Empty inspect method.
     * @param e AdultAcheAway object.
     */
    public void inspect(AdultAcheAway e)
    {

    }

    /**
     * Empty inspect method.
     * @param e ChildAcheAway object.
     */ 
    public void inspect(ChildAcheAway e)
    {

    }

    /**
     * Empty inspect method.
     * @param e NullAcheAway object.
     */ 
    public void inspect(NullAcheAway e)
    {

    }

    /**
     * Empty inspect method.
     * @param e AdultDreamly object.
     */ 
    public void inspect(AdultDreamly e)
    {

    }

    /**
     * Empty inspect method.
     * @param e ChildDreamly object.
     */ 
    public void inspect(ChildDreamly e)
    {

    }

    /**
     * Empty inspect object.
     * @param e NullDreamly object.
     */
    public void inspect(NullDreamly e)
    {
        
    }

    /**
     * Abstract report method.
     * @return nothing
     */ 
    public abstract String report();

    /**
     * Abstract void reset method.
     */ 
    public abstract void reset();

}
