import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {
    VendingMachine vendingMachine;

    @Before
    public void setUp(){
        vendingMachine = new VendingMachine();
    }

    @Test
    public void whenCoinIsInsertedItGetsAddedToTotal(){
        vendingMachine.acceptCoins(.1);
        assertEquals(.1, vendingMachine.getTotal(), .05);
    }

    @Test
    public void whenMultipleCoinsAreInsertedTheyAreAddedToTotal(){
        vendingMachine.acceptCoins(.1);
        vendingMachine.acceptCoins(.05);
        vendingMachine.acceptCoins(.25);
        assertEquals(.4, vendingMachine.getTotal(), .05);
    }

    @Test
    public void vendingMachineShouldNotAcceptPennies(){
        vendingMachine.acceptCoins(.01);
        assertEquals(0, vendingMachine.getTotal(), .001);
    }

    @Test
    public void vendingMachineAcceptsValidCoinsDoesntAcceptPennies()
    {
        vendingMachine.acceptCoins(.1);
        vendingMachine.acceptCoins(.05);
        vendingMachine.acceptCoins(.01);
        vendingMachine.acceptCoins(.25);
        assertEquals(.4,vendingMachine.getTotal(), .05);
    }
}
