package Queue;

/**
 * Created by cgeleta on 12/11/15.
 */
public interface iPriorityQueue<T> {

    void add(T newItem);

    T remove();

    T get();

    boolean isEmpty();

    int getSize();

    void clear();

}// end iPriorityQueue
