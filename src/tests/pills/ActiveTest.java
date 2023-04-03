/**
 *    Project SoftGel Part 2
 *
 * Title:           ActiveTest
 * Files:           ActiveTest.java
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

public class ActiveTest
{
    private GelatinCasing gel;
    private PlasticizerCasing plas;

    private String gelreturn = "gelatin"; 
    private String plasreturn = "plasticizer";
    private ByteArrayOutputStream baos;
    private PrintStream oldout;

    @BeforeEach
    public void beforeEach()
    {
        gel = new GelatinCasing();
        plas = new PlasticizerCasing();

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
    public void testPlasticizer()
    {
        assertEquals(plasreturn, plas.generateCasing());
    }

    @Test
    public void testGelatin()
    {
        assertEquals(gelreturn, gel.generateCasing());
    }

}
