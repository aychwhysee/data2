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
        
        FiniteBag<Integer> t1 = mT.add(6);
        FiniteBag<Integer> t2 = t1.add(5, 2);
        FiniteBag<Integer> t3 = mT.add(8);
        FiniteBag<Integer> t4 = t3.add(9);
        FiniteBag<Integer> t5 = t2.union(t4).add(7);
        FiniteBag<Integer> t6 = mT.add(13).add(18).add(15).add(21);
        FiniteBag<Integer> t7 = mT.add(6).add(8).add(9);
        
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
        System.out.println(b5.getCount(1) + " should be " + 0);

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
        
        // add tests
        System.out.println("=== add tests ===");
        System.out.println(mT.add(9).cardinality() + " should be " + 1);
        System.out.println(mT.add(9).member(9) + " should be " + true);
        System.out.println(b5.add(2).cardinality() + " should be " + 7); // FAILS
        System.out.println(b5.add(5).cardinality() + " should be " + 7);
        System.out.println(b5.add(5).getCount(5) + " should be " + 3);
        System.out.println(b5.add(22).cardinality() + " should be " + 7);
        System.out.println(b5.add(22).member(22) + " should be " + true);
        System.out.println(b5.add(22).getCount(22) + " should be " + 1);
        // add (with nCopies) tests
        System.out.println("=== adding nCopies ===");
        System.out.println(mT.add(9, 4).cardinality() + " should be " + 4);
        System.out.println(mT.add(9, 4).getCount(9) + " should be " + 4);
        System.out.println(mT.add(9, 4).member(9) + " should be " + true);
        System.out.println(b5.add(5, 3).getCount(5) + " should be " + 5);
        System.out.println(b5.add(4, 3).cardinality() + " should be " + 9);
        System.out.println(b5.add(4, 3).getCount(4) + " should be " + 3);
        
        // remove tests
        System.out.println("=== remove tests ===");
        System.out.println(b5.remove(5).cardinality() + " should be " + 5);
        System.out.println(b5.remove(5).member(5) + " should be " + true);
        System.out.println(b5.remove(5).member(6) + " should be " + true);
        System.out.println(b5.remove(6).member(6) + " should be " + false);
        System.out.println(b1.remove(6).cardinality() + " should be " + 0);
        System.out.println(b1.remove(6).isEmptyHuh() + " should be " + true);
        System.out.println(b5.remove(22).cardinality() + " should be " + 6);
        // remove (with nCopies) tests
        System.out.println("=== removing nCopies ===");
        System.out.println(b5.remove(5, 2).cardinality() + " should be " + 4);
        System.out.println(b5.remove(5, 2).member(5) + " should be " + false);
        System.out.println(b5.remove(5, 2).member(6) + " should be " + true);
        System.out.println(b5.remove(6, 2).member(6) + " should be " + false);
        System.out.println(b5.remove(6, 1).member(6) + " should be " + false);
        System.out.println(b5.remove(5, 3).member(5) + " should be " + false);
        // removeAll tests
        System.out.println("=== removeAll tests ===");
        System.out.println(b5.removeAll(5).cardinality() + " should be " + 4);
        System.out.println(b5.removeAll(5).member(5) + " should be " + false);
        System.out.println(b5.removeAll(6).cardinality() + " should be " + 5);
        System.out.println(b5.removeAll(6).member(6) + " should be " + false);
        System.out.println(b5.removeAll(5).member(6) + " should be " + true);
        
        // Union tests
        System.out.println("=== union tests ===");
        System.out.println(mT.union(t2).cardinality() + " should be " + 3);
        System.out.println(t5.cardinality() + " should be " + 6);
        System.out.println(mT.union(t5).union(t6).cardinality() + " should be " + 10);
        System.out.println(mT.union(mT).cardinality() + " should be " + 0);
        System.out.println(t1.union(mT).member(6) + " should be " + true);
        System.out.println(t1.union(t3).cardinality() + " should be " + 2);
        System.out.println(t1.union(t3).member(8) + " should be " + true);
        System.out.println(t1.union(t3).member(6) + " should be " + true);
        System.out.println(t1.union(t3).member(3) + " should be " + false);
        System.out.println(t5.union(t6).cardinality() + " should be " + 10);
        System.out.println(t5.union(t6).member(15) + " should be " + true);
        System.out.println(t5.union(t6).member(77) + " should be " + false);
        
        
        

    }

}
