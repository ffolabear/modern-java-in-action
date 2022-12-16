package chapter2;

import common.Apple;
import common.Color;
import common.Inventory;

import java.util.List;

public class AnonymousClass {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        List<Apple> apples = inventory.getInventory();

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

    public class FilteringApples {

    }

    public interface ApplePredicate {
        boolean test(Apple apple);

    }

}

