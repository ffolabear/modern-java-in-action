package chapter3;

import common.Apple;
import common.AppleInventory;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {

        AppleInventory appleInventory = new AppleInventory();
        List<Apple> inventory = appleInventory.getInventory();

        List<ApplePie> applePieList = map(inventory, (apple -> {
            return new ApplePie(apple);
        }));
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }

    static class ApplePie {

        private String color;

        public ApplePie(Apple apple) {
            this.color = apple.getColor();
        }

    }

}
