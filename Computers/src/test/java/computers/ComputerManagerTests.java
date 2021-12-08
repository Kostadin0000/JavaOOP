package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ComputerManagerTests {
    // TODO: Test ComputerManager

    ComputerManager computerManager = new ComputerManager();

    @Test
    public void testGetComputers() {
        List<Computer> computers = new ArrayList<>();
        Assert.assertEquals(computers, computerManager.getComputers());
    }

    @Test
    public void getCount() {
        Assert.assertEquals(0, computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidate() {
        computerManager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdd() {
        Computer computer = new Computer("AZ", "Apple", 2000.00);
        computerManager.addComputer(computer);
        computerManager.addComputer(computer);

    }

    @Test
    public void testAdd2() {
        Computer computer = new Computer("AZ", "Apple", 2000.00);
        computerManager.addComputer(computer);
        Assert.assertEquals(1, computerManager.getCount());

    }

    @Test
    public void testRemove() {
        Computer computer = new Computer("AZ", "Apple", 2000.00);
        computerManager.addComputer(computer);
        Computer computer1 = computerManager.removeComputer("AZ", "Apple");
        Assert.assertEquals(computer, computer1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemove2() {
        Computer computer = new Computer("AZ", "Apple", 2000.00);
        Computer computer1 = computerManager.removeComputer("AZ", "Apple");
    }

    @Test
    public void testGetListOfComputers() {
        Computer computer = new Computer("AZ", "Apple", 2000.00);
        Computer computer1 = new Computer("AZ", "Samsung", 2000.00);
        Computer computer2 = new Computer("AZ", "Lenovo", 2000.00);
        List<Computer> computerList = new ArrayList<>();
        computerList.add(computer);
        computerList.add(computer1);
        computerList.add(computer2);
        computerManager.addComputer(computer);
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer2);
        Assert.assertEquals(computerList, computerManager.getComputersByManufacturer("AZ"));
    }
}