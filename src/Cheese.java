import java.util.Date;

public class Cheese {
    private int id;
    private String name;
    private String type;
    private double pricePerKG;
    private Date expiryDate;

    public Cheese(int id, String name, Date expiryDate) {
        this.id = id;
        this.name = name;
        this.expiryDate = expiryDate;
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

    public double getPricePerKG() {
        return pricePerKG;
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

    public void setPricePerKG(double pricePerKG) {
        this.pricePerKG = pricePerKG;
    }
}
