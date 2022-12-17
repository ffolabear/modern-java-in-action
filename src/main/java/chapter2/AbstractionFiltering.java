package chapter2;

import common.Apple;
import common.Color;
import common.Inventory;

import java.util.ArrayList;
import java.util.List;

public class AbstractionFiltering {


    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        List<Apple> appleInventory = inventory.getInventory();
        List<Apple> redApples = filter(appleInventory, (Apple apple) -> Color.RED.getColor().equals(apple.getColor()));

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
