package christmas.domain;

import christmas.util.ErrorConstant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    public void testInvalidVisitDateNotANumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Customer("abc");
        });

        assertEquals(ErrorConstant.INVALIDATE_DATE, exception.getMessage());
    }

    @Test
    public void testInvalidVisitDateOutOfRange() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Customer("35");
        });

        assertEquals(ErrorConstant.INVALIDATE_DATE, exception.getMessage());
    }

}