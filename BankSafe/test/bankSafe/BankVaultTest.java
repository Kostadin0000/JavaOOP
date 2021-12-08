package bankSafe;


import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

public class BankVaultTest {

    @Test
    public void testGetMap() {
        BankVault bankVault = new BankVault();
        Map<String, Item> map = bankVault.getVaultCells();
        Assert.assertEquals(map, bankVault.getVaultCells());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdd1() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        bankVault.addItem("C5", null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAdd2() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        bankVault.addItem("C4", null);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdd3() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("az", "ti");
        bankVault.addItem("A1", item);
        bankVault.addItem("A1", null);

    }

    @Test(expected = IllegalArgumentException.class)
    public void remove1() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("az", "ti");
        bankVault.addItem("A1", item);
        bankVault.removeItem("A1", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void remove2() {
        BankVault bankVault = new BankVault();
        bankVault.removeItem("y1", null);
    }

    @Test
    public void remove3() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("az", "ti");
        bankVault.addItem("A1", item);
        bankVault.removeItem("A1", item);
        Assert.assertNull(bankVault.getVaultCells().get("A1"));
    }

    @Test
    public void testAdd4() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("az", "ti");
        bankVault.addItem("A1", item);
        Assert.assertEquals(item, bankVault.getVaultCells().get("A1"));
    }

    @Test
    public void ctor() {
        BankVault bankVault = new BankVault();
        Assert.assertNull(bankVault.getVaultCells().get("A1"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetVaultCells() {
        BankVault bankVault = new BankVault();

        bankVault.getVaultCells().put("D3", null);

    }
    @Test
    public void testRemoveReturnProperMessage() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("Gosho", "OPa");
        bankVault.addItem("A1", item);


        String expected = String.format("Remove item:%s successfully!", item.getItemId());
        String actual = bankVault.removeItem("A1", item);

        Assert.assertEquals(expected,actual);

    }
}