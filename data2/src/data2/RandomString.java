package data2;

import java.util.Random;

public class RandomString implements RandomGenerator<String> {
    
    public String giveMeAThing() {
//        RandomGenerator<Integer> jenny = new RandomInt();
//        Integer boom = jenny.giveMeAThing();
//        char[] stringy = new char[boom];
//        Random rand = new Random();
//        String characters = "ABCDJKLSTYZ1234567";
//        for (int i = 0; i < boom; i++) {
//            stringy[i] = characters.charAt(rand.nextInt(characters.length()));
//        }
//        return stringy.toString();
        RandomGenerator<Integer> jenny = new RandomInt();
        Integer boom = jenny.giveMeAThing();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < boom; i++) {
            sb.append(Character.toChars(65 + new Random().nextInt(26)));
        }
        return sb.toString();
    }
}
