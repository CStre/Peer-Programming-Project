package pills;

//imports
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 *       Project SoftGel Part 3
 *
 * Title:           ChildGelCapFactoryTest
 * Files:           ChildGelCapFactoryTest.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 *
 * @author          Sashe Nikolov,
 *                  Hannah Boulet,
 *                  Ella Fulton
 *
 * Group Name:      SlayFam, Subteam 2
 * Sprint:          7
 * @version         4/24/2023
 */

public class ChildGelCapFactoryTest
{

    // test variables
    public static final double TEST_CHILDDSTR = 1.25;
    public static final double TEST_CHILDASTR = 415.00;

    public static final String TEST_CONSTD = "Constructing Child version of Dreamly\n";
    public static final String TEST_CONSTA = "Constructing Child version of AcheAway\n";

    private ChildGelCapFactory cgc;
    private ByteArrayOutputStream baos;
    private PrintStream oldOut;

    @BeforeEach
    public void setUp() 
    {
        this.cgc = ChildGelCapFactory.getInstance();
        this.oldOut = System.out;
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

    }

    // tests that the Dreamly strength returns correctly.
    @Test
    public void testDStrength() 
    {
        double dStr = cgc.getDreamlyStrength();
        assertEquals(dStr, TEST_CHILDDSTR);
    }

    // tests that the AcheAway strength returns correctly.
    @Test
    public void testAStrength() 
    {
        double aStr = cgc.getAcheAwayStrength();
        assertEquals(aStr, TEST_CHILDASTR);
    }

    // helper method
    @Test
    private String getOutput()
    {
        System.out.flush();
        return baos.toString().replaceAll("\r", "");
    }

    // tests constructDreamly prints correctly and returns correct value
    @Test
    public void testConstD() 
    {
        cgc.constructDreamly("1.25", "4.5", "fuchsia");
        assertEquals(TEST_CONSTD, getOutput());
        // check if ChildDreamly object is returned
        assertTrue(cgc.constructDreamly("1.25", "4.5", "fuchsia") instanceof ChildDreamly);
    }

    // tests constructAcheAway
    @Test
    public void testConstA() 
    {
        cgc.constructAcheAway("415.00", "3.25", "cyan");
        assertEquals(TEST_CONSTA, getOutput());		
        assertTrue(cgc.constructAcheAway("415.00", "3.25", "cyan") instanceof ChildAcheAway);	
    }			
}

