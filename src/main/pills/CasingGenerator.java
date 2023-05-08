package pills;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *    Project SoftGel Part 3
 * 
 * Title:	        CasingGenerator
 * Files:	        CasingGenerator.java
 * Semester:	    Spring 2023
 * Course:	        CS_3667
 * Professor:	    Mx. Sapphire
 * 
 * @author	        Sashe Nikolov
 * 
 * Group Name:	    SlayFam, Overseer
 * Sprint:	        6
 * @version	        4/13/2023
 */

interface CasingGenerator extends Remote 
{
    /**
     * generateCasing method to be overriden.
     *
     * @return RemoteException Remote object to be thrown.
     */
    public String generateCasing() throws RemoteException;
}
