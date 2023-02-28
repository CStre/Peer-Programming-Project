package pills;

/**
 * Title:           GelCapTest
 * Files:           GelCapTest.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 * 
 * @author:         Hannah Boulet,
 *                  Tayo Olofintuyi
 *  
 * 
 * Group Name:      SlayFam, Subteam A
 * @version:        2/27/2023
 */

//general imports needed for the test.
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GelCapTest
{
    // Strings for the tests and formating.
    // These are general formating strings.
    private static final String MANUFACTURE_FSTRING = "Manufacturing...\n"
            + "Adding casing: X\n"
            + "Adding solution: Y\n"
            + "Adding active ingredient: Z\n";
    private static final String TOSTRING_FSTRING = "GelCap { name: %s,"
            + " color: %s,"
            + "size: %.1f, strength: %.1f }";
    private static final String DESCRIPTION_FSTRING = "%s pill, color: %s,"
            + "size: %.1f, strength: %.1f";
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

    private PrintStream oldOut;

    // this is needed for the output for the testmanufactureprocess
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() 
    {
        this.oldOut = System.out;
        testGelCap = new GelCapMock(NAME, STRENGTH, SIZE, COLOR);
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void afterEach()
    {
        System.setOut(System.out);
        System.setOut(oldOut);
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
        assertEquals(expected, testGelCap.getDescription());
    }

    /**
     * @return output string using trim to fix formating.
     */
    private String getOutput()
    {
        return output.toString().trim() + "\n";
    }

    /***
     * Assert equals to test manufacturing process.
     */
    @Test
    public void testManufactureProcess()
    {
        testGelCap.manufacture();
        String expectedOutput = MANUFACTURE_FSTRING;
        assertEquals(expectedOutput, getOutput());
    }

    /**
     * Private inner class called gelcapmock that extends from GelCap.
     */
    private class GelCapMock extends GelCap
    {
        private String casing;
        private String solution;
        private String active;
        private double strength;
        private double size;
        private String color;

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
         */
        public GelCapMock(String name, double strength,
                double size, String color) 
        {
            super(name, strength, size, color);
            casing = "";
            solution = "";
            active = "";
            this.strength = strength;
            this.size = size;
            this.color = color;
            addCasing();
            addActive();
            addSolution();
        }

        /** */
        public void manufacture()
	{
            System.out.println("Manufacturing...");
            addCasing();
            addSolution();
            addActive();
        }

        /**
         * @return stength of the pill
         */
        public double getStrength()
        {
            return strength;
        }

        /**
         * @return stength of the pill.
         */
        public double getSize()
	{
            return size;
        }

        /**
         * @return color of the pill.
         */
        public String getColor()
	{
            return color;
        }

        /**
         * @return Casing of the pill.
         */
        public String getCasing()
	{
            return casing;
        }

        /**
         * @return Solution of the pill.
         */
        public String getSolution()
	{
            return solution;
        }

        /**
         * @return Active of the pill.
         */
        public String getActive()
	{
            return active;
        }

        /**
         * Print casing.
         */
        protected void addCasing()
	{
            casing = "X";
            System.out.println("Adding casing: " + casing);
        }

        /**
         * Print solution.
         */
        protected void addSolution()
	{
            solution = "Y";
            System.out.println("Adding solution: " + solution);
        }

        /**
         * addactive string.
         */
        protected void addActive()
	{
            active = "Z";
            System.out.println("Adding active ingredient: " + active);
        }

        /**
         * @return formated description.
         */
        public String getDescription()
	{
            return String.format(DESCRIPTION_FSTRING, getName(),
                    getColor(), getSize(), getStrength());

        }

        /**
         * @return formated gelcap string.
         */
        public String toString()
	{
            return String.format(TOSTRING_FSTRING,
                    getName(), getColor(), getSize(), getStrength());
        }
    }
}
