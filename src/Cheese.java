import java.util.Date;
import java.util.Calendar;

public class Cheese {
    private int id;
    private String name;
    private String type;
    private double price;
    private Date expiryDate;

    public Cheese(int id, String name, String type, double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.expiryDate = setExpiryDate();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private Date setExpiryDate() {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.MONTH, 3);
        return this.expiryDate = calendar.getTime();
    }
}
