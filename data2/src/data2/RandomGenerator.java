package data2;

/**
 *
 * @author Harry
 * @param <D>
 */
public interface RandomGenerator<D extends Comparable> {
    
    /**
     *
     * @return A new random object of type D.
     */
    public D giveMeAThing();
}
