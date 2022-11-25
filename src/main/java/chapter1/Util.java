package chapter1;

import java.util.List;

public class Util {

    public void printList(List<Apple> sortingResult) {
        for (Apple apple : sortingResult) {
            System.out.println("apple : " + "weight = " + apple.getWeight() + " / color = " + apple.getColor());
        }

    }

}
