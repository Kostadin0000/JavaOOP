package aquarium;

import org.junit.Assert;
import org.junit.Test;

public class AquariumTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Aquarium
    @Test
    public void testGetName() {
        Aquarium aquarium = new Aquarium("az", 1);
        Assert.assertEquals("az", aquarium.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetName() {
        Aquarium aquarium = new Aquarium("    ", 1);
    }
    @Test
    public void testSetName1() {
        Aquarium aquarium = new Aquarium("az", 1);
        Assert.assertEquals("az",aquarium.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetName2() {
        Aquarium aquarium = new Aquarium(null, 1);
    }

    @Test
    public void testCapacity() {
        Aquarium aquarium = new Aquarium("az", 1);
        Assert.assertEquals(1, aquarium.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCapacity2() {
        Aquarium aquarium = new Aquarium("az", -1);

    }
    @Test
    public void testCapacity3() {
        Aquarium aquarium = new Aquarium("az", 10);
        Assert.assertEquals(10,aquarium.getCapacity());

    }

    @Test
    public void testGetCount() {
        Aquarium aquarium = new Aquarium("az", 10);
        Assert.assertEquals(0, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdd() {
        Aquarium aquarium = new Aquarium("az", 1);
        aquarium.add(new Fish("ti"));
        aquarium.add(new Fish("tii"));

    }

    @Test
    public void testAdd2() {
        Aquarium aquarium = new Aquarium("az", 2);
        aquarium.add(new Fish("ti"));
        Assert.assertEquals(1,aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemove() {
        Aquarium aquarium = new Aquarium("az", 2);
        aquarium.remove("ti");
    }

    @Test
    public void testRemove2() {
        Aquarium aquarium = new Aquarium("az", 2);
        aquarium.add(new Fish("ti"));
        Assert.assertEquals(1, aquarium.getCount());
        aquarium.remove("ti");
        Assert.assertEquals(0, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSell() {
        Aquarium aquarium = new Aquarium("az", 2);
        aquarium.sellFish("ti");

    }

    @Test
    public void testSell2() {
        Aquarium aquarium = new Aquarium("az", 2);
        Fish fish = new Fish("ti");
        aquarium.add(fish);
        aquarium.sellFish("ti");
        Assert.assertFalse(fish.isAvailable());

    }
    @Test
    public void testReport(){
        Aquarium aquarium = new Aquarium("az", 2);
        Fish fish = new Fish("ti");
        Fish fish1 = new Fish("tii");
        aquarium.add(fish);
        aquarium.add(fish1);
        String expected = "Fish available at az: ti, tii";
        Assert.assertEquals(expected,aquarium.report());
    }
    @Test
    public void testReport2(){
        Aquarium aquarium = new Aquarium("az", 2);
        Fish fish = new Fish("ti");

        aquarium.add(fish);

        String expected = "Fish available at az: ti";
        Assert.assertEquals(expected,aquarium.report());
    }
}

