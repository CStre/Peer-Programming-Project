package pills;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *    Project SoftGel Part 3
 *
 * Title:           SoftGelPillStore
 * Files:           SoftGelPillStore.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 *
 * @author          Sashe Nikolov,
 *                  Tayo Olofintuyi,
 *                  Ella Fulton
 *
 * Group Name:      SlayFam, Subgroup 1
 * Sprint:          7
 * @version         4/28/2023
 */

public class SoftGelPillStore
{
    /**
     * Store variables.
     */ 
    private GelCapFactory factory;
    private ArrayList<GelCap> currentOrder;
    private Scanner input;
    private PrintStream output;
    private String customerName;
    private int customerAge;
    private boolean isLoggedIn;

    /**
     * Inspector objects.
     */ 
    private StrengthInspector strinspector = new StrengthInspector();
    private FailureInspector failinspector = new FailureInspector();
    private ConsistencyInspector coninspector = new ConsistencyInspector();

    /**
     * Constructor that accepts input and output.
     *
     * @param input the store's scanner input.
     * @param output the store's print stream output.
     *
     */ 
    public SoftGelPillStore(Scanner input, PrintStream output)
    {
        this.input = input;
        this.output = output;
    }

    /**
     * Constructor for output only.
     *
     * @param output PrintStream output.
     */ 
    public SoftGelPillStore(PrintStream output)
    {
        this(new Scanner(System.in), output);
    }

    /**
     * Input only constructor.
     *
     * @param input The Scanner input.
     */ 
    public SoftGelPillStore(Scanner input)
    {

        this(input, System.out);
    }

    /**
     * No arg constructor.
     */  
    public SoftGelPillStore()
    {

        this(new Scanner(System.in), System.out);
    }

    /**
     * Getter for the isLoggedIn boolean.
     * @return boolean
     */
    public boolean isLoggedIn()
    {
        return isLoggedIn;
    }

    /**
     * Getter for age.
     * @return int
     */
    public int getAge()
    {
        return customerAge;
    }

    /**
     * Order method to create a pills order.
     * Checks if user is logged in and prints pill options to user.
     *
     */ 
    public void order()
    {
        if (!isLoggedIn)
        {
            output.println("You must log in before you can order.\n");
            return;
        }

        output.printf("\nHello, %s. What would you like to order?\n", customerName);
        output.println("Options:\n1) Dreamly\n2) AcheAway\n3) Cancel\n");

        int choice = 0;

        choice = Integer.parseInt(input.nextLine());

        while (choice < 1 || choice > 3)
        {
            output.println("Please enter 1, 2, or 3\n");

            try
            {
                choice = Integer.parseInt(input.nextLine());
            }
            catch (Exception e)
            {
                choice = 0;
            }
        }

        if (choice == 1)
        {
            currentOrder.add(factory.constructDreamly("Plasticizer", "Oil", "Zolpidem"));
        }

        else if (choice == 2)
        {
            currentOrder.add(factory.constructAcheAway("Gelatin", "Saline", "Acetaminophen"));
        }
    }

    /**
     * This is the checkOut method. It checks out the user's order and
     * prints it out. 
     * Prints any error statements as well and will
     * reset the order if there are any.
     *
     * @return gcArr the returned order put into an array.
     */
    public GelCap[] checkOut()
    {

        if (!isLoggedIn)
        {
            output.println("You need to log in and order before you can checkout\n");
            return null;
        }

        output.println("Thanks for shopping!\nHere is your order\n");

        if (consistentOrder() != true)
        {
            output.println("Error: Pills inconsistent. Restarting order...");
            coninspector.reset();
            return null;
        }

        if (tooBigFailRate(checkFailRate()) != true)
        {
            output.println("Error: Fail rate too large. Restarting order...");
            failinspector.reset();
            return null;
        }

        for (GelCap g : currentOrder)
        {	
            output.println(g.toString());
        }

        GelCap[] gcArr = (GelCap[]) currentOrder.toArray(new GelCap[currentOrder.size()]);
        currentOrder.clear();

        return gcArr;
    }

    /**
     * Method for the user to log in. Allows user to input name and age.
     */ 
    public void logIn() 
    {

        String name;
        int age = -1;

        output.println("What is your name?  ");
        name = input.nextLine();

        do
        {
            output.println("\nWhat is your age?  ");
            try
            {
                age  = Integer.parseInt(input.nextLine());
                if (age < 18)
                {
                    output.println("Thank you for ordering your"
                        + " child's pills at SoftGelPill store!");
                }
            }
            catch (Exception e)
            {
                age = -1;
            }            
        }
        while (age < 0);

        logIn(name, age);
    }

    /**
     * Same log in method but allows two inputs: name and age.
     * Checks if user is adult or child for adult/child factory.
     *
     * @param name User's name
     * @param age User's age
     */
    public void logIn(String name, int age) 
    {
        customerAge = age;
        customerName = name;

        if (age < 18)
        {
            factory = ChildGelCapFactory.getInstance();
        }
        else
        {
            factory = AdultGelCapFactory.getInstance();
        }

        isLoggedIn = true;

        currentOrder = new ArrayList<GelCap>();
    }

    /**
     * logOut method allows user to exit program.
     *
     * @return true user must be logged in to log out.
     */
    public boolean logOut()
    {
        if (!isLoggedIn)
        {
            output.println("You are not logged in.");
            return false;
        }
        if (currentOrder.size() > 0)
        {
            output.println("You have an order that you have not checked out."
                    + " Are you sure you want to log out? (Y/N)");
            try
            {
                String response = input.nextLine();
                if (!(response.equals("y") || response.equals("Y")))
                {
                    output.println("You have chosen to stay logged in.");
                    return false;
                }
            } 
            catch (Exception e) 
            {
                output.println("You have chosen to stay logged in.");
                return false;
            }
        }
        isLoggedIn = false;
        currentOrder = null;
        customerAge = -1;
        customerName = "";
        output.println("Your cart has been cleared and you have been logged out.");
        return true;
    }

    /**
     * Sets the PrintStream output.
     *
     * @param output PS output.
     */ 
    public void setOutput(PrintStream output)
    {
        this.output = output;
    }

    /**
     * Sets the scanner input.
     *
     * @param input the user input from Scanner.
     */ 
    public void setInput(Scanner input)
    {
        this.input = input;
    }

    /**
     * Gets output.
     *
     * @return output PrintStream output.
     */ 
    public PrintStream getOutput()
    {
        return output;
    }

    /**
     * Gets input.
     *
     * @return input User input.
     */
    public Scanner getInput()
    {
        return input;
    }

    /**
     * This method gets the dreamly strength by using a strength inspector.
     * GelCap object traverses through the current order.
     *
     * @return strinspector.getDreamlyStrength() is the calculated strength
     * after the loop.
     */ 
    public double getDreamlyStrength()
    {
        for (GelCap d : currentOrder)
        {
            d.accept(strinspector);	
        }		   
        return strinspector.getDreamlyStrength();  
    }

    /**
     * This method gets the ache away strength by using a strength inspector.
     * GelCap object traverses through the current order.
     *
     * @return strinspector.getAcheAwayStrength() is the calculated strength
     * after the loop.
     */ 
    public double getAcheAwayStrength()
    {
        for (GelCap a : currentOrder)
        {
            a.accept(strinspector);
        }
        return strinspector.getAcheAwayStrength();
    }


    public void printCurrentOrder()
    {
        output.printf("Hello, " + customerName + "."
                + "\nYour order contains: " + "\nDreamly: "
                + getDreamlyStrength() + "\nAche Away: "
                + getAcheAwayStrength()); 
    }

    /**
     * Boolean method that accepts the failRate and sees if it's too big.
     *
     * @param failRate the calculated failRate.
     * Will reject fail rates that are higher than 15. Average is 10.
     *
     * @return true when fail rate isn't too big.
     */ 
    private boolean tooBigFailRate(double failRate)
    {
        if (failRate > 15)
        {
            return false;
        }	
        return true;
    }

    /**
     * Double method that checks and calculates the fail rate.
     * Uses a loop to traverse through the currentOrder and calculates
     * the fail rate using the fail inspector.
     *
     * @return failinspector.getFailRate() is the calculated rate after the 
     * loop.
     */
    private double checkFailRate()
    {
        for (GelCap rate : currentOrder)
        {
            rate.accept(failinspector);
        }
        return failinspector.getFailRate();
    }

    /**
     * Boolean method to check if order is consistent using
     * consistency inspector.
     *
     * @return true if it is consistent.
     */
    private boolean consistentOrder()
    {
        for (GelCap c : currentOrder)
        {
            c.accept(coninspector);
        }
        if (coninspector.soFarConsistent() == false)
        {
            return false;
        }
        return true;
    }	
}
