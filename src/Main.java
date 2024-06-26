import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static final CheeseService services = new CheeseService();
    private static final CheeseShop shop = new CheeseShop("The Cheese World");
    private static final Scanner scanner = new Scanner(System.in);
    private static final Wallet wallet = new Wallet(100.00, "wallet");
    private static final ArrayList<Cheese> cart = new ArrayList<>();
    private static final ArrayList<Cheese> customersCheese = new ArrayList<>();
    private static final Customer customer = new Customer(wallet, customersCheese);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nWelcome!");
            System.out.println("Please enter 1 if you are the Shop Manager");
            System.out.println("Please enter 2 if you are a Customer");
            System.out.println("Please enter 3 if you want to exit");
            int userInput = scanner.nextInt();
            scanner.nextLine();
            if (userInput == 1) {
                adminMenu();
            } else if (userInput == 2) {
                customerMenu();
            } else {
                System.out.println("Thank you for visiting! Have a nice day!");
                break;
            }
        }
    }

    public static void addItem(){
        System.out.println("Provide an item ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Provide an item name: ");
        String name = scanner.nextLine();
        System.out.println("Provide an item type: ");
        String type = scanner.nextLine();
        System.out.println("Provide an item price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        Cheese cheese = new Cheese(id, name, type, price);
        services.addCheese(cheese);
        System.out.println(cheese.getName() + " added to the stock.");
    }

    public static void printStockList() {
        System.out.println("These are the items in the stock: ");
        ArrayList<Cheese> stock = services.getStock();
        for (Cheese cheese : stock) {
            System.out.println("ID: " + cheese.getId() + "; name: " + cheese.getName() + "; type: " + cheese.getType() + "; price: "+ cheese.getPrice());
        }
    }

    public static void removeItem() {
        System.out.println("Provide an item ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        services.removeCheese(id);
        System.out.println("Cheese with ID number " + id + " has been removed from the stock.");
    }

    public static void updateItem() {
        while (true) {
            System.out.println("\nWhat do you want to update?");
            System.out.println("Press 1 for name, 2 for type, 3 for price, 4 for exit:");
            int userInput = scanner.nextInt();
            scanner.nextLine();
            if (userInput == 4) {
                System.out.println("You have quit item update!");
                break;
            } else {
                System.out.println("To update an item please provide an item ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                if (userInput == 1) {
                    System.out.println("Please enter updated item name: ");
                    String name = scanner.nextLine();
                    for (Cheese cheese : services.getStock()) {
                        if (cheese.getId() == id) {
                            System.out.println(cheese.getName() + " has been changed to ");
                            cheese.setName(name);
                            System.out.println(cheese.getName());
                        }
                    }
                } else if (userInput == 2) {
                    System.out.println("Please enter updated item type: ");
                    String type = scanner.nextLine();
                    for (Cheese cheese : services.getStock()) {
                        if (cheese.getId() == id) {
                            System.out.println(cheese.getType() + " has been changed to ");
                            cheese.setType(type);
                            System.out.println(cheese.getType());
                        }
                    }
                } else if (userInput == 3) {
                    System.out.println("Please enter updated item price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    for (Cheese cheese : services.getStock()) {
                        if (cheese.getId() == id) {
                            System.out.println(cheese.getPrice() + " has been changed to ");
                            cheese.setPrice(price);
                            System.out.println(cheese.getPrice());
                        }
                    }
                }
            }
        }
    }

    public static void printExpiryDates() {
        for (Date expiryDate : services.expiryDates(services.getStock())) {
            System.out.println(expiryDate);
        }
    }

    public static void adminMenu() {
        while (true) {
            System.out.println("\nWelcome to the Cheese Shop Manager!");
            System.out.println("Enter 1 to add an item to the stock");
            System.out.println("Enter 2 to print the list of items");
            System.out.println("Enter 3 to remove an item from the stock");
            System.out.println("Enter 4 to update an item in the stock");
            System.out.println("Enter 5 to see the expiry dates");
            System.out.println("Enter 6 to exit");
            int userInput = scanner.nextInt();
            scanner.nextLine();
            if (userInput == 1) {
                addItem();
            } else if (userInput == 2) {
                printStockList();
            } else if (userInput == 3) {
                removeItem();
            } else if (userInput == 4) {
                updateItem();
            } else if (userInput == 5) {
                printExpiryDates();
            } else {
                System.out.println("You chose to exit the Cheese Shop Manager menu");
                break;
            }
        }
    }

    public static void addItemToCart() {
        shop.setCart(cart);
        System.out.println("Search cheese by name: ");
        String name = scanner.nextLine();
        ArrayList<Cheese> stock = services.getStock();
        for (Cheese cheese : stock){
            if (cheese.getName().equalsIgnoreCase(name)) {
                shop.addCheeseToCart(cheese);
                System.out.println(cheese.getName() + " added to cart");
            } else if (!cheese.getName().equalsIgnoreCase(name)) {
                System.out.println("There has been an issue adding the item to cart!");
            }
        }
    }

    public static void printCart() {
        System.out.println("These are the items in the cart: ");
        ArrayList<Cheese> cart = shop.getCart();
        for (Cheese cheese : cart) {
            System.out.println("ID: " + cheese.getId() +
                    " ; name: " + cheese.getName() +
                    " ; type: " + cheese.getType() +
                    " ; price: "+ cheese.getPrice());
        }
    }

    public static void removeItemFromCart() {
        System.out.println("Search cheese by name to remove from the cart: ");
        String name = scanner.nextLine();
        ArrayList<Cheese> cart = shop.getCart();
        for (Cheese cheese : cart){
            if (cheese.getName().equalsIgnoreCase(name)){
                shop.removeCheeseFromCart(cheese);
                System.out.println(cheese.getName() + " removed from cart");
                return;
            } else {
                System.out.println("There has been an issue removing the item from the cart. Try again!");
            }
        }
    }

    public static void viewMyCheeses() {
        for (Cheese cheese : customer.getMyCheeses()) {
            System.out.println("Name: " + cheese.getName() + "; type: " + cheese.getType() + "; expiry date: " + cheese.getExpiryDate());
        }
    }

    public static void checkout(){
        double finalPrice = shop.totalCart();
        if (wallet.getBalance() >= finalPrice) {
            wallet.buy(finalPrice);
            System.out.println("Transaction finished. " + finalPrice + "EUR deducted from your account.");
            customersCheese.addAll(shop.getCart());
            cart.removeAll(shop.getCart());
        } else {
            System.out.println("Insufficient funds! Your balance is " + wallet.getBalance() + "EUR, checkout total is " + finalPrice + "EUR.");
            System.out.println("\nWould you like to top up your account?\nEnter Y for yes, N for no");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("Y")) {
                System.out.println("Enter amount to add to your account: ");
                double topUp = scanner.nextDouble();
                scanner.nextLine();
                wallet.addBalance(topUp);
                System.out.println("Your account has been topped up, the new balance is " + wallet.getBalance() + "EUR.");
            } else {
                System.out.println("Your account has insufficient funds to finish the transaction!");
            }
        }
    }

    public static void customerMenu() {
        while (true) {
            System.out.println("\nWelcome to the Shop!");
            System.out.println("Enter 1 to add an item to your cart");
            System.out.println("Enter 2 to view items in the cart");
            System.out.println("Enter 3 to remove an item from the cart");
            System.out.println("Enter 4 to checkout");
            System.out.println("Enter 5 to view purchased cheeses");
            System.out.println("Enter 6 to exit");
            int userInput = scanner.nextInt();
            scanner.nextLine();
            if (userInput == 1) {
                addItemToCart();
            } else if (userInput == 2) {
                printCart();
            } else if (userInput == 3) {
                removeItemFromCart();
            } else if (userInput == 4) {
                checkout();
            } else if (userInput == 5) {
                viewMyCheeses();
            } else {
                System.out.println("You chose to exit the shop");
                break;
            }
        }
    }
}
