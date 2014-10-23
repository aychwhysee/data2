package data2;

public class NonMT_FiniteBag<D> implements FiniteBag {
    
    D root;
    FiniteBag left;
    FiniteBag right;
//    int count;
    
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
        
    }
    
    public boolean isEmptyHuh() {
        return false;
    }
    
    public boolean member(D elt) {
        
    }
    
    public FiniteBag add(D elt) {
        
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
        
    }
    
    public boolean subset(FiniteBag u) {
        
    }
    
}
