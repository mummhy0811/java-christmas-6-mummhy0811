package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.util.Constant;

public class InputView {

    public static String getVisitDate(){
        System.out.println(Constant.GET_RESERVE_DATE);
        return Console.readLine();
    }

    public static String getMenu(){
        System.out.println(Constant.GET_ORDERED_MENU);
        return Console.readLine();
    }
}
