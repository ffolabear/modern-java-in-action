package chapter1;

import common.Apple;
import common.Color;
import common.Inventory;
import common.Util;

import java.util.ArrayList;
import java.util.List;

import static common.Color.*;

public class DefaultFiltering {

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

        Util.printList(sortingResult);
    }


}
