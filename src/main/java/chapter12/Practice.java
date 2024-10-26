package chapter12;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class Practice {

    public static void main(String[] args) {
        localDateExample();
    }

    private static void localDateExample() {
        LocalDate date = LocalDate.now();
        int year = date.get(ChronoField.YEAR);
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);
        System.out.println(year + " " + month + " " + day);
    }

}
