package com.bobocode.fp;


import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * {@link PrimeNumbers} provides an API to work with prime numbers. The implementation is based on the
 * {@link IntStream} of prime numbers. That stream is used in all public methods on this class.
 * <p>
 * See {@link OOSumOfPrimes} for a reference
 * TODO: implement each method according to the javadoc and verify it by running {@link PrimeNumbersTest}
 * <p>
 * TODO: if you find this exercise valuable and you want to get more like it, <a href="https://www.patreon.com/bobocode">
 *     please support us on Patreon</a>
 *
 * @author Taras Boychuk
 */
public class PrimeNumbers {
    private PrimeNumbers() {
    }

    /**
     * Generates an infinite int stream of prime numbers.
     * The stream values are 2, 3, 5,... and so on.
     *
     * @return an infinite int stream of prime numbers
     */
    public static IntStream stream() {
         // todo: create an infinite stream of ints, then filter prime numbs
        return IntStream.iterate(2, x -> x + 1).filter(OOSumOfPrimes::isPrime);
    }

    /**
     * Generates an int stream of a certain amount of prime numbers.
     * It is based on the {@link PrimeNumbers#stream()} but specifies the exact size of the stream.
     *
     * @return an int stream of prime numbers with a specified size
     */
    public static IntStream stream(int size) {
       // todo: use the prev to generate a stream method but limit its size
        return IntStream.iterate(2, x -> x + 1).filter(OOSumOfPrimes::isPrime).limit(size);
    }

    /**
     * Calculates the sum on first n prime numbers.
     * E.g. if n = 5, the result should be 2 + 3 + 5 + 7 + 11 = 28
     *
     * @param n the number of first prime numbers
     * @return the sum of n prime numbers
     */
    public static int sum(int n) {
        // todo: use prev method and calculate the sum
        return IntStream.iterate(2, x -> x + 1).filter(OOSumOfPrimes::isPrime).limit(n).sum();
    }

    /**
     * Collects n first prime numbers.
     *
     * @return a list of collected prime numbers
     */
    public static List<Integer> list(int n) {
        return IntStream.iterate(2, x -> x + 1).filter(OOSumOfPrimes::isPrime).limit(n).boxed().toList();
         // todo: collect prime numbers into the list
    }

    /**
     * Find a prime number by index and then applies a provided consumer passing found prime number
     *
     * @param idx      the position of a prime number (index), starting from 0
     * @param consumer a logic that should be applied to the found prime number
     */
    public static void processByIndex(int idx, IntConsumer consumer) {
        IntStream.iterate(2, x -> x + 1).filter(OOSumOfPrimes::isPrime).skip(idx).findFirst().ifPresent(consumer);
        // todo: find an element in the stream by index and process it
    }

    /**
     * Creates a list of n prime numbers and returns a map where all of those prime numbers are groped. The key represents
     * an amount of digits and the value is a corresponding list of all prime numbers.
     * <p>
     * So if you will call this method for with argument 20, you will receive the following map:
     * {1=[2, 3, 5, 7], 2=[11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71]}
     *
     * @param n – the amount of prime numbers
     * @return a map with prime number grouped by the amount of digits
     */
    public static Map<Integer, List<Integer>> groupByAmountOfDigits(int n) {
        return IntStream.iterate(2, x -> x + 1).filter(OOSumOfPrimes::isPrime).limit(n).boxed().
                collect(Collectors.groupingBy(
                x -> String.valueOf(x).length()));
        // todo: group n prime numbers by the amount of digits
    }
}
