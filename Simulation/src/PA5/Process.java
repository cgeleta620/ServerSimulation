package PA5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import Queue.*;

/**
 * Project Number: PA5
 * Date: 12/14/15 Double late pass used
 *
 * Purpose: The purpose of this class is to do the simulation of a customers being server at Starbucks
 *
 * Data In: The Customers from the file being read in
 *
 * Data Out: The average wait time for a customer
 *
 * Other non-standard class files needed for compilation: Customer, Server, Queue, PriorityQueue, Event
 *
 * @author: Christoher Geleta
 */
public class Process {

    /**
     * Data members, keep track of data, such as the total time, the clock, and how many customers
     */
    public double customerCount;
    public int clock;
    public int totalTime;

    /**
     * simulate method: Performs the simulation
     * @author: cgeleta
     * @param fileName - the file being read in
     */
    public void simulate(String fileName) {

        Scanner sc = null;
        PA5Queue q = new PA5Queue();// the Queue
        PA5PriorityQueue pq = new PA5PriorityQueue();// the PriorityQueue

        try {

            sc = new Scanner(new File(fileName));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }// end catch

        String firstLine = sc.nextLine();
        Scanner s = new Scanner(firstLine);// reads in first line

        int arrivalTime = s.nextInt();// the arrival time from file
        String name = s.next();// the name from file
        int complexity = s.nextInt();// the complexity from the file

        Server serverLi = new Server(true);// server is made and not busy
        Customer cust = new Customer(arrivalTime, name, complexity);

        String type = "arrival";
        Event event = new Event(type, arrivalTime, cust);// makes first event
        pq.add(event);// adds to PriorityQueue
        customerCount++;

        while (!pq.isEmpty()) {
            Event e = (Event) pq.remove();// gets the next Event
            this.clock = e.time;// sets clock
            System.out.println("TIME: "+clock);
            if (sc.hasNext()) {

                String nextLine = sc.nextLine();// gets the next line
                Scanner scan = new Scanner(nextLine);
                int t = scan.nextInt();// the time for the customer
                Customer nextCustomer = new Customer(t, scan.next(), scan.nextInt());// makes a customer
                Event nextEvent = new Event("arrival", t, nextCustomer);// makes an new Event
                System.out.println(nextEvent.customer.id + " is arriving ");
                pq.add(nextEvent);// adds to Priority Queue
                customerCount++;

            }// end if

            if (e.type.equalsIgnoreCase("arrival")) {// must be an arrival

                System.out.println(e.customer.id + " has arrived");

                if (serverLi.available) {
                    // do order
                    System.out.println("Li is serving " + e.customer.id +" "+clock);
                    totalTime+=(e.customer.getTime()-clock);// wait time
                    serverLi.available = false;// server is now busy
                    Event ec = new Event("depart", clock+(e.customer.complexity*2), e.customer);
                    System.out.println(e.customer.id + " is being served "+clock);
                    totalTime+=(clock-e.customer.getTime());
                    pq.add(ec);// adds to PriorityQueue

                }// end inner if

                else {
                    q.enqueue(e);// when the server is busy with a customer
                }// end inner else

            }// end if

            else {
                    if (!q.isEmpty()) {

                        Event leavingCustomer = (Event)q.dequeue();// removes waiting customer
                        Event ec = new Event("depart", clock+(leavingCustomer.customer.complexity*2), leavingCustomer.customer);
                        System.out.println(leavingCustomer.customer.id + " is being served "+clock);
                        totalTime+=(clock-leavingCustomer.customer.getTime());// sums up all wait time
                        pq.add(ec);// adds to priority Queue

                    }// end inner if

                    else {
                        serverLi.available = true;// sets the server free
                    }// end inner else

            } // end else

        }// end while

        doStats();// print the stats to the console

    }// end simulate

    /**
     * This method outputs the stats of the simulation to the console
     * @author: cgeleta
     */
    public void doStats() {

        double average = totalTime/customerCount;// calculates average
        System.out.println();// extra line
        System.out.println("Average: " + average);
        System.out.println("Total time: " + totalTime);
        System.out.println("Customer count: " + customerCount);

    }// end doStats

}// end Process
