/**
 *    Project SoftGel Part 2
 *
 * Title:           AdultGelCapFactory
 * Files:           AdultGelCapFactory.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 *
 * @author          Collin Streitman,
 *                  Tayo Olofintuyi
 *
 * Group Name:      SlayFam, Subteam B
 * Sprint:          4
 * @version         4/02/2023
 */

package pills;

public class AdultGelCapFactory extends GelCapFactory
{
    protected Dreamly constructDreamly(String casing, String solution, String active)
    {
        System.out.println("Constructing Adult version of Dreamly");
        return new AdultDreamly(casing, solution, active);
    }

    protected AcheAway constructAcheAway(String casing, String solution, String active)
    {
        System.out.println("Constructing Adult version of AcheAway");
        return new AdultAcheAway(casing, solution, active);
    }

    protected double getDreamlyStrength()
    {
        return AdultDreamly.STRENGTH;
    }

    protected double getAcheAwayStrength()
    {
        return AdultAcheAway.STRENGTH;
    }

}
