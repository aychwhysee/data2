package data2;

/**
 *
 * @author Harry
 * @param <D>
 */
public interface FiniteBag<D extends Comparable> extends Sequenced<D> {

    /**
     *
     * @return
     */
    public int cardinality();

    /**
     *
     * @param elt
     * @return
     */
    public int getCount(D elt);

    /**
     *
     * @return
     */
    public boolean isEmptyHuh();

    /**
     *
     * @param elt
     * @return
     */
    public boolean member(D elt);

    /**
     *
     * @param elt
     * @return
     */
    public FiniteBag<D> add(D elt);

    /**
     *
     * @param elt
     * @param nCopies
     * @return
     */
    public FiniteBag<D> add(D elt, int nCopies); //Adds n occurences of elt

    /**
     *
     * @param elt
     * @return
     */
    public FiniteBag<D> remove(D elt);

    /**
     *
     * @param elt
     * @param nCopies
     * @return
     */
    public FiniteBag<D> remove(D elt, int nCopies); // Removes n occurences of elt

    /**
     *
     * @param elt
     * @return
     */
    public FiniteBag<D> removeAll(D elt); //Removes _all_ occurences of an element

    /**
     *
     * @param u
     * @return
     */
    public FiniteBag<D> union(FiniteBag<D> u);

    /**
     *
     * @param u
     * @return
     */
    public FiniteBag<D> inter(FiniteBag<D> u);

    /**
     *
     * @param u
     * @return
     */
    public FiniteBag<D> diff(FiniteBag<D> u);

    /**
     *
     * @param u
     * @return
     */
    public boolean equal(FiniteBag<D> u);

    /**
     *
     * @param u
     * @return
     */
    public boolean subset(FiniteBag<D> u);

    public Sequence<D> seq();

    /**
     *
     * @return
     */
    public int sumIt();

    /**
     *
     * @param as
     * @return
     */
    public int sumItS(Sequence<D> as);
    
    /**
     *
     * @return
     */
    public String stringIt();
    
    /**
     *
     * @param as
     * @return
     */
    public String stringItS(Sequence<D> as);
    
    /**
     *
     * @param elt
     * @param count
     * @return
     */
    public FiniteBag<D> RBInsert(D elt, int count);
    
    /**
     *
     * @param elt
     * @param count
     * @return
     */
    public FiniteBag<D> RBInsertInner(D elt, int count);
    // ^ this replaces the add(D elt, int nCopies) method????
    
    /**
     *
     * @return
     */
    public FiniteBag<D> blacken();
    
    /**
     *
     * @return
     */
    public boolean isRedHuh();

}
