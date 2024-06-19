package chapter3;

import common.Apple;
import common.AppleInventory;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {

    public static void main(String[] args) {
        AppleInventory appleInventory = new AppleInventory();
        List<Apple> inventory = appleInventory.getInventory();

        inventory.forEach(System.out::println);
    }

    private static <T> void print(List<T> list, Consumer<T> consumer) {
        list.forEach(consumer);
    }

}
