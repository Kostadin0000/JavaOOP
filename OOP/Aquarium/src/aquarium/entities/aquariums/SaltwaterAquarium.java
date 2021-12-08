package aquarium.entities.aquariums;

public class SaltwaterAquarium extends BaseAquarium {
    public static final String AQUARIUM_TYPE = "SaltwaterAquarium";
    private static final int CAPACITY_AQUARIUM = 25;
    public SaltwaterAquarium(String name) {
        super(name, CAPACITY_AQUARIUM);
    }
    @Override
    public String getInfo() {
        return String.format("%s (%s):", super.getName(), AQUARIUM_TYPE) +
                System.lineSeparator() +
                super.getInfo();
    }
}
