package data2;

public class FakeBag3<D extends Comparable> {

    D root1; //K1
    D root2; //K2
    int count1; //V1
    int count2; //V2
    FiniteBag left; //left-tree
    FiniteBag right; //right-tree
    FiniteBag middle; //middle-tree

    FakeBag3(FiniteBag left, D root1, int count1, FiniteBag middle,
            D root2, int count2, FiniteBag right) {
        this.left = left;
        this.root1 = root1;
        this.count1 = count1;
        this.middle = middle;
        this.root2 = root2;
        this.count2 = count2;
        this.right = right;
    }

}
