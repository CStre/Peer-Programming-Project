package pills;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *    Project SoftGel Part 3
 * 
 * Title:	    SolutionGenerator
 * Files:	    SolutionGenerator.java
 * Semester:	Spring 2023
 * Course:	    CS_3667
 * Professor:	Mx. Sapphire
 * 
 * @author	    Sashe Nikolov
 * 
 * Group Name:	SlayFam, Overseer
 * Sprint:	    6
 * @version	    4/13/2023
 */

interface SolutionGenerator extends Remote 
{

    /**
     * generateSolution method using the Remote object.
     * @return throws RemoteException.
     */ 
    public String generateSolution() throws RemoteException;
}


