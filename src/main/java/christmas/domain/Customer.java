package christmas.domain;

import christmas.constant.Constant;
import christmas.constant.ErrorConstant;

import java.util.regex.Pattern;

public class Customer {
    private final Integer visitDate;

    public Customer(String date){
        isNumber(date);
        isInRange(Integer.parseInt(date));
        visitDate = Integer.parseInt(date);
    }
    private void isNumber(String n) {
        if(!Pattern.matches(Constant.REGEXP_PATTERN_NUMBER, n)){
            throw new IllegalArgumentException(ErrorConstant.INVALIDATE_DATE);
        }
    }
    private void isInRange(Integer n) {
        if(n<1 || n>31){
            throw new IllegalArgumentException(ErrorConstant.INVALIDATE_DATE);
        }
    }
}
