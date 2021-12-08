package shopAndGoods;


import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShopTest {


    @Test(expected = IllegalArgumentException.class)
    public void testAdd() throws OperationNotSupportedException {
        Shop shop = new Shop();
        shop.addGoods("Shelves18", null);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAdd2() throws OperationNotSupportedException {
        Shop shop = new Shop();
        shop.addGoods("Shelves1", null);

    }

    @Test
    public void testAdd3() throws OperationNotSupportedException {
        Shop shop = new Shop();
        shop.addGoods("Shelves2", new Goods("ti", "5"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdd4() throws OperationNotSupportedException {
        Shop shop = new Shop();
        shop.addGoods("Shelves2", new Goods("ti", "5"));
        shop.addGoods("Shelves2", new Goods("ti", "5"));

    }

    @Test
    public void testReturn() throws OperationNotSupportedException {
        Shop shop = new Shop();
        String expected = "Goods: 5 is placed successfully!";
        Assert.assertEquals(expected, shop.addGoods("Shelves2", new Goods("ti", "5")));
    }

    @Test
    public void testRet() throws OperationNotSupportedException {
        Shop shop = new Shop();
        String expected = "Goods: 5 is placed successfully!";
        Goods goods = new Goods("ti", "5");
        shop.addGoods("Shelves2", goods);

        Assert.assertEquals(goods, shop.getShelves().get("Shelves2"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemove() throws OperationNotSupportedException {
        Shop shop = new Shop();
        shop.removeGoods("Shelves18", null);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemove2() throws OperationNotSupportedException {
        Shop shop = new Shop();
        shop.removeGoods("Shelves1", new Goods("ti", "5"));


    }

    @Test
    public void testRemove3() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("ti", "5");
        shop.addGoods("Shelves1", goods);
        shop.removeGoods("Shelves1", goods);
        Assert.assertNull(shop.getShelves().get("Shelves1"));

    }

    @Test
    public void testReturn2() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("ti", "5");
        shop.addGoods("Shelves1", goods);
        String expected = "Goods: 5 is removed successfully!";
        Assert.assertEquals(expected, shop.removeGoods("Shelves1", goods));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void ctor() {
        Shop shop = new Shop();
        shop.getShelves().put("az",null);
    }

}
