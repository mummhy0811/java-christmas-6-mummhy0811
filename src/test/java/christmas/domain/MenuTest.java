package christmas.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    @Test
    public void testFindValidMenu() {
        Menu foundMenu = Menu.find("아이스크림");

        assertEquals("아이스크림", foundMenu.getName());
        assertEquals(Integer.valueOf(5000), foundMenu.getPrice());
        assertEquals("디저트", foundMenu.getType());
    }

    @Test()
    public void testFindInvalidMenu() {
        assertThrows(IllegalArgumentException.class, () -> {
            Menu.find("없는메뉴");
        });
    }

}