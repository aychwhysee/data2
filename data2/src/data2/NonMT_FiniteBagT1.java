package data2;

public class NonMT_FiniteBagT1<D extends Comparable> implements FiniteBag<D> {
    
    FiniteBag<D> next;
    
    NonMT_FiniteBagT1(FiniteBag<D> next) {
        this.next = next;
    }
    
    public int cardinality() {
        return next.cardinality();
    }
    
    public int getCount(D elt) {
        return next.getCount(elt);
    }
    
    public boolean isEmptyHuh() {
        return next.isEmptyHuh();
    }
    
    public boolean member(D elt) {
        return next.member(elt);
    }
    
    public FiniteBag<D> add(D elt) {
        // Boop -- replacing add and the add below with smartAdd stuff?
        // Does the same apply to all the other FiniteBag classes? 
    }
    
    public FiniteBag<D> add(D elt, int nCopies) {
        // Boop
    }
    
    public FiniteBag<D> remove(D elt) {
        return next.remove(elt, 1);
    }
    
    public FiniteBag<D> remove(D elt, int nCopies) {
        return next.remove(elt, nCopies);
    }
    
    public FiniteBag<D> removeAll(D elt) {
        return next.removeAll(elt);
    }
    
    public FiniteBag<D> union(FiniteBag<D> u) {
        return next.union(u);
    }
    
    public FiniteBag<D> inter(FiniteBag<D> u) {
        return next.inter(u);
    }
    
    public FiniteBag<D> diff(FiniteBag<D> u) {
        return next.diff(u);
    }
    
    public boolean equal(FiniteBag<D> u) {
        return next.equal(u);
    }
    
    public boolean subset(FiniteBag<D> u) {
        return next.subset(u);
    }
}
