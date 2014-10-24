package data2;

public class NonMT_FiniteBag<D extends Comparable> implements FiniteBag<D> {

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

    NonMT_FiniteBag(D root, int count) {
        this.root = root;
        this.count = count;
        this.left = new MT_FiniteBag();
        this.right = new MT_FiniteBag();
    }

    NonMT_FiniteBag(FiniteBag left, D root, FiniteBag right) {
        this.left = left;
        this.root = root;
        this.right = right;
        this.count = 1;
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
        if (elt.compareTo(this.root) == 0) {
            return true;
        } else if (elt.compareTo(this.root) < 0) {
            return left.member(elt);
        } else {
            return right.member(elt);
        }
    }

    public FiniteBag add(D elt) {
        if (elt.compareTo(this.root) == 0) {
            return new NonMT_FiniteBag(this.left, this.root, this.count + 1, this.right);
        } else if (elt.compareTo(this.root) < 0) {
            return new NonMT_FiniteBag(this.left.add(elt), this.root, this.count, this.right);
        } else {
            return new NonMT_FiniteBag(this.left, this.root, this.count, this.right.add(elt));
        }
        // Need to make it self-balancing now...?
    }

    public FiniteBag add(D elt, int nCopies) {
        if (elt.compareTo(this.root) == 0) {
            return new NonMT_FiniteBag(this.left, this.root, this.count + nCopies, this.right);
        } else if (elt.compareTo(this.root) < 0) {
            return new NonMT_FiniteBag(this.left.add(elt, nCopies), this.root, this.count, this.right);
        } else {
            return new NonMT_FiniteBag(this.left, this.root, this.count, this.right.add(elt, nCopies));
        }
    }

    public FiniteBag remove(D elt) {
        if (elt.compareTo(this.root) == 0) {
            if (this.count == 1) {
                // If completely removing an elt, return union of left and right
                return left.union(right);
                // If more than one of the elt exists, drop count by 1
            } else {
                return new NonMT_FiniteBag(this.left, this.root, this.count -1, this.right);
            }
        } else if (elt.compareTo(this.root) < 0) {
            return new NonMT_FiniteBag(this.left.remove(elt), this.root, this.count, this.right);
        } else {
            return new NonMT_FiniteBag(this.left, this.root, this.count, this.right.remove(elt));
        }
    }

    public FiniteBag remove(D elt, int nCopies) {
//        int max = Math.max(0, this.count-nCopies);
        if (elt.compareTo(this.root) == 0) {
            if (this.count <= nCopies) {
                return left.union(right);
            } else {
                return new NonMT_FiniteBag(this.left, this.root, this.count -nCopies, this.right);
            }
        } else if (elt.compareTo(this.root) < 0) {
            return new NonMT_FiniteBag(this.left.remove(elt, nCopies), this.root, this.count, this.right);
        } else {
            return new NonMT_FiniteBag(this.left, this.root, this.count, this.right.remove(elt, nCopies));
        }

    }

    public FiniteBag removeAll(D elt) {
        if (elt.compareTo(this.root) == 0) {
            return left.union(right);
        } else if (elt.compareTo(this.root) < 0) {
            return new NonMT_FiniteBag(this.left.removeAll(elt), this.root, this.count, this.right);
        } else {
            return new NonMT_FiniteBag(this.left, this.root, this.count, this.right.removeAll(elt));
        }
    }

    public FiniteBag union(FiniteBag u) {
        return left.union(right.union(u)).add(root, this.getCount(root));
    }

    public FiniteBag inter(FiniteBag u) {
        if(u.member(this.root)) {
            if (u.getCount(root) > this.getCount(root)) {
                return new NonMT_FiniteBag(this.left.inter(u), this.root, this.getCount(root),
                this.right.inter(u));
            } else {
                return new NonMT_FiniteBag(this.left.inter(u), this.root, u.getCount(root),
                this.right.inter(u));
            }
        } else {
            return this.left.inter(u).union(this.right.inter(u));
        }
    }

    public FiniteBag diff(FiniteBag u) {

    }

    public boolean equal(FiniteBag u) {
        return this.subset(u) && u.subset(this);
    }

    public boolean subset(FiniteBag u) {

    }

}
