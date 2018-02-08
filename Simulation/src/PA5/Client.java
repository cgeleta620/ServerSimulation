package PA5;

import java.util.Scanner;

/**
 * Project Number: PA5
 * Date: 12/14/15, Double late pass
 *
 * Purpose: This is the client class that holds the main method
 *
 * Data In: name of file
 *
 * Data Out: simulation stats
 *
 * Other non-standard class files needed for compilation: Process
 *
 * @author: cgeleta
 */
public class Client {

    /**
     * main method
     * @author: cgeleta
     * @param args - an array
     */
    public static void main(String[] args) {
        menu();

    }// end main
    /**
     * menu method:<BR>
     * displays to the screen a prompt, then does the simulation
     * @author: cgeleta
     */
    public static void menu() {

        Scanner sc = new Scanner(System.in);
        Process p = new Process();
        announce();
        System.out.println("Enter file name: ");
        String fileName = sc.next();
        p.simulate(fileName);

    }// end menu
    /**
     * announce method:<BR>
     * displays to the screen the purpose of the program<BR>
     * @author: cgeleta
     */
    public static void announce() {

        System.out.println("This program simulates a line at Starbucks and computes" +
                " the average wait time of each customer.");

    }// end announce

}// end class
