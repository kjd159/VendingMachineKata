

public class VendingMachine {
    private double total;

    public VendingMachine(){

    }
    public void acceptCoins(double coin){
        total = coin;
    }
    public double getTotal(){
        return total;
    }
}
