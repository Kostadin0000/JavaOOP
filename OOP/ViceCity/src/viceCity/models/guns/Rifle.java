package viceCity.models.guns;

public class Rifle extends BaseGun {
    private static int BARREL = 50;
    private static int TOTAL = 500;

    public Rifle(String name) {
        super(name, BARREL, TOTAL);
    }

    @Override
    public int fire() {
        if (getBulletsPerBarrel() == 0 && getTotalBullets() > 0) {
            reload();
        }
        if (getBulletsPerBarrel() > 0) {

            setBulletsPerBarrel(getBulletsPerBarrel() - 5);
        }
        return 5;
    }

    private void reload() {
        setTotalBullets(getTotalBullets() - BARREL);
        setBulletsPerBarrel(BARREL);
    }
}
