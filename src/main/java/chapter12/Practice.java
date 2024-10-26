package chapter12;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.util.Locale;

public class Practice {

    public static void main(String[] args) {
        localDateExample();
        instantExample();
        zoneIdExample();
    }

    private static void localDateExample() {
        LocalDate date = LocalDate.now();
        int year = date.get(ChronoField.YEAR);
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);
        System.out.println(year + " " + month + " " + day);
    }

    private static void localTimeExample() {
        LocalTime time = LocalTime.now();
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
    }

    private static void localDateTimeExample() {
        LocalTime time = LocalTime.now();
        LocalDate date = LocalDate.now();
        LocalDateTime dt1 = LocalDateTime.of(2022, Month.APRIL, 21, 13, 14, 15);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(11,12,13);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);
    }

    private static void instantExample() {
        Instant now = Instant.now();
        LocalTime time = LocalTime.now();
        Instant instant = Instant.ofEpochSecond(44 * 365 * 86400);
        Duration d1 = Duration.between(LocalTime.of(13, 45, 10), time);
        Duration d2 = Duration.between(instant, now);

        System.out.println(d1);
        System.out.println(d2);
    }
    private static void localDateDirective() {
        LocalDate dt1 = LocalDate.of(2022, 9, 21);
        LocalDate dt2 = dt1.withYear(2011);
        LocalDate dt3 = dt2.withDayOfMonth(25);
        LocalDate dt4 = dt3.with(ChronoField.MONTH_OF_YEAR, 2);
    }

    private static void localDateDeclarative() {
        LocalDate dt1 = LocalDate.of(2022, 9, 21);
        LocalDate dt2 = dt1.plusWeeks(1);
        LocalDate dt3 = dt2.minusYears(6);
        LocalDate dt4 = dt3.plus(6, ChronoUnit.MONTHS);
    }

    private static void formatterExample() {
        LocalDate dt1 = LocalDate.of(2022, 9, 21);
        String s1 = dt1.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = dt1.format(DateTimeFormatter.ISO_LOCAL_DATE);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String format = dt1.format(formatter);
        LocalDate dt2 = LocalDate.parse(format, formatter);

        DateTimeFormatter complexFormatter = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.ITALIAN);
    }

    private static void zoneIdExample() {
        LocalDateTime dt1 = LocalDateTime.of(2022, 9, 21, 13, 14, 15);
        ZoneId zoneId = ZoneId.of("Asia/Seoul");
        System.out.println(zoneId);

        ZoneOffset zoneOffset = ZoneOffset.of("+08:00");
        OffsetDateTime offsetDateTime = OffsetDateTime.of(dt1, zoneOffset);
    }

    private void chronoCalendarExample() {
        LocalDate dt1 = LocalDate.of(2022, 9, 21);
        JapaneseDate japaneseDate = JapaneseDate.from(dt1);

        Chronology chronology = Chronology.ofLocale(Locale.ITALIAN);
        ChronoLocalDate now = chronology.dateNow();

    }

}
