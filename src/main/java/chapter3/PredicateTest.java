package chapter3;

import common.Apple;
import common.AppleInventory;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String[] args) {

        AppleInventory appleInventory = new AppleInventory();

        List<Apple> inventory = appleInventory.getInventory();
        System.out.println(inventory);
        List<Apple> result = filter(inventory, apple -> apple.getColor().equals("red"));
        System.out.println(result);

    }

    private static  <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }


}
