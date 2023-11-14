package christmas.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DDayEventTest {
    @Test
    public void testDDayDiscountEvent() {
        DDayEvent dDayEvent = new DDayEvent();

        int discountEvent = dDayEvent.dDayDiscount(25);

        assertEquals(3400, discountEvent);
    }

    @Test
    public void testDDayDiscountAfterEvent() {
        DDayEvent dDayEvent = new DDayEvent();

        int discountAfterEvent = dDayEvent.dDayDiscount(30);

        assertEquals(0, discountAfterEvent);
    }

}