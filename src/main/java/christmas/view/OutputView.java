package christmas.view;

import christmas.constant.Constant;
import christmas.domain.Menu;

import java.text.MessageFormat;
import java.util.HashMap;

public class OutputView {
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
}
