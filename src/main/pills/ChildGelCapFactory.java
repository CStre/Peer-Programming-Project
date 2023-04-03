/**
 *    Project SoftGel Part 2
 *
 * Title:           ChildGelCapFactory
 * Files:           ChildGelCapFactory.java
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

public class ChildGelCapFactory extends GelCapFactory
{
    protected Dreamly constructDreamly(String casing, String solution, String active)
    {
        System.out.println("Constructing Child version of Dreamly");
        return new ChildDreamly(casing, solution, active);
    }

    protected AcheAway constructAcheAway(String casing, String solution, String active)
    {
        System.out.println("Constructing Child version of AcheAway");
        return new ChildAcheAway(casing, solution, active);
    }

    protected double getDreamlyStrength()
    {
        return ChildDreamly.STRENGTH;
    }

    protected double getAcheAwayStrength()
    {
        return ChildAcheAway.STRENGTH;
    }
}
