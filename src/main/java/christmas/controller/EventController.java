package christmas.controller;

import christmas.domain.Customer;
import christmas.domain.Order;
import christmas.view.InputView;
import christmas.view.OutputView;
import org.mockito.internal.matchers.Or;

public class EventController {

    public void startPlanner(){
        OutputView.printOpening();
        Customer customer = getVisitDate();
        getMenu();
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
}
