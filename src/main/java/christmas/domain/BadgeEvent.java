package christmas.domain;

import christmas.util.Constant;

public class BadgeEvent {
    public String getBadge(int discountAmount){
        if(discountAmount>= Constant.SANTA_BADGE_PRICE)return Constant.SANTA_BADGE_NAME;
        if(discountAmount>=Constant.TREE_BADGE_PRICE) return Constant.TREE_BADGE_NAME;
        if(discountAmount>=Constant.STAR_BADGE_PRICE) return Constant.STAR_BADGE_NAME;
        else return Constant.NOTHING;
    }
}
