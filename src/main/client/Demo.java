/**
 * Title:           Demo
 * Files:           Demo.java
 * Semester:        Spring 2023
 * Course:          CS_3667
 * Professor:       Mx.Sapphire
 * 
 * @author:         Sashe Nikolov
 * 
 * Group Name:      SlayFam
 * @version:        2/27/2023
 */
package client;

import pills.AcheAway;
import pills.Dreamly;

public class Demo 
{
	/**
	 * This is the main method for the entire project. 
	 * With this method, we create an AcheAway object and
	 * Dreamly object. We are also calling the description
	 * method from the parent class for both objects to make 
	 * sure they work. 
	 * @param args
	 */
    public static void main(String[] args) 
    {
        AcheAway acheAway = new AcheAway(2.0, 5.0, "yellow");
        System.out.println(acheAway.description());
        Dreamly dreamly = new Dreamly(1.0, 7.0, "white");
        System.out.println(dreamly.description());
    }
}
