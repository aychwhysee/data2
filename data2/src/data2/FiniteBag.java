package data2;

public interface FiniteBag<D> {
    
    public int cardinality();
    public boolean isEmptyHuh();
    public boolean member(D elt);
    public FiniteBag add(D elt);
    public FiniteBag remove(D elt);
    public FiniteBag removeAll(D elt); //Removes _all_ instances of an element
    public FiniteBag union(FiniteBag u);
    public FiniteBag inter(FiniteBag u);
    public FiniteBag diff(FiniteBag u);
    public boolean equal(FiniteBag u);
    public boolean subset(FiniteBag u);
    
}
