package data2;

public class NonMT_FiniteBagT1<D extends Comparable> implements FiniteBag<D> {
    
    FiniteBag next;
    
    NonMT_FiniteBagT1(FiniteBag next) {
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
    
    public FiniteBag add(D elt) {
        // Boop
    }
    
    public FiniteBag add(D elt, int nCopies) {
        // Boop
    }
    
    public FiniteBag remove(D elt) {
        // Boop? *** why don't we need a self-balancing mechanism for remove?
    }
    
    public FiniteBag remove(D elt, int nCopies) {
        // Boop? Above
    }
    
    public FiniteBag removeAll(D elt) {
        // boop? above
    }
    
    public FiniteBag union(FiniteBag u) {
        return next.union(u);
    }
    
    public FiniteBag inter(FiniteBag u) {
        return next.inter(u);
    }
    
    public FiniteBag diff(FiniteBag u) {
        return next.diff(u);
    }
    
    public boolean equal(FiniteBag u) {
        return next.equal(u);
    }
    
    public boolean subset(FiniteBag u) {
        return next.subset(u);
    }
}
