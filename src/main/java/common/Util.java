package common;

import java.util.List;

public class Util {

    public static void printList(List<common.Apple> sortingResult) {
        for (Apple apple : sortingResult) {
            System.out.println("apple : " + "weight = " + apple.getWeight() + " / color = " + apple.getColor());
        }
    }

}
