package pills;

/**
 *    Project SoftGel Part 3
 *
 * Title:           ChildGelCapFactory
 * Files:           ChildGelCapFactory.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 *
 * @author          Hannah Boulet
 *
 * Group Name:      SlayFam, Overseer
 * Sprint:          7
 * @version         4/24/2023
 */

public class ChildGelCapFactory extends GelCapFactory
{
    private static ChildGelCapFactory instance;

    /**
     * Empty ChildGelCapFactory constructor.
     */ 
    private ChildGelCapFactory()
    {

    }

    /**
     * getInstance method for ChildGelCapFactory.
     *
     * @return instance Instance of the factory.
     */
    public static ChildGelCapFactory getInstance()
    {
        if (instance == null) 
        {
            synchronized (ChildGelCapFactory.class) 
            {
                if (instance == null) 
                {
                    instance = new ChildGelCapFactory();
                }
            }
        }
        return instance;
    }

    /**
     * constructDreamly method for constructing the pill.
     * @param casing Dreamly casing
     * @param solution Dreamly solution
     * @param active Dreamly active
     *
     * @return new ChildDreamly(casing, solution, active) New Dreamly pill.
     */ 
    protected Dreamly constructDreamly(String casing, String solution, String active)
    {
        System.out.println("Constructing Child version of Dreamly");
        return new ChildDreamly(casing, solution, active);
    }


    /**
     * constructAcheAway method for constructing the pill.
     * @param casing Ache away casing
     * @param solution Ache away solution
     * @param active Ache Away active
     *
     * @return new ChildAcheAway(casing, solution, active) New ache
     * away pill. 
     */
    protected AcheAway constructAcheAway(String casing, String solution, String active)
    {
        System.out.println("Constructing Child version of AcheAway");
        return new ChildAcheAway(casing, solution, active);
    }

    /**
     * getDreamlyStrength method for getting the dreamly strength.
     *
     * @return ChildDreamly.STRENGTH Child dreamly strength.
     */
    protected double getDreamlyStrength()
    {
        return ChildDreamly.STRENGTH;
    }

    /**
     * getAcheAwayStrength method for getting the ache away strength.
     * @return ChildAcheAway.STRENGTH Child ache away strength.
     */ 
    protected double getAcheAwayStrength()
    {
        return ChildAcheAway.STRENGTH;
    }
}
