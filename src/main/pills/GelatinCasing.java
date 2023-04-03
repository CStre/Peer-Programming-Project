/**
 *   SoftGel Project Part 2
 * 
 * Title:           GelatinCasing
 * Files:           GelatinCasing.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 * 
 * @author          Hannah Boulet,
 *                  Ella Fulton,
 *                  Sashe Nikolov
 * 
 * Group Name:      SlayFam, Subteam B
 * Sprint:          3
 * @version         4/02/2023
 */

package pills;

public class GelatinCasing implements CasingGenerator
{
    public String generateCasing()
    {
        System.out.print("Mixing gelatin, water, opacifier, and glycerin ... \n"
                + "Shaping ... \n"
                + "Returning gelatin casing ... \n");
        return "gelatin";
    }
}

