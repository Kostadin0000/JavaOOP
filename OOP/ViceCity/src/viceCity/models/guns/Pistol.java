package viceCity.models.guns;

public class Pistol extends BaseGun {
    private static int BARREL = 10;
    private static int TOTAL = 100;


    public Pistol(String name) {
        super(name, BARREL, TOTAL);
    }

    @Override
    public int fire() {
        if (getBulletsPerBarrel() == 0 && getTotalBullets() > 0) {
            reload();
        }
        if (getBulletsPerBarrel() > 0) {

            setBulletsPerBarrel(getBulletsPerBarrel() - 1);
        }
        return 1;
    }

    private void reload() {
        setTotalBullets(getTotalBullets() - BARREL);
        setBulletsPerBarrel(BARREL);
    }
}
