package chapter1;

import common.Apple;
import common.AppleInventory;

import java.util.List;
import java.util.stream.Collectors;

public class StreamFiltering {

    public static void main(String[] args) {

        AppleInventory inventory = new AppleInventory();
        List<Apple> appleInventory = inventory.getInventory();

    }

    //순차 처리방식
    public static List<Apple> sequentialStreamFiltering(List<Apple> appleInventory) {
        long start = System.currentTimeMillis();

        List<Apple> heavyApple = appleInventory.stream().filter(
                (Apple a) -> a.getWeight() > 150)
                .collect(Collectors.toList());

        long end = System.currentTimeMillis();
        System.out.println("parallelStreamFiltering : " + (end - start)/1000.0);
        return heavyApple;
    }

    //병렬 처리방식
    public static List<Apple> parallelStreamFiltering(List<Apple> appleInventory) {
        long start = System.currentTimeMillis();
        List<Apple> heavyApple = appleInventory.parallelStream().filter(
                (Apple a) -> a.getWeight() > 150)
                .collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.println("parallelStreamFiltering : " + (end - start)/1000.0);
        return heavyApple;
    }

}
