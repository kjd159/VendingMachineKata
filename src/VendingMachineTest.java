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
        System.setOut(new PrintStream(outContent));
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

    @Test
    public void vendingMachineUpdatesDisplayAfterAcceptsCoin(){
        vendingMachine.acceptCoins(.25);
        assertEquals("0.25", outContent.toString().substring(12,16));
    }

    @Test
    public void displayUpdatesAfterMultipleAcceptsCoins(){
        vendingMachine.acceptCoins(.1);
        vendingMachine.acceptCoins(.25);
        vendingMachine.acceptCoins(.05);
        assertEquals(".39", outContent.toString().substring(22,25));
    }

    @Test
    public void rejectedCoinsGetPutIntoCoinReturn(){
        vendingMachine.acceptCoins(.01);
        assertEquals("Coin rejected, please retrieve 0.01 from coin return", outContent.toString().substring(12));
    }

    @Test
    public void whenThereAreNoCoinsDisplayShowsINSERTCOIN(){
        assertEquals("INSERT COIN\n", outContent.toString());
    }

    @After
    public void cleanUp(){
        System.setOut(null);
    }
}
