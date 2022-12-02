package chapter2;

import common.Apple;
import common.Inventory;

import java.util.List;

public class Quiz1 {

    static Inventory inventory = new Inventory();

    public static void main(String[] args) {
        List<Apple> apples = inventory.getInventory();


    }

    public class AppleFancyFormatter implements AppleFormatter {
        @Override
        public String accept(Apple a) {
            String character = a.getWeight() > 150 ? "heavy" : "light";
            return character + "apple";
        }
    }


    public void prettyPrintApple(List<Apple> inventory) {
        for (Apple a : inventory) {

        }
    }

    public interface AppleFormatter{
        String accept(Apple a);
    }

}
