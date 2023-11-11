package christmas.domain;

import christmas.util.Constant;

public class DDayEvent {

    public int dDayDiscount(int date){
        if(date>25) return 0;
        return Constant.DDAY_EVENT_BASIC +date*Constant.DDAY_EVENT_INCREMENT;
    }
}
