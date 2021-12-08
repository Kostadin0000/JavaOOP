package halfLife;

import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PlayerTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Player

    @Test
    public void testGetHealth() {
        Player player = new Player("Javarcho", 10);
        Assert.assertEquals(10, player.getHealth());
    }

    @Test
    public void testGetUsername() {
        Player player = new Player("Javarcho", 10);
        Assert.assertEquals("Javarcho", player.getUsername());
    }

    @Test(expected = NullPointerException.class)
    public void testSetUsername() {
        Player player = new Player(null, 10);

    }

    @Test(expected = NullPointerException.class)
    public void testSetUsername3() {
        Player player = new Player("", 10);

    }

    @Test
    public void testSetUsername2() {
        Player player = new Player("Az", 10);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHealth() {
        Player player = new Player("Javarcho", -1);

    }

    @Test
    public void testSetHealth2() {
        Player player = new Player("Javarcho", 10);

    }

    @Test
    public void testList() {
        Player player = new Player("Javarcho", 10);
        Gun gun = new Gun("Makarov", 10);
        player.addGun(gun);
        List<Gun> gunList = player.getGuns();
        Assert.assertEquals(gunList, player.getGuns());
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamage() {
        Player player = new Player("Javarcho", 0);
        player.takeDamage(10);

    }

    @Test
    public void testTakeDamage2() {
        Player player = new Player("Javarcho", 10);
        player.takeDamage(10);
        Assert.assertEquals(0, player.getHealth());

    }

    @Test
    public void testTakeDamage3() {
        Player player = new Player("Javarcho", 10);
        player.takeDamage(11);
        Assert.assertEquals(0, player.getHealth());

    }

    @Test(expected = NullPointerException.class)
    public void testAddGun() {
        Player player = new Player("Javarcho", 10);
        List<Gun> guns = new ArrayList<>();
        guns.add(null);
        player.addGun(null);
    }

    @Test
    public void testAddGun2() {
        Player player = new Player("Javarcho", 10);
        Gun gun = new Gun("Az", 10);
        List<Gun> guns = new ArrayList<>();
        guns.add(gun);
        Assert.assertEquals(gun, guns.get(guns.indexOf(gun)));
    }

    @Test
    public void testRemove() {
        Player player = new Player("Javarcho", 10);
        Gun gun = new Gun("Az", 10);
        List<Gun> guns = new ArrayList<>();
        player.addGun(gun);
        Assert.assertTrue(player.removeGun(gun));
    }

    @Test
    public void testGetGun() {
        Player player = new Player("Javarcho", 10);
        Gun gun = new Gun("Az", 10);
        List<Gun> guns = new ArrayList<>();
        player.addGun(gun);
        Assert.assertEquals(gun, player.getGun("Az"));
    }

    @Test
    public void testGetGun2() {
        Player player = new Player("Javarcho", 10);
        Gun gun = new Gun("Az", 10);
        List<Gun> guns = new ArrayList<>();
        player.addGun(gun);
        Assert.assertNull(player.getGun("aAz"));
    }
}
