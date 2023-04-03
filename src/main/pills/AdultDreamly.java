/**
 *    Project SoftGel Part2
 * 
 * Title:           AdultDreamly
 * Files:           AdultDreamly.java
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

public class AdultDreamly extends Dreamly
{
    public final static double STRENGTH = 5.2;
    public final static double SIZE = 12.24;
    public final static String COLOR = "tan";


    public AdultDreamly(String casing, String solution, String active)
    {
        super(STRENGTH, SIZE, COLOR, casing, solution, active);
    }
}

