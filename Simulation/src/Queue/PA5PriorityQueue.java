package Queue;

/**
 * Project Number: PA5
 * Date: 12/14/15 Double late pass used
 *
 * Purpose: The purpose of this class is to save Generic data in a Queue
 *
 * Data In: Events or any Generic object
 *
 * Data Out: Events or any Generic object
 *
 * Algorithm: Highest priority
 *
 * Other non-standard class files needed for compilation: Node class
 *
 * @author: Christoher Geleta
 */
public class PA5PriorityQueue<T extends Comparable<? super T>> implements iPriorityQueue<T> {

    public Node head;
    public Node tail;
    public int size;

    /**
     * Default constructor
     */
    public PA5PriorityQueue() {

        this.head = null;
        this.tail = null;
    }// end PA5Queue

    /**
     * Other constructor
     * @param head
     * @param tail
     */
    public PA5PriorityQueue(Node head, Node tail) {

        this.head = head;
        this.tail = tail;

    }// end

    /**
     * Adds the next item then compares them
     * @param newItem - next Comparable item
     */
    public void add(Comparable newItem) {

        Node newNode = new Node(newItem);

        if (head == null) {
            head = newNode;
            return;
        }// end if

        else if (newItem.compareTo(head.data) < 0) {
            newNode.next = head;
            head = newNode;
        }// end else if

        else {
            Node after = head.next;
            Node before = head;
            while (after != null) {
                if (newItem.compareTo(after.data) < 0)
                    break;
                before = after;
                after = after.next;
            }// end while

            newNode.next = before.next;
            before.next = newNode;

        }// end else

    }// end add
    /**
     * Removes the next generic object
     * @return T - generic data
     */
    public T remove() {

        T front = get();
        head.setData(null);
        head = head.getNextNode();

        if(head == null)
            tail = null;

        this.size--;
        return front;
    }// end remove
    /**
     *  Gets the next generic object
     * @return T - gets the next generic object
     */
    public T get() {

        if (isEmpty()) {
            throw new NullPointerException();
        }
        else {

            T ret = (T) head.getData();
            return ret;
        }
    }// end getFront
    /**
     *  Does the PriorityQueue contain anything?
     * @return boolean - if the Queue is empty or not
     */
    public boolean isEmpty() {

        return (head == null) && (tail == null);

    }// end isEmpty
    /**
     * Clears the Queue
     */
    public void clear() {

        head = null;
        tail = null;
        this.size = 0;

    }// end clear

    /**
     * Get the size
     * @return int - the size of the Priority Queue
     */
    public int getSize() {
        return this.size;
    }

    private class Node<T> {

        private T data;
        private Node next;

        private Node(T data, Node next) {

            this.data = data;
            this.next = next;
        }

        private Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNextNode() {
            return next;
        }

        public void setNextNode(Node next) {
            this.next = next;
        }

    }// end private Node class

}// end PA5PriorityQueue
