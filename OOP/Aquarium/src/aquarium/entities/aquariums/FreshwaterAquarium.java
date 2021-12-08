package aquarium.entities.aquariums;

public class FreshwaterAquarium extends BaseAquarium {

    private static final int CAPACITY_AQUARIUM = 50;
    public static final String AQUARIUM_TYPE = "FreshwaterAquarium";

    public FreshwaterAquarium(String name) {
        super(name, CAPACITY_AQUARIUM);
    }


    @Override
    public String getInfo() {

        return String.format("%s (%s):", super.getName(), AQUARIUM_TYPE) +
                System.lineSeparator() +
                super.getInfo();
    }
}
