package christmas.domain;

import christmas.constant.Constant;
import christmas.constant.ErrorConstant;

import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Order {
    private final HashMap<Menu, Integer> menuAndQuantity = new HashMap<>();
    private static final Pattern isNumberPattern = Pattern.compile(Constant.REGEXP_PATTERN_NUMBER);

    public Order(String order){
        StringTokenizer st = new StringTokenizer(order, "-,");

        validateOrderForm(st.countTokens());

        int total_quantity=0;
        String quantity;
        while(st.hasMoreTokens()){

            Menu menu = Menu.find(st.nextToken());

            quantity = st.nextToken();
            validateIsNumber(quantity);
            validateQuantity(total_quantity, quantity);

            total_quantity+=Integer.parseInt(quantity);

            insertMenu(menu, Integer.parseInt(quantity));
        }

   }

   private void validateDuplicate(Menu menu){
        if(menuAndQuantity.containsKey(menu))
            throw new IllegalArgumentException(ErrorConstant.INVALIDATE_ORDER);
   }
   private void validateOrderForm(int tokenNumber){
       if(tokenNumber%2!=0)
           throw new IllegalArgumentException(ErrorConstant.INVALIDATE_ORDER);
   }
    private void validateIsNumber(String quantity){
        if(!isNumberPattern.matcher(quantity).matches()){
            throw new IllegalArgumentException(ErrorConstant.INVALIDATE_ORDER);
        }
    }
    private void validateQuantity(Integer total, String quantity){
        if(total + Integer.parseInt(quantity)>Constant.MAX_ORDER_QUANTITY){
            throw new IllegalArgumentException(ErrorConstant.OVER_MAX_QUANTITY);
        }
    }
    private void insertMenu(Menu menu, Integer quantity){
        validateDuplicate(menu);
        menuAndQuantity.put(menu, quantity);
    }

    public HashMap<Menu, Integer> getMenuAndQuantity() {
        return menuAndQuantity;
    }

    public int calcTotalOrderAmount(){
        int total=0;
        for(Menu m : menuAndQuantity.keySet()){
            total+=m.getPrice()*menuAndQuantity.get(m);
        }
        return total;
    }

    public boolean overMinimum(){
        int total = calcTotalOrderAmount();
        return total >= Constant.MINIMUM_AMOUNT;
    }

    public boolean notOnlyDrinks(){
        for(Menu m : menuAndQuantity.keySet()){
            if(!m.getType().equals("음료")) return false;
        }
        return true;
    }
}
