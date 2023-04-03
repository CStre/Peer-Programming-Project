/**
 *   SoftGel Project Part 2
 * 
 * Title:           AcetaminophenActive
 * Files:           AcetaminophenActive.java
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

public class AcetaminophenActive implements ActiveGenerator
{
    public String generateActive(double amount)
    {
        System.out.printf("Acetylating para-aminophenol with acetic anhydride\n"
                + "Carefully extracting %.2fmg of acetaminophen\n"
                + "Returning %.2fmg of acetaminophen\n", amount, amount);
        return "acetaminophen";
    }
}

