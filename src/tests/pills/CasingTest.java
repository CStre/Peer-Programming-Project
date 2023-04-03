/**
 *    Project SoftGel Part2
 * 
 * Title:           CasingTest
 * Files:           CasingTest.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 * 
 * @author:         Hannah Boulet,
 *                  Ella Fulton
 *  
 * Group Name:      SlayFam, Subteam A
 * Sprint:          3
 * @version:        4/02/2023
 */

package pills;

// imports
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;			
import java.io.PrintStream;	

public class CasingTest
{
    private OilSolution oil;
    private SalineSolution saline;

    private String oilreturn = "oil";
    private String salineReturn = "saline";
    private ByteArrayOutputStream baos;
    private PrintStream oldout;

    @BeforeEach
    public void beforeEach()
    {
        saline = new SalineSolution();
        oil = new OilSolution();
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
        assertEquals(oilreturn, oil.generateSolution());
    }

    @Test
    public void testSaline()
    {
        assertEquals(salineReturn, saline.generateSolution());
    }

}
