package christmas.controller;

import christmas.util.Constant;
import christmas.domain.*;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.HashMap;

public class EventController {
    private Order order;
    private Customer customer;
    private EventManager eventManager;

    public void startPlanner(){
        OutputView.printOpening();
        customer = getVisitDate();
        order = getMenu();
        OutputView.eventTxt(customer.getVisitDate());

        eventManager = new EventManager(order, customer.getVisitDate());

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
        OutputView.printAmountBeforeDiscount(order.calcTotalOrderAmount());
        if(!canParticipateEvent()){
            justPrint();
            return;
        }
        joinEvent();
    }
    private boolean canParticipateEvent(){
        return order.overMinimum() && order.notOnlyDrinks();
    }

    private void joinEvent(){

        printGiftMenu(order.overGiveAwayMinimum());

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

    }
    private void justPrint(){
        printGiftMenu(false);
        OutputView.printDiscountList(null, false);
        OutputView.printTotalDiscountAmount(0, false);
        OutputView.printAmountAfterDiscount(order.calcTotalOrderAmount());
        OutputView.printBadge(Constant.NOTHING);
    }
    private void printGiftMenu(boolean b){
        if(b){
            OutputView.printGiftMenu(Constant.GIVEAWAY_MENU+Constant.GIVEAWAY_MENU_QUANTITY);
            return;
        }
        OutputView.printGiftMenu(Constant.NOTHING);
    }


}
