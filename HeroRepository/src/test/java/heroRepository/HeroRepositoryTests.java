package heroRepository;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toUnmodifiableList;

public class HeroRepositoryTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS HeroRepository

    @Test(expected = NullPointerException.class)
    public void testCreate() {
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.create(null);
    }

    @Test
    public void testGetCount() {
        HeroRepository heroRepository = new HeroRepository();
        Assert.assertEquals(0, heroRepository.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate2() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("az", 10);
        heroRepository.create(hero);
        heroRepository.create(hero);
    }

    @Test
    public void testCreate3() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("az", 10);
        String expected = "Successfully added hero az with level 10";
        Assert.assertEquals(expected, heroRepository.create(hero));
    }

    @Test(expected = NullPointerException.class)
    public void testRemove() {
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemove2() {
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.remove("     ");
    }

    @Test
    public void testRemove3() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("az", 10);
        heroRepository.create(hero);
        Assert.assertTrue(heroRepository.remove("az"));
    }

    @Test
    public void testRemove4() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("az", 10);
        heroRepository.create(hero);
        Assert.assertFalse(heroRepository.remove("azz"));
    }

    @Test
    public void testHighLevel() {
        HeroRepository heroRepository = new HeroRepository();

        Assert.assertNull(heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void testHighLevel2() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("az", 10);
        Hero hero1 = new Hero("azz", 11);
        heroRepository.create(hero);
        heroRepository.create(hero1);
        Assert.assertEquals(hero1, heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void getHero() {
        HeroRepository heroRepository = new HeroRepository();

        Assert.assertNull(heroRepository.getHero("asz"));
    }

    @Test
    public void getHero2() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("az", 10);
        heroRepository.create(hero);
        Assert.assertEquals(hero, heroRepository.getHero("az"));
    }

}
