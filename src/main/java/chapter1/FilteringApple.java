package chapter1;

import common.Apple;
import common.AppleInventory;
import java.util.List;

public class FilteringApple {

    private static final AppleInventory appleInventory = new AppleInventory();

    public static void main(String[] args) {
        ModernFiltering modernFiltering = new ModernFiltering();
        DefaultFiltering defaultFiltering = new DefaultFiltering();

        List<Apple> apples = modernFiltering.filterApples(appleInventory.getInventory(), Apple::isGreenApple);
        System.out.println("apples = " + apples);
    }


}
