package chapter5;

import static chapter4.Dish.Type.FISH;
import static chapter4.Dish.Type.MEAT;
import static chapter4.Dish.Type.OTHER;

import chapter4.Dish;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
        streamSlicing2();
//        System.out.println("==============");
//        streamLimit();
//        System.out.println("==============");
//        streamSkip();
//        System.out.println("==============");
//        streamMapping();
//        System.out.println("==============");
//        streamFlatMapping();
//        streamFindAny();
//        streamFindAll();
//        streamFindNone();
//        streamReduce();
//        streamReduceOptional();
//        streamReduceMaxMin();
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

    private static void streamFindAny() {
        boolean anyMatch = menu.stream()
                .anyMatch(dish -> dish.getName().equals("pork"));
        System.out.println(anyMatch);
    }

    private static void streamFindAll() {
        boolean anyMatch = menu.stream()
                .allMatch(dish -> dish.getCalories() > 100);
        System.out.println(anyMatch);
    }

    private static void streamFindNone() {
        boolean anyMatch = menu.stream()
                .allMatch(dish -> dish.getCalories() > 1000);
        System.out.println(anyMatch);
    }

    private static void streamReduce() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(1, (a, b) -> a * b);
        System.out.println(reduce);
    }

    private static void streamReduceOptional() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> reduce = list.stream().reduce((a, b) -> a * b);
        System.out.println(reduce.get());
    }

    private static void streamReduceMaxMin() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> reduce = list.stream().reduce(Integer::sum);
        list.stream().reduce((a, b) -> a + b);
        System.out.println(reduce + " " + reduce);
    }

    private static void pythagoras() {
        Stream<double[]> pythagorasTriples = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(
                                b -> new double[]{a, b, (int) Math.sqrt(a * a + b * b)})
                        .filter(t -> t[2] % 1 == 0));
    }

    private static void test() {
        menu.stream()
                .mapToInt(dish -> dish.getCalories());
    }

}
