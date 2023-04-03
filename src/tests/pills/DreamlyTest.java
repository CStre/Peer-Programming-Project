/**
 *  SoftGel Project Part 2
 * 
 * Title:           DreamlyTest
 * Files:           DreamlyTest.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 * 
 * @author          Hannah Boulet, 
 *                  Collin Streitman, 
 *                  Sashe Nikolov
 * 
 * Group Name:      SlayFam, Subteam B
 * Sprint:          2
 * @version         4/02/2023
 */

package pills;

// imports
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DreamlyTest
{
    // test variables
    public static final String CORRECT_NAME = "Dreamly";

    //things that dont change    
    public static final String TEST_CASE = "Plasticizer";
    public static final String TEST_SOL = "Oil";
    public static final String TEST_ACT = "Zolpidem";
    //things that change 
    public static final int TEST_STR = 10;
    public static final int TEST_SIZE = 15;
    public static final String TEST_COLOR = "BLUE";

    public final static double ADULT_STRENGTH = 5.2;
    public final static double ADULT_SIZE = 12.24;
    public final static String ADULT_COLOR = "tan";

    public final static double CHILD_STRENGTH = 1.25;
    public final static double CHILD_SIZE = 4.5;
    public final static String CHILD_COLOR = "fuchsia";

    private static DreamlyMock dreamly;
    private static ChildDreamly childDreamly;
    private static AdultDreamly adultDreamly;


    /**
     * creating test objects.
     */
    @BeforeEach
    public void setup()
    {
        dreamly = new DreamlyMock(TEST_STR, TEST_SIZE, TEST_COLOR, TEST_CASE, TEST_SOL, TEST_ACT);
        childDreamly = new ChildDreamly(TEST_CASE, TEST_SOL, TEST_ACT);
        adultDreamly = new AdultDreamly(TEST_CASE, TEST_SOL, TEST_ACT);
    }

    /**
     * tests assert equals with name getter.
     */
    @Test
    public void testName()
    {
        assertEquals(CORRECT_NAME, dreamly.getName());
        assertEquals(CORRECT_NAME, adultDreamly.getName());
        assertEquals(CORRECT_NAME, childDreamly.getName());

    }

    /**
     * tests assert equals with strength getter.
     */
    @Test
    public void testStrength()
    {
        assertEquals(TEST_STR, dreamly.getStrength());
        assertEquals(ADULT_STRENGTH, adultDreamly.getStrength());
        assertEquals(CHILD_STRENGTH, childDreamly.getStrength());
    }

    /**
     * tests assert equals with size getter.
     */
    @Test
    public void testSize()
    {
        assertEquals(TEST_SIZE, dreamly.getSize());
        assertEquals(ADULT_SIZE, adultDreamly.getSize());
        assertEquals(CHILD_SIZE, childDreamly.getSize());
    }

    /**
     * tests assert equals with color getter.
     */
    @Test
    public void testColor()
    {
        assertEquals(TEST_COLOR, dreamly.getColor());
        assertEquals(ADULT_COLOR, adultDreamly.getColor());
        assertEquals(CHILD_COLOR, childDreamly.getColor());
    }

    @Test
    public void testCasing()
    {
        assertEquals(TEST_CASE, dreamly.getCasing());
        assertEquals(TEST_CASE, adultDreamly.getCasing());
    }
    
    @Test
    public void testSolution() 
    {
        assertEquals(TEST_SOL, dreamly.getSolution());
        assertEquals(TEST_SOL, childDreamly.getSolution());
        assertEquals(TEST_SOL, adultDreamly.getSolution());
    }
    
    @Test
    public void testActive()
    {
        assertEquals(TEST_ACT, dreamly.getActive());
        assertEquals(TEST_ACT, childDreamly.getActive());
        assertEquals(TEST_ACT, adultDreamly.getActive());
    }

    private class DreamlyMock extends Dreamly
    {
        public DreamlyMock(double strength, double size, String color, String casing, 
            String solution, String active)
        {
            super(strength, size, color, casing, solution, active);
        }
    }

}
