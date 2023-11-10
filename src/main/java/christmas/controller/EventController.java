package christmas.controller;

import christmas.constant.Constant;
import christmas.domain.Customer;
import christmas.domain.EventManager;
import christmas.domain.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {
    private Order order;
    private EventManager eventManager;

    public void startPlanner(){
        OutputView.printOpening();
        Customer customer = getVisitDate();
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

    }
    private void justPrint(){
        OutputView.printGiftMenu(Constant.NOTHING);
        OutputView.printDiscountList(null, false);
        OutputView.printTotalDiscountAmount(0, false);
        OutputView.printAmountAfterDiscount(order.calcTotalOrderAmount());
        OutputView.printBadge(Constant.NOTHING);
    }

}
