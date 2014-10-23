package data2;

public class NonMT_FiniteBag<D> implements FiniteBag {
    
    D root;
    FiniteBag left;
    FiniteBag right;
    int count;
    
    NonMT_FiniteBag(D root) {
        this.root = root;
        this.count = 1;
        this.left = new MT_FiniteBag();
        this.right = new MT_FiniteBag();
    }
    
    NonMT_FiniteBag(FiniteBag left, D root, FiniteBag right, int count) {
        this.left = left;
        this.root = root;
        this.right = right;
        this.count = count;
    }
    
}
