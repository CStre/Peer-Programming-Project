package pills;

//imports
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.fail;

/**
 *    Project SoftGel Part 3
 *
 * Title:           GelCapFactoryTest
 * Files:           GelCapFactoryTest.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 *
 * @author          Hannah Boulet,
 *                  Tayo Olofintuyi
 *
 * Group Name:      SlayFam, Subteam 1
 * Sprint:          7
 * @version         4/17/2023
 */

public class GelCapFactoryTest 
{
    // private static variables for testing the construct methods and getters
    private static final String CONSTDREAM = "constructDreamly called\n";
    private static final String CONSTACHE = "constructAcheAway called\n";
    private static final String GETDREAM = "getDreamlyStrength called\n";
    private static final String GETACHE = "getAcheAwayStrength called\n";
    private static final String NULLA = "GelCap { name: AcheAway, color:" 
        + " , size: 0.0, strength: 0.0 }";
    private static final String NULLD = "GelCap { name: Dreamly, color:"
        + " , size: 0.0, strength: 0.0 }";
    // private static variables for testing produceDreamly
    private static final String QUALITYDGOOD = "Creating a Dreamly pill ... \n"
    // From GelatinCasing

            + "getDreamlyStrength called\n"

            + "constructDreamly called\n"
            // From GalCapFactory
            + "Performing quality check ... \n"
            + "quality check passed\n"
            + "Returning a good Dreamly GelCap Pill\n";

    private static final String QUALITYDBAD = "Creating a Dreamly pill ... \n"

            + "getDreamlyStrength called\n"
        
            + "constructDreamly called\n"
            // From GalCapFactory
            + "Performing quality check ... \n"
            + "quality check failed\n"
            + "Error during Dreamly production. Returning null.\n";

    // private static variables for testing produceAcheAway
    private static final String QUALITYAGOOD = "Creating an AcheAway pill ... \n"
    // From PlasticizerCasing
            + "getAcheAwayStrength called\n"
            // From ZolpidemActive
            + "constructAcheAway called\n"
            // From GelCapFactory
            + "Performing quality check ... \n"
            + "quality check passed\n"
            + "Returning a good AcheAway GelCap Pill\n";

    private static final String QUALITYABAD = "Creating an AcheAway pill ... \n"
    // From PlasticizerCasing
            + "getAcheAwayStrength called\n"
            + "constructAcheAway called\n"
            // From GelCapFactory
            + "Performing quality check ... \n"
            + "quality check failed\n"
            + "Error during AcheAway production. Returning null.\n";

    // private static variables for ConstructDreamly()
    private static final String DCASING = "plasticizer";
    private static final String DSOLUTION = "oil";
    private static final String DACTIVE = "zolpidem";

    // private static variables for ConstructAcheAway()
    private static final String ACASING = "gelatin";
    private static final String ASOLUTION = "saline";
    private static final String AACTIVE = "acetaminophen";

    // private static variables for testing qualityCheck()
    private static final int TESTAMT = 100;
    private static final double TESTHIGH = 0.96;
    private static final double TESTLOW = 0.75;

    // private static variables for redirecting System.out
    private GelCapFactoryMock gcf;
    private ByteArrayOutputStream baos;
    private PrintStream oldOut;

    // helper method for other tests
    private String getOutput()
    {
        System.out.flush();
        return baos.toString().replaceAll("\r", "");
    }

    // redirects System.out before each test
    @BeforeEach
    public void beforeEach()
    {
        try
        { 
            this.gcf = new GelCapFactoryMock();
       
        }
        catch (Exception e)
        {

        }
        this.oldOut = System.out;
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    // sets System.out back to the oldOut
    @AfterEach
    public void afterEach()
    {
        System.setOut(oldOut);
    }

    // tests that the constructDreamly prints correctly
    @Test
    public void testConstD()
    {
        gcf.constructDreamly(DCASING, DSOLUTION, DACTIVE);
        assertEquals(CONSTDREAM, getOutput());
    }

    // tests that the constructAcheAway prints correctly
    @Test
    public void testConstA()
    {
        gcf.constructAcheAway(ACASING, ASOLUTION, AACTIVE);
        assertEquals(CONSTACHE, getOutput());
    }

    // tests that the getDreamlyStrength prints correctly
    @Test
    public void getD()
    {
        gcf.getDreamlyStrength();
        assertEquals(GETDREAM, getOutput());
    }

    // tests that the getAcheAwayStrength prints correctly
    @Test
    public void getA()
    {
        gcf.getAcheAwayStrength();
        assertEquals(GETACHE, getOutput());
    }

    // tests that the produceDreamly() works as well as tests to make sure
    // qualityCheck()
    // stays within an acceptable range around 90% passing.
    @Test
    public void produceDreamly()
    {
        try
        {
            int counter = 1;
            int accept = 0;
            int fail = 0;
            String strGood = "";
            String strBad = "";
            while (counter <= TESTAMT)
            {
                GelCap pill = gcf.produceDreamly();
                String out = getOutput();
                baos.reset();

                //checks to see if the qualityCheck() passed
                if (QUALITYDGOOD.equals(out))
                {
                    // test return statement
                    //assertTrue(pill instanceof Dreamly);
                    counter++;
                    accept++;
                    strGood = out;
                }
                else if (QUALITYDBAD.equals(out))
                {
                    // test if returns null
                    
                    assertEquals(NULLD, pill.toString());
                    counter++;
                    fail++;
                    strBad = out;
                }
                else
                {
                    fail("Expected outputs were not matched up");
                }
            }
            
            
            // qualityCheck() should return around 90% passing so I set the boundaries to
            // 0.75 and 0.95 when dividing fail/(fail+ accept). This means the boundary outcomes are
            // 75 passing to 25 failing on the low end to 96 passing to 4 failing on the high end. 
            // I purposely made it to where it could be more skewed toward failing instead 
            // of passing because I feel like that is most realistic with testing medication.

            double rate = (fail / TESTAMT);
            if (((rate >= TESTLOW && rate <= TESTHIGH)) || !(strGood.equals(QUALITYDGOOD))
                    || !(strBad.equals(QUALITYDBAD)))
            {
                fail("qualityCheck() is not working correctly");
            }
        }
        catch (Exception e)
        {

        }
    }
    // tests that the produceAcheAway() works as well as tests to make sure
    // qualityCheck()
    // stays within an acceptable range around 90% passing.
    @Test
    public void produceAcheAway()
    {
        try
        { 
            int counter = 1;
            int accept = 0;
            int fail = 0;
            String strGood = "";
            String strBad = "";
            while (counter <= TESTAMT)
            {
                GelCap pill = gcf.produceAcheAway();
                String out = getOutput();
                baos.reset();
                // assertEquals(QUALITYAGOOD, out);

                // checks to see if the qualityCheck() passed
                if (QUALITYAGOOD.equals(out))
                {
                    // testing the return statement
                    // assertTrue(pill instanceof AcheAway);
                    counter++;
                    accept++;
                    strGood = out;
                }
                else if (QUALITYABAD.equals(out))
                {
                    // testing if returns nullpill
                    assertEquals(NULLA, pill.toString());
                    counter++;
                    fail++;
                    strBad = out;
                }
                else
                {
                    fail("Expected outputs were not matched up");                
                }
            }

            // qualityCheck() should return around 90% passing so I set the boundaries to
            // 0.75 and 0.95 when dividing fail/(fail+ accept). This means the boundary outcomes are
            // 75 passing to 25 failing on the low end to 96 passing to 4 failing on the high end. 
            // I purposely made it to where it could be more skewed toward failing instead 
            // of passing because I feel like that is most realistic with testing medication.

            double rate = (fail / TESTAMT);
            if (((rate >= TESTLOW && rate <= TESTHIGH)) || !(strGood.equals(QUALITYAGOOD))
                    || !(strBad.equals(QUALITYABAD)))
            {
                fail("qualityCheck() is not working correctly");
            }
        }
        catch (Exception e)
        {

        }
    }

    /**
     * Private inner class called GelCapFactoryMock that extends from GelCapFactory
     * that includes
     * the constructDreamly(), constructAcheAway(), getDreamlyStrength(), and
     * getAcheAwayStrength()
     * to be used in the tests. The print statements and return statements were
     * added and changed to test.
     */
    private class GelCapFactoryMock extends GelCapFactory
    {
        private String solution;
        private String active;
        private String casing;

        /**
         * This is a protected method called constructDreamly() that prints
         * "constructDreamly called" and
         * returns null.
         * 
         * @param casing
         * @param solution
         * @param active
         * @return null
         */
        protected Dreamly constructDreamly(String casing, String solution, String active)
        {
            System.out.print("constructDreamly called\n");
            return null;
        }

        /**
         * This is a protected method called constructAcheAway() that prints
         * "constructAcheAway called" and
         * returns null.
         * 
         * @param casing
         * @param solution
         * @param active
         * @return null
         */
        protected AcheAway constructAcheAway(String casing, String solution, String active)
        {
            System.out.print("constructAcheAway called\n");
            return null;
        }

        /**
         * This is a protected method called getDreamlyStrength() that prints
         * "getDreamlyStrength called" and
         * returns a double of zero.
         * 
         * @return double
         */
        protected double getDreamlyStrength()
        {
            System.out.print("getDreamlyStrength called\n");
            return 0;
        }

        /**
         * This is a protected method called getAcheAwayStrength() that prints
         * "getAcheAwayStrength called" and
         * returns a double of zero.
         * 
         * @return double
         */
        protected double getAcheAwayStrength()
        {
            System.out.print("getAcheAwayStrength called\n");
            return 0;
        }

    }
}
