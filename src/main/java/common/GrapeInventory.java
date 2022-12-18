package common;

import java.util.Arrays;
import java.util.List;

import static common.Color.*;

public class GrapeInventory {

    List<Grape> inventory;

    public GrapeInventory() {
        inventory = Arrays.asList(
                new Grape(80, GREEN.getColor()),
                new Grape(155, GREEN.getColor()),
                new Grape(120, RED.getColor()),
                new Grape(170, BLUE.getColor())
        );

    }

    public List<Grape> getInventory() {
        return inventory;
    }

}
