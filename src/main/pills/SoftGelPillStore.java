/**
 *    Project SoftGel Part 2
 *
 * Title:           SoftGelPillStore
 * Files:           SoftGelPillStore.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 *
 * @author          Collin Streitman,
 *                  Tayo Olofintuyi
 *
 * Group Name:      SlayFam, Subteam B
 * Sprint:          4
 * @version         4/02/2023
 */

package pills;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class SoftGelPillStore
{
    private GelCapFactory factory;
    private ArrayList<GelCap> currentOrder;
    private Scanner input;
    private PrintStream output;
    private String customerName;
    private int customerAge;
    private boolean isLoggedIn;
    
    public SoftGelPillStore(Scanner input, PrintStream output)
    {
        this.input = input;
        this.output = output;
    }

    public SoftGelPillStore(PrintStream output)
    {
        this(new Scanner(System.in), output);
    }

    public SoftGelPillStore(Scanner input)
    {

        this(input, System.out);
    }

    public SoftGelPillStore()
    {

        this(new Scanner(System.in), System.out);
    }

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

    public GelCap[] checkOut()
    {

        if (!isLoggedIn)
        {
            output.println("You need to log in and order before you can checkout\n");
            return null;
        }

        else
        {
            output.println("Thanks for shopping!\nHere is your order\n");
        }

        for (GelCap g : currentOrder)
        {
            output.println(g.toString());
        }

        GelCap[] gcArr = (GelCap[]) currentOrder.toArray(new GelCap[currentOrder.size()]);
        currentOrder.clear();
        return gcArr;
    }

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
            }
            catch (Exception e)
            {
                age = -1;
            }            
        }
        while (age < 0);

        logIn(name, age);
    }

    public void logIn(String name, int age) 
    {
        customerAge = age;
        customerName = name;

        if (age < 18)
        {
            factory = new ChildGelCapFactory();
        }
        else
        {
            factory = new AdultGelCapFactory();
        }

        isLoggedIn = true;

        currentOrder = new ArrayList<GelCap>();
    }

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
                    + " Are you sure you want to log out? (y/N)");
            try 
            {
                String response = input.nextLine();
                if (!response.equals("y"))
                {
                    return false;
                }
            } 
            catch (Exception e) 
            {
                return false;
            }
        }
        isLoggedIn = false;
        currentOrder = null;
        customerAge = -1;
        customerName = "";
        return true;
    }

    public void setOutput(PrintStream output)
    {
        this.output = output;
    }

    public void setInput(Scanner input)
    {
        this.input = input;
    }

    public PrintStream getOutput()
    {
        return output;
    }

    public Scanner getInput()
    {
        return input;
    }

}
