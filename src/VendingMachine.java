import java.util.ArrayList;

public class VendingMachine {
    private double total;
    private ArrayList<Double> coinCollection;

    public VendingMachine(){
        System.out.println("INSERT COIN");
        coinCollection = new ArrayList<Double>();

    }

    public void acceptCoins(double coin){
        if (coin != .01) {
            total += coin;
            coinCollection.add(coin);
            System.out.print(total + "\n");
        }
        else{
            System.out.print("Coin Return: .01");
        }

    }

    public void selectProduct(String product){
        boolean canDisplay = testPriceOfProduct(product);
        if (canDisplay) {
            displayProduct(product);
        }
        makeChange();
        total = 0;
        coinCollection.clear();
        System.out.println("INSERT COIN");
    }

    public void returnCoins(){
        for (int i = 0; i < coinCollection.size(); i += 1){
            System.out.println("Coin Return: " + coinCollection.get(i));
        }
        System.out.println("INSERT COIN");
        total = 0;
        coinCollection.clear();
    }

    private void makeChange(){
        if (total != 0){
            if (total >= .25){
                Double doubleQuarters = total/.25;
                int numberOfQuarters = doubleQuarters.intValue();
                for (int i = 0; i < numberOfQuarters; i += 1){
                    System.out.println("Coin Return: " + .25);
                }
                total = total - (numberOfQuarters*.25);
            }
        }
    }

    private boolean testPriceOfProduct(String product) {
        boolean canDisplay = true;
        switch (product){
            case "Cola":
                if (total < 1.00)
                {
                    canDisplay = false;
                    System.out.println("$1.00");
                }
                break;
            case "Chips":
                if (total < .50)
                {
                    canDisplay = false;
                    System.out.println("$0.50");
                }
                break;
            case "Candy":
                if (total < .65)
                {
                    canDisplay = false;
                    System.out.println("$0.65");
                }
                break;
            default:
                System.out.println("INSERT COIN");
                break;
        }
        return canDisplay;
    }

    private void displayProduct(String product) {
        switch (product){
            case "Cola":
                System.out.println("1 Cola Dispensed");
                total = total - 1.00;
                break;
            case "Chips":
                System.out.println("1 Chips Dispensed");
                total = total - .50;
                break;
            case "Candy":
                System.out.println("1 Candy Dispensed");
                total = total - .65;
                break;
            default:
                System.out.println("INSERT COIN");
                break;
        }
        System.out.println("THANK YOU");
    }

    public double getTotal(){
        return total;
    }
}
