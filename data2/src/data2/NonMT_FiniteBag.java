package data2;

public class NonMT_FiniteBag<D extends Comparable> implements FiniteBag<D> {

    D root;
    FiniteBag left;
    FiniteBag right;
    int count;

    NonMT_FiniteBag(D root, int count) {
        this.root = root;
        this.count = count;
        this.left = new MT_FiniteBag();
        this.right = new MT_FiniteBag();
    }

    NonMT_FiniteBag(FiniteBag left, D root, int count, FiniteBag right) {
        this.left = left;
        this.root = root;
        this.count = count;
        this.right = right;
    }

    public int cardinality() {
        return left.cardinality() + right.cardinality() + count;
    }

    public int getCount(D elt) {
        if (elt.compareTo(this.root) == 0) {
            return this.count;
        } else if (elt.compareTo(this.root) < 0) {
            return left.getCount(elt);
        } else {
            return right.getCount(elt);
        }
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
        if (elt.compareTo(this.root) == 0) {
            return true;
        } else if (elt.compareTo(this.root) < 0) {
            return left.member(elt);
        } else {
            return right.member(elt);
        }
    }

    public FiniteBag add(D elt) {
        // find a place to add elt into. If elt is = a root, just
        // add 1 to the count of the elt and return the tree with the new count
        // else keep checking left and right...uh...and balance yourself, tree!

    }

    public FiniteBag add(D elt, int nCopies) {

    }

    public FiniteBag remove(D elt) {

    }

    public FiniteBag removeAll(D elt) {

    }

    public FiniteBag remove(D elt, int nCopies) {

    }

    public FiniteBag union(FiniteBag u) {
        return left.union(right.union(u)).add(root);
    }

    public FiniteBag inter(FiniteBag u) {

    }

    public FiniteBag diff(FiniteBag u) {

    }

    public boolean equal(FiniteBag u) {
        return this.subset(u) && u.subset(this);
    }

    public boolean subset(FiniteBag u) {

    }

}
