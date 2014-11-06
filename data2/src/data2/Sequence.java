package data2;

/**
 *
 * @author Harry
 * @param <D>
 */
public interface Sequence<D extends Comparable> {

    /**
     *
     * @return
     */
    public D here();

    /**
     *
     * @return
     */
    public boolean hasNext();

    /**
     *
     * @return
     */
    public Sequence<D> next();

    /**
     *
     * @return
     */
    public String toStringS();

}
