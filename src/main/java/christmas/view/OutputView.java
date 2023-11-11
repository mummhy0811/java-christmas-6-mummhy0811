package christmas.view;

import christmas.util.Constant;
import christmas.domain.Menu;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.HashMap;

public class OutputView {
    private static final DecimalFormat decimalFormat = new DecimalFormat(Constant.MONEY_OUTPUT_FORMAT);

    public static void printError(String e){
        System.out.println(e);
    }

    public static void printOpening(){
        System.out.println(Constant.OPENING_TXT);
    }

    public static void eventTxt(Integer date){
        System.out.println((MessageFormat.format(Constant.SHOW_EVENT, date)));
        System.out.println();
    }

    public static void printOrderedMenu(HashMap<Menu, Integer> menuAndQuantity){
        System.out.println(Constant.ORDERED_MENU);
        for(Menu m : menuAndQuantity.keySet()){ //저장된 key값 확인
            System.out.println(m.getName()+" "+ menuAndQuantity.get(m)+"개");
        }

    }
    public static void printAmountBeforeDiscount(int price){
        System.out.println();
        System.out.println(Constant.AMOUNT_BEFORE_DISCOUNT);
        System.out.println(decimalFormat.format(price)+"원");
    }

    public static void printGiftMenu(String menu){
        System.out.println();
        System.out.println(Constant.GIVEAWAY_MENU_TXT);
        System.out.println(menu);
    }

    public static void printDiscountList(HashMap<String, String> events, Boolean b){
        System.out.println();
        System.out.println(Constant.DISCOUNT_LIST_TXT);
        if(b){
            //todo
            return;
        }
        System.out.println(Constant.NOTHING);

    }

    public static void printTotalDiscountAmount(int price, Boolean b){
        System.out.println();
        System.out.println(Constant.TOTAL_DISCOUNT_AMOUNT);
        if(b){
            System.out.println("-"+decimalFormat.format(price));
            return;
        }
        System.out.println(Constant.NOTHING);
    }
    public static void printAmountAfterDiscount(int price){
        System.out.println();
        System.out.println(Constant.AMOUNT_AFTER_DISCOUNT);
        System.out.println(decimalFormat.format(price)+"원");
    }
    public static void printBadge(String badge){
        System.out.println();
        System.out.println(Constant.DECEMBER_BADGE);
        System.out.println(badge);
    }
}
