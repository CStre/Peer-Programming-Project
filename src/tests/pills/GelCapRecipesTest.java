/**
 *    Project SoftGel Part 2
 * 
 * Title:           GelCapRecipesTest
 * Files:           GelCapRecipesTest.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 * 
 * @author:         Hannah Boulet,
 *                  Ella Fulton,
 *                  Sashe Nikolov 
 *  
 * 
 * Group Name:      SlayFam, Subteam A
 * Sprint:          4
 * @version:         4/02/2023
 */

package pills;

// imports
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GelCapRecipesTest
{
    /**
     * General test to see if each dreamly
     * and acheaway return their proper casing objects.
     */
    @Test
    public void testCasings()
    {
		// test for Dreamly
        assertTrue(GelCapRecipes.CASINGS.get("dreamly") 
                instanceof GelatinCasing);
		// test for AcheAway
        assertTrue(GelCapRecipes.CASINGS.get("acheAway") 
                instanceof PlasticizerCasing);
    }
    /**
     * General test to see if each dreamly 
     * and acheaway return their proper solution objects.
     */
    @Test
    public void testSolutions() 
    {
		// test for Dreamly
        assertTrue(GelCapRecipes.SOLUTIONS.get("dreamly") 
                instanceof SalineSolution);
		// test for AcheAway
        assertTrue(GelCapRecipes.SOLUTIONS.get("acheAway") 
                instanceof OilSolution);
    }
    /**
     * General test to see if each dreamly 
     * and acheaway return their proper actives objects.
     */
    @Test
    public void testActives() 
    {
		// test for Dreamly
        assertTrue(GelCapRecipes.ACTIVES.get("dreamly") 
                instanceof AcetaminophenActive);
		// test for AcheAway
        assertTrue(GelCapRecipes.ACTIVES.get("acheAway") 
                instanceof ZolpidemActive);
    }
}
