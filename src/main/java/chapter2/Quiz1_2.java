package chapter2;

import common.Apple;
import common.Inventory;

import java.util.List;

public class Quiz1_2 {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        List<Apple> appleInventory = inventory.getInventory();

        prettyPrintApple1(appleInventory);
        System.out.println();
        prettyPrintApple2(appleInventory);
    }

    public static void prettyPrintApple1(List<Apple> inventory) {
        AppleWeightFormatter formatter = new AppleWeightFormatter();
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    public static void prettyPrintApple2(List<Apple> inventory) {
        AppleColorFormatter formatter = new AppleColorFormatter();
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    public interface AppleFormatter {
        String accept(Apple apple);

    }
}

class AppleWeightFormatter implements Quiz1.AppleFormatter {

    @Override
    public String accept(Apple a) {
        String character = "";
        if (a.getWeight() > 150) {
            character = "heavy apple";
        } else {
            character = "light apple";
        }
        return "Apple is " + character;
    }

}

class AppleColorFormatter implements Quiz1.AppleFormatter {
    @Override
    public String accept(Apple a) {
        return "Current apple is " + a.getColor() + " apple";
    }
}