package pills;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *   SoftGel Project Part 3
 * 
 * Title:           AcetaminophenActive
 * Files:           AcetaminophenActive.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 * 
 * @author          Collin Streitman
 * 
 * Group Name:      SlayFam, Subteam 2
 * Sprint:          6
 * @version         4/14/2023
 * 
 * Concrete strategy for generating Acetaminophen.
 * This is remotely accessible on Java RMI.
 */

public class AcetaminophenActive extends UnicastRemoteObject implements ActiveGenerator
{
    /**
     * Creates an Acetaminophen Active strategy object.
     * 
     * @param port is the port being listened to
     * @throws RemoteException is thrown when something goes wrong with the Java RMI
     */
    protected AcetaminophenActive(int port) throws RemoteException
    {
        super(port);
    }

    /**
     * This is the method that creates the casing for the pill. 
     * 
     * It also has a print statement that notifies the user of the the current
     * status of the generation of the pill.
     * 
     * @return String which is the casing of the pill, in this case Acetaminophen
     * @throws RemoteException is thrown when something goes wrong with the Java RMI
     */
    @Override
    // tells the method it is overriding a parent class 
    public String generateActive(double amount) throws RemoteException
    {
        System.out.printf("Acetylating para-aminophenol with acetic anhydride\n"
                + "Carefully extracting %.2fmg of acetaminophen\n"
                + "Returning %.2fmg of acetaminophen\n", amount, amount);
        return "acetaminophen";
    }
}

