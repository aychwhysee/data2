package data2;

public interface FiniteBag<D extends Comparable> extends Sequenced<D>{

    public int cardinality();

    public int getCount(D elt);

    public boolean isEmptyHuh();

    public boolean member(D elt);

    public FiniteBag<D> add(D elt);

    public FiniteBag<D> add(D elt, int nCopies); //Adds n occurences of elt

    public FiniteBag<D> remove(D elt);

    public FiniteBag<D> remove(D elt, int nCopies); // Removes n occurences of elt

    public FiniteBag<D> removeAll(D elt); //Removes _all_ occurences of an element

    public FiniteBag<D> union(FiniteBag<D> u);

    public FiniteBag<D> inter(FiniteBag<D> u);

    public FiniteBag<D> diff(FiniteBag<D> u);

    public boolean equal(FiniteBag<D> u);

    public boolean subset(FiniteBag<D> u);
    
    public Sequence<D> seq();

}
