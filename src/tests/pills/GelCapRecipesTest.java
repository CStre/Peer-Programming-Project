package pills;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *    Project SoftGel Part 3
 * 
 * Title:           GelCapRecipesTest
 * Files:           GelCapRecipesTest.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 * 
 * @author          Hannah Boulet,
 *                  Sashe Nikolov, 
 *                  Ella Fulton
 *  
 * 
 * Group Name:      SlayFam, Subteam 2
 * Sprint:          5
 * @version         4/21/2023
 */

public class GelCapRecipesTest
{
    /**
     * Testing that GelCapRecipes returns a CasingGenerator
     * when called with "dreamly" and "acheAway". 
     */
    @Test
    public void testCasings()
    {
        assertTrue(GelCapRecipes.CASINGS.get("dreamly") 
                instanceof CasingGenerator);
        assertTrue(GelCapRecipes.CASINGS.get("acheAway") 
                instanceof CasingGenerator);
    }

    /**
     * Testing that GelCapRecipes returns a SolutionGenerator
     * when called with "dreamly" and "acheAway". 
     */
    @Test
    public void testSolutions() 
    {
        assertTrue(GelCapRecipes.SOLUTIONS.get("dreamly")
                instanceof SolutionGenerator);
        assertTrue(GelCapRecipes.SOLUTIONS.get("acheAway") 
                instanceof SolutionGenerator);
    }

    /**
     * Testing that GelCapRecipes returns an ActiveGenerator
     * when called with "dreamly" and "acheAway". 
     */
    @Test
    public void testActives() 
    {
        assertTrue(GelCapRecipes.ACTIVES.get("dreamly") 
                instanceof ActiveGenerator);
        assertTrue(GelCapRecipes.ACTIVES.get("acheAway") 
                instanceof ActiveGenerator); 
    }
}
