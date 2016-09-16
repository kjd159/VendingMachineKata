import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {
    VendingMachine vendingMachine;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @Before
    public void setUp(){
        vendingMachine = new VendingMachine();
        System.setOut(new PrintStream(outContent));
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

    @Test
    public void vendingMachineUpdatesDisplayAfterAcceptsCoin(){
        vendingMachine.acceptCoins(.25);
        assertEquals("0.25\n", outContent.toString());
    }

    @Test
    public void displayUpdatesAfterMultipleAcceptsCoins(){
        vendingMachine.acceptCoins(.1);
        vendingMachine.acceptCoins(.25);
        vendingMachine.acceptCoins(.05);
        assertEquals(".39", outContent.toString().substring(10,13));
    }

    @Test
    public void rejectedCoinsGetPutIntoCoinReturn(){
        vendingMachine.acceptCoins(.01);
        assertEquals("Coin rejected, please retrieve 0.01 from coin return", outContent.toString());
    }

    @After
    public void cleanUp(){
        System.setOut(null);
    }
}
