package data2;

/**
 *
 * @author Harry
 * @param <D> A generic data type
 */
public interface FiniteBag<D extends Comparable> extends Sequenced<D> {

    /**
     *
     * @return The number of elements in this (Finite Bag).
     */
    public int cardinality();

    /**
     *
     * @param elt an element of type D
     * @return The number of occurrences of elt in this.
     */
    public int getCount(D elt);

    /**
     *
     * @return True if this is empty; False if it is not.
     */
    public boolean isEmptyHuh();

    /**
     *
     * @param elt an element of type D
     * @return True if elt is in this; False if it is not. 
     */
    public boolean member(D elt);

    /**
     *
     * @param elt an element of type D
     * @return A finite bag containing one more occurrence of elt, and everything in this.
     */
    public FiniteBag<D> add(D elt);

    /**
     *
     * @param elt an element of type D
     * @param nCopies an int
     * @return A finite bag containing nCopies more occurrences of elt, and everything in this.
     */
    public FiniteBag<D> add(D elt, int nCopies); //Adds n occurences of elt

    /**
     *
     * @param elt an element of type D
     * @return A finite bag containing everything in this, except one occurrence of elt.
     */
    public FiniteBag<D> remove(D elt);

    /**
     *
     * @param elt an element of type D
     * @param nCopies an int
     * @return A finite bag containing everything in this, except nCopies fewer occurrences of elt.
     */
    public FiniteBag<D> remove(D elt, int nCopies); // Removes n occurences of elt

    /**
     *
     * @param elt an element of type D
     * @return A finite bag containing everything in this, except all occurrences of elt.
     */
    public FiniteBag<D> removeAll(D elt); //Removes _all_ occurences of an element

    /**
     *
     * @param u a FiniteBag containing elements of type D
     * @return A finite bag containing everything in this and u.
     */
    public FiniteBag<D> union(FiniteBag<D> u);

    /**
     *
     * @param u a FiniteBag containing elements of type D
     * @return A finite bag containing everything that is both in this and u.
     */
    public FiniteBag<D> inter(FiniteBag<D> u);

    /**
     *
     * @param u a FiniteBag containing elements of type D
     * @return A finite bag containing everything in u except those that are in this. 
     */
    public FiniteBag<D> diff(FiniteBag<D> u);

    /**
     *
     * @param u a FiniteBag containing elements of type D
     * @return True if this and u contain the same elements (and same occurrences); false otherwise
     */
    public boolean equal(FiniteBag<D> u);

    /**
     *
     * @param u a FiniteBag containing elements of type D
     * @return True if this is a subset of u.
     */
    public boolean subset(FiniteBag<D> u);
    
    /**
     * 
     * @return a Sequence containing type D 
     */
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
