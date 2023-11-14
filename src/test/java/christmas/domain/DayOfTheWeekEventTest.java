package christmas.domain;

import christmas.util.Constant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DayOfTheWeekEventTest {
    @Test
    public void testCheckWeekend() {
        DayOfTheWeekEvent event = new DayOfTheWeekEvent();

        boolean Friday = event.checkWeekend(1);
        boolean Saturday = event.checkWeekend(2);
        boolean Sunday = event.checkWeekend(3);

        assertTrue(Friday);
        assertTrue(Saturday);
        assertFalse(Sunday);
    }

    @Test
    public void testDayDiscountWeekend() {
        DayOfTheWeekEvent calculator = new DayOfTheWeekEvent();

        String friday = calculator.dayDiscount(8);
        String saturday = calculator.dayDiscount(9);

        assertEquals(Constant.MENU_TYPE_MAIN, friday);
        assertEquals(Constant.MENU_TYPE_MAIN, saturday);
    }

    @Test
    public void testDayDiscountWeekday() {
        DayOfTheWeekEvent calculator = new DayOfTheWeekEvent();

        String weekday = calculator.dayDiscount(10);

        assertEquals(Constant.MENU_TYPE_DESSERT, weekday);
    }

}