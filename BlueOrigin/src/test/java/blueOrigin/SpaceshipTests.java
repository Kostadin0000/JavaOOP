package blueOrigin;

import org.junit.Assert;
import org.junit.Test;

public class SpaceshipTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Spaceship
    Spaceship spaceship;

    @Test
    public void testGetCount() {
        spaceship = new Spaceship("AZ", 1);
        Assert.assertEquals(0, spaceship.getCount());

    }

    @Test
    public void testGetName() {
        spaceship = new Spaceship("az", 1);
        Assert.assertEquals("az", spaceship.getName());
    }

    @Test
    public void testGetCapacity() {
        spaceship = new Spaceship("az", 1);
        Assert.assertEquals(1, spaceship.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddThrows() {
        spaceship = new Spaceship("az", 1);
        spaceship.add(new Astronaut("Pesho", 20.0));
        spaceship.add(new Astronaut("Peshko", 20.0));
    }

    @Test
    public void testAdd() {
        spaceship = new Spaceship("az", 1);
        spaceship.add(new Astronaut("Pesho", 20.0));
        Assert.assertEquals(1, spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddExists() {
        spaceship = new Spaceship("az", 2);
        spaceship.add(new Astronaut("Pesho", 20.0));
        spaceship.add(new Astronaut("Pesho", 20.0));
    }

    @Test(expected = NullPointerException.class)
    public void setName() {
        spaceship = new Spaceship("", 10);

    }

    @Test(expected = NullPointerException.class)
    public void setName2() {
        spaceship = new Spaceship(null, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setCapacity() {
        spaceship = new Spaceship("az", -1);
    }

    @Test
    public void testRemove() {
        spaceship = new Spaceship("az", 10);
        Assert.assertFalse(spaceship.remove("ti"));
    }
    @Test
    public void testRemove2() {
        spaceship = new Spaceship("az", 10);
        spaceship.add(new Astronaut("ti",20.0));
        Assert.assertTrue(spaceship.remove("ti"));
    }
}
