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
 * Title:           SolutionTest
 * Files:           SolutionTest.java
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

public class SolutionTest
{
    private OilSolution oil;
    private SalineSolution saline;

    private String oilreturn = "oil";
    private String salineReturn = "saline";
    private ByteArrayOutputStream baos;
    private PrintStream oldout;

    private final int oilSolutionPort = 1096;
    private final int salineSolutionPort = 1095;

    @BeforeEach
    public void beforeEach() 
    {
        try
        {
            saline = new SalineSolution(salineSolutionPort);
            oil = new OilSolution(oilSolutionPort);
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
    public void testOil()
    {
        try
        {
            assertEquals(oilreturn, oil.generateSolution());
        }
        catch (Exception e)
        {

        }
    }

    @Test
    public void testSaline()
    {
        try
        {
            assertEquals(salineReturn, saline.generateSolution());
        }
        catch (Exception e)
        {

        }
    }
}
