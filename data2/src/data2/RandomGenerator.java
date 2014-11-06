package data2;

/**
 *
 * @author Harry
 * @param <D>
 */
public interface RandomGenerator<D extends Comparable> {
    
    /**
     *
     * @return
     */
    public D giveMeAThing();
}
