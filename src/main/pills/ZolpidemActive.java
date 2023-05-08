package pills;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *   SoftGel Project Part 3
 * 
 * Title:           ZolpidemActive
 * Files:           ZolpidemActive.java
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
 * Concrete strategy for generating Zolpidem.
 * This is remotely accessible on Java RMI.
 */

public class ZolpidemActive extends UnicastRemoteObject implements ActiveGenerator
{
    /**
     * Creates an Zolpidem Active strategy object.
     * 
     * @param port is the port being listened to
     * @throws RemoteException is thrown when something goes wrong with the Java RMI
     */
    protected ZolpidemActive(int port) throws RemoteException
    {
        super(port);
    }

    /**
     * This is the method that creates the casing for the pill. 
     * 
     * It also has a print statement that notifies the user of the the current
     * status of the generation of the pill.
     * 
     * @return String which is the casing of the pill, in this case Zolpidem
     * @throws RemoteException is thrown when something goes wrong with the Java RMI
     */
    @Override
    // tells the method it is overriding a parent class 
    public String generateActive(double amount) throws RemoteException 
    {
        System.out.format("Opening secure storage area ... \n"
                + "Carefully extracting %.2fmg of zolpidem\n"
                + "Returning %.2fmg of zolpidem\n", amount, amount);
        return "zolpidem";
    }
}
