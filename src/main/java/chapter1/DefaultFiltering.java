package chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static chapter1.Color.*;

public class DefaultFiltering {

    static Util util = new Util();

    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        List<Apple> appleInventory = inventory.getInventory();
        defaultSorting(appleInventory);

    }

    public static void defaultSorting(List<Apple> inventory) {
        List<Apple> sortingResult = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(GREEN.getColor())) {
                sortingResult.add(apple);
            }
        }

        util.printList(sortingResult);
    }


}
