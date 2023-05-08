package client; 
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import pills.GelCap;
import pills.SoftGelPillStore;
import pills.StrengthInspector;
import pills.ConsistencyInspector;
import pills.FailureInspector;
import pills.AdultAcheAway;
import pills.AdultDreamly;
import pills.ChildDreamly;
import pills.ChildAcheAway;
import pills.NullAcheAway;
import pills.NullDreamly;
/**
 *    Project SoftGel Part 3
 *
 * Title:           Demo
 * Files:           Demo.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 * 
 * @author :        Hannah Boulet,
 *                  Ella Fulton,
 *                  Sashe Nikolov
 * 
 * Group Name:      SlayFam, Subteam 1 + 2 + Overseer
 * Sprint:          7
 * @version :        4/30/2023
 */

public class Demo
{
    /**
     * To avoid using magic numbers.
     */
    private static final int ANCIENT = 99;
    private static final int BABY = 10;

    /**
     * A simple interface to interact with the SoftGelPillStore.
     * 
     * @param args unused
     */
    public static void main(String[] args)
    { 
        Random adnum = new Random();
        int ad = adnum.nextInt(6) + 1;
        Scanner input = new Scanner(System.in);
        SoftGelPillStore store = new SoftGelPillStore(input, System.out);
        ArrayList<GelCap[]> orders = new ArrayList<>();
        
        //random goofy ads :).
        switch (ad)
        {
            case 1:
                System.out.println("**************************************************************");
                System.out.println("*  Have you heard of crack? Get ready for the softgelpill    *" 
                    + "\n*version AcheAway and Dreamly. Comes in Child and Adult form!*" 
                    + "\n**************************************************************");
                break;
            case 2:
                System.out.println("******************************************************");
                System.out.println("*Congratulations you've won a $100 Amamzon gift card!*" 
                    + "\n*            Just click the link below!!             *" 
                    + "\n*            totally_not_a_scam.com                  *"
                    + "\n******************************************************");
                break;
            case 3:
                System.out.println("******************************************************************");
                System.out.println("*    Does your child get jealous when you take Dreamly pills?    *" 
                    + "\n*  Well today's your lucky day! Order Child Dreamly pills today! *"
                    + "\n*****************************************************************");
                break;
            case 4:
                System.out.println("*********************************************************");
                System.out.println("* Is your child falling asleep in class? Coming soon to *" 
                    + "\n* softgellpills in 2069 trimethylxanthine for children! *"
                    + "\n********************************************************");
                break;
            case 5:
                System.out.println("***********************************************************");
                System.out.println("*Is your bootyhole sore? Get an Adult AcheAway pill today!*"
                    + "\n***********************************************************");
                break;
            case 6:
                System.out.println("**************************************");
                System.out.println("* Advil just isn't doing it for you? *"
                    + "\n*Well you've come to the right place!*" 
                    + "\n*  Get Adult or Child AcheAway pills *"
                    + "\n*   today! **Side effects may vary.  *"
                    + "\n**************************************");
                break;
            default:
                break;
        }
       
        boolean exit = false;
        String choice = "";
        // Asks user if they inspector or client
        System.out.println("Are you an Inspector or Client?");
        choice = input.nextLine();
        if (choice.equalsIgnoreCase("Inspector")) 
        {
            runInspector();
        } 
        if (choice.equalsIgnoreCase("Client")) 
        {
            runClient();
        }  
        while (!choice.equalsIgnoreCase("Inspector") && !choice.equalsIgnoreCase("Client"))
        {
            System.out.println("Are you an INSPECTOR?? or CLIENT????");
            choice = input.nextLine();
            if (choice.equalsIgnoreCase("Inspector")) 
            {
                runInspector();
            } 
            if (choice.equalsIgnoreCase("Client")) 
            {
                runClient();
            }
        }
    }
    /**
     * Helper method that checks if use input is a 1, 2, or 3.
     * @param selection the string entered by the user
     * @return true if the selection was valid, false otherwise
     */
    private static boolean validSelection(String selection) 
    {
        try 
        {
            int choice = Integer.parseInt(selection);
            return choice == 1 || choice == 2 || choice == 3 || choice == 4;
        } 
        catch (NumberFormatException e) 
        {
            return false;
        }
    }
    /**
     * This method runs the Inspector program by 
     * displaying a menu of inspector options to the user and
     * prompting for user input. The user can 
     * select from four different types of inspectors:
     * ConsistencyInspector for Adult or Child
     * AcheAway and Dreamly products, FailureInspector for
     * all AcheAway and Dreamly products, and 
     * StrengthInspector for Adult AcheAway products.
     * Depending on the user's selection, the
     * corresponding inspector object is instantiated and used to
     * inspect the relevant product(s). The results 
     * of the inspection are printed to the console.
     * The user can exit the program by entering 0.
     */
    public static void runInspector() 
    {
        Scanner scanner = new Scanner(System.in);
        int c = -1;
        while (c != 0) 
        {
            System.out.println("Which inspector would you like to use?" 
                + " (Enter the corresponding number)");
            System.out.println("1. ConsistencyInspector Adult");
            System.out.println("2. ConsistencyInspector Child");
            System.out.println("3. ConsistencyInspector Failure");
            System.out.println("4. FailureInspector for AcheAway");
            System.out.println("5. FailureInspector for Dreamly");
            System.out.println("6. StrengthInspector for Adult AcheAway Pill");
            System.out.println("7. StrengthInspector for Child AcheAway Pill");
            System.out.println("8. StrengthInspector for Adult Dreamly Pill");
            System.out.println("9. StrengthInspector for Child Dreamly Pill");
            System.out.println("0. Exit");
            c = scanner.nextInt();
            switch (c) 
            {
                //Orders 2 different adult pills
                case 1:
                    consistencyAdult();
                    break;
                //Orders 2 different child pills
                case 2:
                    consistencyChild();
                    break;
                //checks if there was a order with 1 adult pill and 2 child pills if its consist.
                case 3:
                    consistencyFail();
                    break;
                //Checks failure rate of AcheAway.
                case 4:
                    failureAcheaway();
                    break;
                //checks failure rate of Dreamly.
                case 5:
                    failureDreamly();
                    break;
                //checks the strength of a adult AcheAway pill.
                case 6:
                    strengthAdultAcheAway();
                    break;
                //Checks the strength of a child acheaway pill.
                case 7:
                    strengthChildAcheAway();
                    break;
                //Checks the Strength of a adult dreamly pill.
                case 8:
                    strengthAdultDreamly();
                    break;
                //Checks the strength of a child dreamly pill.
                case 9:
                    strengthChildDreamly();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    /**
     * Orders 2 adult pills to check if consistent.
     */
    public static void consistencyAdult() 
    {
        ConsistencyInspector consistencyInspector = new ConsistencyInspector();
        consistencyInspector.reset();
        consistencyInspector.inspect(
            new AdultAcheAway("Gelatin", "Saline", "Acetaminophen"));
        consistencyInspector.inspect(
            new AdultDreamly("Plasticizer", "Oil", "Zolpidem"));
        System.out.println(consistencyInspector.report());

    }
    /**
     * Orders 2 child pills to check if consistent.
     */
    public static void consistencyChild()
    {
        ConsistencyInspector consistencyInspector = new ConsistencyInspector();
        consistencyInspector.reset();
        consistencyInspector.inspect(
            new ChildAcheAway("Gelatin", "Saline", "Acetaminophen"));
        consistencyInspector.inspect(
            new ChildDreamly("Plasticizer", "Oil", "Zolpidem"));
        System.out.println(consistencyInspector.report());
    }

    /**
     * Orders 1 adult pill and 2 child pills to check if returns not consistent.
     */
    public static void consistencyFail()
    {
        ConsistencyInspector consistencyInspector = new ConsistencyInspector();
        consistencyInspector.reset();
        consistencyInspector.inspect(
            new ChildAcheAway("Gelatin", "Saline", "Acetaminophen"));
        consistencyInspector.inspect(
            new ChildDreamly("Plasticizer", "Oil", "Zolpidem"));
        consistencyInspector.inspect(
            new AdultAcheAway("Gelatin", "Saline", "Acetaminophen"));
        System.out.println(consistencyInspector.report());
    }
    /**
     * Checks failure rate of acheaway by ordering 1 null acheaway pill.
     */
    public static void failureAcheaway()
    {
        FailureInspector failureInspector = new FailureInspector();
        failureInspector.reset();
        failureInspector.inspect(
            new AdultAcheAway("Gelatin", "Saline", "Acetaminophen"));
        failureInspector.inspect(
            new ChildAcheAway("Gelatin", "Saline", "Acetaminophen"));
        failureInspector.inspect(
            new NullAcheAway());
        System.out.println(failureInspector.report());

    }


    /**
     * Checks failure rate of dreamly by ordering 1 null dreamly pill.
     */
    public static void failureDreamly()
    {
        FailureInspector failureInspector = new FailureInspector();
        failureInspector.inspect(
            new AdultDreamly("Plasticizer", "Oil", "Zolpidem"));
        failureInspector.inspect(
            new ChildDreamly("Plasticizer", "Oil", "Zolpidem"));
        failureInspector.inspect(
            new NullDreamly());
        System.out.println(failureInspector.report());
    }

    /**
     * Checks strength of Adult acheaway by ordering 1 acheaway adult pill.
     */
    public static void strengthAdultAcheAway()
    {
        StrengthInspector strengthInspector = new StrengthInspector();
        strengthInspector.reset();
        strengthInspector.inspect(
            new AdultAcheAway("Gelatin", "Saline", "Acetaminophen"));
        System.out.println(strengthInspector.report());
    }

    /**
     * Checks strength of Child acheaway by ordering 1 acheaway Child pill.
     */
    public static void strengthChildAcheAway()
    {
        StrengthInspector strengthInspector = new StrengthInspector();
        strengthInspector.reset();
        strengthInspector.inspect(
            new ChildAcheAway("Gelatin", "Saline", "Acetaminophen"));
        System.out.println(strengthInspector.report());

    }
    
    /**
     * Checks strength of adult dreamly by ordering 1 dreamly Child pill.
     */
    public static void strengthAdultDreamly()
    {        
        StrengthInspector strengthInspector = new StrengthInspector();
        strengthInspector.reset();
        strengthInspector.inspect(
            new AdultDreamly("Plasticizer", "Oil", "Zolpidem"));
        System.out.println(strengthInspector.report());

    }

    /**
     * Checks strength of Child dreamly by ordering 1 dreamly Child pill.
     */
    public static void strengthChildDreamly()
    {
        StrengthInspector strengthInspector = new StrengthInspector();
        strengthInspector.reset();
        strengthInspector.inspect(
            new ChildDreamly("Plasticizer", "Oil", "Zolpidem"));
        System.out.println(strengthInspector.report());
    }
    /**
     * This method runs the SoftGelPillStore client 
     * program by displaying a menu of options to the user and
     * prompting for user input. The user can either 
     * place an order, checkout, or logout. If the user chooses
     * to checkout, the ordered items are added to an 
     * ArrayList of orders. If the randomly generated number is 3,
     * the user is notified that they have won free drugs. 
     * After the user logs out, the method displays a list of
     * all orders made during the session.
     */
    public static void runClient() 
    {
        Scanner input = new Scanner(System.in);

        Random winner = new Random();
        SoftGelPillStore store = new SoftGelPillStore(input, System.out);
        ArrayList<GelCap[]> orders = new ArrayList<>();
        int winm = winner.nextInt(5) + 1;
        
        System.out.println("\nLogin");
        store.logIn();
        if (store.getAge() > ANCIENT)
        {
            System.out.println("\n(Damn, you're ancient!)\n");
        }
        if (store.getAge() < BABY)
        {
            System.out.println("\n(Damn, you're a wil baby! Are you sure you can read this?)\n");
        }
        boolean exit = true;
        String choice = "";
        boolean openOrder = false;
        while (exit) 
        {
            while (!validSelection(choice)) 
            {
                System.out.println("\nChoose from the following menu");
                System.out.println("1) Order");
                System.out.println("2) Checkout");
                System.out.println("3) Logout");
                choice = input.nextLine();
                if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3")) 
                {
                    System.out.println("Invalid input. Please enter 1, 2, or 3.");
                    choice = "";
                }
            }
            switch (Integer.parseInt(choice)) 
            {
                case 1:
                    store.order();
                    choice = "";

                    openOrder = true;
                    break;
                case 2: 
                    GelCap[] order = store.checkOut();
                    choice = "";

                    if (winm == 3)
                    {
                        System.out.println("********************************");
                        System.out.println("*Congrats!! You got FREE drugs!*");
                        System.out.println("********************************");

                    }
                    if (order != null) 
                    {
                        orders.add(order);
                    }

                    openOrder = false;
                    break;
                case 3:
                    exit = false;
                    store.logOut();
                    if (store.isLoggedIn())
                    {
                        exit = true;
                        choice = "";
                    }
                    break;
                default:
                    break;
            }
        }
        if (!openOrder)
        {
            int orderNum = 0;
            for (GelCap[] order : orders) 
            {
                System.out.println("\nHere is what you ordered:");
                orderNum = 0;
                for (GelCap[] or : orders) 
                {
                    System.out.printf("Order Number %d\n", ++orderNum);
                    for (GelCap g : or) 
                    {
                        System.out.printf("\t%s\n", g);
                    }
                    System.out.println();
                }
            }
        }
        input.close();
    }
}
