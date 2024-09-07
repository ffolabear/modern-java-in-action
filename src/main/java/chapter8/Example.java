package chapter8;

import common.Trader;
import common.Transaction;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Example {

    private static List<Transaction> transactions;

    private static final Map<String, String> immutableMap = Map.ofEntries(
            Map.entry("ironman", "tony stark"),
            Map.entry("avengers", "captain america"),
            Map.entry("spriderman", "peter parker"),
            Map.entry("black panther", "tChalla")
    );

    private static final Map<String, String> mutableMap = new HashMap<>();

    public static void main(String[] args) throws NoSuchAlgorithmException {

        transactions = new ArrayList<>();

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions.add(new Transaction(brian, 2011, 300));
        transactions.add(new Transaction(raoul, 2012, 1000));
        transactions.add(new Transaction(raoul, 2011, 400));
        transactions.add(new Transaction(mario, 2012, 710));
        transactions.add(new Transaction(mario, 2012, 700));
        transactions.add(new Transaction(alan, 2012, 950));

        mutableMap.put("ironman", "tony stark");
        mutableMap.put("avengers", "captain america");
        mutableMap.put("spriderman", "peter parker");
        mutableMap.put("black panther", "tChalla");
//        System.out.println("Before : " + transactions);
//        removeIf();
//        removeExplain();
//        removeIfImprove();
//        replaceAll();
//        forEach();
//        comparingBy();
//        getOrDefault();
//        computeIfAbsent();
//        replaceAllMap();
        merge();
    }


    private static void removeIf() {
        System.out.println("======================= removeIf =======================");
        try {
            for (Transaction transaction : transactions) {
                if (transaction.getValue() == 300) {
                    transactions.remove(transaction);
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println(e);
        }
    }

    private static void removeExplain() {
        System.out.println("==================== removeExplain ====================");
        for (Transaction transaction : transactions) {
            if (transaction.getValue() == 300) {
                transactions.remove(transaction);
            }
        }
        System.out.println("transactions = " + transactions.size());
    }

    private static void removeIfImprove() {
        System.out.println("==================== removeIfImprove ====================");
        transactions.removeIf(transaction -> transaction.getValue() == 1000);
        System.out.println("transactions = " + transactions.size());
    }

    private static void replaceAll() {
        System.out.println("======================= replaceAll =======================");
        System.out.println(transactions);
        transactions.replaceAll(transaction -> new Transaction(null, 9999, 9999));
        System.out.println(transactions);
    }

    private static void forEach() {
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, (char) (65 + i));
        }

//        for (Entry<Integer, Character> entry : map.entrySet()) {
//            Integer key = entry.getKey();
//            Character value = entry.getValue();
//            System.out.println(key + " : " + value);
//        }

        map.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    private static void comparingBy() {
        immutableMap
                .entrySet()
                .stream()
                .sorted(Entry.comparingByKey())
                .forEachOrdered(entry -> System.out.println(entry));
    }

    private static void getOrDefault() {

        System.out.println(immutableMap.getOrDefault("batman", "ironman"));
        System.out.println(immutableMap.getOrDefault("superman", "ironman"));
    }

    private static void computeIfAbsent() throws NoSuchAlgorithmException {
        System.out.println(mutableMap.computeIfAbsent("Thor", key -> "ironman"));
    }

    private static void replaceAllMap() {
        mutableMap.replaceAll((key, value) -> value.toUpperCase());
        System.out.println(mutableMap);
    }

    private static void merge() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("ironman", "Tony stark");

        Map<String, String> map2 = new HashMap<>();
        map2.put("ironman", "Pepper Potts");

        Map<String, String> map3 = new HashMap<>(map2);
        System.out.println("Before merge : " + map1);
        map1.forEach((k, v) -> map3.merge(k, v, (item1, item2) -> item1 + "-" + item2));
        System.out.println("After merge : " + map3);
    }
}
