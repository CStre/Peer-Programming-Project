package pills;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 *  SoftGel Project Part 3
 * 
 * Title:           InspectorTest
 * Files:           InspectorTest.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx. Sapphire
 * 
 * @author          Ella Fulton,
 *                  Collin Streitman,
 *                  Tayo Olofintuyi
 * 
 * Group Name:      SlayFam, Subteam 1 & 2
 * Sprint:          7
 * @version         4/24/2023
 */

public class InspectorTest
{
    private static final String STRENGTH = "The strength of Dreamly pills is 6.45 "
        + "and the strength of AcheAway pills is 1240.0";
    private static final String FAILURE = "The failure rate is 33.33333333333333%";
    private static final String CONSISTENCY = "The pills are not consistent";
    private static final String STRENGTH_RESET = "The strength of Dreamly pills is 0.0 "
        + "and the strength of AcheAway pills is 0.0";
    private static final String FAILURE_RESET = "The failure rate is 0.0%"; 
    private static final String CONSISTENCY_RESET = "The pills are consistent ";  
    

    private ArrayList<GelCap> pills;
    private GelCapFactory factory;
    private Inspector insp;
    
    @BeforeEach
    public void setUp()
    {
        pills = new ArrayList<GelCap>();
        AcheAway aNull = new NullAcheAway();
        AcheAway aChild = new ChildAcheAway("Gelatin", "Saline", "Acetaminophen");
        AcheAway aAdult = new AdultAcheAway("Gelatin", "Saline", "Acetaminophen");
        Dreamly dNull = new NullDreamly();
        Dreamly dChild = new ChildDreamly("Plasticizer", "Oil", "Zolpidem");
        Dreamly dAdult = new AdultDreamly("Plasticizer", "Oil", "Zolpidem");
        // Need to actually generate an array list of gelcap pills
        pills.add(aNull);
        pills.add(aChild);
        pills.add(aAdult);
        pills.add(dNull);
        pills.add(dChild);
        pills.add(dAdult);
    }

    @Test
    public void consistencyTest()
    {
        insp = new ConsistencyInspector();
        // Need a for loop that runs through the gelcap array, and calls the accept method with insp
        for (GelCap g : pills)
        {
            g.accept(insp);
        }
        assertEquals(CONSISTENCY, insp.report());
    }

    @Test
    public void failureReportTest()
    {
        insp = new FailureInspector();
        // Need a for loop that runs through the gelcap array, and calls the accept method with insp
        for (GelCap g : pills)
        {
            g.accept(insp);
        }
        assertEquals(FAILURE, insp.report());
    }

    @Test
    public void failureResetTest()
    {
        insp = new FailureInspector();
        insp.reset();
        // after calling reset(), the report() method should return the FAILURE_RESET string

        
        assertEquals(FAILURE_RESET, insp.report());
    }

    @Test
    public void strengthReportTest()
    {
        insp = new StrengthInspector();
        //need a for loop that runs through the gelcap array, and calls the accept method with insp
        for (GelCap g : pills)
        {
            g.accept(insp);
        }
        assertEquals(STRENGTH, insp.report());
    }

    @Test
    public void strengthResetTest()
    {
        insp = new StrengthInspector();
        insp.reset();
        // after calling reset(), the report() method should return the STRENGTH_RESET string
        
        assertEquals(STRENGTH_RESET, insp.report());
    }

    @Test
    public void consistencyResetTest()
    {
        insp = new ConsistencyInspector();
        insp.reset();
        // after calling reset(), the report() method should return the STRENGTH_RESET string
        
        assertEquals(CONSISTENCY_RESET, insp.report());
    }
}

