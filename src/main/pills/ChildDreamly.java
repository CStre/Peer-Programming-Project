/**
 *    Project SoftGel Part2
 * 
 * Title:           ChildDreamly
 * Files:           ChildDreamly.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 * 
 * @author:         Ella Fulton,
 *                  Tayo Olofintuyi
 * 
 * Group Name:      SlayFam, Subteam A
 * Sprint:          2
 * @version:        4/02/2023
 */

package pills;

public class ChildDreamly extends Dreamly
{
    public final static double STRENGTH = 1.25;
    public final static double SIZE = 4.5;
    public final static String COLOR = "fuchsia";


    public ChildDreamly(String casing, String solution, String active)
    {
        super(STRENGTH, SIZE, COLOR, casing, solution, active);
    }
}

