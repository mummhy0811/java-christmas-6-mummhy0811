package christmas.controller;

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
        if(canParticipateEvent()){
            joinEvent();
        }else{
            justPrint();
        }
    }
    private boolean canParticipateEvent(){
        return order.overMinimum() && order.notOnlyDrinks();
    }
    private void joinEvent(){

    }
    private void justPrint(){
        
    }

}
