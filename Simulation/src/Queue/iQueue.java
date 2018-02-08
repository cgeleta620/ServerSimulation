package Queue;

/**
 * Created by cgeleta on 12/11/15.
 */
public interface iQueue<T> {

    void enqueue(T newEntry);

    T dequeue();

    T get();

    boolean isEmpty();

    void clear();

}// end iQueue
