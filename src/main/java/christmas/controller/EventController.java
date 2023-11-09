package christmas.controller;

import christmas.domain.Customer;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {

    public void startPlanner(){
        OutputView.printOpening();
        Customer customer = getVisitDate();
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
}
