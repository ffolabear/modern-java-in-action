package chapter1;

import static common.Color.*;

import common.Apple;
import common.Color;
import java.util.ArrayList;
import java.util.List;

public class ModernFiltering {

    public boolean isGreenApple(Apple apple) {
        return GREEN.getColor().equals(apple.getColor());
    }

    public boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public interface Predicate<T> {
        boolean test(T t);
    }

    public List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
