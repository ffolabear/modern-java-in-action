package chapter2;

import common.*;

import java.util.ArrayList;
import java.util.List;

public class AbstractionFiltering {


    public static void main(String[] args) {
        AppleInventory inventory = new AppleInventory();

        List<Apple> appleInventory = new AppleInventory().getInventory();
        List<Orange> orangeInventory = new OrangeInventory().getInventory();
        List<Grape> grapeInventory = new GrapeInventory().getInventory();

        List<Apple> appleAbstractFilter = filter(appleInventory,
                (Apple apple) -> Color.RED.getColor().equals(apple.getColor()));

        List<Orange> orangeAbstractFilter = filter(orangeInventory,
                (Orange orange) -> Color.GREEN.getColor().equals(orange.getColor()));

        List<Grape> grapeAbstractFilter = filter(grapeInventory,
                (Grape grape) -> Color.GREEN.getColor().equals(grape.getColor()));

    }

    public interface Predicate<T> {
        boolean test(T t);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

}
