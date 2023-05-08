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
 * @version         4/18/2023
 */

public class CasingTest
{
    private GelatinCasing gel;
    private PlasticizerCasing plas;

    private String gelreturn = "gelatin"; 
    private String plasreturn = "plasticizer";
    private ByteArrayOutputStream baos;
    private PrintStream oldout;

    private final int gelatinCasingPort = 1098;
    private final int plasticizerCasingPort = 1097;

    @BeforeEach
    public void beforeEach()
    {
        try
        {
            gel = new GelatinCasing(gelatinCasingPort);
            plas = new PlasticizerCasing(plasticizerCasingPort);
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
    public void testPlasticizer()
    {
        try
        {
            assertEquals(plasreturn, plas.generateCasing());
        }
        catch (Exception e)
        {

        }
    }

    @Test
    public void testGelatin() 
    {
        try
        {
            assertEquals(gelreturn, gel.generateCasing());
        }
        catch (Exception e)
        {

        }
    }

}


