package data2;

public class FakeBag3<D extends Comparable> implements FakeBag<D>{

    D root1; //K1
    D root2; //K2
    int count1; //V1
    int count2; //V2
    FiniteBag<D> left; //left-tree
    FiniteBag<D> right; //right-tree
    FiniteBag<D> middle; //middle-tree

    FakeBag3(FiniteBag<D> left, D root1, int count1, FiniteBag<D> middle,
            D root2, int count2, FiniteBag<D> right) {
        this.left = left;
        this.root1 = root1;
        this.count1 = count1;
        this.middle = middle;
        this.root2 = root2;
        this.count2 = count2;
        this.right = right;
    }

}
