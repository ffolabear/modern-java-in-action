package chapter2;

import common.Apple;
import common.Color;
import common.AppleInventory;

import java.util.ArrayList;
import java.util.List;

public class RequirementsApply {

    static AppleInventory inventory = new AppleInventory();

    public static void main(String[] args) {
        List<Apple> apples = inventory.getInventory();
    }

    //첫번째 시도
    //녹색 사과 필터링
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (Color.GREEN.getColor().equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    //두번째 시도
    //색을 파라미터화
    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    //무게일때도 반영
    public static List<Apple> filterApplesByColor(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }


    //세번째 시도
    //가능한 모든 속성으로 필터링 -> 형편없는 코드
    //flag 는 왜 존재하는가?
    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((flag && apple.getColor().equals(color.getColor())) || (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }

}
