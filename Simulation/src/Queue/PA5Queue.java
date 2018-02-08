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
 * Algorithm: FIFO
 *
 * Other non-standard class files needed for compilation: Node class
 *
 * @author: Christoher Geleta
 */
public class PA5Queue<T> implements iQueue<T> {

    public Node head;
    public Node tail;
    public int size;

    /**
     * Default constructor
     */
    public PA5Queue() {

        head = null;
        tail = null;

    }// end PA5Queue

    /**
     * Other constructor
     * @param head
     * @param tail
     */
    public PA5Queue(Node head, Node tail) {

        this.head = head;
        this.tail = tail;

    }// end other constructor

    /**
     *  Adds a newItem to the Queue
     * @param newEntry - the Generic data being added to the Queue
     */
    @Override
    public void enqueue(T newEntry) {

        Node newNode = new Node(newEntry, null);

        if (isEmpty()) {

            head = newNode;
        } else {
            tail.setNextNode(newNode);
        }
        tail = newNode;

        this.size++;

    }// end enqueue

    /**
     * Removes the next generic object
     * @return T - generic data
     */
    @Override
    public T dequeue() {

        T front = get();
        head.setData(null);
        head = head.getNextNode();

        if (head == null)
            tail = null;

        this.size--;
        return front;
    }// end remove

    /**
     *  Gets the next generic object
     * @return T - gets the next generic object
     */
    @Override
    public T get() {

        if (isEmpty()) {
            throw new NullPointerException();
        } else {
            T ret = (T) head.getData();
            return ret;
        }
    }// end getFront

    /**
     *  Does the Queue contain anything?
     * @return boolean - if the Queue is empty or not
     */
    @Override
    public boolean isEmpty() {

        return (head == null) && (tail == null);

    }// end isEmpty

    /**
     * Clears the Queue
     */
    @Override
    public void clear() {

        head = null;
        tail = null;
        this.size = 0;

    }// end clear

    /**
     * Private Node class, used to hold data
     * @param <T>
     */
    private class Node<T> {

        private T data;
        private Node next;

        private Node(T data, Node next) {

            this.data = data;
            this.next = next;

        }

        public T getData() {
            return this.data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNextNode() {
            return this.next;
        }

        public void setNextNode(Node next) {
            this.next = next;
        }

    }// end private Node class

}// end PA5Queue
