package chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static chapter1.Color.*;


public class ModernFiltering {

    static Util util = new Util();

    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        List<Apple> appleInventory = inventory.getInventory();

        //코드 넘겨주기
        List<Apple> greenSortingResult = filterApples(appleInventory, ModernFiltering::isGreenApple);
        util.printList(greenSortingResult);

        System.out.println();

        List<Apple> weightSortingResult = filterApples(appleInventory, ModernFiltering::isHeavyApple);
        util.printList(weightSortingResult);

        System.out.println("\n========= 메서드 전달에서 람다로 =========\n");
        lambda(appleInventory);
    }

    public static void lambda(List<Apple> inventory) {

        List<Apple> greenSortingResult = filterApples(inventory, (Apple a) -> GREEN.getColor().equals(a.getColor()));
        util.printList(greenSortingResult);

        System.out.println();

        List<Apple> weightSortingResult = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        util.printList(weightSortingResult);
    }

    public static boolean isGreenApple(Apple apple) {
        return GREEN.getColor().equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    //Predicate 는 인수로 값을 받아 true / false 를 리턴하는 함수
    public interface Predicate<T> {
        boolean test(T t);
    }

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        //사과가 p가 제시하는 조건에 맞는가??
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

}
