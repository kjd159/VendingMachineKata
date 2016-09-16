

public class VendingMachine {
    private double total;

    public VendingMachine(){
        System.out.println("INSERT COIN");

    }

    public void acceptCoins(double coin){
        if (coin != .01) {
            total += coin;
            System.out.print(total + "\n");
        }
        else{
            System.out.print("Coin rejected, please retrieve 0.01 from coin return");
        }

    }

    public void selectProduct(String product){
        boolean canDisplay = testPriceOfProduct(product);
        if (canDisplay) {
            displayProduct(product);
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
                break;
            case "Chips":
                System.out.println("1 Chips Dispensed");
                break;
            case "Candy":
                System.out.println("1 Candy Dispensed");
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
