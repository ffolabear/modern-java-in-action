package chapter3;

import common.Apple;
import common.Color;
import java.nio.file.DirectoryStream.Filter;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;

public class LambdaExample {

    public static void main(String[] args) throws Exception {

        Function<String, Integer> stringIntegerFunction = (String s) -> s.length();
        System.out.println(stringIntegerFunction.apply("hello"));

        Predicate<Apple> applePredicate = (Apple a) -> a.getWeight() > 150;
        System.out.println(applePredicate.test(new Apple(200, Color.RED.getColor())));

        IntBinaryOperator intBinaryOperator = (int x, int y) -> {
            System.out.println("Result : ");
            System.out.println(x + y);
            return x + y;
        };
        intBinaryOperator.applyAsInt(10, 20);

        Callable<Integer> integerCallable = () -> 42;
        System.out.println(integerCallable.call());

//        (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
    }

}
