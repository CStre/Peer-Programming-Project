package pills;

/**
 *    Project SoftGel Part 3
 *
 * Title:           AdultGelCapFactory
 * Files:           AdultGelCapFactory.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 *
 * @author          Hannah Boulet
 *
 * Group Name:      SlayFam, OverSeer
 * Sprint:          7
 * @version         4/24/2023
 */

public class AdultGelCapFactory extends GelCapFactory
{
    private static AdultGelCapFactory instance;

    /**
     * Empty AdultGelCapFactory constructor.
     */     
    private AdultGelCapFactory()
    {

    }

    /**
     * getInstance method for the adult factory.
     *
     * @return instance The factory instense to be returned.
     */
    public static AdultGelCapFactory getInstance()
    {
        if (instance == null) 
        {
            synchronized (AdultGelCapFactory.class) 
            {
                if (instance == null) 
                {
                    instance = new AdultGelCapFactory();
                }
            }
        }
        return instance;
    }

    /**
     * constructDreamly method for constructing the pill.
     * is a protected method.
     * @param casing Dreamly casing.
     * @param solution Dreamly solution.
     * @param active Dreamly active.
     *
     * @return new AdultDreamly(casing, solution, active) returns
     * new Dreamly pill.
     */ 
    protected Dreamly constructDreamly(String casing, String solution, String active)
    {
        System.out.println("Constructing Adult version of Dreamly");
        return new AdultDreamly(casing, solution, active);
    }


    /**
     * Protected constructAcheAway method for constructing the pill.
     * @param casing Ache Away casing.
     * @param solution Ache Away solution.
     * @param active Ache Away active.
     *
     * @return new AdultAcheAway(casing, solution, active) new ache away pill
     */ 
    protected AcheAway constructAcheAway(String casing, String solution, String active)
    {
        System.out.println("Constructing Adult version of AcheAway");
        return new AdultAcheAway(casing, solution, active);
    }

    /**
     * Protected method for getting dreamly strength.
     *
     * @return AdultDreamly.Strength Strength of the Adult dreamly pill.
     */ 
    protected double getDreamlyStrength()
    {
        return AdultDreamly.STRENGTH;
    }

    /**
     * Protected method for getting ache away strength.
     *
     * @return AdultAcheAway.STRENGTH Adult ache away strength.
     */ 
    protected double getAcheAwayStrength()
    {
        return AdultAcheAway.STRENGTH;
    }

}
