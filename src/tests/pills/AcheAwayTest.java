package pills;
/**
 * Title:           AcheAwayTest
 * Files:           AcheAwayTest.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx.Sapphire
 * 
 * @author:         Sashe Nikolov,
 *                  Ella Fulton,
 *                  Collin Streitman
 *
 * Group Name:      SlayFam, Subteam B
 * @version:        2/26/2023
 */

// imports
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

    // formatting string
    private static final String MANU_FSTRING = "Manufacturing...\n"
            + "Adding %s casing\nAdding %s solution\n"
            + "Adding %s active\n...completed manufacturing\n";

    private static AcheAway acheA;
    private PrintStream oldOut;
    private ByteArrayOutputStream baos = new ByteArrayOutputStream();

    /**
     * creating test objects.
     */
    @BeforeEach
    public void setup()
    {
        this.oldOut = System.out;
        acheA = new AcheAway(TEST_STR, TEST_SIZE, TEST_COLOR);
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
        assertEquals(CORRECT_NAME, acheA.getName());
    }

    /**
     * tests assert equals with strength getter.
     */
    @Test
    public void testStrength()
    {
        assertEquals(TEST_STR, acheA.getStrength());
    }

    /**
     * tests assert equals with size getter.
     */
    @Test
    public void testSize()
    {
        assertEquals(TEST_SIZE, acheA.getSize());
    }

    /**
     * tests assert equals with color getter.
     */
    @Test
    public void testColor()
    {
        assertEquals(TEST_COLOR, acheA.getColor());
    }

    /**
     * tests assert equals with casing getter.
     */
    @Test
    public void testCasing()
    {
        assertEquals(TEST_CASE, acheA.getCasing());
    }

    /**
     * tests assert equals with solution getter.
     */
    @Test
    public void testSolution()
    {
        assertEquals(TEST_SOL, acheA.getSolution());
    }

    /**
     * tests assert equals with active getter.
     */
    @Test
    public static void testActive()
    {
        assertEquals(TEST_ACT, acheA.getActive());
    }

    /**
     * tests assert equals with manufacture process.
     */
    @Test
    public void testManufactureProcess()
    {
        acheA.manufacture();
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
