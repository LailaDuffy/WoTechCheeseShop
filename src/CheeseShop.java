import java.util.ArrayList;

public class CheeseShop {
    private String name;
    private ArrayList<Cheese> cart;

    public CheeseShop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Cheese> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Cheese> cart) {
        this.cart = cart;
    }

    public ArrayList<Cheese> availableItems(CheeseService shop) {
        return shop.getStock();
    }

    public void addCheeseToCart(Cheese cheese) {
        cart.add(cheese);
    }

    public void removeCheeseFromCart(Cheese cheese) {
        cart.remove(cheese);
    }

    public double totalCart() {
        double sum = 0.00;
        for (Cheese cheese : cart) {
            sum += cheese.getPrice();
        }
        return sum;
    }
}
