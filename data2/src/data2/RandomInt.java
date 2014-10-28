package data2;

import java.util.Random;

public class RandomInt implements RandomGenerator<Integer> {
    
    public Integer giveMeAThing() {
        Random rand = new Random();
        int min = 1;
        int max = 100;
        return rand.nextInt((max - min) + 1) + min;
    }
}
