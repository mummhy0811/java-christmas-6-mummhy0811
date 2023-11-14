package christmas.domain;

import christmas.util.Constant;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @Test
    public void testValidOrder() {
        Order order = new Order("양송이스프-1,티본스테이크-1,제로콜라-2");

        HashMap<Menu, Integer> menuAndQuantity = order.getMenuAndQuantity();

        assertEquals(1, menuAndQuantity.get(Menu.MUSHROOM_SOUP));
        assertEquals(1, menuAndQuantity.get(Menu.T_BONE_STEAK));
        assertEquals(2, menuAndQuantity.get(Menu.ZERO_COKE));
    }

    @Test
    public void testInvalidOrderDuplicateMenu() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Order("타파스-1,타파스-1");
        });
    }

    @Test
    public void testInvalidOrderForm() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Order("타파스 1개, 제로콜라 2개");
        });
    }

    @Test
    public void testInvalidOrderNotOnlyDrinks() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Order("레드와인-2,제로콜라-1");
        });
    }

    @Test
    public void testCalcTotalOrderAmount() {
        Order order = new Order("타파스-1,제로콜라-1");

        assertEquals(8500, order.calcTotalOrderAmount());
    }

    @Test
    public void testOverMinimum() {
        Order order = new Order("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");

        assertEquals(true, order.overMinimum());
    }

    @Test
    public void testNotOverMinimum() {
        Order order = new Order("타파스-1,제로콜라-1");

        assertEquals(false, order.overMinimum());
    }

    @Test
    public void testCalcDayDiscount() {
        Order order = new Order("티본스테이크-1,바비큐립-3,초코케이크-2,제로콜라-1");

        assertEquals(4 * Constant.DAY_DISCOUNT, order.calcDayDiscount("메인"));
        assertEquals(2 * Constant.DAY_DISCOUNT, order.calcDayDiscount("디저트"));
    }

    @Test
    public void testOverGiveAwayMinimum() {
        Order order = new Order("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");

        assertTrue(order.overGiveAwayMinimum());
    }

    @Test
    public void testNotOverGiveAwayMinimum() {
        Order order = new Order("타파스-1,제로콜라-1");

        assertFalse(order.overGiveAwayMinimum());
    }
}