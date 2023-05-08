package pills;

// imports
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;			
import java.io.PrintStream;	

/**
 *    Project SoftGel Part 3
 *
 * Title:           ActiveTest
 * Files:           ActiveTest.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 * 
 * @author          Hannah Boulet,
 *                  Tayo Olofintuyi
 * 
 * Group Name:      SlayFam, Subteam 1
 * Sprint:          6
 * @version         4/17/2023
 */

public class ActiveTest 
{
    private AcetaminophenActive ace;
    private ZolpidemActive zol;

    private String acereturn = "acetaminophen"; 
    private String zolreturn = "zolpidem";
    private ByteArrayOutputStream baos;
    private PrintStream oldout;

    private final int zolpidemActivePort = 1093;
    private final int acetaminophenActivePort = 1094;

    @BeforeEach
    public void beforeEach()
    {
        try
        {
            ace = new AcetaminophenActive(acetaminophenActivePort);
            zol = new ZolpidemActive(zolpidemActivePort);
        }
        catch (Exception e)
        {

        }

        this.oldout = System.out;
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    @AfterEach
    public void afterEach()
    {
        System.setOut(oldout);
    }

    @Test
    public void testAcetaminophen()
    {
        try
        {
            assertEquals(acereturn, ace.generateActive(AdultAcheAway.STRENGTH));
        }
        catch (Exception e)
        {

        }
    }

    @Test
    public void testZolpidem()
    {
        try
        {
            assertEquals(zolreturn, zol.generateActive(AdultAcheAway.STRENGTH));
        }
        catch (Exception e)
        {

        }
    }
}
