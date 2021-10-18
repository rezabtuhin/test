import java.util.ArrayList;

public class CartManager {
    ArrayList<cartItem> items;
    CartManager(){
        items = new ArrayList<>();
    }
    public void addItem(cartItem item){
        items.add(item);
    }
    public double getTotalPrice(){
        double sum = 0;
        for (cartItem item:
             items) {
            sum+=item.price;
        }
        return sum;
    }


    void applyPromo(String code) throws InvalidPromoCodeException{
        if (!code.equals("ENJOY50")){
            throw new InvalidPromoCodeException(code+" is not a valid promo code right now");
        }
        else if(!code.equals("HELLO100")){
            throw new InvalidPromoCodeException(code+" is not a valid promo code right now");
        }
        else{
            double price = getTotalPrice();
            if (code.equals("ENJOY50") && price<250){
                throw new InvalidPromoCodeException(code+ " cannot be applied for order price of " +price);
            }
            else if (code.equals("HELLO100") && price<500){
                throw new InvalidPromoCodeException(code+ " cannot be applied for order price of " +price);
            }
            else{
                System.out.println("Promo code applied successfully");
            }
        }
    }
}

class cartItem{
    String name;
    double price;
    cartItem(String name, double price){
        this.name = name;
        this.price = price;
    }
}

class InvalidPromoCodeException extends Exception{
    public InvalidPromoCodeException(String msg){
        super(msg);
    }
}