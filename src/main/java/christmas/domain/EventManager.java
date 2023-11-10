package christmas.domain;


public class EventManager {
    private final Order order;
    private final Integer date;

    public EventManager(Order order, Integer date){
        this.order = order;
        this.date = date;
    }

}
