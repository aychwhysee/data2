package data2;

/**
 *
 * @author Harry
 * @param <D> A generic data type
 */
public interface Sequence<D extends Comparable> {

    /**
     *
     * @return The object of type D located where the sequence is currently looking at.
     */
    public D here();

    /**
     *
     * @return True if the sequence has not reached its end; false otherwise.
     */
    public boolean hasNext();

    /**
     *
     * @return A sequence containing objects of type D located after the current object of type D
     */
    public Sequence<D> next();

    /**
     *
     * @return A string containing all objects in the sequence.
     */
    public String toStringS();

}
