package pills;

import java.util.HashMap;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;

/**
 *  SoftGel Project Part 3
 * 
 * Title:           GelCapRecipes
 * Files:           GelCapRecipes.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 * 
 * @author          Hannah Boulet,
 *                  Tayo Olofintuyi
 * 
 * Group Name:      SlayFam, Subteam 1
 * Sprint:          6
 * @version         4/14/2023
 */

public class GelCapRecipes
{
    public static final HashMap<String, CasingGenerator> CASINGS = getCasings();
    public static final HashMap<String, SolutionGenerator> SOLUTIONS = getSolutions();
    public static final HashMap<String, ActiveGenerator> ACTIVES = getActives();

    /**
    * Private static method called getCasings that retrieves 
    * the CasingGenerator objects remotely using RMI, 
    * then adds two keys deamly and acheaway to the map and 
    * returns the same map to be assigned to CASINGS.
    * @return HashMap
    */
    private static HashMap<String, CasingGenerator> getCasings()
    {
        HashMap<String, CasingGenerator> map1 = new HashMap<String, CasingGenerator>();
        try
        {
            CasingGenerator gelatinCasing 
                = (CasingGenerator) Naming.lookup("rmi://152.10.10.40/GelatinCasing");
            CasingGenerator plasticizerCasing 
                = (CasingGenerator) Naming.lookup("rmi://152.10.10.40/PlasticizerCasing");
            map1.put("dreamly", plasticizerCasing);
            map1.put("acheAway", gelatinCasing);
        }
        catch (RemoteException e)
        {
            return null;
        }
        catch (MalformedURLException e)
        {
            return null;
        }
        catch (NotBoundException e)
        {
            return null;
        }
            
        return map1;
    }

    /**
    * Private static method called getSolutions that retrieves
    * the SolutionGenerator objects remotely using RMI, 
    * then adds two keys deamly and acheaway to the map and 
    * returns the same map to be assigned to SOLUTIONS.
    * @return HashMap
    */
    private static HashMap<String, SolutionGenerator> getSolutions()
    {
        HashMap<String, SolutionGenerator> map2 
            = new HashMap<String, SolutionGenerator>();
        try
        {
            SolutionGenerator salineSolution 
                = (SolutionGenerator) Naming.lookup("rmi://152.10.10.40/SalineSolution");
            SolutionGenerator oilSolution 
                = (SolutionGenerator) Naming.lookup("rmi://152.10.10.40/OilSolution");
            map2.put("dreamly", oilSolution);
            map2.put("acheAway", salineSolution);
        }
        catch (RemoteException e)
        {
            return null;
        }
        catch (MalformedURLException e)
        {
            return null;
        }
        catch (NotBoundException e)
        {
            return null;
        }
        return map2;
    }

    /**
    * Private static method called getActives that retrieves 
    * the ActiveGenerator objects remotely using RMI, 
    * then adds two keys deamly and acheaway to the map and 
    * returns the same map to be assigned to ACTIVES.
    * @return HashMap
    */
    private static HashMap<String, ActiveGenerator> getActives()
    {
        HashMap<String, ActiveGenerator> map3 
            = new HashMap<String, ActiveGenerator>();
        try
        {    
            ActiveGenerator acetaminophenActive 
                = (ActiveGenerator) Naming.lookup("rmi://152.10.10.40/AcetaminophenActive");
            ActiveGenerator zolpidemActive 
                = (ActiveGenerator) Naming.lookup("rmi://152.10.10.40/ZolpidemActive");
            map3.put("dreamly", zolpidemActive);
            map3.put("acheAway", acetaminophenActive);
        }
        catch (RemoteException e)
        {
            return null;
        }
        catch (MalformedURLException e)
        {
            return null;
        }
        catch (NotBoundException e)
        {
            return null;
        }
        return map3;
    }
}
