package pills;

//imports
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *    Project SoftGel Part 3
 * 
 * Title:           SoftGelPillStoreTest
 * Files:           SoftGelPillStoreTest.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 *
 * @author          Sashe Nikolov,
 *                  Hannah Boulet,
 *                  Tayo Olofintuyi
 *                  Ella Fulton
 *
 * Group Name:      SlayFam, Subteam 2
 * Sprint:          7
 * @version         4/29/2023
 **/

public class SoftGelPillStoreTest 
{
    public static final int AGE = 20;
    public static final int CHILDAGE = 5;
    public static final String NAME = "Ella";
    public static final String LOGIN = "Ella\n20";
    public static final String LOGINOUTPUT = "What is your name?  \n\nWhat is your age?  \n";
    public static final String LOGOUTFAIL = "You are not logged in.\n";
    public static final String LOGOUTFAIL2 = "You have an order that you have not checked out. "
        + "Are you sure you want to log out? (Y/N)\n"
        + "You have chosen to stay logged in.\n";
    public static final String ORDERFAIL = "You must log in before you can order.\n\n";
    public static final String ORDER = String.format("\nHello, %s. What would you like to order?"
            + "\nOptions:\n1) Dreamly\n2) AcheAway\n3) Cancel\n\n", NAME);
    public static final String CHECKOUTFAIL = "You need to log in and order before you can "
        + "checkout\n\n";
    public static final String CHECKOUT = "Thanks for shopping!\nHere is your order\n\nGelCap { "
        + "name: AcheAway, color: white, size: 8.5, strength: 825.0 }\n";
    public static final String PRINTCURRENTORDER = "\nHello, Ella. What would you like to order?"
        + "\nOptions:\n1) Dreamly\n2) AcheAway\n3) Cancel\n\n\nHello, Ella. "
        + "What would you like to order?"
        + "\nOptions:\n1) Dreamly\n2) AcheAway\n3) Cancel\n\nHello, Ella.\nYour order contains: "
        + "\nDreamly: 5.2\nAche Away: 1650.0";

    private SoftGelPillStore sgp;
    private ByteArrayOutputStream baos;
    private Scanner testInput;
    private PrintStream testOutput;
   
   /**
    * Method to be completed before each test.
    * Sets variables and creates the SoftGelPillStore.
    */ 
    @BeforeEach
    public void setUp() 
    {
        baos = new ByteArrayOutputStream();
        testInput = new Scanner(System.in);
        testOutput = new PrintStream(baos);
        this.sgp = new SoftGelPillStore(testOutput);
    }

    /**
     * A test for the constructors of SoftGelPillStore.
     * Ensures that the getInput and getOutput methods work as well.
     */
    @Test
    public void testConstructors()
    {
        // Testing two-arg constructor...
        sgp = new SoftGelPillStore(testInput, testOutput);
        assertEquals(testInput, sgp.getInput());
        assertEquals(testOutput, sgp.getOutput());

        // Testing one-arg constructor (Scanner)...
        sgp = new SoftGelPillStore(testInput);
        assertEquals(testInput, sgp.getInput());
        assertEquals(System.out, sgp.getOutput());

        // Testing one-arg constructor (PrintStream)...
        sgp = new SoftGelPillStore(testOutput);
        assertEquals(testOutput, sgp.getOutput());	
    }		

    /**
     * Testing the logIn method of the store to make sure the name and age is set. 
     */
    @Test
    public void testLogIn()
    {
        sgp.setInput(new Scanner(LOGIN));
        sgp.logIn();
        assertEquals(LOGINOUTPUT, baos.toString().replaceAll("\r", ""));
    }

    /**
     * Testing the situation that you try to logout but are not logged in yet.
     */
    @Test
    public void testLogOutFail1()
    {
        assertFalse(sgp.logOut());
        assertEquals(LOGOUTFAIL, baos.toString().replaceAll("\r", ""));
    }

    /**
     * Testing the situation that you've logged in but have an uncompleted order.
     */
    @Test
    public void testLogOutFail2()
    {
        sgp.logIn(NAME, AGE);
        sgp.setInput(new Scanner("1"));
        sgp.order();
        sgp.setInput(new Scanner("N"));
        // Because user input is "N"
        assertFalse(sgp.logOut());
        assertEquals(ORDER + LOGOUTFAIL2, baos.toString().replaceAll("\r", ""));
        sgp.setInput(new Scanner("y"));
        // Because user input is "y"
        assertTrue(sgp.logOut());
    }

    /**
     * Testing for a valid logout in valid circumstance.
     */
    @Test
    public void testLogOutSuccess()
    {
        sgp.logIn(NAME, AGE);
        assertTrue(sgp.logOut());
    }
   
    /**
     * Testing that you cannot order if you haven't logged in yet.
     */
    @Test
    public void testOrderFail()
    {
        sgp.order();
        assertEquals(ORDERFAIL, baos.toString().replaceAll("\r", ""));
    }

    /**
     * Testing for a valid order.
     */
    @Test
    public void testOrder()
    {
        sgp.logIn(NAME, AGE);
        sgp.setInput(new Scanner("1"));
        sgp.order();
        assertEquals(ORDER, baos.toString().replaceAll("\r", ""));
    }

    /**
     * Testing that you can't checkout if you haven't logged in or ordered yet.
     */
    @Test
    public void testCheckOutFail()
    {
        assertEquals(null, sgp.checkOut());
        assertEquals(CHECKOUTFAIL, baos.toString().replaceAll("\r", ""));        
    }

    /**
     * Testing for a valid checkout after ordering an adult ache away pill.
     */
    @Test
    public void testCheckOut()
    {
        sgp.logIn(NAME, AGE);
        sgp.setInput(new Scanner("2"));
        sgp.order();
        sgp.checkOut();
        assertEquals(ORDER + CHECKOUT, baos.toString().replaceAll("\r", ""));
    }

    /**
     * Testing the printCurrentOrder method of the store after ordering one of each pill.
     */
    @Test
    public void testPrintCurrentOrder()
    {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        sgp.setOutput(new PrintStream(out));
        sgp.logIn(NAME, AGE);
        sgp.setInput(new Scanner("1"));
        sgp.order();
        sgp.setInput(new Scanner("2"));
        sgp.order();
        sgp.printCurrentOrder();
        assertEquals(PRINTCURRENTORDER, out.toString().replaceAll("\r", ""));
    }
}

