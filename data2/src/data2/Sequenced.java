package data2;

/**
 *
 * @author Harry
 * @param <D> A generic data type
 */
public interface Sequenced<D extends Comparable> {

    /**
     * Example: {a, b, c}.seq() = [a, b, c]
     * @return A sequence containing the objects of type D in this.
     */
    public Sequence<D> seq();

}
