package christmas.util;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayCalc {
    public static int calcDay(int visitDate){

        LocalDate date = LocalDate.of(2021, 12, visitDate);

        DayOfWeek dayOfWeek = date.getDayOfWeek();

        return dayOfWeek.getValue();

    }
}
