package christmas.controller;

import christmas.domain.Menu;
import christmas.util.Constant;
import christmas.domain.*;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.HashMap;

public class EventController {
    private Order order;
    private Customer customer;
    private int discountAmount=0;
    private int giveAwayAmount=0;

    public void startPlanner(){
        OutputView.printOpening();
        customer = getVisitDate();
        order = getMenu();
        OutputView.eventTxt(customer.getVisitDate());

        showEvent();
    }
    private Customer getVisitDate(){
        while(true){
            try {
                return new Customer(InputView.getVisitDate());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
    private Order getMenu(){
        while(true){
            try {
                return new Order(InputView.getMenu());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
    private void showEvent(){
        OutputView.printOrderedMenu(order.getMenuAndQuantity());
        int beforeDiscount = order.calcTotalOrderAmount();
        OutputView.printAmountBeforeDiscount(beforeDiscount);
        if(!order.overMinimum()){
            justPrint();
            return;
        }
        joinEvent();
        OutputView.printAmountAfterDiscount(beforeDiscount-discountAmount);
        OutputView.printBadge(getBadge());
    }

    private int joinEvent(){

        boolean getGiveAway=printGiftMenu(order.overGiveAwayMinimum());

        HashMap<String, Integer> discountList = calcEvent(getGiveAway);
        OutputView.printDiscountList(discountList, true);
        return printTotalDiscount(discountList);
    }
    private void justPrint(){
        printGiftMenu(false);
        OutputView.printDiscountList(null, false);
        OutputView.printTotalDiscountAmount(0, false);
        OutputView.printAmountAfterDiscount(order.calcTotalOrderAmount());
        OutputView.printBadge(Constant.NOTHING);
    }
    private boolean printGiftMenu(boolean b){
        if(b){
            OutputView.printGiftMenu(Constant.GIVEAWAY_MENU+Constant.GIVEAWAY_MENU_QUANTITY);
            return true;
        }
        OutputView.printGiftMenu(Constant.NOTHING);
        return false;
    }

    private HashMap<String, Integer> calcEvent(boolean getGiveAway){
        HashMap<String, Integer> event = new HashMap<>();
        int date = customer.getVisitDate();

        DDayEvent dDayEvent = new DDayEvent();
        event.put(Constant.DDAY_EVENT,dDayEvent.dDayDiscount(date));

        DayOfTheWeekEvent dayOfTheWeek = new DayOfTheWeekEvent();
        String dayCheck=Constant.WEEK_EVENT;
        if(dayOfTheWeek.checkWeekend(date)) dayCheck=Constant.WEEKEND_EVENT;
        event.put(dayCheck,order.calcDayDiscount(dayOfTheWeek.dayDiscount(date)));

        StarEvent starEvent = new StarEvent();
        event.put(Constant.SPECIAL_EVENT, starEvent.dayDiscount(date));

        if(getGiveAway) event.put(Constant.GIVE_AWAY_EVENT, Menu.find(Constant.GIVEAWAY_MENU).getPrice());
        return event;
    }
    private int printTotalDiscount(HashMap<String, Integer> discountList){
        for(String s : discountList.keySet()){
            if(s.equals(Constant.GIVE_AWAY_EVENT)){
                giveAwayAmount=discountList.get(s);
                continue;
            }
            discountAmount+=discountList.get(s);
        }
        OutputView.printTotalDiscountAmount(discountAmount+giveAwayAmount, true);
        return discountAmount;
    }
    private String getBadge(){
        BadgeEvent badgeEvent = new BadgeEvent();
        return badgeEvent.getBadge(discountAmount+giveAwayAmount);
    }
}
