package data2;

public class NonMT_Sequence<D extends Comparable> implements Sequence<D>, Sequenced<D> {

    D here;
    int count;
    Sequence<D> next;

    NonMT_Sequence(D here, int count, Sequence<D> next) {
        this.here = here;
        this.count = count;
        this.next = next;
    }

    public D here() {
        return this.here;
    }

    public boolean hasNext() {
        return true;
    }

    public Sequence<D> next() {
        if (count > 1) {
            return new NonMT_Sequence(here, count - 1, next);
        } else {
            return next;
        }
    }

    public String toStringS() {
        return "" + this.here;
    }

    public Sequence<D> seq() {
        return this;
    }

}
