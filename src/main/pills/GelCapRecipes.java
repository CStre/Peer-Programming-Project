/**
 *  SoftGel Project Part 2
 * 
 * Title:           GelCapRecipes
 * Files:           GelCapRecipes.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 * 
 * @author          Collin Streitman, 
 *                  Tayo Olofintuyi
 * 
 * Group Name:      SlayFam, Subteam B
 * Sprint:          3    
 * @version         4/02/2023
 */

package pills;
import java.util.HashMap;

public class GelCapRecipes
{
    public static final HashMap<String, CasingGenerator> CASINGS = getCasings();
    public static final HashMap<String, SolutionGenerator> SOLUTIONS = getSolutions();
    public static final HashMap<String, ActiveGenerator> ACTIVES = getActives();

    /**
    * Private static method called getCasings that creates a new HashMap, 
    * then adds two keys deamly and acheaway to the map and then returns
    * the same map to them be assigned to CASINGS.
    * @return HashMap
    */
    private static HashMap<String, CasingGenerator> getCasings()
    {
        HashMap<String, CasingGenerator> map1 = new HashMap<String, CasingGenerator>();
        map1.put("dreamly", new GelatinCasing());
        map1.put("acheAway", new PlasticizerCasing());
        return map1;
    }

    /**
    * Private static method called getSolutions that creates a new HashMap, 
    * then adds two keys deamly and acheaway to the map and then returns
    * the same map to them be assigned to SOLUTIONS.
    * @return HashMap
    */
    private static HashMap<String, SolutionGenerator> getSolutions()
    {
        HashMap<String, SolutionGenerator> map2 = new HashMap<String, SolutionGenerator>();
        map2.put("dreamly", new SalineSolution());
        map2.put("acheAway", new OilSolution());
        return map2;
    }

    /**
    * Private static method called getActives that creates a new HashMap, 
    * then adds two keys deamly and acheaway to the map and then returns
    * the same map to them be assigned to ACTIVES.
    * @return HashMap
    */
    private static HashMap<String, ActiveGenerator> getActives()
    {
        HashMap<String, ActiveGenerator> map3 = new HashMap<String, ActiveGenerator>();
        map3.put("dreamly", new AcetaminophenActive());
        map3.put("acheAway", new ZolpidemActive());
        return map3;
    }
}
