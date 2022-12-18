package chapter1;

import common.Apple;
import common.AppleInventory;
import common.Util;

import java.util.ArrayList;
import java.util.List;

import static common.Color.*;

public class DefaultFiltering {

    public static void main(String[] args) {

        AppleInventory inventory = new AppleInventory();
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
