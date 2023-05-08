package pills;

//imports
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 *    Project SoftGel Part 3
 *
 * Title:           AdultGelCapFactoryTest
 * Files:           AdultGelCapFactoryTest.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 *
 * @author          Sashe Nikolov,
 *                  Ella Fulton,
 *                  Hannah Boulet
 *
 * Group Name:      SlayFam, Subteam A
 * Sprint:          4
 * @version         4/02/2023
 */

public class AdultGelCapFactoryTest
{
    // test variables
    public static final double TEST_ADULTDSTR = 5.20;
    public static final double TEST_ADULTASTR = 825.00;

    public static final String TEST_CONSTD = "Constructing Adult version of Dreamly\n";
    public static final String TEST_CONSTA = "Constructing Adult version of AcheAway\n";

    private AdultGelCapFactory agc;
    private ByteArrayOutputStream baos;
    private PrintStream oldOut;

    @BeforeEach
    public void setUp() 
    {
        this.agc = AdultGelCapFactory.getInstance();
        this.oldOut = System.out;
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

    }

    // tests that the Dreamly strength returns correctly.
    @Test
    public void testDStrength() 
    {
        double dStr = agc.getDreamlyStrength();
        assertEquals(dStr, TEST_ADULTDSTR);
    }

    // tests that the AcheAway strength returns correctly.
    @Test
    public void testAStrength() 
    {
        double aStr = agc.getAcheAwayStrength();
        assertEquals(aStr, TEST_ADULTASTR);
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
        agc.constructDreamly("5.20", "12.24", "tan");
        assertEquals(TEST_CONSTD, getOutput());
        assertTrue(agc.constructDreamly("5.20", "12.24", "tan") instanceof AdultDreamly);
        // check if AdultDreamly object is returned
    }

    // tests constructAcheAway
    @Test
    public void testConstA() 
    {
        agc.constructAcheAway("825.00", "8.50", "white");
        assertEquals(TEST_CONSTA, getOutput());		
        assertTrue(agc.constructAcheAway("825.00", "8.50", "white") instanceof AdultAcheAway);	
    }			
}

