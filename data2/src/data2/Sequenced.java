package data2;

/**
 *
 * @author Harry
 * @param <D>
 */
public interface Sequenced<D extends Comparable> {

    /**
     *
     * @return
     */
    public Sequence<D> seq();

}
