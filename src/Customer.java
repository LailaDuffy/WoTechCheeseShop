import java.util.ArrayList;

public class Customer {
    private Wallet wallet;
    private ArrayList<Cheese> myCheeses;

    public Customer(Wallet wallet, ArrayList<Cheese> myCheeses) {
        this.wallet = wallet;
        this.myCheeses = myCheeses;
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
