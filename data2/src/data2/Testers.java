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
        FiniteBag b1 = new NonMT_FiniteBag(mT, 6, mT);
        FiniteBag b2 = new NonMT_FiniteBag(mT, 5, b1);
        // Right branches
        FiniteBag b3 = new NonMT_FiniteBag(mT, 8, mT);
        FiniteBag b4 = new NonMT_FiniteBag(b3, 9, mT);
        // Combined with root = 7
        FiniteBag b5 = new NonMT_FiniteBag(b2, 7, b4);
        
        FiniteBag<String> s1 = new NonMT_FiniteBag(mT, "aa", mT);
        FiniteBag<String> s2 = new NonMT_FiniteBag(mT, "a", s1);
        FiniteBag<String> s3 = new NonMT_FiniteBag(mT, "aaaa", mT);
        FiniteBag<String> s4 = new NonMT_FiniteBag(s3, "aaaaa", mT);
        FiniteBag<String> s5 = new NonMT_FiniteBag(s2, "aaa", s4);
        
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
        
        System.out.println("a".compareTo("aa"));
        
    }
    
}
