package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constant.Constant;

public class InputView {

    public static String getVisitDate(){
        System.out.println(Constant.GET_RESERVE_DATE);
        return Console.readLine();
    }
}
