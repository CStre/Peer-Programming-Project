package pills;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *    Project SoftGel Part 3
 * 
 * Title:	        ActiveGenerator
 * Files:	        ActiveGenerator.java
 * Semester:	    Spring 2023
 * Course:	        CS_3667
 * Professor:	    Mx. Sapphire
 * 
 * @author	        Sashe Nikolov
 * 
 * Group Name	    SlayFam, Overseer
 * Sprint	        6
 * @version	        4/14/2023
 */

interface ActiveGenerator extends Remote 
{
    /**
     * generateActive method that throws the RemoteException.
     * 
     * @param amount Input amount for the generator.
     * @return RemoteException
     */ 	
    public String generateActive(double amount) throws RemoteException;
}

