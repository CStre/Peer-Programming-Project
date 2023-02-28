/**
 * Title:           Dreamly
 * Files:           Dreamly.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 * 
 * @author:         Ella Fulton, 
 *                  Collin Streitman, 
 *                  Sashe Nikolov
 * 
 * Group Name:      SlayFam, Subteam B
 * @version:        2/22/2023
 */

package pills;
public class Dreamly extends GelCap
{
    /**
     * Constructor for the dreamly class.
     * @param strength
     * @param size
     * @param color
     */
    public Dreamly(double strength, double size, String color)
    {
	super("Dreamly", strength, size, color);
    }

    /**
     * Protected void method that adds the plasticizer casing. 
     * @return
     */
    protected void addCasing()
    {
	super.casing = "Plasticizer";
        System.out.println("Adding plasticizer casing");
    }

    /**
     * Protected void method that adds the oil solution. 
     * @return
     */
    protected void addSolution()
    {
	super.solution = "Oil";
        System.out.println("Adding oil solution");
    }

    /**
     * Protected void method that adds the zolpidem active. 
     * @return
     */
    protected void addActive()
    {
	super.active = "Zolpidem";
        System.out.println("Adding zolpidem active");
    }
}
