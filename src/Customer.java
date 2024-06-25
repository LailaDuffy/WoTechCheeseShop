import java.util.ArrayList;

public class Customer {
    private String name;
    private Wallet wallet;
    private ArrayList<Cheese> myCheeses;

    public Customer(String name, Wallet wallet, ArrayList<Cheese> myCheeses) {
        this.name = name;
        this.wallet = wallet;
        this.myCheeses = myCheeses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public ArrayList<Cheese> getMyCheeses() {
        return myCheeses;
    }

    public void setMyCheeses(ArrayList<Cheese> myCheeses) {
        this.myCheeses = myCheeses;
    }
}
