package data2;

/**
 *
 * @author Harry
 * @param <D> A generic data type
 */
public interface RandomGenerator<D extends Comparable> {
    
    /**
     *
     * @return A new random object of type D.
     */
    public D giveMeAThing();
}
