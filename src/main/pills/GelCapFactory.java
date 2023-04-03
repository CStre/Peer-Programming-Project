/**
 *    Project SoftGel Part 2
 *
 * Title:           GelCapFactory
 * Files:           GelCapFactory.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 *
 * @author          Sashe Nikolov,
 *                  Ella Fulton,
 *                  Hannah Boulet
 *
 * Group Name:      SlayFam, Subteam A
 * Sprint:          4
 * @version         4/02/2023
 */

package pills;

public abstract class GelCapFactory
{
    public final Dreamly produceDreamly()
    {
        System.out.print("Creating a Dreamly pill ... \n");	
        Dreamly d = constructDreamly(GelCapRecipes.CASINGS.get("dreamly").generateCasing(), 
                GelCapRecipes.SOLUTIONS.get("dreamly").generateSolution(), 
                GelCapRecipes.ACTIVES.get("dreamly").generateActive(getDreamlyStrength()));
        if (qualityCheck())
        {
            System.out.print("Returning a good Dreamly GelCap Pill\n");
            return d;
        }
        else
        {
            System.out.print("Error during Dreamly production. Returning null.\n");
            return null;
        }
    }

    public final AcheAway produceAcheAway()
    {
        System.out.print("Creating an AcheAway pill ... \n");
        AcheAway a = constructAcheAway(GelCapRecipes.CASINGS.get("acheAway").generateCasing(),
                GelCapRecipes.SOLUTIONS.get("acheAway").generateSolution(),
                GelCapRecipes.ACTIVES.get("acheAway").generateActive(getAcheAwayStrength()));
        if (qualityCheck())
        {
            System.out.print("Returning a good AcheAway GelCap Pill\n");
            return a;
        }
        else
        {
            System.out.print("Error during AcheAway production. Returning null.\n");
            return null;
        }
    }

    protected abstract Dreamly constructDreamly(String casing, String solution, String active);
    protected abstract AcheAway constructAcheAway(String casing, String solution, String active);
    protected abstract double getDreamlyStrength();
    protected abstract double getAcheAwayStrength();

    private final boolean qualityCheck()
    {
        System.out.print("Performing quality check ... \n");
        double r = Math.random() * 100;
        if (r < 91)
        {
            System.out.print("quality check passed\n");
            return true;
        }
        else 
        {
            System.out.print("quality check failed\n");
            return false;
        }
    }
}

