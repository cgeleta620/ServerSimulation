package PA5;

/**
 * Project Number: PA5
 * Date: 12/14/15, double late pass
 *
 * Purpose: The Event object is created using this class,
 *
 * Data In: type, time, customer
 *
 * Data Out: type, time, customer
 *
 * Algorithm: Implements compareTo so can be sorted
 *
 * Other non-standard class files needed for compilation: Comparable
 *
 * @author: cgeleta
 */
public class Event implements Comparable<Event> {

    public String type;
    public int time;
    public Customer customer;

    public Event(String type, int time, Customer customer) {

        this.type = type;
        this.time = time;
        this.customer = customer;

    }// end constructor
    /**
     * compareTo method:<BR>
     * Compares the Event objects for sorting
     * @author: cgeleta
     * @param that - the time of the other event
     * @return the subtraction of the two times
     */
    public int compareTo(Event that) {

        return this.time - that.time;

    }// end compareTo

}// end class
