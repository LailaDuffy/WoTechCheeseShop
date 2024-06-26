import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;

public class CheeseService {
    private ArrayList<Cheese> stock;

    public CheeseService() {
        this.stock = new ArrayList<>();
    }

    public ArrayList<Cheese> getStock() {
        return stock;
    }

    public void setStock(ArrayList<Cheese> stock) {
        this.stock = stock;
    }

    public void addCheese(Cheese cheese) {
        stock.add(cheese);
    }

    public void removeCheese(int cheeseID) {
        stock.removeIf(cheese -> cheese.getId() == cheeseID);
    }

    public ArrayList<Date> expiryDates(ArrayList<Cheese> stock) {
        ArrayList<Date> expiryDates = new ArrayList<>();
        for (Cheese cheese : stock) {
            expiryDates.add(cheese.getExpiryDate());
        }
        Collections.sort(expiryDates);
        return expiryDates;
    }
}
