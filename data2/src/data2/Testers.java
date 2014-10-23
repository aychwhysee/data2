package data2;

public class Testers {

    public static FiniteBag empty() {
        return new MT_FiniteBag();
    }

    public static void main(String[] args) {
        //Hard-coded tests for now:

        // MT set
        FiniteBag mT = new MT_FiniteBag();
        // Left branches
        FiniteBag<Integer> b1 = new NonMT_FiniteBag(mT, 6, 1, mT);
        FiniteBag<Integer> b2 = new NonMT_FiniteBag(mT, 5, 2, b1);
        // Right branches
        FiniteBag<Integer> b3 = new NonMT_FiniteBag(mT, 8, 1, mT);
        FiniteBag<Integer> b4 = new NonMT_FiniteBag(b3, 9, 1, mT);
        // Combined with root = 7
        FiniteBag<Integer> b5 = new NonMT_FiniteBag(b2, 7, 1, b4);

        FiniteBag<String> s1 = new NonMT_FiniteBag(mT, "aa", 1, mT);
        FiniteBag<String> s2 = new NonMT_FiniteBag(mT, "a", 1, s1);
        FiniteBag<String> s3 = new NonMT_FiniteBag(mT, "aaaa", 1, mT);
        FiniteBag<String> s4 = new NonMT_FiniteBag(s3, "aaaaa", 1, mT);
        FiniteBag<String> s5 = new NonMT_FiniteBag(s2, "aaa", 1, s4);

        // Cardinality tests
        System.out.println("=== Cardinality tests ===");
        System.out.println(mT.cardinality() + " should be " + 0);
        System.out.println(b1.cardinality() + " should be " + 1);
        System.out.println(b2.cardinality() + " should be " + 3);
        System.out.println(b3.cardinality() + " should be " + 1);
        System.out.println(b4.cardinality() + " should be " + 2);
        System.out.println(b5.cardinality() + " should be " + 6);

        // getCount tests
        System.out.println("=== getCount tests ===");
        System.out.println(b1.getCount(6) + " should be " + 1);
        System.out.println(b2.getCount(5) + " should be " + 2);
        System.out.println(b5.getCount(5) + " should be " + 2); // FIXED

        //Member tests
        System.out.println("=== Member tests ===");
        System.out.println(mT.member(5) + " should be " + false);
        System.out.println(b1.member(6) + " should be " + true);
        System.out.println(b1.member(5) + " should be " + false);
        System.out.println(b2.member(5) + " should be " + true);
        System.out.println(b3.member(8) + " should be " + true);
        System.out.println(b4.member(8) + " should be " + true);
        System.out.println(b5.member(8) + " should be " + true);
        System.out.println(b5.member(8) + " should be " + true);
        System.out.println(b5.member(9) + " should be " + true);
        System.out.println(b5.member(7) + " should be " + true);
        System.out.println(b5.member(6) + " should be " + true);
        System.out.println(b5.member(5) + " should be " + true);
        System.out.println("=== Member tests ===");
        System.out.println(mT.member(5) + " should be " + false);
        System.out.println(s1.member("aa") + " should be " + true);
        System.out.println(s1.member("a") + " should be " + false);
        System.out.println(s2.member("a") + " should be " + true);
        System.out.println(s3.member("aaaa") + " should be " + true);
        System.out.println(s4.member("aaaa") + " should be " + true);
        System.out.println(s5.member("aaaa") + " should be " + true);
        System.out.println(s5.member("aaaa") + " should be " + true);
        System.out.println(s5.member("aaaaa") + " should be " + true);
        System.out.println(s5.member("aaa") + " should be " + true);
        System.out.println(s5.member("aa") + " should be " + true);
        System.out.println(s5.member("a") + " should be " + true);

        System.out.println("a".compareTo("aaa"));
        System.out.println("a".compareTo("aa"));
        System.out.println("aaaa".compareTo("a"));

    }

}
