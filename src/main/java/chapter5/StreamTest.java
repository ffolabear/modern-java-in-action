package chapter5;

import static chapter4.Dish.Type.FISH;
import static chapter4.Dish.Type.MEAT;
import static chapter4.Dish.Type.OTHER;

import chapter4.Dish;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    private static List<Dish> menu;

    public static void main(String[] args) {

        menu = Arrays.asList(
                new Dish("pork", false, 800, MEAT),
                new Dish("beef", false, 700, MEAT),
                new Dish("chicken", false, 400, MEAT),

                new Dish("french fries", true, 530, OTHER),
                new Dish("rice", true, 350, OTHER),
                new Dish("season fruit", true, 120, OTHER),

                new Dish("pizza", true, 550, OTHER),
                new Dish("pizza", true, 550, OTHER),
                new Dish("pizza", true, 550, OTHER),
                new Dish("pizza", true, 550, OTHER),
                new Dish("pizza", true, 550, OTHER),
                new Dish("pizza", true, 550, OTHER),
                new Dish("pizza", true, 550, OTHER),
                new Dish("pizza", true, 550, OTHER),
                new Dish("pizza", true, 550, OTHER),
                new Dish("pizza", true, 550, OTHER),
                new Dish("pizza", true, 550, OTHER),
                new Dish("prawns", false, 300, FISH),
                new Dish("salmon", false, 450, FISH)
        );

//        filteringByPredicate();
//        filteringByDistinct();
//        System.out.println("==============");
//        streamSlicing1();
//        System.out.println("==============");
//        streamSlicing2();
//        System.out.println("==============");
//        streamLimit();
//        System.out.println("==============");
//        streamSkip();
//        System.out.println("==============");
//        streamMapping();
//        System.out.println("==============");
        streamFlatMapping();
    }

    private static void filteringByPredicate() {
        menu.stream()
                .filter(dish -> dish.getCalories() < 500)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private static void filteringByDistinct() {

        menu.stream()
                .filter(dish -> dish.getName().equals("pizza"))
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private static void streamSlicing1() {
        menu.stream()
                .takeWhile(dish -> dish.getName().equals("pork"))
                .forEach(System.out::println);
    }

    private static void streamSlicing2() {
        menu.stream()
                .dropWhile(dish -> dish.getType() == MEAT)
                .forEach(System.out::println);
    }

    private static void streamLimit() {
        menu.stream()
                .limit(5)
                .forEach(System.out::println);
    }

    private static void streamSkip() {
        menu.stream()
                .skip(5)
                .forEach(System.out::println);
    }

    private static void streamMapping() {
        menu.stream()
                .map(dish -> dish.getName())
                .forEach(System.out::println);
    }

    private static void streamFlatMapping() {
        List<String> words = Arrays.asList("Apple", "Banana", "Orange", "Pie", "Water");
        List<String> collect = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println(collect);
    }



}
