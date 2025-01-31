package christmas.domain;

import christmas.util.ErrorConstant;

import java.util.Arrays;


public enum Menu {
    MUSHROOM_SOUP("애피타이저", "양송이스프", 6000),
    TAPAS("애피타이저", "타파스", 5500),
    CAESAR_SALAD("애피타이저", "시저샐러드", 8000),

    T_BONE_STEAK("메인","티본스테이크", 55000),
    BARBECUERIBS("메인","바비큐립", 54000),
    SEAFOOD_PASTA("메인","해산물파스타", 35000),
    CHRISTMAS_PASTA("메인","크리스마스파스타", 25000),

    CHOCO_CAKE("디저트", "초코케이크", 15000),
    ICECREAM("디저트", "아이스크림", 5000),

    ZERO_COKE("음료", "제로콜라", 3000),
    RED_WINE("음료", "레드와인", 60000),
    CHAMPAGNE("음료", "샴페인", 25000);

    private String type;
    private String name;
    private Integer price;

    Menu(String type, String name,Integer price){
        this.type=type;
        this.name=name;
        this.price=price;
    }
    public static Menu find(String input) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.name.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorConstant.INVALIDATE_ORDER));
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
}
