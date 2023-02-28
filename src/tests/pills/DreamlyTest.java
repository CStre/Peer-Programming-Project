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
 * @author:         2/27/2023
 */

// imports
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DreamlyTest
{
    // test variables
    public static final String CORRECT_NAME = "Dreamly";
    public static final int TEST_STR = 10;
    public static final int TEST_SIZE = 15;
    public static final String TEST_COLOR = "BLUE";
    public static final String TEST_CASE = "Plasticizer";
    public static final String TEST_SOL = "Oil";
    public static final String TEST_ACT = "Zolpidem";

    // formatting string
    private static final String MANU_FSTRING = "Manufacturing...\n"
            + "Adding %s casing\nAdding %s solution\n"
            + "Adding %s active\n...completed manufacturing\n";

    private static Dreamly dreamly;
    private PrintStream oldOut;
    private ByteArrayOutputStream baos = new ByteArrayOutputStream();

    /**
     * creating test objects.
     */
    @BeforeEach
    public void setup()
    {
        this.oldOut = System.out;
        dreamly = new Dreamly(TEST_STR, TEST_SIZE, TEST_COLOR);
        System.setOut(new PrintStream(baos));
    }

    @AfterEach
    public void afterEach()
    {
        System.setOut(System.out);
        System.setOut(oldOut);
    }

    /**
     * tests assert equals with name getter.
     */
    @Test
    public void testName()
    {
        assertEquals(CORRECT_NAME, dreamly.getName());
    }

    /**
     * tests assert equals with strength getter.
     */
    @Test
    public void testStrength()
    {
        assertEquals(TEST_STR, dreamly.getStrength());
    }

    /**
     * tests assert equals with size getter.
     */
    @Test
    public void testSize()
    {
        assertEquals(TEST_SIZE, dreamly.getSize());
    }

    /**
     * tests assert equals with color getter.
     */
    @Test
    public void testColor()
    {
        assertEquals(TEST_COLOR, dreamly.getColor());
    }

    /**
     * tests assert equals with casing getter.
     */
    @Test
    public void testCasing()
    {
        assertEquals(TEST_CASE, dreamly.getCasing());
    }

    /**
     * tests assert equals with solution getter.
     */
    @Test
    public void testSolution() 
    {
        assertEquals(TEST_SOL, dreamly.getSolution());
    }

    /**
     * tests assert equals with active getter.
     */
    @Test
    public static void testActive()
    {
        assertEquals(TEST_ACT, dreamly.getActive());
    }

    /**
     * tests assert equals with manufacture process.
     */
    @Test
    public void testManufactureProcess()
    {
        dreamly.manufacture();
        String expectedOut = String.format(MANU_FSTRING,
                TEST_CASE, TEST_SOL, TEST_ACT);
        assertEquals(expectedOut, getOutput());
    }

    /**
     * @return output string with format fixed using trim.
     */
    private String getOutput()
    {
        return baos.toString().trim() + "\n";
    }
}
