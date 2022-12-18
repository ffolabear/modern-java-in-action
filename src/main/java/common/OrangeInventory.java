package common;

import java.util.Arrays;
import java.util.List;

import static common.Color.*;

public class OrangeInventory {

    List<Orange> inventory;

    public OrangeInventory() {
        inventory = Arrays.asList(
                new Orange(80, GREEN.getColor()),
                new Orange(155, GREEN.getColor()),
                new Orange(120, RED.getColor()),
                new Orange(170, BLUE.getColor())
        );

    }

    public List<Orange> getInventory() {
        return inventory;
    }

}
