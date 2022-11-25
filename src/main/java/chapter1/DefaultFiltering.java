package chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static chapter1.Color.*;

public class DefaultFiltering {

    static Util util = new Util();

    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(
                new Apple(80, GREEN.getColor()),
                new Apple(155, GREEN.getColor()),
                new Apple(120, RED.getColor()),
                new Apple(170, BLUE.getColor())
        );

        defaultSorting(inventory);

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
