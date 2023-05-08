package pills;

// imports
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 *  SoftGel Project Part 3
 * 
 * Title:           AcheAwayTest
 * Files:           AcheAwayTest.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 * 
 * @author          Collin Streitman 
 *                  
 * Group Name:      SlayFam, Subteam 2
 * Sprint:          5
 * @version         4/10/2023
 */

public class AcheAwayTest
{
    // test variables
    public static final String CORRECT_NAME = "AcheAway";
    public static final int TEST_STR = 10;
    public static final int TEST_SIZE = 15;
    public static final String TEST_COLOR = "BLUE";
    public static final String TEST_CASE = "gelatin";
    public static final String TEST_SOL = "saline";
    public static final String TEST_ACT = "acetaminophen";

    // adult variables
    public static final double ADULT_STRENGTH = 825.00;
    public static final double ADULT_SIZE = 8.50;
    public static final String ADULT_COLOR = "white";

    public static final double CHILD_STRENGTH = 415.00;
    public static final double CHILD_SIZE = 3.25;
    public static final String CHILD_COLOR = "cyan";

    private static AcheAwayMock mock;
    private static ChildAcheAway child;
    private static AdultAcheAway adult;

    @BeforeEach
    public void setup()
    {
        mock = new AcheAwayMock(TEST_STR, TEST_SIZE, TEST_COLOR, TEST_CASE, TEST_SOL, TEST_ACT);
        child = new ChildAcheAway(TEST_CASE, TEST_SOL, TEST_ACT);
        adult = new AdultAcheAway(TEST_CASE, TEST_SOL, TEST_ACT);
    }

    /**
     * tests that null constant exists iin AcheAway class.
     * tests the NullAcheAway class
     */
    @Test 
    public void testNull()
    {
        assertNull(AcheAway.NULL);
        AcheAway girl = new NullAcheAway();
        assertNotNull(girl);
    }

    @Test
    public void testName()
    {
        assertEquals(CORRECT_NAME, mock.getName());
        assertEquals(CORRECT_NAME, child.getName());
        assertEquals(CORRECT_NAME, adult.getName());
    }

    @Test
    public void testStrength()
    {
        assertEquals(TEST_STR, mock.getStrength());
        assertEquals(CHILD_STRENGTH, child.getStrength());
        assertEquals(ADULT_STRENGTH, adult.getStrength());
    }

    @Test
    public void testSize()
    {
        assertEquals(TEST_SIZE, mock.getSize());
        assertEquals(CHILD_SIZE, child.getSize());
        assertEquals(ADULT_SIZE, adult.getSize());
    }

    @Test
    public void testColor()
    {
        assertEquals(TEST_COLOR, mock.getColor());
        assertEquals(CHILD_COLOR, child.getColor());
        assertEquals(ADULT_COLOR, adult.getColor());
    }

    @Test
    public void testCasing()
    {
        assertEquals(TEST_CASE, mock.getCasing());
        assertEquals(TEST_CASE, child.getCasing());
        assertEquals(TEST_CASE, adult.getCasing());
    }

    @Test
    public void testSolution()
    {
        assertEquals(TEST_SOL, mock.getSolution());
        assertEquals(TEST_SOL, child.getSolution());
        assertEquals(TEST_SOL, adult.getSolution());
    }

    @Test
    public void testActive()
    {
        assertEquals(TEST_ACT, mock.getActive());
        assertEquals(TEST_ACT, child.getActive());
        assertEquals(TEST_ACT, adult.getActive());
    }

    private class AcheAwayMock extends AcheAway
    {
        public AcheAwayMock(double strength, double size, String color, String casing, 
            String solution, String active) 
        {
            super(strength, size, color, casing, solution, active);
        }

        public void accept(Inspector insp)
        {
            
        }

    }
}
