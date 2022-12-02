package chapter2;

import common.Apple;
import common.Color;
import common.Inventory;

import java.util.List;

public class BehaviorParameterization {

    static Inventory inventory = new Inventory();

    public static void main(String[] args) {
        List<Apple> apples = inventory.getInventory();
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
            return Color.GREEN.getColor().equals(apple.getColor());
        }
    }

    class AppleRedHeavyPredicate implements ApplePredicate{
        @Override
        public boolean test(Apple apple) {
            return Color.RED.getColor().equals(apple.getColor()) && apple.getWeight() > 150;
        }
    }

    public interface ApplePredicate {
        boolean test(Apple apple);

    }


//    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
//        List<Apple> result = new ArrayList<>();
//        for (Apple apple : inventory) {
//            if (p.test(apple)) {
//                result.add(apple);
//            }
//        }
//        return result;
//    }

}
