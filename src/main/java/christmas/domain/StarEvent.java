package christmas.domain;

import christmas.util.DayCalc;

public class StarEvent {
    private boolean checkSunday(int day){
        return DayCalc.calcDay(day) == 7;
    }

    public int dayDiscount(int day){
        if(checkSunday(day) || day==25){
            return 1000;
        }
        return 0;
    }
}
