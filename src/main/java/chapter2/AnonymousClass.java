package chapter2;

import common.Apple;
import common.Color;
import common.Inventory;

import java.util.ArrayList;
import java.util.List;

public class AnonymousClass {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        List<Apple> appleInventory = inventory.getInventory();


        List<Apple> anonymousFilter1 = filteringApples(appleInventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return Color.RED.getColor().equals(apple.getColor());
            }
        });

        List<Apple> anonymousFilter2 = filteringApples(appleInventory, (Apple apple) -> Color.RED.getColor().equals(apple.getColor()));

    }

    public class AppleHeavyWeightPredicate implements BehaviorParameterization.ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    public class AppleGreenColorPredicate implements BehaviorParameterization.ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return Color.GREEN.getColor().equals(apple.getColor());
        }
    }

    public static List<Apple> filteringApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


    public interface ApplePredicate {
        boolean test(Apple apple);

    }

}

