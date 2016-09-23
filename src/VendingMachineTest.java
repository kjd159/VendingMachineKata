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
        assertEquals("Coin Return: .01", outContent.toString().substring(12));
    }

    @Test
    public void whenThereAreNoCoinsDisplayShowsINSERTCOIN(){
        assertEquals("INSERT COIN\n", outContent.toString());
    }

    @Test
    public void selectProductColaDispenses(){
        vendingMachine.acceptCoins(.25);
        vendingMachine.acceptCoins(.25);
        vendingMachine.acceptCoins(.25);
        vendingMachine.acceptCoins(.25);
        vendingMachine.selectProduct("Cola");
        assertEquals("1 Cola Dispensed\nTHANK YOU\n", outContent.toString().substring(30));
    }

    @Test
    public void selectProductChipsDispenses(){
        vendingMachine.acceptCoins(.25);
        vendingMachine.acceptCoins(.25);
        vendingMachine.selectProduct("Chips");
        assertEquals("1 Chips Dispensed\nTHANK YOU\n", outContent.toString().substring(21));
    }

    @Test
    public void selectProductCandyDispenses(){
        vendingMachine.acceptCoins(.25);
        vendingMachine.acceptCoins(.25);
        vendingMachine.acceptCoins(.05);
        vendingMachine.acceptCoins(.10);
        vendingMachine.selectProduct("Candy");
        assertEquals("1 Candy Dispensed\nTHANK YOU\n", outContent.toString().substring(31));
    }

    @Test
    public void selectColaDoesntDispenseIfThereIsntEnoughMoney(){
        vendingMachine.selectProduct("Cola");
        assertEquals("$1.00\n",outContent.toString().substring(12));
    }

    @Test
    public void selectChipsDoesntDispenseIfThereIsntEnoughMoney(){
        vendingMachine.selectProduct("Chips");
        assertEquals("$0.50\n",outContent.toString().substring(12));
    }

    @Test
    public void selectCandyDoesntDispenseIfThereIsntEnoughMoney(){
        vendingMachine.selectProduct("Candy");
        assertEquals("$0.65\n",outContent.toString().substring(12));
    }

    @Test
    public void coinReturnOutputsCorrectChangeUsingReturnCoins(){
        vendingMachine.acceptCoins(.25);
        vendingMachine.acceptCoins(.1);
        vendingMachine.returnCoins();
        assertEquals("Coin Return: 0.25\nCoin Return: 0.1\n", outContent.toString().substring(22));
    }

    @Test
    public void coinReturnAndCoinTotalResetsAfterReturnCoins(){
        vendingMachine.acceptCoins(.25);
        vendingMachine.acceptCoins(.1);
        vendingMachine.returnCoins();
        vendingMachine.acceptCoins(.05);
        vendingMachine.returnCoins();
        assertEquals(0.0, vendingMachine.getTotal(), .5);
        assertEquals("Coin Return: 0.05\n", outContent.toString().substring(62));
    }

    @After
    public void cleanUp(){
        System.setOut(null);
    }
}
