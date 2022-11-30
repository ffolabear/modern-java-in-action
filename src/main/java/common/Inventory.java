package common;

import java.util.Arrays;
import java.util.List;

import static chapter1.Color.*;

public class Inventory {

    List<Apple> inventory;

    public Inventory() {

        inventory = Arrays.asList(
                new Apple(80, GREEN.getColor()),
                new Apple(155, GREEN.getColor()),
                new Apple(120, RED.getColor()),
                new Apple(170, BLUE.getColor())
        );

    }

    public List<Apple> getInventory() {
        return inventory;
    }

}
