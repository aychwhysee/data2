package data2;

public class MT_FiniteBag<D extends Comparable> implements FiniteBag<D> {
    
    MT_FiniteBag() {}
    
    public int cardinality() {
        // MT_FiniteBag is always MT, return 0
        return 0;
    }
    
    public int getCount(D elt) {
        return 0;
    }
    
    public boolean isEmptyHuh() {
        // MT_FiniteBag is always MT, return true
        return true;
    }
    // Wants "Object" instead of "D". Why? Also for the other ones that
    // take in data type <D>.
    public boolean member(D elt) {
        // MT_FiniteBag is always MT, no members, return false
        return false;
    }
    
    public FiniteBag add(D elt) {
        // Since this is always empty, we just need to make a new NonMT bag
        // with elt as the only element in the bag
        return new NonMT_FiniteBag(elt);
    }
    
    public FiniteBag remove(D elt) {
        // Removing from an empty bag should just return the original empty bag
        // But since we're going for a _pure_ implementation, return a fresh
        // empty right?
        return new MT_FiniteBag();
    }
    
    public FiniteBag removeAll(D elt) {
        // Same reasoning as above
        return new MT_FiniteBag();
    }
    
    public FiniteBag remove(D elt, int nCopies) {
        return new MT_FiniteBag();
    }
    
    public FiniteBag union(FiniteBag u) {
        // Since this is MT, just return u
        return u;
    }
    
    public FiniteBag inter(FiniteBag u) {
        // Intersection of MT and anything is just MT
        return new MT_FiniteBag();
    }
    
    public FiniteBag diff(FiniteBag u) {
        // Diff between bag U and MT this is U
        return u;
    }
    
    public boolean equal(FiniteBag u) {
        // if u is empty, this it is equal to this(MT)
        return u.isEmptyHuh();
    }
    
    public boolean subset(FiniteBag u) {
        // MT bag is always a subset of another bag (right?)
        return true;
    }
    
}
