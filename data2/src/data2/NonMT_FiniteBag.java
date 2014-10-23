package data2;

public class NonMT_FiniteBag<D> implements FiniteBag {
    
    D root;
    FiniteBag left;
    FiniteBag right;
    int count;
    
    NonMT_FiniteBag(D root) {
        this.root = root;
//        this.count = 1;
        this.left = new MT_FiniteBag();
        this.right = new MT_FiniteBag();
    }
    
    NonMT_FiniteBag(FiniteBag left, D root, FiniteBag right) {
        this.left = left;
        this.root = root;
        this.right = right;
    }
    
    public int cardinality() {
        // Can't just do left + right + 1 now, since an elt could be repeated
        // and can have a count of more than just 1.
        // So we need a "count" variable
        // Does this also mean we need a method to return how many times
        // an elt of type D is in the FiniteBag?
        
    }
    
    public boolean isEmptyHuh() {
        // NonMT bag is NonMT. Return false.
        return false;
    }
    
    public boolean member(D elt) {
        // Can work similarly to FiniteSets right? Since it's only checking
        // if an elt of type D is in the bag, and not how many of it. 
        // Also, why/how would we get the intersection, subset etc. of
        // multisets in the first place? With FiniteSets, we used
        // member as a big player in getting those, but here...
        // We need to account for # of times an elt appears
        
    }
    
    public FiniteBag add(D elt) {
        // find a place to add elt into. If elt is = a root, just
        // add 1 to the count of the elt and return the tree with the new count
        // else keep checking left and right...uh...and balance yourself, tree!
        
    }
    
    public FiniteBag remove(D elt) {
        
    }
    
    public FiniteBag removeAll(D elt) {
        
    }
    
    public FiniteBag union(FiniteBag u) {
        
    }
    
    public FiniteBag inter(FiniteBag u){
        
    }
    
    public FiniteBag diff(FiniteBag u) {
        
    }
    
    public boolean equal(FiniteBag u) {
        return this.subset(u) && u.subset(this);
    }
    
    public boolean subset(FiniteBag u) {
        
    }
    
}
