package data2;

public class NonMT_FiniteBag<D extends Comparable> implements FiniteBag<D> {

    D root;
    FiniteBag<D> left;
    FiniteBag<D> right;
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

    NonMT_FiniteBag(FiniteBag<D> left, D root, FiniteBag<D> right) {
        this.left = left;
        this.root = root;
        this.right = right;
        this.count = 1;
    }

    NonMT_FiniteBag(FiniteBag<D> left, D root, int count, FiniteBag<D> right) {
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
        //return false;
        // ^ the above is no longer valid
        if (this.getCount(root) == 0) {
            if (!left.isEmptyHuh()) {
                return right.isEmptyHuh();
            } else {
                return left.isEmptyHuh();
            }
        } else {
            return false;
        }
    }

    public boolean member(D elt) {
        if (elt.compareTo(this.root) == 0) {
            return this.count > 0;
        } else if (elt.compareTo(this.root) < 0) {
            return left.member(elt);
        } else {
            return right.member(elt);
        }
    }

    public FiniteBag<D> add(D elt) {
//        if (elt.compareTo(this.root) == 0) {
//            return new NonMT_FiniteBag(this.left, this.root, this.count + 1, this.right);
//        } else if (elt.compareTo(this.root) < 0) {
//            return new NonMT_FiniteBag(this.left.add(elt), this.root, this.count, this.right);
//        } else {
//            return new NonMT_FiniteBag(this.left, this.root, this.count, this.right.add(elt));
//        }
        return this.add(elt, 1);
        // Need to make it self-balancing now...?
    }

    public FiniteBag<D> add(D elt, int nCopies) {
        if (elt.compareTo(this.root) == 0) {
            return new NonMT_FiniteBag(this.left, this.root, this.count + nCopies, this.right);
        } else if (elt.compareTo(this.root) < 0) {
            return new NonMT_FiniteBag(this.left.add(elt, nCopies), this.root, this.count, this.right);
        } else {
            return new NonMT_FiniteBag(this.left, this.root, this.count, this.right.add(elt, nCopies));
        }
    }

    public FiniteBag<D> remove(D elt) {
//        if (elt.compareTo(this.root) == 0) {
////            if (this.count == 1) {
////                // If completely removing an elt, return union of left and right
////                return left.union(right);
////                // If more than one of the elt exists, drop count by 1
////            } else {
//            return new NonMT_FiniteBag(this.left, this.root, this.count - 1, this.right);
////          }
//        } else if (elt.compareTo(this.root) < 0) {
//            return new NonMT_FiniteBag(this.left.remove(elt), this.root, this.count, this.right);
//        } else {
//            return new NonMT_FiniteBag(this.left, this.root, this.count, this.right.remove(elt));
//        }
        return this.remove(elt, 1);
    }

    public FiniteBag<D> remove(D elt, int nCopies) {
//        int max = Math.max(0, this.count-nCopies); <-- only helps if you're
        // going to set count to 0? But that doesn't fully remove the elt...
        if (elt.compareTo(this.root) == 0) {
            // If nCopies will make the count go into the negatives or 0,
            // completely remove the elt from the bag
//            if (this.count <= nCopies) {
//                return left.union(right);
//                // else just do the do
//            } else {
//                return new NonMT_FiniteBag(this.left, this.root, this.count - nCopies, this.right);
//            }
            int max = Math.max(0, this.count - nCopies);
            return new NonMT_FiniteBag(this.left, this.root, max, this.right);
        } else if (elt.compareTo(this.root) < 0) {
            return new NonMT_FiniteBag(this.left.remove(elt, nCopies), this.root, this.count, this.right);
        } else {
            return new NonMT_FiniteBag(this.left, this.root, this.count, this.right.remove(elt, nCopies));
        }

    }

    public FiniteBag<D> removeAll(D elt) {
        if (elt.compareTo(this.root) == 0) {
            return new NonMT_FiniteBag(this.left, this.root, 0, this.right);
        } else if (elt.compareTo(this.root) < 0) {
            return new NonMT_FiniteBag(this.left.removeAll(elt), this.root, this.count, this.right);
        } else {
            return new NonMT_FiniteBag(this.left, this.root, this.count, this.right.removeAll(elt));
        }
    }

    public FiniteBag<D> union(FiniteBag<D> u) {
        return left.union(right.union(u)).add(root, this.getCount(root));
    }

    public FiniteBag<D> inter(FiniteBag<D> u) {
        if (u.member(this.root)) {
            int min = Math.min(u.getCount(root), this.getCount(root));
            return new NonMT_FiniteBag(this.left.inter(u), this.root, min, this.right.inter(u));
//            if (u.getCount(root) > this.getCount(root)) {
//                return new NonMT_FiniteBag(this.left.inter(u), this.root, this.getCount(root),
//                        this.right.inter(u));
//            } else {
//                return new NonMT_FiniteBag(this.left.inter(u), this.root, u.getCount(root),
//                        this.right.inter(u));
//            }
        } else {
            return this.left.inter(u).union(this.right.inter(u));
        }
    }

    public FiniteBag<D> diff(FiniteBag<D> u) {
        FiniteBag removedD = u.remove(root, this.getCount(root));
        return left.union(right).diff(removedD);
    }

    public boolean equal(FiniteBag<D> u) {
        return this.subset(u) && u.subset(this);
    }

    public boolean subset(FiniteBag<D> u) {
        return (u.getCount(root) >= this.getCount(root))
                && this.left.union(this.right).subset(u);
    }

    public Sequence<D> seq() {
        return new NonMT_Sequence(root, count, (new Cat_Sequence(left.seq(), right.seq())));
    }

    public int sumIt() {
        return sumItS(this.seq());
    }

    public int sumItS(Sequence<D> as) {
        int sum = 0;
        while (as.hasNext()) {
            sum = sum + 1;
            as = as.next();
        }
        return sum;
    }

}
