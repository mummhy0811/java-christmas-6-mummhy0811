package christmas.domain;

import christmas.util.Constant;
import christmas.util.DayCalc;

public class DayOfTheWeek {

    public boolean checkWeekend(int day){
        return DayCalc.calcDay(day) == 5 || DayCalc.calcDay(day) == 6;
    }

    public String dayDiscount(int day){
        if(checkWeekend(day)){
            return Constant.MENU_TYPE_MAIN;
        }
        return Constant.MENU_TYPE_DESSERT;
    }
}
