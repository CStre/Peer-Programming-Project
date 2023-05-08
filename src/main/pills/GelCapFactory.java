package pills;

import java.rmi.RemoteException;

/**
 *    Project SoftGel Part 3
 *
 * Title:           GelCapFactory
 * Files:           GelCapFactory.java
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
 * This class is important in producing the Dreamly and AcheAway pill. This is also the class
 * that contains the qualityCheck() method to make sure that there is no problems during
 * production.
 */

public abstract class GelCapFactory
{
    /**
     * This method is used to be many important things. The Dreamly Pill is produced here
     * as well as tested here to make sure it is good quality. This method also is handled
     * to notify the user if the remote is unavailable for some reason. 
     * 
     * There is also status updates printed throughout the entire production process.
     * 
     * @return Dreamly pill
     * @throws RemoteException if the generators are unable to connect to the remote
     */
    public final Dreamly produceDreamly() throws RemoteException
    {
        System.out.print("Creating a Dreamly pill ... \n");
        // prints this to notify user the produceDreamly() method was called	
        try 
        {
            Dreamly d = constructDreamly(GelCapRecipes.CASINGS.get("dreamly").generateCasing(), 
                GelCapRecipes.SOLUTIONS.get("dreamly").generateSolution(), 
                GelCapRecipes.ACTIVES.get("dreamly").generateActive(getDreamlyStrength()));
            // attempts to construct an Dreamly pill

            if (qualityCheck())
            {
                System.out.print("Returning a good Dreamly GelCap Pill\n");
                // prints this if quality check is passed
                return d;
            }
            else
            {
                System.out.print("Error during Dreamly production. Returning null.\n");
                // prints this if quality check is failed
                return new NullDreamly();
            }
        }
        catch (RemoteException e)
        {
            throw new RemoteException("Unable to connect to remote service ... \n");
            // if the remote service encountered some sort of error
            // not returning anything ensures the qualityCheck() wont count this as a bad pill
        }
    }

    /**
     * This method is used to be many important things. The AcheAway Pill is produced here
     * as well as tested here to make sure it is good quality. This method also is handled
     * to notify the user if the remote is unavailable for some reason. 
     * 
     * There is also status updates printed throughout the entire production process.
     * 
     * @return AcheAway pill
     * @throws RemoteException if the generators are unable to connect to the remote
     */
    public final AcheAway produceAcheAway() throws RemoteException
    {
        System.out.print("Creating an AcheAway pill ... \n");
        // prints this to notify user the produceAcheAway() method was called	
        try
        {
            AcheAway a = constructAcheAway(GelCapRecipes.CASINGS.get("acheAway").generateCasing(),
                GelCapRecipes.SOLUTIONS.get("acheAway").generateSolution(),
                GelCapRecipes.ACTIVES.get("acheAway").generateActive(getAcheAwayStrength()));
            // attempts to construct an AcheAway pill

            if (qualityCheck())
            {
                System.out.print("Returning a good AcheAway GelCap Pill\n");
                // prints this if quality check is passed
                return a;
            }
            else
            {
                System.out.print("Error during AcheAway production. Returning null.\n");
                // prints this if quality check is failed
                return new NullAcheAway();
            }
        }
        catch (RemoteException e)
        {
            throw new RemoteException("Unable to connect to remote service ... \n");
            // if the remote service encountered some sort of error
            // not returning anything ensures the qualityCheck() wont count this as a bad pill
        }
    }

    // protected abstract variables initialized to perform some task
    protected abstract Dreamly constructDreamly(String casing, String solution, String active);
    protected abstract AcheAway constructAcheAway(String casing, String solution, String active);
    protected abstract double getDreamlyStrength();
    protected abstract double getAcheAwayStrength();

    /**
     * This method is the qualityCheck() method that determines whether or not the pill is okay
     * for the consumer. It generates a random number from 1 - 100 and if the number generated
     * is less than 91; (1 - 90), than the pill passes. 
     * 
     * This guarantees an approximate passing rate of 90%. If it passes it returns true and if 
     * it fails it returns false. 
     * 
     * @return boolean true or false
     */
    private final boolean qualityCheck()
    {
        System.out.print("Performing quality check ... \n");
        double r = Math.random() * 100;
        if (r < 91)
        {
            System.out.print("quality check passed\n");
            //prints this if the pill passes the quality check
            return true;
        }
        else 
        {
            System.out.print("quality check failed\n");
            // prints this if the pill fails the quality check
            return false;
        }
    }
}

