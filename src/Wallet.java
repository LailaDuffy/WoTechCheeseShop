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

    public double buy(double price) {
        if (balance >= price) {
            return balance -= price;
        } else {
           return getBalance();
        }
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }
}
