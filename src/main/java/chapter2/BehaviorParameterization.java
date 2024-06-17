package chapter2;

import static common.Color.*;

import common.Apple;
import common.Color;
import common.AppleInventory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BehaviorParameterization {

    static AppleInventory inventory = new AppleInventory();

    public static void main(String[] args) {
        List<Apple> apples = inventory.getInventory();
        List<Apple> appleList = filterApples(apples, new AppleRedAndHeavyPredicate());
        System.out.println("apples = " + apples);
        System.out.println("appleList = " + appleList);

        List<Apple> appleList2 = filterApples(apples, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equals(GREEN.getColor());
            }
        });

        List<Apple> appleList3 = filterApples(apples, apple -> apple.getColor().equals(GREEN.getColor()));
        ComparingParameter.filter(inventory.getInventory(), (Apple apple) -> RED.getColor().equals(apple.getColor()));

        inventory.getInventory().sort((o1, o2) -> o1.getWeight() - o2.getWeight());
    }

    public interface ApplePredicate {
        boolean test(Apple apple);
    }

    //Predicate 함수를 재정의 -> 전략
    class AppleHeavyWeightPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    //Predicate 함수를 재정의 -> 전략
    class AppleGreenColorPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return GREEN.getColor().equals(apple.getColor());
        }
    }

    class AppleRedHeavyPredicate implements ApplePredicate{
        @Override
        public boolean test(Apple apple) {
            return RED.getColor().equals(apple.getColor()) && apple.getWeight() > 150;
        }
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    static class AppleRedAndHeavyPredicate implements ApplePredicate{
        @Override
        public boolean test(Apple apple) {
            return GREEN.getColor().equals(apple.getColor())
                    && apple.getWeight() > 150;
        }
    }



}
