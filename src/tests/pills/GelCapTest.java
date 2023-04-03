/**
 *  SoftGel Project Part 2
 * 
 * Title:           GelCapTest
 * Files:           GelCapTest.java
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GelCapTest
{
    // Strings for the tests and formating.
    // These are general formating strings.

    private static final String TOSTRING_FSTRING = "GelCap { name: %s,"
        + " color: %s,"
        + " size: %.1f, strength: %.1f }";
    private static final String DESCRIPTION_FSTRING = "%s pill, color: %s,"
        + " size: %.1f, strength: %.1f";
    // General strings and setting them to values.
    private static final String NAME = "EXPERIMENT PILL";
    private static final double STRENGTH = 9.0;
    private static final double SIZE = 3.0;
    private static final String COLOR = "Green";
    private static final String CASING = "X";
    private static final String SOLUTION = "Y";
    private static final String ACTIVE = "Z";
    // GelcapMock object
    private GelCapMock testGelCap;


    // this is needed for the output for the testmanufactureprocess

    @BeforeEach
    public void setUp() 
    {
        testGelCap = new GelCapMock(NAME, STRENGTH, SIZE, COLOR, CASING, SOLUTION, ACTIVE);
    }

    /**
     * Assert equals to test pill name.
     */
    @Test
    public void testName() 
    {
        assertEquals(NAME, testGelCap.getName());
    }

    /**
     * Assert equals to test pill strength.
     */
    @Test
    public void testStrength()
    {
        assertEquals(STRENGTH, testGelCap.getStrength());
    }

    /**
     * Assert equals to test pill size.
     */
    @Test
    public void testSize()
    {
        assertEquals(SIZE, testGelCap.getSize());
    }

    /**
     * Assert equals to test pill color.
     */
    @Test
    public void testColor()
    {
        assertEquals(COLOR, testGelCap.getColor());
    }

    /**
     * Assert equals to test pill casing.
     */
    @Test
    public void testCasing()
    {
        assertEquals(CASING, testGelCap.getCasing());
    }

    /**
     * Assert equals to test pill solution.
     */
    @Test
    public void testSolution()
    {
        assertEquals(SOLUTION, testGelCap.getSolution());
    }

    /**
     * Assert equals to test pill Active.
     */
    @Test
    public void testActive()
    {
        assertEquals(ACTIVE, testGelCap.getActive());
    }

    /**
     * Assert equals to test pill toString testing if format is correct.
     */
    @Test
    public void testToString()
    {
        String expected = String.format(TOSTRING_FSTRING,
                NAME, COLOR, SIZE, STRENGTH);
        assertEquals(expected, testGelCap.toString());
    }

    /**
     * Assert equals to test pill description.
     */
    @Test
    public void testDescription()
    {
        String expected = String.format(DESCRIPTION_FSTRING,
                NAME, COLOR, SIZE, STRENGTH);
        assertEquals(expected, testGelCap.description());
    }

    /**
     * Private inner class called gelcapmock that extends from GelCap.
     */
    private class GelCapMock extends GelCap
    {

        /**
         * Constructs a new GelCapMock object
         * with the specified name, strength, size,
         * and color.
         * Initializes the casing, solution,
         * and active fields to empty strings and sets
         * the strength, size, and color fields.
         * Adds casing, active ingredient,
         * and solution to the GelCapMock object.
         * 
         * @param name     the name of the pill for gelcapmock.
         * @param strength the strength of the pill.
         * @param size     the size of the pill.
         * @param color    the color of the pill.
         * @param casing   the casing of the pill
         * @param solution the solution
         * @param active   the active
         */
        public GelCapMock(String name, double strength, double size, String color, String casing, 
            String solution, String active)
        {
            super(name, strength, size, color, casing, solution, active);
        }
    }
}
