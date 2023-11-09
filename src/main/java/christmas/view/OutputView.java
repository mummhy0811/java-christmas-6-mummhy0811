package christmas.view;

import christmas.constant.Constant;

public class OutputView {
    public static void printError(String e){
        System.out.println(e);
    }

    public static void printOpening(){
        System.out.println(Constant.OPENING_TXT);
    }
}
