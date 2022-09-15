package oddevenbag;

import java.util.*;

public class OddEvenBag {
    List<Integer> bag;

    // Create an empty OddEvenBag
    OddEvenBag() {
        bag = new ArrayList<>();
    }

    // Create an OddEvenBag using the elements in the provided array
    // requires: seedArray is not null
    OddEvenBag(int[] seedArray) {
        int len = seedArray.length;
        bag = new ArrayList<>();
        for (int i=0; i<len; i++) {
            bag.add(seedArray[i]);
        }
    }

    // add x to the OddEvenBag
    void add(int x) {
        bag.add(x);
    }

    // remove x from the OddEvenBag
    // if x does not exist in the Bag then do nothing
    void remove(int x) {
        int idx = bag.indexOf(x);
        if (idx != -1) {
            bag.remove(idx);
        }
    }

    // increment each value in the OddEvenBag by 1
    void increment() {
        int len = bag.size();
        for (int i=0; i<len; i++) {
            bag.set(i,bag.get(i) + 1);
        }
    }

    // decrement each value in the OddEvenBag by 1
    void decrement() {
        int len = bag.size();
        for (int i=0; i<len; i++) {
            bag.set(i,bag.get(i) - 1);
        }
    }

    // return true if this OddEvenBag contains x
    // and false otherwise
    boolean contains(int x) {
        return bag.contains(x);
    }

    // count the occurrences of x in the OddEvenBag
    int getCount(int x) {
        int count = 0;
        int len = bag.size();
        for (int i=0; i<len; i++) {
            if (bag.get(i) == x) {
                count++;
            }
        }
        return count;
    }

    // return the sum of the values in the OddEvenBag
    long sum() {
        int sum = 0;
        int len = bag.size();
        for (int i=0; i<len; i++) {
            sum += bag.get(i);
        }
        return sum;
    }

    boolean equals(OddEvenBag b) {
        int len = bag.size();
        int evens = 0;
        int odds = 0;
        if (len == b.bag.size()) {
            for (int i=0; i<len; i++) {
                if (bag.get(i) % 2 == 0) {
                    evens++;
                } else {
                    odds++;
                }

                if (b.bag.get(i) % 2 == 0) {
                    evens--;
                } else {
                    odds--;
                }
            }
            if (evens == 0 && odds == 0) {
                return true;
            }
        }
        return false;
    }

    int hashcode() {
        
    }
}