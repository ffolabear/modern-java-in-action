package chapter2;

import common.Apple;
import common.Inventory;

import java.util.List;

public class Quiz1 {

    static Inventory inventory = new Inventory();

    public static void main(String[] args) {
        List<Apple> apples = inventory.getInventory();
        prettyPrintApple(inventory.getInventory(), new AppleFancyFormatter());

    }

    public static class AppleFancyFormatter implements AppleFormatter {
        @Override
        public String accept(Apple a) {
            String character = a.getWeight() > 150 ? "heavy" : "light";
            return character + "apple";
        }
    }

    public class AppleSimpleFormatter implements AppleFormatter {
        @Override
        public String accept(Apple a) {
            return a.getWeight() + "g";
        }
    }


    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple a : inventory) {
            String output = formatter.accept(a);
            System.out.println(output);
        }
    }

    public interface AppleFormatter {
        String accept(Apple a);
    }

}
