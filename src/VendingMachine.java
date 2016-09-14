

public class VendingMachine {
    private double total;

    public VendingMachine(){

    }
    public void acceptCoins(double coin){
        if (coin != .01) {
            total += coin;
        }
    }
    public double getTotal(){
        return total;
    }
}
