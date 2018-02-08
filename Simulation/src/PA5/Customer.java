package PA5;

/**
 * Project Number: PA5
 * Date: 12/14/15, double late pass
 *
 * Purpose: The Customer class used for the Customer object
 *
 * Data In: time, id, complexity
 *
 * @author: cgeleta
 */
public class Customer {

    public int time;
    public String id;
    public int complexity;

    public Customer(int time, String id, int complexity) {

        this.id = id;
        this.time = time;
        this.complexity = complexity;

    }// end

    public int getTime() {
        return time;
    }

}// end Customer
