import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {
    @Test
    public void whenCoinIsInsertedItGetsAddedToTotal(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.acceptCoins(.1);
        assertEquals(.1, vendingMachine.getTotal(), .05);
    }
}
