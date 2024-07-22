package chapter6;

import static chapter4.Dish.Type.FISH;
import static chapter4.Dish.Type.MEAT;
import static chapter4.Dish.Type.OTHER;
import static java.util.stream.Collectors.groupingBy;

import chapter4.Dish;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector.Characteristics;
import java.util.stream.Collectors;

public class CollectorTest {

    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, MEAT),
                new Dish("beek", false, 700, MEAT),
                new Dish("chicken", false, 400, MEAT),

                new Dish("french fries", true, 530, OTHER),
                new Dish("rice", true, 350, OTHER),
                new Dish("season fruit", true, 120, OTHER),

                new Dish("pizza", true, 550, OTHER),
                new Dish("prawns", false, 300, FISH),
                new Dish("salmon", false, 450, FISH)
        );

        ToListCollector<Dish> newCollector = new ToListCollector<>();

        //Collectors.toList 와 비슷
        List<Dish> collect = menu.stream()
                .collect(newCollector);
        System.out.println(collect);

        //accumulator 를 사용한 요소 추가
        List<Dish> additionalMenu = new ArrayList<>();
        Dish coffee = new Dish("coffee", false, 800, OTHER);
        Dish tea = new Dish("tea", false, 700, OTHER);
        Dish beer = new Dish("beer", false, 400, OTHER);
        additionalMenu.add(coffee);
        additionalMenu.add(tea);
        additionalMenu.add(beer);

        List<Dish> newMenu = new ArrayList<>();
        for (Dish dish : additionalMenu) {
            newCollector.accumulator().accept(newMenu, dish);
        }
        System.out.println(newMenu);

        //combiner 를 사용한 합치기
        newMenu = new ArrayList<>();
        List<Dish> apply = newCollector.combiner().apply(newMenu, additionalMenu);
        System.out.println(apply);

        //finisher
        newMenu = new ArrayList<>();
        List<Dish> finisher = newCollector.finisher().apply(newMenu);
        System.out.println(finisher);

        //characteristics
//        newCollector.characteristics().add(Characteristics.CONCURRENT);
    }

}
