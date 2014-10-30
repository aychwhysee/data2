package data2;

public class FakeBagL<D extends Comparable> {
    
    D root;
    int count;
    
    FakeBagL(D root, int count) {
        this.root = root;
        this.count = count;
    }
    
}
