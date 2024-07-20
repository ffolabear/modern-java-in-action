package chapter7;

import java.util.stream.Stream;

public class ParallelStreamTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        parallelSum(10000000);
        long end = System.currentTimeMillis();

        long duration = end - start;
        System.out.println("parallel steram result : " + duration);

        start = System.currentTimeMillis();
        int seed = 0;
        for (int i = 1; i < 10000000; i++) {
            seed += i;
        }
        end = System.currentTimeMillis();
        long duration2 = end - start;
        System.out.println("for result : " + duration2);

    }

    private static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

}
