

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
        if (product == "Cola") {
            System.out.println("1 Cola Dispensed");
            System.out.println("THANK YOU");
        }
        else{
            System.out.println("1 Chips Dispensed");
            System.out.println("THANK YOU");
        }
    }
    public double getTotal(){
        return total;
    }
}
