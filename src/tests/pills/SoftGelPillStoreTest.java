/**
 *    Project SoftGel Part 2
 * 
 * Title:           SoftGelPillStoreTest
 * Files:           SoftGelPillStoreTest.java
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
 **/

package pills;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class SoftGelPillStoreTest 
{
    public static final int AGE = 20;
    public static final String NAME = "Ella";
    public static final String LOGIN = "Ella\n20";
    public static final String LOGINOUTPUT = "What is your name?  \n\nWhat is your age?  \n";
    public static final String LOGOUTFAIL = "You are not logged in.\n";
    public static final String LOGOUTFAIL2 = "You have an order that you have not checked out. "
        + "Are you sure you want to log out? (y/N)\n";
    public static final String ORDERFAIL = "You must log in before you can order.\n\n";
    public static final String ORDER = String.format("\nHello, %s. What would you like to order?"
            + "\nOptions:\n1) Dreamly\n2) AcheAway\n3) Cancel\n\n", NAME);
    public static final String CHECKOUTFAIL = "You need to log in and order before you can "
        + "checkout\n\n";
    public static final String CHECKOUT = "Thanks for shopping!\nHere is your order\n\nGelCap { "
        + "name: AcheAway, color: white, size: 8.5, strength: 825.0 }\n";

    private SoftGelPillStore sgp;
    private ByteArrayOutputStream baos;
    private Scanner testInput;
    private PrintStream testOutput;
    
    @BeforeEach
    public void setUp() 
    {
        baos = new ByteArrayOutputStream();
        testInput = new Scanner(System.in);
        testOutput = new PrintStream(baos);
        this.sgp = new SoftGelPillStore(testOutput);
    }

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

    @Test
    public void testLogIn()
    {
        sgp.setInput(new Scanner(LOGIN));
        sgp.logIn();
        assertEquals(LOGINOUTPUT, baos.toString().replaceAll("\r", ""));
    }

    @Test
    public void testLogOutFail1()
    {
        // In the situation that you're not logged in yet...
        assertFalse(sgp.logOut());
        assertEquals(LOGOUTFAIL, baos.toString().replaceAll("\r", ""));
    }

    @Test
    public void testLogOutFail2()
    {
        // In the situation that you're logged in but have an uncompleted order...
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

    @Test
    public void testLogOutSuccess()
    {
        // Testing for a valid logout...
        sgp.logIn(NAME, AGE);
        assertTrue(sgp.logOut());
    }

    @Test
    public void testOrderFail()
    {
        // In the situation that you're not logged in yet...
        sgp.order();
        assertEquals(ORDERFAIL, baos.toString().replaceAll("\r", ""));
    }

    @Test
    public void testOrder()
    {
        // Testing for a valid order
        sgp.logIn(NAME, AGE);
        sgp.setInput(new Scanner("1"));
        sgp.order();
        assertEquals(ORDER, baos.toString().replaceAll("\r", ""));
    }


    @Test
    public void testCheckOutFail()
    {
        assertEquals(null, sgp.checkOut());
        assertEquals(CHECKOUTFAIL, baos.toString().replaceAll("\r", ""));
    }

    @Test
    public void testCheckOut()
    {
        sgp.logIn(NAME, AGE);
        sgp.setInput(new Scanner("2"));
        sgp.order();
        sgp.checkOut();
        assertEquals(ORDER + CHECKOUT, baos.toString().replaceAll("\r", ""));
    }
}
