package data2;

/**
 *
 * @author Harry
 * @param <D> A generic data type
 */
public interface Sequence<D extends Comparable> {

    /**
     * Example: [a, b, c].here = a
     * @return The object of type D located where the sequence is currently looking at.
     */
    public D here();

    /**
     * Example: [a, b, c].hasNext() = true
     * @return True if the sequence has not reached its end; false otherwise.
     */
    public boolean hasNext();

    /**
     * [a, b, c].next() = [b, c]
     * @return A sequence containing objects of type D located after the current object of type D
     */
    public Sequence<D> next();

    /**
     * [a, b, c].toStringS() = "A B C"
     * @return A string containing all objects in the sequence.
     */
    public String toStringS();

}
