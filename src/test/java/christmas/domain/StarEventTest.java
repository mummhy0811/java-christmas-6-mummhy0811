package christmas.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StarEventTest {
    @Test
    public void testDayDiscount() {
        StarEvent starEvent = new StarEvent();

        assertEquals(1000, starEvent.dayDiscount(3));
        assertEquals(1000, starEvent.dayDiscount(25));
        assertEquals(0, starEvent.dayDiscount(27));

    }
}