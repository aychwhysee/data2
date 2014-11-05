package data2;

public class MT_Sequence<D extends Comparable> implements Sequence<D>, Sequenced<D> {

    MT_Sequence() {
    }

    public D here() {
        return null; //throw exception later
    }

    public boolean hasNext() {
        return false;
    }

    public Sequence<D> next() {
        return this;
    }

    public String toStringS() {
        return "";
    }
    
    public Sequence<D> seq() {
        return this;
    }
}
