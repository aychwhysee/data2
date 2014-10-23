package data2;

public interface FiniteBag<D extends Comparable> {

    public int cardinality();

    public int getCount(D elt);

    public boolean isEmptyHuh();

    public boolean member(D elt);

    public FiniteBag add(D elt);

    public FiniteBag add(D elt, int nCopies); //Adds n occurences of elt

    public FiniteBag remove(D elt);

    public FiniteBag removeAll(D elt); //Removes _all_ occurences of an element

    public FiniteBag remove(D elt, int nCopies); // Removes n occurences of elt

    public FiniteBag union(FiniteBag u);

    public FiniteBag inter(FiniteBag u);

    public FiniteBag diff(FiniteBag u);

    public boolean equal(FiniteBag u);

    public boolean subset(FiniteBag u);

}
