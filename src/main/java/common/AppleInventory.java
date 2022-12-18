package common;

import java.util.Arrays;
import java.util.List;

import static common.Color.*;


public class AppleInventory {

    List<Apple> inventory;

    public AppleInventory() {
        inventory = Arrays.asList(
                new Apple(80, GREEN.getColor()),
                new Apple(155, GREEN.getColor()),
                new Apple(120, RED.getColor()),
                new Apple(170, BLUE.getColor())
        );

    }

    private void checkFruit(Object o) {
    }

    public List<Apple> getInventory() {
        return inventory;
    }

}
