/**
 * Title:           GelCap
 * Files:           GelCap.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 * 
 * @author:         Hannah Boulet,
 *                  Tayo Olofintuyi
 * 
 * Group Name:      SlayFam, Subteam A
 * @version:        2/27/2023
 */

package pills;
public class AcheAway extends GelCap
{
    /**
     * Constructor for the AcheAway class.
     * @param strength
     * @param size
     * @param color
     */
    public AcheAway(double strength, double size, String color)
    {
        super("AcheAway", strength, size, color);
    }

    /**
     * Protected void method that adds the gelatin casing. 
     * @return
     */
    protected void addCasing()
    {
        super.casing = "Gelatin";
        System.out.println("Adding gelatin casing");
    }

    /**
     * Protected void method that adds the saline solution. 
     * @return
     */
    protected void addSolution()
    {
        super.solution = "Saline";
        System.out.println("Adding saline solution");
    }

    /**
     * Protected void method that adds the acetaminophen active. 
     * @return
     */
    protected void addActive()
    {
        super.active = "Acetaminophen";
        System.out.println("Adding acetaminophen active");
    }
}
