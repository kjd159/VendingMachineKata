

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
        }
        System.out.println("THANK YOU");
    }
    public double getTotal(){
        return total;
    }
}
