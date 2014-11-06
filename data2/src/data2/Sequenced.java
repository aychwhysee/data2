package data2;

/**
 *
 * @author Harry
 * @param <D> A generic data type
 */
public interface Sequenced<D extends Comparable> {

    /**
     *
     * @return A sequence containing the objects of type D in this.
     */
    public Sequence<D> seq();

}
