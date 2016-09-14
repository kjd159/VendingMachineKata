

public class VendingMachine {
    private double total;

    public VendingMachine(){

    }
    public void acceptCoins(double coin){
        if (coin != .01) {
            total += coin;
        }
        System.out.print(total + "\n");
    }
    public double getTotal(){
        return total;
    }
}
