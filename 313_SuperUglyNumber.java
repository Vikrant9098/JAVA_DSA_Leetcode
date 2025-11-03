import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        Comparator<Number> comparator = new NumberCompare(); // create a comparator to sort by value
        PriorityQueue<Number> queue = new PriorityQueue<>(primes.length, comparator); // min-heap to get smallest number first

        // add all primes to the queue as starting numbers
        for (int i = 0; i < primes.length; i++)
            queue.add(new Number(primes[i], 0, primes[i]));

        long[] uglyNums = new long[n]; // use long to avoid integer overflow
        uglyNums[0] = 1; // first ugly number is always 1

        // generate super ugly numbers up to n
        for (int i = 1; i < n; i++) {
            Number min = queue.peek(); // get smallest number from heap
            uglyNums[i] = min.un; // store it as next ugly number

            // update all primes that generated this same smallest number
            while (queue.peek().un == min.un) {
                Number tmp = queue.poll(); // remove that smallest number
                // multiply the prime with the next ugly number and add to heap
                queue.add(new Number(uglyNums[tmp.pos + 1] * tmp.prime, tmp.pos + 1, tmp.prime));
            }
        }

        return (int) uglyNums[n - 1]; // return nth super ugly number as int
    }

    // helper class to store current value, index, and prime
    public class Number {
        long un;   // current ugly number value
        int pos;   // position in uglyNums
        int prime; // prime used to generate the number

        Number(long un, int pos, int prime) {
            this.un = un;   // set value
            this.pos = pos; // set position
            this.prime = prime; // set prime
        }
    }

    // comparator class to compare two Number objects by their value
    public class NumberCompare implements Comparator<Number> {
        @Override
        public int compare(Number x, Number y) {
            return Long.compare(x.un, y.un); // compare using long values
        }
    }
}
