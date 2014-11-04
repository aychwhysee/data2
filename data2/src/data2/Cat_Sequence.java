package data2;

public class Cat_Sequence<D extends Comparable> implements Sequence<D> {
    
    Sequence<D> left;
    Sequence<D> right;
    
    Cat_Sequence(Sequence<D> left, Sequence<D> right) {
        this.left = left;
        this.right = right;
    }
    
    public D here() {
        if (this.left.hasNext()) {
            return this.left.here();
        } else {
            return this.right.here();
        }
    }
    
    public boolean hasNext() {
        return this.left.hasNext() || this.right.hasNext();
    }
    
    public Sequence<D> next() {
        if (this.left.hasNext()) {
            return new Cat_Sequence(this.left.next(), this.right);
        } else {
            return this.right.next();
        }
    }
    
    public String toStringS() {
        return this.left.toStringS() + " " + this.right.toStringS();
    }
}
