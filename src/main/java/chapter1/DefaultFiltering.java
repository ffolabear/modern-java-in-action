package chapter1;

import static common.Color.GREEN;

import common.Apple;
import java.util.ArrayList;
import java.util.List;

public class DefaultFiltering {


    public List<Apple> filteringGreenApple(List<Apple> inventory) {
        List<Apple> sortingResult = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(GREEN.getColor())) {
                sortingResult.add(apple);
            }
        }
        return sortingResult;
    }

}
