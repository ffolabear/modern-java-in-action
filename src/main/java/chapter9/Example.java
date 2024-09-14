package chapter9;

import static common.Dish.Type.FISH;
import static common.Dish.Type.MEAT;
import static common.Dish.Type.OTHER;
import static java.util.stream.Collectors.*;

import common.CaloricLevel;
import common.Dish;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example {

    private static List<Dish> menu;

    public static void main(String[] args) {

        menu = Arrays.asList(
                new Dish("pork", false, 300, MEAT),
                new Dish("beef", false, 350, MEAT),
                new Dish("chicken", false, 370, MEAT),

                new Dish("rice", true, 650, OTHER),
                new Dish("season fruit", true, 680, OTHER),

                new Dish("french fries", true, 800, OTHER),
                new Dish("pizza", true, 900, OTHER),
                new Dish("fried chicken", true, 900, OTHER),
                new Dish("Donut", true, 900, OTHER)
        );

    }

    private static void compareRefactoring() {
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel1 = menu.stream()
                .collect(groupingBy(dish -> {
                    if (dish.getCalories() <= 400) {
                        return CaloricLevel.DIET;
                    } else if (dish.getCalories() <= 700) {
                        return CaloricLevel.NORMAL;
                    } else {
                        return CaloricLevel.FAT;
                    }
                }));

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel2 = menu.stream()
                .collect(groupingBy(Dish::getCaloricLevel));

        menu.sort((Dish dish1, Dish dish2) -> dish1.getName().compareTo(dish2.getName()));
        menu.sort(Comparator.comparing(Dish::getCalories));

        Integer totalCalories1 = menu.stream().map(Dish::getCalories).reduce(0, (c1, c2) -> c1 + c2);
        Integer totalCalories2 = menu.stream().collect(summingInt(Dish::getCalories));
    }

}
