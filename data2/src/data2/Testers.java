package data2;

import java.util.Random;

public class Testers<D extends Comparable> {

    Testers(RandomGenerator<D> jenny) {
        this.jenny = jenny;
    }

    public static FiniteBag empty() {
        return new MT_FiniteBag();
    }

    static Random rand = new Random();

    RandomGenerator<D> jenny;

    public static int randomInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

    public FiniteBag<D> randomBag(int length) {
        if (length == 0) {
            return empty();
        } else {
            return randomBag(length - 1).add(jenny.giveMeAThing(), randomInt(1, 10));
        }
    }

    static int empty_isEmptyHuh = 0;
    static int isEmptyHuh_cardinality = 0;
    static int cardinality_add = 0;
    static int card_remove_getCount = 0;
    static int add_remove_getC_equal = 0;
    static int add_member = 0;
    static int member_union = 0;
    static int union_getCount = 0;
    static int union_subset = 0;
    static int member_diff = 0;
    static int equal_inter = 0;
    static int getCount_add_nCopies = 0;
    static int getCount_remove_nCopies = 0;

    // Property testing~
    // Empty and isEmptyHuh
    public void empty_isEmptyHuh(int count) throws Exception {
        for (int i = 0; i < 50; i++) {
            if (count == 0) {
                FiniteBag e = empty();
                if (!e.isEmptyHuh()) {
                    throw new Exception("Test failed. MT bag is not MT");
                }
            } else {
                int length = randomInt(1, 10);
                FiniteBag n = randomBag(length);
                if (n.isEmptyHuh()) {
                    throw new Exception("Test failed. NonMT bag is MT");
                }
            }
            empty_isEmptyHuh++;
        }
    }

    // isEmptyHuh and cardinality
    public void isEmptyHuh_cardinality() throws Exception {
        for (int i = 0; i < 50; i++) {
            int length = randomInt(0, 10);
            FiniteBag b = randomBag(length);
            if (!b.isEmptyHuh() && (b.cardinality() == 0)) {
                throw new Exception("Test failed. NonMT bag had card. = 0");
            }
            if (b.isEmptyHuh() && (b.cardinality() != 0)) {
                throw new Exception("Test failed. MT ");
            }
            isEmptyHuh_cardinality++;
        }
    }

    // cardinality and add
    public void cardinality_add() throws Exception {
        for (int i = 0; i < 50; i++) {
            int length = randomInt(0, 10);
            FiniteBag myBag = randomBag(length);
            int currentCard = myBag.cardinality();
            if (myBag.add(jenny.giveMeAThing()).cardinality() != currentCard + 1) {
                throw new Exception("Test failed. Not adding to card properly");
            }
            if (myBag.add(jenny.giveMeAThing()).cardinality() == currentCard) {
                throw new Exception("Test failed. Not adding at all");
            }
            cardinality_add++;
        }
    }

    // cardinality, remove, and getCount
    public void card_remove_getCount() throws Exception {
        for (int i = 0; i < 50; i++) {
            D randomElt = jenny.giveMeAThing();
            int length = randomInt(0, 10);
            FiniteBag myBag = randomBag(length);
            int newCard = myBag.remove(randomElt).cardinality();
            if (myBag.getCount(randomElt) >= 1 && newCard != myBag.cardinality() - 1) {
                throw new Exception("Test failed. Cardinality didn't decrease by 1");
            }
            if (myBag.getCount(randomElt) == 0 && newCard != myBag.cardinality()) {
                throw new Exception("Test failed. Cardinality should've stayed the same");
            }
            card_remove_getCount++;
        }
    }

    // At this point we know that add, remove, and getCount work. So we can test
    // for equal
    // add, remove, getCount, equal
    public void add_remove_getC_equal() throws Exception {
        for (int i = 0; i < 50; i++) {
            D randomElt = jenny.giveMeAThing();
            int length = randomInt(0, 10);
            FiniteBag myBag = randomBag(length);
            FiniteBag biggerBag = myBag.add(randomElt);
            if (biggerBag.getCount(randomElt) - 1 != myBag.getCount(randomElt)) {
                throw new Exception("Test failed. Count for randomElt didn't go up by 1");
            }
            FiniteBag smallBag = biggerBag.remove(randomElt);
            if (smallBag.getCount(randomElt) != myBag.getCount(randomElt)) {
                throw new Exception("Test failed. Count for randomElt didn't go back"
                        + "to what it was before");
            }
            if (!myBag.equal(smallBag)) {
                throw new Exception("Test failed. myBag and smallBag should be equal");
            }
            add_remove_getC_equal++;
        }
    }

    // add and member
    public void add_member() throws Exception {
        for (int i = 0; i < 50; i++) {
            D x = jenny.giveMeAThing();
            D y = jenny.giveMeAThing();
            int length = randomInt(0, 10);
            FiniteBag myBag = randomBag(length);
            if (myBag.add(x).member(y)) {
                if (x.compareTo(y) == 0 || myBag.member(y)) {
                    // It works
                } else {
                    throw new Exception("Test failed. Y should not be in myBag");
                }
            } else {
                if (x.compareTo(y) == 0 || myBag.member(y)) {
                    throw new Exception("Test failed. Check add_member again");
                }
            }
            add_member++;
        }
    }

    // member and union
    public void member_union() throws Exception {
        for (int i = 0; i < 50; i++) {
            int length = randomInt(0, 10);
            FiniteBag myBag = randomBag(length);
            FiniteBag yourBag = randomBag(length);
            D x = jenny.giveMeAThing();
            if (myBag.union(yourBag).member(x)) {
                if (myBag.member(x) || yourBag.member(x)) {
                    // It works properly
                } else {
                    throw new Exception("X should be in either bag or both!");
                }
            } else {
                if (myBag.member(x) || yourBag.member(x)) {
                    throw new Exception("X should not be in either bag!");
                }
            }
            member_union++;
        }
    }

    // union and getCount
    public void union_getCount() throws Exception {
        for (int i = 0; i < 50; i++) {
            int length = randomInt(0, 10);
            D x = jenny.giveMeAThing();
            FiniteBag myBag = randomBag(length);
            FiniteBag yourBag = randomBag(length);
            if (myBag.union(yourBag).getCount(x) != ((myBag.getCount(x)) + (yourBag.getCount(x)))) {
                throw new Exception("Test failed. Union of myBag and yourBag should have"
                        + " the same count of x");
            }
            union_getCount++;
        }
    }

    // union and subset
    public void union_subset() throws Exception {
        for (int i = 0; i < 50; i++) {
            int length = randomInt(0, 10);
            FiniteBag myBag = randomBag(length);
            FiniteBag yourBag = randomBag(length);
            FiniteBag theirBag = randomBag(length);
            if (myBag.union(yourBag).subset(theirBag) != myBag.subset(theirBag) && yourBag.subset(theirBag)) {
                throw new Exception("Test failed. Check union_subset");
            }
            union_subset++;
        }
    }

    // member and diff
    public void member_diff() throws Exception {
        for (int i = 0; i < 50; i++) {
            int length = randomInt(0, 10);
            D x = jenny.giveMeAThing();
            FiniteBag myBag = randomBag(length);
            FiniteBag yourBag = randomBag(length);
            if (myBag.diff(yourBag).member(x)) {
                if (!yourBag.member(x)) {
                    throw new Exception("Test failed. X should be in yourBag");
                }
            } else if (!yourBag.member(x) || myBag.member(x)) {
                // Thing works
            } else {
                throw new Exception("Test failed. Check again");
            }
            member_diff++;
        }
    }

    // equal and inter
    public void equal_inter() throws Exception {
        for (int i = 0; i < 50; i++) {
            int length = randomInt(0, 10);
            FiniteBag BagX = randomBag(length);
            FiniteBag BagY = randomBag(length);
            FiniteBag BagZ = BagX.union(BagY);
            if (!BagX.inter(BagZ).equal(BagX) || !BagY.inter(BagZ).equal(BagY)) {
                throw new Exception("Test failed. Check again");
            }
            equal_inter++;
        }
    }

    // getCount and add(nCopies ver)
    public void getCount_add_nCopies() throws Exception {
        for (int i = 0; i < 50; i++) {
            int length = randomInt(0, 10);
            D x = jenny.giveMeAThing();
            FiniteBag myBag = randomBag(length);
            FiniteBag newBag = myBag.add(x);
            int currentCount = newBag.getCount(x);
            if (newBag.add(x, length).getCount(x) != currentCount + length) {
                throw new Exception("Test failed. Didn't add the right amount");
            }
            getCount_add_nCopies++;
        }
    }

    // getCount and remove(nCopies ver)
    public void getCount_remove_nCopies() throws Exception {
        for (int i = 0; i < 50; i++) {
            int length = randomInt(0, 10);
            int randInt = randomInt(0, 10);
            D x = jenny.giveMeAThing();
            FiniteBag myBag = randomBag(length);
            FiniteBag newBag = myBag.add(x, randInt);
            int currentCount = newBag.getCount(x);
            int max = Math.max(0, currentCount-randInt);
            if (newBag.remove(x, randInt).getCount(x) != max) {
                throw new Exception("Test failed. remove (n Copies) not working");
            }
            getCount_remove_nCopies++;
        }
    }

    public static void main(String[] args) throws Exception {
        // Random tests!!!
        System.out.println();
        System.out.println("=====================================");
        System.out.println("| Property Testing with Random Sets |");
        System.out.println("|   Containing Integers or Strings  |");
        System.out.println("=====================================");
        System.out.println();

        Testers myIntTests = new Testers(new RandomInt());
        Testers myStringTests = new Testers(new RandomString());

        int checkInt = randomInt(0, 1);
        myIntTests.empty_isEmptyHuh(checkInt);
        myStringTests.empty_isEmptyHuh(checkInt);
        System.out.println("Tested empty_isEmptyHuh " + empty_isEmptyHuh + " times successfully");

        myIntTests.isEmptyHuh_cardinality();
        myStringTests.isEmptyHuh_cardinality();
        System.out.println("Tested isEmptyHuh_cardinality " + isEmptyHuh_cardinality + " times successfully");

        myIntTests.cardinality_add();
        myStringTests.cardinality_add();
        System.out.println("Tested cardinality_add " + cardinality_add + " times successfully");

        myIntTests.card_remove_getCount();
        myStringTests.card_remove_getCount();
        System.out.println("Tested card_remove_getCount " + card_remove_getCount + " times successfully");

        myIntTests.add_remove_getC_equal();
        myStringTests.add_remove_getC_equal();
        System.out.println("Tested add_remove_getC_equal " + add_remove_getC_equal + " times successfully");

        myIntTests.add_member();
        myStringTests.add_member();
        System.out.println("Tested add_member " + add_member + " times successfully");

        myIntTests.member_union();
        myStringTests.member_union();
        System.out.println("Tested member_union " + member_union + " times successfully");

        myIntTests.union_getCount();
        myStringTests.union_getCount();
        System.out.println("Tested union_getCount " + union_getCount + " times successfully");

        myIntTests.union_subset();
        myStringTests.union_subset();
        System.out.println("Tested union_subset " + union_subset + " times successfully");

        myIntTests.member_diff();
        myStringTests.member_diff();
        System.out.println("Tested member_diff " + member_diff + " times successfully");

        myIntTests.equal_inter();
        myStringTests.equal_inter();
        System.out.println("Tested equal_inter " + equal_inter + " times successfully");

        myIntTests.getCount_add_nCopies();
        myStringTests.getCount_add_nCopies();
        System.out.println("Tested getCount_add_nCopies " + getCount_add_nCopies + " times successfully");

        myIntTests.getCount_remove_nCopies();
        myStringTests.getCount_remove_nCopies();
        System.out.println("Tested getCount_remove_nCopies " + getCount_remove_nCopies
                + " times successfully");
    }

}
