public class Wallet {
    private double balance;
    private String name;

    public Wallet(double balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void buy(double price) {
        balance -= price;
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }
}
