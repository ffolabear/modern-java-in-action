package chapter2;

import common.*;

import java.util.ArrayList;
import java.util.List;

public class AnonymousClass {

    public static void main(String[] args) {

        List<Apple> appleInventory = new AppleInventory().getInventory();
        List<Orange> orangeInventory = new OrangeInventory().getInventory();
        List<Grape> grapeInventory = new GrapeInventory().getInventory();

        List<Apple> anonymousFilter1 = filteringApples(appleInventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return Color.RED.getColor().equals(apple.getColor());
            }
        });

        List<Apple> appleAnonymousFilter = filteringApples(
                appleInventory, (Apple apple) -> Color.RED.getColor().equals(apple.getColor()));

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

