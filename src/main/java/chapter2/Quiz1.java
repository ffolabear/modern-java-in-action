package chapter2;

import chapter2.BehaviorParameterization.ApplePredicate;
import common.Apple;
import common.AppleInventory;

import java.util.List;

public class Quiz1 {

    static AppleInventory inventory = new AppleInventory();

    public static void main(String[] args) {
        List<Apple> appleInventory = inventory.getInventory();
        String result = prettyPrintApple(appleInventory, new PrettyPrintApple());
        System.out.println(result);
    }


    public static String prettyPrintApple(List<Apple> appleInventory, ApplePrintPredicate p) {
        StringBuilder result = new StringBuilder();
        for (Apple apple : inventory.getInventory()) {
            result.append(p.print(apple));
            result.append("\n");
        }
        return result.toString();
    }

    public interface ApplePrintPredicate {
        String print(Apple apple);
    }

    static class PrettyPrintApple implements ApplePrintPredicate{

        @Override
        public String print(Apple apple) {
            return apple.toString();
        }
    }

}
