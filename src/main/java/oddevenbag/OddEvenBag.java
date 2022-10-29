package oddevenbag;

import java.util.*;

public class OddEvenBag {
    List<Integer> numbers;
    int[] evenOdd = {0,0};

    // Create an empty OddEvenBag
    OddEvenBag() {
        numbers = new ArrayList<>();
    }

    // Create an OddEvenBag using the elements in the provided array
    // requires: seedArray is not null
    OddEvenBag(int[] seedArray) {
        int len = seedArray.length;
        numbers = new ArrayList<>();
        for (int i=0; i<len; i++) {
            add(seedArray[i]);
        }
    }

    // add x to the OddEvenBag
    void add(int x) {
        numbers.add(x);
        evenOdd[x % 2]++;
    }

    // remove x from the OddEvenBag
    // if x does not exist in the Bag then do nothing
    void remove(int x) {
        int idx = numbers.indexOf(x);
        if (idx != -1) {
            numbers.remove(idx);
            evenOdd[x % 2]--;
        }
    }

    // increment each value in the OddEvenBag by 1
    void increment() {
        int len = numbers.size();
        int temp;
        for (int i=0; i<len; i++) {
            numbers.set(i,numbers.get(i) + 1);
        }
        temp = evenOdd[0];
        evenOdd[0] = evenOdd[1];
        evenOdd[1] = temp;
    }

    // decrement each value in the OddEvenBag by 1
    void decrement() {
        int len = numbers.size();
        int temp;
        for (int i=0; i<len; i++) {
            numbers.set(i,numbers.get(i) - 1);
        }
        temp = evenOdd[0];
        evenOdd[0] = evenOdd[1];
        evenOdd[1] = temp;
    }

    // return true if this OddEvenBag contains x
    // and false otherwise
    boolean contains(int x) {
        return numbers.contains(x);
    }

    // count the occurrences of x in the OddEvenBag
    int getCount(int x) {
        int count = 0;
        int len = numbers.size();
        for (int i=0; i<len; i++) {
            if (numbers.get(i) == x) {
                count++;
            }
        }
        return count;
    }

    // return the sum of the values in the OddEvenBag
    long sum() {
        int sum = 0;
        int len = numbers.size();
        for (int i=0; i<len; i++) {
            sum += numbers.get(i);
        }
        return sum;
    }

    boolean equals(OddEvenBag b) {
        return evenOdd[0] == b.evenOdd[0] && evenOdd[1] == b.evenOdd[1];
    }

    public int hashCode() {
        return Integer.parseInt(Integer.toString(evenOdd[0]) + Integer.toString(evenOdd[1]));
    }
}