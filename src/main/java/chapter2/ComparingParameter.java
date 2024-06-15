package chapter2;

import static common.Color.GREEN;

import chapter2.BehaviorParameterization.ApplePredicate;
import common.Apple;
import common.Color;
import java.util.ArrayList;
import java.util.List;

public class ComparingParameter {

    //첫번째 시도 : 녹색 사과 필터링
    public List<Apple> filteringGreenApple(List<Apple> inventory) {
        List<Apple> sortingResult = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(GREEN.getColor())) {
                sortingResult.add(apple);
            }
        }
        return sortingResult;
    }

    //두번째 시도 : 색을 파라미터화
    public List<Apple> filterAppleByColor(List<Apple> inventory, Color color) {
        List<Apple> sortingResult = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color.getColor())) {
                sortingResult.add(apple);
            }
        }
        return sortingResult;
    }

    //세번째 시도 : 가능한 모든 속성으로 필터링
    public List<Apple> filterApples(List<Apple> inventory, Color color, int weight, Boolean flag) {
        List<Apple> sortingResult = new ArrayList<>();
        for (Apple apple : inventory) {
            if (flag && apple.getColor().equals(color.getColor()) && apple.getWeight() > weight) {
                sortingResult.add(apple);
            }
        }
        return sortingResult;
    }

    //네번째 시도 : 추상적 조건으로 필터링
    public List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> sortingResult = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                sortingResult.add(apple);
            }
        }
        return sortingResult;
    }

}
