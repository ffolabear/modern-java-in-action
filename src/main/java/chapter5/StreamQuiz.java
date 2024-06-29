package chapter5;

import common.Trader;
import common.Transaction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamQuiz {

    private static List<Transaction> transactions;

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));

        quiz1();
        quiz2();
        quiz3();
        quiz4();
        quiz5();
        quiz6();
        quiz7();
        quiz8();
    }

    private static void quiz1() {
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted((o1, o2) -> o1.getValue() - o2.getValue())
                .forEach(System.out::println);
    }

    private static void quiz2() {
        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
    }

    private static void quiz3() {
        transactions.stream()
                .map(transaction -> transaction.getTrader())
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
                .forEach(trader -> System.out.println(trader));
    }

    private static void quiz4() {
        transactions.stream()
                .map(transaction -> transaction.getTrader())
                .sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
                .forEach(trader -> System.out.println(trader));
    }

    private static void quiz5() {
        boolean anyMatch = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(anyMatch);
    }

    private static void quiz6() {
        Optional<Integer> sum = transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce((a, b) -> a + b);
        System.out.println(sum.get());
    }

    private static void quiz7() {
        Optional<Integer> max = transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce((a, b) -> Integer.max(a, b));
        System.out.println(max.get());
    }

    private static void quiz8() {
        Optional<Integer> min = transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce((a, b) -> Integer.min(a, b));
        System.out.println(min.get());
    }

}
