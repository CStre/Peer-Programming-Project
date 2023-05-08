package pills;

/**
 *   SoftGel Project Part 3
 * 
 * Title:           StrengthInspector
 * Files:           StrengthInspector.java
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

public class StrengthInspector extends Inspector
{
    private double dreamlyStrength;
    private double acheAwayStrength;

    /**
     * inspect method for adult acheaway.
     * @param e ache away object
     */ 
    public void inspect(AdultAcheAway e)
    {   
        
        acheAwayStrength += e.STRENGTH;
    }

    /**
     * inspect method for child ache away.
     * @param e child ache away object.
     */ 
    public void inspect(ChildAcheAway e)
    {
        acheAwayStrength += e.STRENGTH;
    }

    /**
     * inspect metehod for adult dreamly.
     * @param e AdultDreamly object.
     */ 
    public void inspect(AdultDreamly e)
    {
        dreamlyStrength += e.STRENGTH;
    }

    /**
     * inspect method for child dreamly.
     * @param e ChildDreamly object.
     */
    public void inspect(ChildDreamly e)
    {
        dreamlyStrength += e.STRENGTH;
    }

    /**
     * report method that reports the pill strengths.
     * @return print statement stating the pill strengths
     */ 
    public String report()
    {
        return "The strength of Dreamly pills is " 
                + dreamlyStrength 
                + " and the strength of AcheAway pills is " 
                + acheAwayStrength;

    }

    /**
     * reset method for the pill strengths.
     */ 
    public void reset()
    {
        dreamlyStrength = 0;
        acheAwayStrength = 0;
    }
    
    /**
     * method for getting dreamly strength.
     * @return dreamly strength.
     */ 
    public double getDreamlyStrength()
    {
        return dreamlyStrength;
    }

    /**
     * method for getting ache away strength.
     * @return ache away strength.
     */
    public double getAcheAwayStrength()
    {
        return acheAwayStrength;
    }

}
